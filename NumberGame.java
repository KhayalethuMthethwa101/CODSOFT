import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    public int num;
    public Boolean playAgain;
    public ArrayList<Integer> scoreList;

    public NumberGame(){
        Random random = new Random();
        this.num = random.nextInt(100);
        this.playAgain = true;
        ArrayList<Integer> newRecord = new ArrayList<>();
        this.scoreList = newRecord;
    }

    public Boolean isCorrect(int inputNum){
        return inputNum == num;
    }

    public String position(int inputNum){
        if (inputNum < this.num){
            return "This number is too low";
        }
        return "This number is too high";
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
                int score = 110; //initial score recieve when the game starts, eachh attampt will deduct it by 10 including the first one
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
                    score-=10;
                }
                newGame.scoreList.add(score);
                System.out.print("Game over, Correct number was: ");
                System.out.print(newGame.num);
                System.out.println();
                System.out.println("Your Score for this round was: "+score);
                System.out.println("=================================");
                System.out.println("Do you want to play a new Game? (Type 1 = yes or 0 = no)");
                int response = input.nextInt();
                newGame.playAgain = newGame.playAgain(response); 
                System.out.println("=================================");
            }
            int totalScore = 0;
            for(int i = 0; i < newGame.scoreList.size();i++){
                System.out.println("Your Score for Round " + i + " was: "+newGame.scoreList.get(i));
                totalScore+=newGame.scoreList.get(i);
            }
            System.out.println("Your Score for this round was: "+totalScore);
        }catch (Exception e) {
            System.out.println("An error occured");
            newGame.playAgain = false;
        }
        System.out.println("Thank you for play with us!!!");
    }
}