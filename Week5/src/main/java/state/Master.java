package state;

public class Master extends Level{

    public Master(GameCharacter character){
        super(character);
        name = "Master";
    }

    @Override
    public void train(){
        increaseExpPoints(randomNumGen(20));
        decreaseHealthPoints(randomNumGen(20));
    }

    @Override
    public void meditate() {
        increaseHealthPoints(randomNumGen(25));
    }

    @Override
    public void fight() {
        decreaseHealthPoints(randomNumGen(30));
        increaseExpPoints(randomNumGen(25));
    }
}
