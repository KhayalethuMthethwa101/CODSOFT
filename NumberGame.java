import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    public int num;
    public Boolean playAgain;

    public NumberGame(){
        Random random = new Random();
        this.num = random.nextInt(100);
        this.playAgain = true;
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
    public Boolean playAgain(int answer){
        Random random = new Random();
        this.num = random.nextInt(100);
        return answer == 1;
    }

    public static void main(String[] args) {
        NumberGame newGame = new NumberGame();
        try (Scanner input = new Scanner(System.in)){
            while(newGame.playAgain){
                System.out.println("Lets play a game, Guess a number between 1 and 100. You have 10 attempts. Goodluck!");
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
                System.out.print("Game over, Correct number was: ");
                System.out.print(newGame.num);
                System.out.println();
                System.out.println("Do you want to play a new Game? (Type 1 = yes or 0 = no)");
                int response = input.nextInt();
                newGame.playAgain = newGame.playAgain(response); 
            }
        }catch (Exception e) {
            System.out.println("An error occured");
            newGame.playAgain = false;
        }
        System.out.println("Thank you for play with us!!!");
    }
}