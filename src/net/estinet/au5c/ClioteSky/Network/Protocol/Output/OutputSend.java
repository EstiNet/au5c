package net.estinet.au5c.ClioteSky.Network.Protocol.Output;

import java.util.List;

import net.estinet.au5c.ClioteSky.Network.NetworkThread;
import net.estinet.au5c.ClioteSky.Network.Protocol.Packet;

public class OutputSend extends Packet{
	@Deprecated
	public void run(List<String> args){
		String sent = "";
		for(String st : args){
			sent += st;
		}
		NetworkThread nt = new NetworkThread();
		nt.sendOutput(sent);
	}

}
