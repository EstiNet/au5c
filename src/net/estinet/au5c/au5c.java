package net.estinet.au5c;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class au5c {
	public static String version = "1.0.0b";
	public static State state = State.ENABLING;
	public static boolean exit = true;
	public static boolean debug = false;
	
	public static PublicKey publickey = null;
	public static PrivateKey privatekey = null;
	
	public static List<Command> commands = new ArrayList<>();
	
	public static void main(String[] args){
		System.out.println("au5c.");
		Enable enable = new Enable();
		enable.enable();
	}
	public static void println(String print){
		System.out.println("[System]: " + print);
	}
	public static String getPublicKey(){
		String pub = "";
		for(byte b :  au5c.publickey.getEncoded()){
			pub += b;
		}
		return pub;
	}
	public static String getPrivateKey(){
		String pri = "";
		for(byte b : au5c.privatekey.getEncoded()){
			pri += b;
		}
		return pri;
	}
}
