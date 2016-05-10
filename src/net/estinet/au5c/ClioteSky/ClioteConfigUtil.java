package net.estinet.au5c.ClioteSky;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import net.estinet.au5c.ClioteSky.ClioteSky;

public class ClioteConfigUtil {
	public void load(){
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("Data/config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			try{
				ClioteSky.setName(prop.getProperty("ClioteSky.Name").toString());
				ClioteSky.setCategory(prop.getProperty("ClioteSky.Category").toString());
				ClioteSky.setAddress(prop.getProperty("ClioteSky.Address").toString());
				ClioteSky.setPassword(prop.getProperty("ClioteSky.Password").toString());
				ClioteSky.setPort(prop.getProperty("ClioteSky.Port").toString());
			}
			catch(Exception e){
				e.printStackTrace();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		File file = new File("Data/cliotecache.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void resetCache(){
		File file = new File("Data/cliotecache.txt");
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void addCacheEntry(String message){
		File file = new File("Data/cliotecache.txt");
		ClioteSky.cachedQueries.add(message);
		BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(file, true));
			output.write(message + "\n");
			output.newLine();
			output.close();
		}
		catch(Exception e){}
	}
	public void fillCacheFromFile(){
		try (BufferedReader br = new BufferedReader(new FileReader("Data/cliotecache.txt"))){
			String CurrentLine;
			while ((CurrentLine = br.readLine()) != null) {
				ClioteSky.cachedQueries.add(CurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
