package net.estinet.au5c.ClioteSky;

import java.util.ArrayList;
import java.util.List;

import net.estinet.au5c.Debug;
import net.estinet.au5c.ClioteSky.API.ClioteHook;
import net.estinet.au5c.ClioteSky.Network.NetworkThread;
import net.estinet.au5c.ClioteSky.Network.Protocol.Packet;

public class ClioteSky {
	private static String address = "";
	private static String port = "";
	private static String category = "";
	private static String name = "";
	private static String password = "";
	private static boolean serverOnline = false;
	private static boolean aliveCache = true;
	private static boolean syncedOutput = false;
	public static List<Packet> inputPackets = new ArrayList<>();
	public static List<ClioteHook> hooks = new ArrayList<>();
	public static List<String> cachedQueries = new ArrayList<>();
	public static List<String> secondCachedQueries = new ArrayList<>();
	public static boolean isSyncedOutput() {
		return syncedOutput;
	}
	public static void setSyncedOutput(boolean syncedOutput) {
		ClioteSky.syncedOutput = syncedOutput;
		if(!syncedOutput){
			try{
				NetworkThread nt = new NetworkThread();
				nt.sendOutput(secondCachedQueries.get(0));
				secondCachedQueries.remove(0);
			}
			catch(Exception e){
				Debug.print("[ClioteSky] Reached end of cache line.");
			}
		}
	}
	public static String getCategory() {
		return category;
	}
	public static void setCategory(String category) {
		ClioteSky.category = category;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		ClioteSky.name = name;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		ClioteSky.password = password;
	}
	public static void setAddress(String address) {
		ClioteSky.address = address;
	}
	public static void setPort(String port) {
		ClioteSky.port = port;
	}
	public static String getAddress(){
		return address;
	}
	public static String getPort(){
		return port;
	}
	public static void printError(String errorCode){
		System.out.println("[ClioteSky Error] " + errorCode);
	}
	public static void printLine(String line){
		System.out.println("[ClioteSky] " + line);
	}
	public static boolean isAliveCache() {
		return aliveCache;
	}
	public static void setAliveCache(boolean aliveCache) {
		ClioteSky.aliveCache = aliveCache;
	}
	public static boolean isServerOnline() {
		return serverOnline;
	}
	public static void setServerOffline(){
		ClioteSky.serverOnline = false;
		NetworkThread.clientSocket = null;
	}
	public static void setServerOnline(boolean startup) {
		ClioteSky.serverOnline = true;
		NetworkThread.start(startup);
	}
	public static void addClioteHook(ClioteHook ch){
		hooks.add(ch);
	}
}
