import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    public int num;

    public NumberGame(){
        Random random = new Random();
        this.num = random.nextInt(100);
    }

    public Boolean isCorrect(int inputNum){
        return inputNum == num;
    }

    public String position(int inputNum){
        if (inputNum < this.num){
            return "This number is too low";
        }
        else{
            return "This number is too high";
        }
    }

    public static void main(String[] args) {
        System.out.println("Lets play a game, Guess a number between 1 and 100. You have 10 attempts. Goodluck!");
        NumberGame newGame = new NumberGame();
        try (Scanner input = new Scanner(System.in)) {
            int guessNum = input.nextInt();
            int tracker = 0;
            while (tracker < 10){
                if(newGame.isCorrect(guessNum)){
                    System.out.println("correct Number, you Win");
                    tracker +=10;
                }
                else{
                    System.out.println(newGame.position(guessNum));
                    guessNum = input.nextInt();
                    tracker+=1;
                }
            }
            if (tracker>=10){
                System.out.println("Game over, Correct number was: ");
                System.out.print(newGame.num);
            }  
        } catch (Exception e) {
            System.out.println("An error occured");
        }
    }
}