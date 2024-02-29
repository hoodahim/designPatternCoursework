package state;

public class Novice extends Level{
    public Novice(GameCharacter character){
        super(character);
        this.name = "Novice";

    }

    @Override
    public void train(){
        increaseExpPoints(randomNumGen(5));
        decreaseHealthPoints(randomNumGen(5));
    }

    @Override
    public void meditate() {
        increaseHealthPoints(randomNumGen(10));
    }

    @Override
    public void fight() {
        increaseExpPoints(randomNumGen(10));
        decreaseHealthPoints(randomNumGen(15));
    }
}
