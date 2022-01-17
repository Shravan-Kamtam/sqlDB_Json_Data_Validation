package com.jsonDbDataComparision;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

public class Validation {
	public static void main(String[] args) throws ParseException {

		try {
			Map<String, Object> dbMap = ReadDBData.readDBData();
			Map<String, List<Object>> mapJson = JsonFileReader.jsonData();
			String[] a = null;

			for (String name : dbMap.keySet()) {
				if (name.contains(" Type:VARCHAR") || name.contains(" Type:TEXT")) {
					a = name.split(" Type:");

					if (!dbMap.get(name).toString().equals(mapJson.get(a[0]).get(0).toString()))
						System.out.println(("'DB Value'--> " + dbMap.get(name) + " 'Is not matching to json value'--> "
								+ mapJson.get(a[0]).toString()));
					else System.out.println(a[0] + " --> DB column Matched with Json Value");

				} 
				else if (name.contains(" Type:INT")) {
					a = name.split(" Type:");
					if (Integer.parseInt(dbMap.get(name).toString()) != Integer
							.parseInt(mapJson.get(a[0]).get(0).toString()))
						System.out.println(("'DB Value'--> " + dbMap.get(name) + " 'Is not matching to json value'--> "
								+ mapJson.get(a[0]).toString()));
					else System.out.println(a[0] + " --> DB column Matched with Json Value");
					
				} 
				else if (name.contains(" Type:DECIMAL")) {
					if (Double.parseDouble(dbMap.get(name).toString()) != Double
							.parseDouble(mapJson.get(a[0]).get(0).toString()))
						System.out.println(("'DB Value'--> " + dbMap.get(name) + " 'Is not matching to json value'--> "
								+ mapJson.get(a[0]).toString()));
					else System.out.println(a[0] + " --> DB column Matched with Json Value");
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
