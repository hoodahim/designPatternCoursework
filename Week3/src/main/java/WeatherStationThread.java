import java.util.Random;

public class WeatherStationThread extends Thread{

    private int temperature;
    private WeatherStation weatherStation;

    public WeatherStationThread(int temperature, WeatherStation weatherStation){
        this.temperature = temperature;
        this.weatherStation = weatherStation;
    }

    public void run(){
        while (true) {
            if (new Random().nextBoolean()) {
                if (temperature < 50) {
                    temperature++;
                } else temperature--;
            } else if (temperature < -50) {
                temperature++;
            } else temperature--;

            weatherStation.setTemperature(temperature);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
