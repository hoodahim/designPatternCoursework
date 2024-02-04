import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Subject{

    private int temperature;
    private List<Observer> observerList;
    

    public WeatherStation() {
        observerList = new ArrayList<>();
        temperature = (int)(Math.random()*50 +1) ;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int observerIndex = observerList.indexOf(observer);
        if (observerIndex> 0){
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for(Observer observer:observerList){
            observer.updateObserver(temperature);
        }
    }
}
