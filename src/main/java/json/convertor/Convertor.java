package json.convertor;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import json.convertor.model.User;

public class Convertor {
	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		user.setFullName("omer hussein");
		user.setPassword("1234");
		user.setUserName("omer@1");
		JSONObject userJson = new JSONObject();
		try {
			userJson.put("id", 2);
			userJson.put("fullName", "ahmed");
			userJson.put("password", "ahmed122");
			userJson.put("userName", "ahmed@21");
		} catch (JSONException e) {
			System.out.println("exception in put method , cause by : "+ e.getMessage());
		}
		//convert user object to json object
		JSONObject objectToJson = JsonConvertor.convertPojoToJson(user);
		System.out.println(objectToJson);// {"id":1,"userName":"omer@1","password":"1234","fullName":"omer hussein"}
		
		//convert json object to user object
		User jsonToObject = new User();
		jsonToObject = (User) JsonConvertor.convertJsonToPojo(userJson, jsonToObject);
		System.out.println(jsonToObject.getFullName());//ahmed
	}

}
