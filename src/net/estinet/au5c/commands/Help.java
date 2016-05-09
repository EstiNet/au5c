package net.estinet.au5c.commands;

import java.util.List;

import net.estinet.au5c.Command;
import net.estinet.au5c.au5c;

public class Help extends Command{
	public Help(){
		super.setName("Help");
		super.setDescription("Lists all commands and descriptions.");
	}
	@Override
	public void run(List<String> args){
		System.out.println("-----<Help>-----");
		for(Command command : au5c.commands){
			System.out.println(command.getName() + " : " + command.getDescription());
		}
	}
}
