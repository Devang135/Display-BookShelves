package userDefinedLibraries;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonRead {

	public static JSONParser parser;
	public static JSONObject jsonObject;
	public static Object obj;
	public static String amount;
	public static String recipientName;
	public static String recipientEmail;
	public static String recipientErrorEmail;
	public static String customerName;
	public static String customerEmail;
	public static String customerErrorEmail;
	public static String customerMobile;
	
	public static void readJSONFile() {
		
		try {
			
			parser = new JSONParser();
			obj = parser.parse(new FileReader("./src/main/java/data/formData.json"));
	        jsonObject = (JSONObject)obj;
	        
	        amount         = (String)jsonObject.get("Amount");
	        recipientName  = (String)jsonObject.get("Recipient_Name");
	        recipientEmail = (String)jsonObject.get("Recipient_Email");
	        recipientErrorEmail = (String)jsonObject.get("Recipient_Error_Email");
	        customerName   = (String)jsonObject.get("Customer_Name");
	        customerEmail  = (String)jsonObject.get("Customer_Email");
	        customerErrorEmail  = (String)jsonObject.get("Customer_Error_Email");
	        customerMobile = (String)jsonObject.get("Customer_Mobile");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
	 
	}
	
}
