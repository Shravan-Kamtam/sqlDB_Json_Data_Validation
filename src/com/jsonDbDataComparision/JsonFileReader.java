package com.jsonDbDataComparision;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileReader {
	
	static String id = "id",
				  name = "name",
				  population ="population",
				  countryCode ="countryCode",
				  district ="district",
				  countrycode = "countryCode";	
		
	static Properties prop = new Properties();
	static HashMap<String, Object> jsonMap = new HashMap<String, Object>();
	static JSONParser parser = new JSONParser();	
	public static HashMap<String, Object> jsonData() {
		try {			
			FileInputStream fis = new FileInputStream( System.getProperty("user.dir")+"\\src\\com\\jsonDbDataComparision\\config.properties");
			prop.load(fis);
			FileReader reader = new FileReader(prop.getProperty("JsonFilePath"));
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			
			jsonMap.put(id, jsonObject.get(id));
			jsonMap.put(name, jsonObject.get(name));
			jsonMap.put(population, jsonObject.get(population));
			jsonMap.put(district,jsonObject.get(district));
			jsonMap.put(countryCode, jsonObject.get(countryCode));			
			System.out.println(jsonMap + "**Json Values**");
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return jsonMap;
	}	
	/*
	 * public static void main(String[] args) { jsonData(); }
	 */
}
