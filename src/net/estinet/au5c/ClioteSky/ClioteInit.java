package net.estinet.au5c.ClioteSky;

import net.estinet.au5c.ClioteSky.Network.Protocol.Input.InputAlive;
import net.estinet.au5c.ClioteSky.Network.Protocol.Input.InputError;
import net.estinet.au5c.ClioteSky.Network.Protocol.Input.InputMessage;
public class ClioteInit {
	public void enable(){
		ClioteConfigUtil ccu = new ClioteConfigUtil();
		ccu.load();
		ClioteSky.printLine("Connecting to ClioteSky...");
		ClioteSky.inputPackets.add(new InputAlive());
		ClioteSky.inputPackets.add(new InputError());
		ClioteSky.inputPackets.add(new InputMessage());
		ccu.fillCacheFromFile();
		ClioteSky.setServerOnline(true);
	}
}
