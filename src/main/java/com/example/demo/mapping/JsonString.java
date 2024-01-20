package com.example.demo.mapping;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonString {
	
	public static void main(String[] args)  {
		String json = "{ \r\n"
				+ "  \"accounting\" : [   \r\n"
				+ "                     { \"firstName\" : \"John\",  \r\n"
				+ "                       \"lastName\"  : \"Doe\",\r\n"
				+ "                       \"age\"       : 23 },\r\n"
				+ "\r\n"
				+ "                     { \"firstName\" : \"Mary\",  \r\n"
				+ "                       \"lastName\"  : \"Smith\",\r\n"
				+ "                        \"age\"      : 32 }\r\n"
				+ "                 ],                            \r\n"
				+ "  \"sales\"      : [ \r\n"
				+ "                     { \"firstName\" : \"Sally\", \r\n"
				+ "                       \"lastName\"  : \"Green\",\r\n"
				+ "                        \"age\"      : 27 },\r\n"
				+ "\r\n"
				+ "                     { \"firstName\" : \"Jim\",   \r\n"
				+ "                       \"lastName\"  : \"Galley\",\r\n"
				+ "                       \"age\"       : 41 }\r\n"
				+ "                 ] \r\n"
				+ "} ";
		
		JSONObject jsonValue = new JSONObject(json);
		getKeyValue(jsonValue, "John");
		
	}
	
	public static void getKeyValue(JSONObject json, String value) {
		Iterator<?> keys = json.keys();
		String nextKey;
		while(keys.hasNext()) {
			nextKey= (String)keys.next();
			System.out.println("key value " + nextKey);
			try {
				if(json.get(nextKey) instanceof JSONArray) {
					
					JSONArray jsonArray = json.getJSONArray(nextKey);
					for(int i =0 ;i <jsonArray.length();i++) {
						String newJson = jsonArray.get(i).toString();
						JSONObject jsonValue = new JSONObject(newJson);
						
						getKeyValue(jsonValue, value);
						
					}
				} else {
					String value1 = json.getString(nextKey);
					if(value1.equalsIgnoreCase("john")) {
						
						System.out.println("I found my match");
					}
					
				}
			} catch(Exception e) {
				
			}
		}
		
	}

}
