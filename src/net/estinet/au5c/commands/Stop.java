package net.estinet.au5c.commands;

import java.util.List;

import net.estinet.au5c.Command;
import net.estinet.au5c.Disable;

public class Stop extends Command{
	public Stop(){
		super.setName("Stop");
		super.setDescription("Stops this instance of au5c.");
	}
	@Override
	public void run(List<String> args){
		Disable disable = new Disable();
		disable.stop();
	}
}
