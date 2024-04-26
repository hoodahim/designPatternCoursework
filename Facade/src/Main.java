import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        APIFacade apiCall = new APIFacade();

        try {
            String joke = apiCall.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println(joke);

            String rate = apiCall.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "INR");
            System.out.println(rate);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
