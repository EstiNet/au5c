package net.estinet.au5c;

public class Debug {
	public static void print(String print){
		if(au5c.debug){
			System.out.println("[Debug] " + print);
		}
	}
}
