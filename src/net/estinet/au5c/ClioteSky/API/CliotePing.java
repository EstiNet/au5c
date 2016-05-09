package net.estinet.au5c.ClioteSky.API;

import net.estinet.au5c.ClioteSky.Network.NetworkThread;

public class CliotePing {
	public void sendMessage(String message, String categoryOrCliote){
		NetworkThread nt = new NetworkThread();
		nt.sendOutput("send " + categoryOrCliote + " " + message);
	}
}
