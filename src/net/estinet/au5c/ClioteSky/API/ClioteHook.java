package net.estinet.au5c.ClioteSky.API;

import java.util.List;

public class ClioteHook{
	private String argument;
	public ClioteHook(String coreArgument){
		argument = coreArgument;
	}
	public String getCoreArgument(){
		return argument;
	}
	public void setCoreArgument(String coreArg){
		argument = coreArg;
	}
	//Must override
	public void run(List<String> args, String categoryName, String clioteName){}
}
