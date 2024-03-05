import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberGame extends Game{
    Scanner scanner = new Scanner(System.in);
    final int  WIN_SCORE = 10;
    List<Player> numPlayers=new ArrayList<>();
    Random random = new Random();
/*    int numberOfPlayers;

    public NumberGame(int numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
    }*/

    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.println("Guess the correct answer to the Math problems \nEach correct answer gives +2 points \nFirst player to reach 10 points win.\n");
        for (int i=0; i<numberOfPlayers; i++){
            numPlayers.add(new Player());
        }
    }

    @Override
    public boolean endOfGame() {
        for(Player player:numPlayers){
            if(player.score >= WIN_SCORE) return true;
        }
        for(Player player:numPlayers) {
            System.out.println("Player:" + player.id + " Score: " + player.score);
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println("Player turn: " + (player + 1));
        int num1 = random.nextInt(11), num2 = random.nextInt(11), correctAnswer = 0;

        switch (random.nextInt(3) + 1){
            case 1:
                System.out.println( num1 + " + " + num2);
                correctAnswer = num1 + num2;
                break;
            case 2:
                System.out.println( num1 + " - " + num2);
                correctAnswer = num1 - num2;
                break;
            case 3:
                System.out.println( num1 + " * " + num2);
                correctAnswer = num1 * num2;
                break;
        }
        int answer = scanner.nextInt();
        Player player1 = numPlayers.get(player);
        if (answer == correctAnswer) {
            System.out.println("Correct: +2 points\n");
            player1.score += 2;
        }else System.out.println("Incorrect!!!");


    }

    @Override
    public void displayWinner() {
        for(Player player:numPlayers) {
            System.out.println("Player:" + player.id + " Score: " + player.score);
            if (player.score >= WIN_SCORE) {
                System.out.println("Player:" + player.id + " Wins ");
            }
        }
    }
}

