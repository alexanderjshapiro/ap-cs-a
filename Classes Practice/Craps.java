import java.util.Scanner;

/**
 * The Craps class plays a game of craps using MyRandom objects as dice. 
 * The program utilizes user input to control the game.
 *
 * @author Alexander Shapiro
 * @version 2/14/18
 */
public class Craps
{
    public static void main()
    {
        // Instatiate dice objects
        MyRandom dice1 = new MyRandom(1,6);
        MyRandom dice2 = new MyRandom(1,6);
        
        // Instantiate console scanner object
        Scanner scanner = new Scanner(System.in);
        
        System.out.print('\u000C');
        calibrateWindow();
        String windowCalibrated = scanner.nextLine();
        if (windowCalibrated.equals(""))
        {
            System.out.print('\u000C');
        }
        
        // Welcome first-time user
        System.out.println("Welcome to the craps table!");
        System.out.println("You double your wager if you win, but lose your wager if you lose.");
        System.out.println();
        
        int bal = 1000;
        
        boolean playing = true;
        while (playing)
        {
            // Notify player of cash in wallet and place wager
            System.out.println("You have $" + bal + ". Type the amount of money to bet and press enter.");
            
            // Set the wager and match it in the wallet variable
            int wager = setWager();
            
            System.out.println("Your wager is $" + wager + " and you have $" + (bal - wager) + " left.");
            System.out.println("Are you sure? (yes/no)");
            String finalWager = scanner.nextLine();
            if (finalWager.equals("no"))
            {
                wager = setWager();
            }
            
            // Declare and instantiate dice value variables
            int dice1Val = 0;
            int dice2Val = 0;
            
            // Prompt player to roll dice, then roll
            System.out.println("Press r then enter to roll the dice.");
            String roll = scanner.nextLine();
            if (roll.equals("r"))
            {
                dice1Val = dice1.nextRandom();
                dice2Val = dice2.nextRandom();
            }
            // Print ASCII dice to console
            printDice(dice1Val, dice2Val);
            
            // Add dice values together
            int totalVal = dice1Val + dice2Val;
            
            // Check come out roll for instant win or loss
            if (totalVal == 7 || totalVal == 11)
            {
                System.out.println("You won $" + (wager * 2) + "! You rolled a " + totalVal + ".");
                bal += wager * 2;
            }
            else if (totalVal == 2 || totalVal == 3 || totalVal == 12)
            {
                System.out.println("You lost $" + wager + "! You rolled a " + totalVal + ".");
                bal -= wager;
            }
            // Turn the come out roll into the point and continue
            else
            {
                System.out.println("The come out roll is a " + totalVal + ".");
                int point = totalVal;
                totalVal = 0;
                
                // Keep rolling until a win or a loss
                while (totalVal != point && totalVal != 7)
                {
                    // Prompt user to roll dice, then roll
                    System.out.println("Press r then enter to roll the dice again.");
                    roll = scanner.nextLine();
                    if (roll.equals("r"))
                    {
                        dice1Val = dice1.nextRandom();
                        dice2Val = dice2.nextRandom();
                    }
                    
                    // Print ASCII dice to console
                    printDice(dice1Val, dice2Val);
                    
                    // Add dice values together
                    totalVal = dice1Val + dice2Val;
                    
                    // Check for win or loss
                    if (totalVal == point)
                    {
                        System.out.println("You won $" + (wager * 2) + "! You rolled a " + totalVal + " and the point was " + point + ".");
                        bal += wager * 2;
                    }
                    else if (totalVal == 7)
                    {
                        System.out.println("You lost $" + wager + "! You rolled a " + totalVal + ".");
                        bal -= wager;
                    }
                    else
                    {
                        System.out.println("You rolled a " + totalVal + ", but the point is " + point + ".");
                    }
                }
            }
            
            // Notify user of current amount of money and ask to continue playing
            System.out.println("You have $" + bal + ". Would you like to play again? (yes/no): ");
            String play = scanner.nextLine();
            boolean choiceWasMade = false;
            while (!choiceWasMade)
            {
                if (play.equals("yes"))
                {
                    playing = true;
                    choiceWasMade = true;
                }
                else if (play.equals("no"))
                {
                  System.out.println("Are you sure? (yes/no): ");
                  play = scanner.nextLine();
                  if (play.equals("yes")) 
                  {
                       System.out.println("Ending...");
                       playing = false;
                       choiceWasMade = true;
                  }
                  else if (play.equals("no"))
                  {
                      choiceWasMade = false;
                  }
                  else
                  {
                      System.out.println("Input not recognized. Please answer with \"yes\" or \"no\" and press enter.");
                      choiceWasMade = false;
                      play = scanner.nextLine();
                  }
                }
                else
                {
                    System.out.println("Input not recognized. Please answer with \"yes\" or \"no\" and press enter.");
                    choiceWasMade = false;
                    play = scanner.nextLine();
                }
            }
        }
        
    }
    
    // Sets wager of current play
    public static int setWager()
    {
        Scanner scanner = new Scanner(System.in);
        String setWager = scanner.nextLine();
        
        // Check to make sure the wager is only number, if not ask for another input
        while (!setWager.matches("[0-9]+") || setWager.equals("0"))
        {
            System.out.println("You wager has to be at least $1. Enter a new integer amount.");
            setWager = scanner.nextLine();
        }
        
        // Convert the wager from a string to an integer
        return Integer.parseInt(setWager);
    }
    
    // Call drawDice method on each dice object
    public static void printDice(int dice1Val, int dice2Val)
    {
        drawDice(dice1Val);
        drawDice(dice2Val);
        
    }
    
    // Check the nextRandom values and print ASCII ice to console
    public static void drawDice(int diceVal)
    {
        if (diceVal == 1)
        {
            System.out.println(" -------");
            System.out.println("|       |");
            System.out.println("|   o   |");
            System.out.println("|       |");
            System.out.println(" -------");
        }
        else if (diceVal == 2)
        {
            System.out.println(" -------");
            System.out.println("| o     |");
            System.out.println("|       |");
            System.out.println("|     o |");
            System.out.println(" -------");
        }
        else if (diceVal == 3)
        {
            System.out.println(" -------");
            System.out.println("| o     |");
            System.out.println("|   o   |");
            System.out.println("|     o |");
            System.out.println(" -------");
        }
        else if (diceVal == 4)
        {
            System.out.println(" -------");
            System.out.println("| o   o |");
            System.out.println("|       |");
            System.out.println("| o   o |");
            System.out.println(" -------");
        }
        else if (diceVal == 5)
        {
            System.out.println(" -------");
            System.out.println("| o   o |");
            System.out.println("|   o   |");
            System.out.println("| o   o |");
            System.out.println(" -------");
        }
        else if (diceVal == 6)
        {
            System.out.println(" -------");
            System.out.println("| o   o |");
            System.out.println("| o   o |");
            System.out.println("| o   o |");
            System.out.println(" -------");
        }
    }
    
    public static void calibrateWindow()
    {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("| Adjust the window so the scroll bars disappear. Press enter to continue.     |");
        for (int i = 0; i <= 17; i++)
        {
            System.out.println("|                                                                              |");
        }
        System.out.print("--------------------------------------------------------------------------------");
    }
}
