public class ForcastingTemperature implements Observer {

    private float temperature;

    public ForcastingTemperature(Subject weatherStation){
        weatherStation.registerObserver(this);
    }

    @Override
    public void updateObserver(float temperature) {
        this.temperature = temperature;
        System.out.println("Forecasting temperature based on: " + this.temperature);
    }
}
