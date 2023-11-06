package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	
	public static Properties userData = LoadProperties(System.getProperty("user.dir")+
			"\\src\\main\\java\\properties\\userdata.properties");
	
	private static Properties LoadProperties(String path) 
	{
		Properties pro = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(path);
			pro.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}

}
