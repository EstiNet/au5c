package net.estinet.au5c.ClioteSky.Network.Protocol.Output;

import java.util.List;

import net.estinet.au5c.ClioteSky.ClioteConfigUtil;
import net.estinet.au5c.ClioteSky.ClioteSky;
import net.estinet.au5c.ClioteSky.Network.NetworkThread;
import net.estinet.au5c.ClioteSky.Network.Protocol.Packet;

public class OutputHello extends Packet{
	public void run(List<String> args){
		NetworkThread nt = new NetworkThread();
		nt.sendOutput("hello " + ClioteSky.getName() + " " + ClioteSky.getPassword());
		ClioteSky.printLine("Attempting to login...");
		for(String message : ClioteSky.cachedQueries){
			if(!message.equalsIgnoreCase("alive") && !message.equalsIgnoreCase("")){
				nt.sendOutput(message);
				ClioteSky.printLine("Sending cached command " + message);
			}
		}
		ClioteConfigUtil ccu = new ClioteConfigUtil();
		ccu.resetCache();
	}
}
