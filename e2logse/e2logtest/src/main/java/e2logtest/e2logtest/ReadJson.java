package e2logtest.e2logtest;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJson {
	public static String setobjectLocatorFilePath;

	//public static void main(String[] args) throws Exception {
	public static String json(String name) {
		
	
		  JSONParser parser = new JSONParser();
	        try
	        {
	            Object object = parser
	                    .parse(new FileReader("/home/thrymr/Desktop/workspacenew/e2logse/e2logtest/src/main/java/e2logtest/e2logtest/Locatorspath.json"));
	            
	            //convert Object to JSONObject
	            JSONObject jsonObject = (JSONObject)object;
	            
	            //Reading the String
	            setobjectLocatorFilePath = (String) jsonObject.get(name);
	          /*  Long age = (Long) jsonObject.get("Age");
	            
	            //Reading the array
	            JSONArray countries = (JSONArray)jsonObject.get("Countries");
	            */
	            //Printing all the values
	            //System.out.println("Name: " + setobjectLocatorFilePath);
	            
	        }
	        catch(FileNotFoundException fe)
	        {
	            fe.printStackTrace();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
			return setobjectLocatorFilePath;
	
		
		
	}


}
