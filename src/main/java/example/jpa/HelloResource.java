package example.jpa;

import java.io.IOException;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.ibm.json.java.JSON;
import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;


// This class define the RESTful API to fetch the database service information
// <basepath>/api/dbinfo

@Path("/dbinfo")
public class HelloResource {

	@GET
	public String getInformation() throws Exception, IOException {
		// load all system environments
		//JSONObject sysEnv = new JSONObject(System.getenv());

		// 'VCAP_APPLICATION' is in JSON format, it contains useful information about a deployed application
		// String envApp = System.getenv("VCAP_APPLICATION");

		// 'VCAP_SERVICES' contains all the credentials of services bound to this application.
		
		//String envServices = System.getenv("VCAP_SERVICES");
		
		String envServices = "{" +
				"				  \"sqldb\": [" +
				"				            {" +
				"				              \"name\": \"moppster-sqldb\"," +
				"				              \"label\": \"sqldb\"," +
				"				              \"plan\": \"sqldb_free\"," +
				"				              \"credentials\": {" +
				"				                \"hostname\": \"75.126.155.153\"," +
				"				                \"password\": \"j9Er8wXnU6ps\"," +
				"				                \"port\": 50000," +
				"				                \"host\": \"75.126.155.153\"," +
				"				                \"jdbcurl\": \"jdbc:db2://75.126.155.153:50000/SQLDB\"," +
				"				                \"uri\": \"db2://user13180:j9Er8wXnU6ps@75.126.155.153:50000/SQLDB\"," +
				"				                \"db\": \"SQLDB\"," +
				"				                \"username\": \"user13180\"" +
				"				              }" +
				"				            }" +
				"				          ]" +
				"				        }"; 

        if (envServices == null) {
        	  return("VCAP_SERVICES not found");
        	  
          }
		 	
        JSONObject obj =  (JSONObject) JSON.parse(envServices);
        
        String thekey = null;
        Set<String> keys = obj.keySet();
        System.out.println ("Searching through VCAP keys");
  	  // Look for the VCAP key that holds the SQLDB information
        for (String eachkey : keys) {
      	  if (eachkey.contains("sqldb")) {
      		  thekey = eachkey;
      	  }
        }
        if (thekey == null) {
      	  return("Cannot find any SQLDB service in the VCAP_SERVICES");
      	  
        }
        
        JSONArray list = (JSONArray) obj.get (thekey);
        obj = (JSONObject) list.get(0);
        String name = (String) obj.get("name");
        obj = (JSONObject) obj.get ("credentials");
        String databaseHost = (String) obj.get ("host");
        String databaseName = (String) obj.get ("db");
        Long port = (Long) obj.get ("port");
//        String user = (String) obj.get ("username"); 
//        String password = (String) obj.get ("password");
        String jdbcurl = (String) obj.get("jdbcurl");
        
        
        JSONObject DBInfoObj = new JSONObject();

        DBInfoObj.put("name", name);
        DBInfoObj.put("host", databaseHost);
        DBInfoObj.put("db", databaseName);
        DBInfoObj.put("port", port);
        DBInfoObj.put("jdbcurl", jdbcurl);
        
        return DBInfoObj.toString();
        
        
        
	}
}