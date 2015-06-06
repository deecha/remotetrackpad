package com.ossginc;

import com.illposed.osc.OSCPortIn;

import java.io.IOException;
import java.net.*;

public class Dispatcher {

    int listenPort;
    OSCPortIn receiver;
    ApplicationTrayIcon appTrayIcon;
    boolean appListening = false;
    int multicastPort;
    String ip = "224.1.2.1";
    boolean runServer;
    Thread mcastServer;
    private MulticastSocket multicastSocket;
    private InterruptSocketThread stopMcastServer;

    public Dispatcher(int port, int mport) {
        listenPort = port;
        multicastPort = mport;
        appTrayIcon = new ApplicationTrayIcon(this);
    }

    public boolean init() {
        try {
            startHandshakeService();
            receiver = new OSCPortIn(listenPort);
            Receiver worker = new Receiver();
            receiver.addListener("/mouse_event", worker);
            receiver.addListener("/scroll_event", worker);
            receiver.addListener("/keyboard_event", worker);
            receiver.addListener("/volume_event", worker);
            appListening = true;
            appTrayIcon.runIconTray();
            receiver.startListening();
        } catch (SocketException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean isAppListening() {
        return appListening;
    }

    public void quit() {
        System.out.println("QUIT was called");
        runServer = false;
        System.exit(0);
    }

    public void settings() {
        System.out.println("SETTINGS was called");
    }

    public void startHandshakeService() {
        runServer = true;
        mcastServer = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    InetAddress group = InetAddress.getByName(ip);
                    System.out.println(group.getHostAddress());
                    multicastSocket = new MulticastSocket(multicastPort);
                    multicastSocket.joinGroup(group);

                    String msg = "VIP_Pong_02";
                    // s.send(data);

                    byte[] buffer = new byte[10 * 1024];
                    DatagramPacket recvData = new DatagramPacket(buffer,
                            buffer.length);
                    while (runServer) {
                        multicastSocket.receive(recvData);
                        System.out.println("MReceived: "
                                + (new String(buffer, 0, recvData.getLength())));
                        String phrase = new String(recvData.getData());
                        if (phrase.contains("VIP_Ping")) {
                            // DatagramPacket sendData = new DatagramPacket(msg
                            // .getBytes(), msg.length(), group,
                            // multicastPort);

                            DatagramPacket sendData = new DatagramPacket(msg
                                    .getBytes(), msg.length(), recvData
                                    .getAddress(), recvData.getPort());
                            multicastSocket.send(sendData);
                            System.out.println("MSending: "
                                    + (new String(msg.getBytes(), 0, sendData
                                    .getLength())));
                        }
                    }
                    multicastSocket.close();
                    System.out
                            .println("MCastServer is done, quitting ! Enjoy the hiding...");
                } catch (IOException e) {
                    System.out.println(e.toString());
                    runServer = false;
                }

            }

        }, "McastResponder");

        mcastServer.start();
        stopMcastServer = new InterruptSocketThread(multicastSocket);
        stopMcastServer.start();
    }

    public void stopMcastserver() {
        if (runServer) {
            runServer = false;
            stopMcastServer.interrupt();
        }
    }

    public void startUPDServer() {
        final String sendMsg = "VIP_Pong_02";
        final String recvMsg = "VIP_Ping";
        byte[] buffer = new byte[10 * 1024];
        final DatagramPacket recvData = new DatagramPacket(buffer,
                buffer.length);

        Thread srvr = new Thread(new Runnable() {

            @Override
            public void run() {


                if (runServer) {
                    DatagramSocket recvSocket = null;
                    try {
                        recvSocket = new DatagramSocket(multicastPort);

                        recvSocket.receive(recvData);
                        String phrase = new String(recvData.getData());
                        System.out.println("Received: " + phrase);
                        if (phrase.contains(recvMsg)) {
                            InetAddress DestIPAddress = recvData.getAddress();
                            int destPort =
                                    recvData.getPort();
                            byte[] sendData = sendMsg.getBytes();
                            DatagramPacket
                                    Packet = new DatagramPacket(sendData, sendData.length, DestIPAddress,
                                    destPort);
                            try {
                                System.out.println("Sending: " + sendMsg);
                                recvSocket.send(Packet);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (phrase.contains(sendMsg)) {
                            InetAddress DestIPAddress =
                                    recvData.getAddress();
                            int destPort = recvData.getPort();
                            byte[] sendData
                                    = recvMsg.getBytes();
                            DatagramPacket Packet = new
                                    DatagramPacket(sendData, sendData.length, DestIPAddress, destPort);
                            try {
                                System.out.println("Sending: " + recvMsg);
                                recvSocket.send(Packet);
                            } catch (IOException e) { // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                        recvSocket.close();
                    } catch (Exception e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        }, "Responder");
        srvr.start();
    }

    class InterruptSocketThread extends Thread {

        public InterruptSocketThread(DatagramSocket s) {

        }

        @Override
        public void interrupt() {
            // super.interrupt();
            // this.s.close();
            multicastSocket.close();
            System.out
                    .println("MCastServer is Killed, quitting ! Enjoy the hiding...");
        }
    }
}
