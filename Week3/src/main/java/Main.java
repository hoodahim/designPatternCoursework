public class Main {
    public static void main(String [] args) throws InterruptedException {

        WeatherStation weatherStation = new WeatherStation();
        Observer currentTemperature1 = new CurrentTemperature(weatherStation);
        Observer currentTemperature2 = new CurrentTemperature(weatherStation);
        Observer forecastTemperature1 = new ForcastingTemperature(weatherStation);
        Observer forecastTemperature2 = new ForcastingTemperature(weatherStation);

        Thread t1 = new WeatherStationThread(weatherStation.getTemperature(), weatherStation);

        t1.start();

        for(int i=0; i<5; i++){
            weatherStation.notifyObserver();
            Thread.sleep(5000);
        }

        weatherStation.removeObserver(currentTemperature2);

        for(int i=0; i<5; i++){
            weatherStation.notifyObserver();
            Thread.sleep(5000);
        }





    }
}
