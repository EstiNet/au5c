package net.estinet.au5c.commands;

import java.util.List;

import net.estinet.au5c.EncryptionUtil;
import net.estinet.au5c.au5c;
import net.estinet.au5c.Command;

public class Encrypt extends Command{
	public Encrypt(){
		super.setName("Encrypt");
		super.setDescription("Encrypts the given query with the public key.");
	}
	@Override
	public void run(List<String> args){
		String query = "";
		for(int i = 1; i < args.size(); i++){
			query += args.get(i) + " ";
		}
		    final byte[] cipherText = EncryptionUtil.encrypt(query, au5c.publickey);
			System.out.println(query);
			System.out.println(new String(cipherText)); 
	}
}
