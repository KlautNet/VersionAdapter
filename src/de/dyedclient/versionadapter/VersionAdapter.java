package de.dyedclient.versionadapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class VersionAdapter {
	
	 private static final String USER_AGENT = "Mozilla/5.0";

	    private static final double CURRENT_VERSION = 1.0;
	    
	    private static final String GET_URL = "http://localhost:3030/version?method=GET";

	    public static void main(String[] args) throws IOException {
	        Double serverVersion = getVersion();
	        if(CURRENT_VERSION != serverVersion) {
	        	System.out.println("[Warning] | Your Client is outdated. Please update to it version " + serverVersion +  " on www.ichwilleinensportwagen.de");
	        }else {
	        	System.out.println("[Client] VersionCheck:OK");
	        }
	    }

	    private static Double getVersion() throws IOException {
	    	
	        URL obj = new URL(GET_URL);
	        
	        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
	        httpURLConnection.setRequestMethod("GET");
	        httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
	        
	        int responseCode = httpURLConnection.getResponseCode();

	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
	            String inputLine;
	            StringBuffer response = new StringBuffer();

	            while ((inputLine = in .readLine()) != null) {
	                response.append(inputLine);
	            } in .close();

	            JsonObject convertedObject = new Gson().fromJson(response.toString(), JsonObject.class);
	            return Double.parseDouble(convertedObject.get("version").toString());
	            
	        } else {
	            System.out.println("GET request not worked | Status: " + responseCode);
	        }
			return null;
	        

	    }
}
