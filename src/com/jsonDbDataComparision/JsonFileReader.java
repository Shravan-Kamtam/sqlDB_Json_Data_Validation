package com.jsonDbDataComparision;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsonFileReader {

	public static Map<String, List<Object>> jsonData() throws ParseException, ClassNotFoundException, SQLException {

		Map<String, List<Object>> detailedMap = new HashMap<String, List<Object>>();

		RestAssured.baseURI = "https://reqres.in";
		Response response = RestAssured.given().expect().statusCode(200).when().get("api/users/2").then().extract()
				.response();

		String jsonRes = response.asString();

		Map<String, Object> dbMap = ReadDBData.readDBData();
		String[] a = null;

		for (String name : dbMap.keySet()) {
			a = name.split(" Type:");
			detailedMap.put(a[0], JsonPath.read(jsonRes, "$.." + a[0] + ""));
		}

//		System.out.println(detailedMap);
		return detailedMap;
	}

	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
//		jsonData();
	}

}
