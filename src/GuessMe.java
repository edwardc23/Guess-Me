import java.util.Random;
import java.util.Scanner;

public class GuessMe {
    static Scanner in = new Scanner(System.in);
    static String name;
    static String fin ="y";
    public static void main(String[] args)
    {
        Random rand = new Random();

        System.out.println("Hello! What is your name?");
        name= in.next();
        while(fin.toLowerCase().equals("y")){

            String interpolateMe = "Well, %s, I am thinking of a number between 1 and 20.\n";
            // ↓↓↓↓ your code goes here ↓↓↓↓
            String sen1 = String.format(interpolateMe,name);
            System.out.println(sen1);
            int cpuGuess= rand.nextInt(20)+1;
            newGame(cpuGuess);
        }

    }
    public static boolean Guess(int cpu, int num)
    {
        if (cpu==num)
        {
            System.out.println("Right");
            return true;
        }
        else if(cpu<num)
        {
            System.out.println("Your guess is too high.");
        }
        else if(cpu>num)
        {
            System.out.println("Your guess is too low.");
        }
        return false;


    }
    public static void newGame(int cpuGuess)
    {
        String ans="";
        boolean correct= false;
        boolean news = true;
        int guesses = 0;
        while(news&&guesses<=6){
            System.out.println("Take a guess.");
            int num = in.nextInt();
            correct= Guess(cpuGuess,num);
            guesses++;
            if(guesses==7)
            {
                String complete= ("%s,You Lose \n"+"Would you like to play again? (y or n)");
                String done =String.format(complete,name);
                System.out.println(done);
                fin=in.next();

            }
            if(correct)
            {
                String winner = "Good job, %s! You guessed my number in %s guesses!\n" +
                        "\n" +
                        "Would you like to play again? (y or n)";
                String sen2= String.format(winner,name,guesses);
                System.out.println(sen2);
                guesses=0;
                fin = in.next();
                news=false;

            }
        }


    }

}
