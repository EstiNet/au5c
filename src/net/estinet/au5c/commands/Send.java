package net.estinet.au5c.commands;

import java.util.List;

import net.estinet.au5c.Command;
import net.estinet.au5c.ClioteSky.ClioteSky;
import net.estinet.au5c.ClioteSky.Network.NetworkThread;

public class Send extends Command{
	public Send(){
		super.setName("Send");
		super.setDescription("Sends a message to ClioteSky.");
	}
	@Override
	public void run(List<String> args){
		args.remove(0);
		String add = "";
		for(String str : args){
			add += str + " ";
		}
		NetworkThread nt = new NetworkThread();
		nt.sendOutput(add);
		ClioteSky.printLine("Sent " + add + " to ClioteSky.");
	}
}
