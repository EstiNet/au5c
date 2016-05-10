package net.estinet.au5c;

import java.io.IOException;

import net.estinet.au5c.ClioteSky.Network.NetworkThread;

public class Disable {
	public void stop(){
		au5c.println("Stopping au5c version " + au5c.version + "...");
		try {
			NetworkThread.clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
