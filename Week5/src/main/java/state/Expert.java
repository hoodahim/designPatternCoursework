package state;

public class Expert extends Level{

    public Expert(GameCharacter character){
        super(character);
        name = "Expert";
    }

    @Override
    public void train(){
        increaseExpPoints(randomNumGen(15));
        decreaseHealthPoints(randomNumGen(15));
    }

    @Override
    public void meditate() {
        increaseHealthPoints(randomNumGen(20));
    }

    @Override
    public void fight() {
        increaseExpPoints(randomNumGen(20));
        decreaseHealthPoints(randomNumGen(25));
    }
}
