package net.estinet.au5c;

public class Disable {
	public void stop(){
		au5c.println("Stopping au5c version " + au5c.version + "...");
		System.exit(0);
	}
}
