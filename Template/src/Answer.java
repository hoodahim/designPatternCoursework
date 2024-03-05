import java.util.Scanner;

public class Answer extends Thread{

    Scanner scanner = new Scanner(System.in);
    NumberGame numberGame;

    public Answer(NumberGame numberGame){
        this.numberGame = numberGame;
    }
    @Override
    public void run() {
        numberGame.setAnswer(scanner.nextInt());
    }


}
