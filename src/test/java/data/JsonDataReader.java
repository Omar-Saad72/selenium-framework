package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonDataReader {
	
	public String fname, lname, email, password;
	
	public void JsonReader() throws IOException, ParseException {
		String filepath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.json";
		File srcFile = new File(filepath);
		JSONParser parser = new JSONParser();
		JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile));
		
		for(Object jsonObj : jarray)
		{
			JSONObject person = (JSONObject) jsonObj;
			fname = (String)person.get("firstname");
			lname = (String)person.get("lastname");
			email = (String)person.get("email");
			password = (String)person.get("password");
		}
		
	}

}
