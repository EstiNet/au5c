package net.estinet.au5c;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

import net.estinet.au5c.ClioteSky.ClioteInit;
import net.estinet.au5c.audio.MakeSound;
import net.estinet.au5c.commands.Encrypt;
import net.estinet.au5c.commands.Help;
import net.estinet.au5c.commands.Key;
import net.estinet.au5c.commands.Stop;
import net.estinet.au5c.configuration.Config;

final class Enable {
	protected void enable(){
		/*
		 * ClioteSky Startup Process.
		 */
		System.out.println("Starting au5c version " + au5c.version + "...");
		
		MakeSound ms = new MakeSound();
		ms.play();
		
		/*
		 * Load Configurations
		 */
		
		au5c.println("Loading configurations...");
		Config c = new Config();
		c.setConfig();
		c.loadConfig();
		
		/*
		 * Sets up RSA encryption variables
		 */
		
		ObjectInputStream inputStream = null;
	    try {
			inputStream = new ObjectInputStream(new FileInputStream(EncryptionUtil.PUBLIC_KEY_FILE));
			final PublicKey publicKey = (PublicKey) inputStream.readObject();
			au5c.publickey = publicKey;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    try {
			inputStream = new ObjectInputStream(new FileInputStream(EncryptionUtil.PRIVATE_KEY_FILE));
			final PrivateKey privateKey = (PrivateKey) inputStream.readObject();
			au5c.privatekey = privateKey;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		/*
		 * Startup Listener 
		 */
		Thread thr1 = new Thread(new Runnable(){
		public void run(){
		au5c.println("Opening socket listeners...");
		//OPEN SOCKET HERE
		ClioteInit ccu = new ClioteInit();
		ccu.enable();
		}
		});
		thr1.start();
		
		/*
		 * Load Commands 
		 */
		
		au5c.println("Loading command objects...");
		au5c.commands.add(new Help());
		au5c.commands.add(new Stop());
		au5c.commands.add(new Key());
		au5c.commands.add(new Encrypt());
		
		/*
		 * Start CommandSystem
		 */
		
		au5c.println("Starting CommandSystem...");
		
		au5c.state = State.COMMAND;
		
		CommandSystem cs = new CommandSystem();
		Thread thr = new Thread(new Runnable(){
			public void run(){
				cs.start();
			}
		});
		thr.start();
		System.out.println("Welcome to au5c.");
	}
}
