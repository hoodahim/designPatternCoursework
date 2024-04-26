import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class APIFacade {
    public String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException, ParseException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        String jsonResult;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            jsonResult = content.toString();
        } finally {
            con.disconnect();
        }

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonResult);
        return findValueByKey(jsonObject, attributeName);
    }

    private String findValueByKey(JSONObject jsonObject, String key) {
        for (Object obj : jsonObject.keySet()) {
            String currKey = (String) obj;
            Object value = jsonObject.get(currKey);
            if (currKey.equals(key)) {
                if(value instanceof Double){
                    return String.valueOf(value);
                }else return (String) value;
            } else if (value instanceof JSONObject) {
                String innerResult = findValueByKey((JSONObject) value, key);
                if (innerResult != null) {
                    return innerResult;
                }
            }
        }
        return null; // Key not found
    }

}
