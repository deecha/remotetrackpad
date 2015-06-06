package com.ossginc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ApplicationTrayIcon {
    private String wiTechServerMsg;
    private String startedMsg;
    private String stoppedMsg;
    private String transitioningMsg;

    private String startLabel;
    private String stopLabel;
    private String restartLabel;
    private String quitLabel;

    private MenuItem stopItem;
    private MenuItem startItem;
    private MenuItem restartItem;
    private Image stoppedImage;
    private Image xtionImage;
    private Image startedImage;
    private TrayIcon trayIcon;
    private MenuItem quitItem;
    final SystemTray tray = SystemTray.getSystemTray();
//    private Timer blinkImageTimer;
    
    public static final String START_TEXT = "Start";
    public static final String STOP_TEXT = "Stop";
    public static final String RESTART_TEXT = "Restart";
    public static final String QUIT_TEXT = "Quit";
    public static final String STATUS_TEXT = "Status";

    private Dispatcher ds;
    
    public ApplicationTrayIcon(Dispatcher ds) {
        this.ds = ds;
        
        startLabel = START_TEXT;
        stopLabel = STOP_TEXT;
        restartLabel = RESTART_TEXT;
        quitLabel = QUIT_TEXT;
        wiTechServerMsg = "Started";
        startedMsg = "Started";
        stoppedMsg = "Stopped";
        transitioningMsg = "Starting/Stopping";
    }

    private static String getServeMsg() {
        String serverName = "wiTECH";
        String appName = System.getenv("NGST_APPNAME");
        if (appName != null) {
            serverName = appName;
        }
        return serverName + " Server: ";
    }


    public void stopIconTray() {
        try {
            tray.remove(trayIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runIconTray() {
        URL imgURLStart = ClassLoader.getSystemResource("icons/track_green.png");
        URL imgURLStop = ClassLoader.getSystemResource("icons/track_red.png");
        startedImage = Toolkit.getDefaultToolkit().getImage(imgURLStart);
        stoppedImage = Toolkit.getDefaultToolkit().getImage(imgURLStop);
        //xtionImage = Toolkit.getDefaultToolkit().getImage(imgURLStart);


        MouseListener mouseListener = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }
        };

        ActionListener quitListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("\"Quit\" was requested from the icon tray.");
                stopIconTray();
                ds.quit();
            }
        };

        ActionListener startListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	ds.startHandshakeService();
            	setIconData(true, false);
            }
        };

        ActionListener stopListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
               System.out.println(event);
               ds.stopMcastserver();
               setIconData(false, false);
            }
        };

        ActionListener restartListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                
            }
        };

        PopupMenu popup = new PopupMenu();

        startItem = new MenuItem(startLabel);
        startItem.addActionListener(startListener);
        startItem.setEnabled(!ds.runServer);
        popup.add(startItem);

        stopItem = new MenuItem(stopLabel);
        stopItem.addActionListener(stopListener);
        stopItem.setEnabled(ds.runServer);
        popup.add(stopItem);

        restartItem = new MenuItem(restartLabel);
        restartItem.addActionListener(restartListener);
        restartItem.setEnabled(!ds.runServer);
        popup.add(restartItem);

        popup.addSeparator();

        quitItem = new MenuItem(quitLabel);
        quitItem.addActionListener(quitListener);
        popup.add(quitItem);

        trayIcon = new TrayIcon(startedImage, wiTechServerMsg, popup);
        trayIcon.setImageAutoSize(true);
        trayIcon.addMouseListener(mouseListener);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.err.println("TrayIcon could not be added.");
        }
    }

    public void setIconData(boolean running, boolean transitioning) {
        if (transitioning) {
            stopItem.setEnabled(false);
            startItem.setEnabled(false);
            restartItem.setEnabled(false);
            quitItem.setEnabled(true);
        } else {
            stopItem.setEnabled(running);
            startItem.setEnabled(!running);
            restartItem.setEnabled(running);
            quitItem.setEnabled(true);
        }
        if (transitioning) {
            trayIcon.setImage(xtionImage);
            trayIcon.setToolTip(wiTechServerMsg + transitioningMsg);
        } else if (running) {
            trayIcon.setToolTip(wiTechServerMsg + startedMsg);
            trayIcon.setImage(startedImage);
        } else {
            trayIcon.setToolTip(wiTechServerMsg + stoppedMsg);
            trayIcon.setImage(stoppedImage);
        }
    }


}

