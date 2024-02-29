package state;

import java.util.Random;

public abstract class Level {

    Random random = new Random();
    GameCharacter character;
    String[] option = {"train", "meditate", "fight"};
    public static String[] levels = {"Novice", "Intermediate", "Expert", "Master"};
    String name;
    public Level(GameCharacter character){
        this.character = character;
    }

    public void action(){
        character.levelCheck();
        character.checkHealth();
        System.out.println(character.name + " Level:" + name + " HP:" + character.getHealthPoints() + " XP:" + character.getExpPoints());
        switch (character.readUserChoice(option)){
            case 1:
                train();
                break;
            case 2:
                meditate();
                break;
            case 3:
                fight();
        }
    };
    public void train(){}
    public void meditate(){}
    public void fight(){}

    public int randomNumGen(int bound){
        return random.nextInt(bound) + 1;
    }

    public void increaseHealthPoints(int value){
        character.healthPoints += value;
    }

    public void decreaseHealthPoints(int value){
        character.healthPoints -= value;
    }

    public void increaseExpPoints(int value){
        character.expPoints += value;
    }

/*    public void decreaseExpPoints(int value){
        character.expPoints -= value;
    }*/

}
