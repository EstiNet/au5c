package net.estinet.au5c.ClioteSky.Network;

import java.util.ArrayList;
import java.util.List;

import net.estinet.au5c.ClioteSky.ClioteSky;
import net.estinet.au5c.ClioteSky.Network.Protocol.Packet;

public class Decosion {
	public void decode(String message){
		String[] args = message.split("\\s+");
		for(Packet packet : ClioteSky.inputPackets){
			if(args[0].equalsIgnoreCase(packet.name)){
				List<String> newArgs = new ArrayList<>();
				for(int i = 1; i<args.length; i++){
					newArgs.add(args[i]);
				}
				packet.run(newArgs);
			}
		}
	}
}
