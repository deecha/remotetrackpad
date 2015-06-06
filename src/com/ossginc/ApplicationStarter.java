package com.ossginc;

import java.io.File;
import java.io.IOException;

public class ApplicationStarter {

	static int DEFAULT_UDP_PORT = 12321;
	static int MCAST_LISTENER_PORT = 12421;
	
	public static void main(String[] args) throws IOException {
		Dispatcher ds;
		if (args.length != 0 ) ds = new Dispatcher(Integer.parseInt(args[0]), MCAST_LISTENER_PORT);
		else ds = new Dispatcher(DEFAULT_UDP_PORT, MCAST_LISTENER_PORT);
		new ApplicationTrayIcon(ds);
		ds.init();
	}

}
