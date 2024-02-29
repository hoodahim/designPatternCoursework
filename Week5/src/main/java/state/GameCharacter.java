package state;

import java.util.Scanner;

public class GameCharacter {
    String name = "Magic";
    Level level = null;
    double expPoints;
    int healthPoints;
    Scanner scanner = new Scanner(System.in);
    String[] choice = {"Yes", "No"};

    public GameCharacter(){
        this.expPoints = 0;
        this.healthPoints = 100;
    }

    public void run(){
        nameSetup();
        while(confirmation(choice)!= 1) {
            name = null;
            scanner.nextLine();
            nameSetup();
        }
        while (level == null) levelSetup();
        while(name != null){
            level.action();
        }
    }

    public int readUserChoice(String[] action){
        System.out.println("\nSelect an option:");
        for (int i = 1; i <= action.length; i++) {
            System.out.println(i + ". " + action[i-1]);
        }
        return scanner.nextInt();
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void levelCheck(){
        // check level for the character
        if(expPoints < 40 && expPoints >=0){
            setLevel(new Novice(this));
        } else if (expPoints < 60 && expPoints>=40) {
            setLevel(new Intermediate(this));
        } else if (expPoints < 90 && expPoints >=60) {
            setLevel(new Expert(this));
        } else setLevel(new Master(this));
    }

    public void levelSelection(int level){
        switch (level){
            case 1:
                setLevel(new Novice(this));
                setExpPoints(0);
                break;
            case 2:
                setLevel(new Intermediate(this));
                setExpPoints(40);
                break;
            case 3:
                setLevel(new Expert(this));
                setExpPoints(60);
                break;
            case 4:
                setLevel(new Master(this));
                setExpPoints(90);
                break;
            default:
        }

    }

    public double getExpPoints() {

        return expPoints;
    }

    public int getHealthPoints() {
        if (healthPoints < 0) return 0;
        else return  Math.min(healthPoints, 100);
    }

    public void nameSetup(){
        System.out.println("What do we call you (Default name: Magic): ");
        name = scanner.nextLine();
        if(name.equalsIgnoreCase("")) {
            name = "Magic";
        }
        System.out.println("Name: " + name);

    }

    public  void levelSetup(){
        levelSelection(readUserChoice(Level.levels));
    }

    public int confirmation(String[] choice){
        System.out.println("Are you sure?");
        return readUserChoice(choice);
    }

    public void setExpPoints(double expPoints) {
        this.expPoints = expPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void checkHealth(){
        if (healthPoints <=0){
            System.out.println("Your Died! /// GameOver ///");
            System.exit(0);
        }
    }
}
