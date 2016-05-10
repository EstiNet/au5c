package net.estinet.au5c.ClioteSky.Network.Protocol.Input;

import java.util.ArrayList;
import java.util.List;

import net.estinet.au5c.Debug;
import net.estinet.au5c.ClioteSky.ClioteSky;
import net.estinet.au5c.ClioteSky.API.ClioteHook;
import net.estinet.au5c.ClioteSky.Network.Protocol.Packet;

public class InputMessage extends Packet{
	public InputMessage(){
		super.name = "Message";
	}
	public void run(List<String> args){
		List<String> newArgs = new ArrayList<>();
		for(int i = 3; i < args.size(); i++){
			newArgs.add(args.get(i));
		}
		Debug.print("Recieved message " + args + " from category " + args.get(0) + " and cliote " + args.get(1));
		for(ClioteHook ch : ClioteSky.hooks){
			if(ch.getCoreArgument().equals(args.get(2))){
				ch.run(newArgs, args.get(0), args.get(1));
			}
		}
	}
}