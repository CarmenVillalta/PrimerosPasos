package com.trabajopractico.dds.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ApiClima {
    //Lo hice generico para que pase por ahora, despues ver que tienen que tener las apis etc
    private String API_KEY;
    private String LOCATION_ID;
    private String urlString;

    public double getClima(String ciudad, LocalDateTime hora) {

    	this.urlString = this.urlString + ciudad + "&appid=" + this.API_KEY + "&units=metric";

		String jsonString = this.readURLInformationAsString();

		if( jsonString.equals("ERROR") )
			return -1;

		Map<String, Object> jsonMap = jsonToMap(jsonString);
		Map<String, Object> mainMap = jsonToMap(jsonMap.get("main").toString());

		Object temp= mainMap.get("temp");
		String temperatura = temp.toString();
		return Double.valueOf(temperatura);
    }

	public Map<String, Object> jsonToMap(String str){
		Map<String, Object> map = new Gson().fromJson(
				str, new TypeToken<HashMap<String, Object>>() {}.getType()
		);
		return map;
	}

	public String readURLInformationAsString(){
		try{
			StringBuilder result = new StringBuilder();
			URL url = new URL(this.urlString);
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line = rd.readLine()) != null){
				result.append(line);
			}
			rd.close();
			return result.toString();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		return "ERROR";
	}

	public String getAPI_KEY() {
		return API_KEY;
	}
	public void setAPI_KEY(String aPI_KEY) {
		API_KEY = aPI_KEY;
	}
	public String getLOCATION_ID() {
		return LOCATION_ID;
	}
	public void setLOCATION_ID(String lOCATION_ID) {
		LOCATION_ID = lOCATION_ID;
	}
	public String getUrlString() {
		return urlString;
	}
	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}
}
