package net.estinet.au5c.ClioteSky.Network.Protocol.Output;

import java.io.IOException;
import java.util.List;

import net.estinet.au5c.ClioteSky.ClioteSky;
import net.estinet.au5c.ClioteSky.Network.NetworkThread;
import net.estinet.au5c.ClioteSky.Network.Protocol.Packet;

public class OutputAlive extends Packet{
	public void run(List<String> args){
		if(NetworkThread.clientSocket == null){
			ClioteSky.setServerOnline(false);
		}
		else{
			ClioteSky.setAliveCache(true);
			NetworkThread nt = new NetworkThread();
			nt.sendOutput("alive");
			Thread thr = new Thread(new Runnable(){
				public void run(){
					while(true){
						if(ClioteSky.isAliveCache()){
							if(ClioteSky.isServerOnline()){
								ClioteSky.printLine("Uh oh! Server went offline.");
								try {
									NetworkThread.clientSocket.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
								ClioteSky.setServerOffline();
							}
						}
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
			thr.start();
		}
	}
}
