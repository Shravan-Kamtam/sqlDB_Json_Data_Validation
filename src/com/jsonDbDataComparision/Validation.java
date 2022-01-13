package com.jsonDbDataComparision;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

public class Validation {
	
	public static int idDB, idJson;
	public static String nameDB, nameJson;
	public static int populationDB, populationJson;
	public static String countryDB, countryJson;
	public static String districtDB, districtJson;
	

	public static void main(String[] args) {
		
		try {
			Map<String, Object> map = ReadDBData.readDBData();
			Map<String, Object> mapJson = JsonFileReader.jsonData();
			
			
	    	idDB = Integer.parseInt(map.get("ID").toString());
	    	nameDB = map.get("Name").toString();
	    	populationDB = Integer.parseInt(map.get("Population").toString()); 
	    	countryDB = map.get("CountryCode").toString(); 
	    	districtDB = map.get("District").toString();
	    	
	    	idJson = Integer.parseInt(mapJson.get("id").toString());
	    	nameJson = mapJson.get("name").toString();
	    	populationJson = Integer.parseInt(mapJson.get("population").toString());
	    	countryJson = mapJson.get("countryCode").toString();
	    	districtJson = mapJson.get("district").toString();
	    	
	    	Assert.assertTrue(idDB == idJson &&
	    			nameDB.equals(nameJson) &&
	    			populationDB == populationJson &&
	    			countryDB.equals(countryJson) &&
	    			districtDB.equals(districtJson));
		}
		
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
	}
}
