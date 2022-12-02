import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class check {


	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int j, b, result;// = 4;

		String fi = "hiiii";
		// System.out.println(fi.ca));

		b = 3;
		result = (int) Math.pow(2, 3);// * b;
		// System.out.printf("%f,%f",j,b);

		// Scanner hi = new Scanner(System.in);
		// hi.next();
		// System.out.println(hi.("bello"));
		
		Calendar fjf=  Calendar.getInstance();
		fjf.set(2022, 10, 24);
		int ss = fjf.get(fjf.DAY_OF_WEEK);
		System.out.println(ss);

		JSONObject vishal = new JSONObject();
		vishal.put("Name", "vishal");
		JSONArray hash = new JSONArray();

		String[] hii = { "this", "yes", "oops", "doops" };
		hash.add("sdfsd");
		hash.add("fff");
		vishal.put("object", hash);

		try {
			FileWriter gile = new FileWriter("D:/newfile.json");
			gile.write(vishal.toJSONString());
			gile.close();

			System.out.println("done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
