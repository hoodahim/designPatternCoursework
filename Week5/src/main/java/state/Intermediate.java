package state;

public class Intermediate extends Level{

    public Intermediate(GameCharacter character){
        super(character);
        name = "Intermediate";
    }

    @Override
    public void train(){
        increaseExpPoints(randomNumGen(10));
        decreaseHealthPoints(randomNumGen(10));
    }

    @Override
    public void meditate() {
        increaseHealthPoints(randomNumGen(15));
    }

    @Override
    public void fight() {
        increaseExpPoints(15);
        decreaseHealthPoints(20);
    }

}
