public class CurrentTemperature implements Observer{

    private float temperature;

    public CurrentTemperature(Subject weatherStation){
        weatherStation.registerObserver(this);

    }

    @Override
    public void updateObserver(float temperature) {
        this.temperature = temperature;
        System.out.println("The current temperature is: " + this.temperature);
    }
}
