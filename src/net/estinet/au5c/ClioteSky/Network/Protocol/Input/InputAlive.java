package net.estinet.au5c.ClioteSky.Network.Protocol.Input;

import java.util.List;

import net.estinet.au5c.Debug;
import net.estinet.au5c.ClioteSky.ClioteSky;
import net.estinet.au5c.ClioteSky.Network.Protocol.Packet;

public class InputAlive extends Packet{
	public InputAlive(){
		super.name = "Alive";
	}
	public void run(List<String> args){
		ClioteSky.setAliveCache(false);
		Debug.print("[ClioteSky] Ping successful.");
	}
}
