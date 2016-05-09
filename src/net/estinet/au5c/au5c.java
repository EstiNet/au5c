package net.estinet.au5c;

public class au5c {
	public static String version = "1.0.0b";
	public static State state = State.ENABLING;
	public static boolean exit = true;
	public static void main(String[] args){
		System.out.println("au5c.");
		Enable enable = new Enable();
		enable.enable();
	}
	public static void println(String print){
		System.out.println("");
	}
}
