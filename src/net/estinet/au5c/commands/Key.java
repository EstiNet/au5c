package net.estinet.au5c.commands;

import java.util.List;

import net.estinet.au5c.Command;
import net.estinet.au5c.au5c;

public class Key extends Command{
	public Key(){
		super.setName("Key");
		super.setDescription("Prints the public and private key.");
	}
	@Override
	public void run(List<String> args){
		System.out.println("Public Key: \n\n" + au5c.getPublicKey());
		System.out.println("\n\nPrivate Key: \n\n" + au5c.getPrivateKey());
	}
}
