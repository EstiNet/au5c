package net.estinet.au5c.commands;

import java.util.List;

import net.estinet.au5c.Command;
import net.estinet.au5c.au5c;

public class Debug extends Command{
	public Debug(){
		super.setName("Debug");
		super.setDescription("Toggles Debug messages.");
	}
	@Override
	public void run(List<String> args){
		if(au5c.debug){
			au5c.debug = false;
		}
		else{
			au5c.debug = true;
		}
	}
}
