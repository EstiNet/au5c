package net.estinet.au5c.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import net.estinet.au5c.au5c;

public class Config {
	File f = new File("./Data");
	File file = new File("./Data/config.properties");
	File rsa = new File("./RSA");
	File rsapub = new File("./RSA/public.key");
	File rsapri = new File("./RSA/private.key");
	public void setConfig(){
		/*
		 * File check if exists.
		 */
		
		
		if(!f.isDirectory()){
			au5c.println("Creating directory ./Data");
			f.mkdir();
		}
		if(!rsa.isDirectory()){
			au5c.println("Creating directory ./RSA");
			rsa.mkdir();
		}
		if(!file.exists()){
			try {
				au5c.println("Creating file ./Data/config.properties");
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(!rsapub.exists()){
			try {
				au5c.println("Creating file ./RSA/public.key");
				rsapub.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(!rsapri.exists()){
			try {
				au5c.println("Creating file ./RSA/private.key");
				rsapri.createNewFile();
				net.estinet.au5c.EncryptionUtil.generateKey();
				//Assume that if they don't have the public key they don't have the private key :P
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Properties prop = new Properties();
		OutputStream output = null;
		InputStream input = null;
		try {
			input = new FileInputStream(file.getPath());
			prop.load(input);
			input.close();
			output = new FileOutputStream(f.getPath());
			if(!(prop.containsKey("ClioteSky.Address"))){
				prop.setProperty("ClioteSky.Address", "localhost");
			}
			if(!(prop.containsKey("ClioteSky.Port"))){
				prop.setProperty("ClioteSky.Port", "36000");
			}
			if(!(prop.containsKey("ClioteSky.Category"))){
				prop.setProperty("ClioteSky.Category", "Default");
			}
			if(!(prop.containsKey("ClioteSky.Name"))){
				prop.setProperty("ClioteSky.Name", "Server");
			}
			if(!(prop.containsKey("ClioteSky.Password"))){
				prop.setProperty("ClioteSky.Password", "password");
			}
			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void loadConfig(){
		/*
		 * Load configuration (config.properties)
		 */
		
	}
}
