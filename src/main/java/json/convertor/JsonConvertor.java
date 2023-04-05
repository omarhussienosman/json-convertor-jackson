package json.convertor;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonConvertor {
	public static JSONObject convertPojoToJson(Object pojo) {
		ObjectMapper Obj = new ObjectMapper();
		Obj.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		Obj.setSerializationInclusion(Include.NON_NULL);
		Obj.setSerializationInclusion(Include.NON_EMPTY);
		Obj.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			String jsonStr = Obj.writeValueAsString(pojo);
			JSONObject json = new JSONObject(jsonStr);
			return json;
		} catch (JsonProcessingException | JSONException e) {
			System.out.println("can't convert object to string or can't convert string to json , cause by --------> " + e.getMessage());
			return null;

		}
	}

	public static Object convertJsonToPojo(JSONObject json, Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			obj = mapper.readValue(json.toString(), obj.getClass());
			return obj;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return null;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}

	}
}
