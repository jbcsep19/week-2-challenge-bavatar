import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
public class Main {
    // Chipotle Jr. Plus+

    static Random rnd = new Random();
    static int itemCount = 0;   // current tally of items added so far to the current burrito being made
    static int noBurritos = 25; // number of burritos to make
    static String[] toppingArray = new String[25];
    static int randomNoItems = 0;   // no of items needed for each burrito
    static String[] rice = {"none", "all", "white", "brown"};

    public static void main(String[] args) {
        // Randomly generate a number of ingredients per burrito.
        // Each burrito should have a minimum of 5 ingredients and a maximum of 9 ingredients.
        // Save the finished burritos and display the contents.
        // Calculate and display a price for each burrito.
        // Pricing will be $3.00 plus 0.50 for each additional ingredient.
        String[] rice = {"none", "all", "white", "brown"};
        String[] meat = {"none", "all","chicken", "steak", "carnidas", "chorizo", "sofritas", "veggies"};
        String[] beans = {"none", "pinto", "black"};
        String[] salsa = {"none", "all", "mild", "medium", "hot"};
        String[] veggies = {"none", "all", "lettuce", "fajita veggies"};
        boolean cheese = false;
        boolean guac = false;
        boolean queso = false;
        boolean SourCream = false;
        int randomNoItems = 0;
        randomNoItems = rnd.nextInt(5) + 5; // Number of items to place on the burrito: gen random 5 <= number <= 9

        // test random number generator
//        for (int j=0; j< 20; j++) {
//            randomNoItems = rnd.nextInt(5) + 5;
//            System.out.println("Test: Random number between 5 and 9: " + randomNoItems);
//        }

        for (int i=0; i<5; i++){
            // Build a burrito
            itemCount = 0;
            randomNoItems = rnd.nextInt(5) + 5;
            toppingArray[i] = "";
            toppingArray[i] += getRice();
            System.out.println("Your total toppings for burrito " + i + " is: " + toppingArray[i] + "  This has: " + itemCount + " toppings");
            // toppingArray[i] += "brown rice" + ",";
        }
//        for (int k=0; k<5; k++){
//            String str = toppingArray[k].replaceAll(", $", "");
//            System.out.println("Your total toppings for burrito " + k + " is: " + str + "  This has: " + itemCount + " toppings");
//        }
    }

    static String getRice() {
        String riceToppings = "";
        int randomChoice = 0;
        int lclCnt = 0;
        boolean addAll = false;

        for (int i=0; i< rice.length; i++){
            if (addAll) {
                randomChoice = 100;
            }
            else {
                randomChoice = rnd.nextInt(100);
            }
            if (randomChoice > 75){
                // add this topping?
                if (!addAll) {
                    if (rice[i].equalsIgnoreCase("none")) {
                        // no rice is added
                        return "no rice";
                    } else if (rice[i].equalsIgnoreCase("all")) {
                        System.out.println("getRice: all was chosen");
                        addAll = true;
                        //continue;
                    }
                }
                // add topping
                System.out.println("getRice: Incrementing Count: " + " Local count= " + lclCnt + " Global count= " + itemCount + " index i= " + i + " rice[i]: " + rice[i]);
                itemCount++;
                lclCnt++;
                riceToppings += rice[i] + " rice,";
            }
        }
        if (lclCnt==0)
        {
            riceToppings = "no rice";
        }
        riceToppings = riceToppings.replaceAll(",$", "");  // strips out blanks and trailing commas
        System.out.println("Your Rice Toppings are: " + riceToppings);
        return riceToppings;
    }
}
