import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Term {

	public static void main(String[] args) {

		JSONObject jsonObject = new JSONObject();

		JSONArray array = new JSONArray();
		array.add("vishal");
		array.add("papa");
		array.add("dfs");
		jsonObject.put("ID", array);
		array.add(111);

		jsonObject.put("firstname", "Vishal");
		jsonObject.put("middlename", "Vishal");
		jsonObject.put("Lastname", "Vishal");
		jsonObject.put("number", "9437272");

		try {
			FileWriter file = new FileWriter("D:/output.json");
			file.write(jsonObject.toJSONString());
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("json file creatred " + jsonObject);

	}
}
