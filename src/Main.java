import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.text.NumberFormat;
import java.util.Locale;
public class Main {
    // Chipotle Jr. Plus+

    static Random rnd = new Random();
    static int itemCount = 0;   // current tally of items added so far to the current burrito being made
    static int noBurritos = 25; // number of burritos to make
    static String[] toppingArray = new String[25];
    static int randomNoItems = 0;   // no of items needed for each burrito
    //static String[] rice = {"none", "all", "white", "brown"};
    static String[] rice = {"all", "white", "brown"};
    static String[] meat = {"none", "all","chicken", "steak", "carnidas", "chorizo", "sofritas", "veggies"};
    static String[] beans = {"none", "pinto", "black"};
    static String[] salsa = {"none", "all", "mild", "medium", "hot"};
    static String[] veggies = {"none", "all", "lettuce", "fajita"};
    static boolean cheese = false;
    static boolean guac = false;
    static boolean queso = false;
    static boolean sourCream = false;

    public static void main(String[] args) {
        // Randomly generate a number of ingredients per burrito.
        // Each burrito should have a minimum of 5 ingredients and a maximum of 9 ingredients.
        // Save the finished burritos and display the contents.
        // Calculate and display a price for each burrito.
        // Pricing will be $3.00 plus 0.50 for each additional ingredient.
        randomNoItems = rnd.nextInt(5) + 5; // Number of items to place on the burrito: gen random 5 <= number <= 9

        // test random number generator
//        for (int j=0; j< 20; j++) {
//            randomNoItems = rnd.nextInt(5) + 5;
//            System.out.println("Test: Random number between 5 and 9: " + randomNoItems);
//        }

        for (int i=0; i<25; i++){
            // Build a burrito
            itemCount = 0;
            randomNoItems = rnd.nextInt(5) + 5;
            toppingArray[i] = "";
            toppingArray[i] += getRice();
            toppingArray[i] += getMeat();
            toppingArray[i] += getBeans();

            toppingArray[i] += getSalsa();
            toppingArray[i] += getVeggies();
            toppingArray[i] += getCheese();
            toppingArray[i] += getGuac();
            toppingArray[i] += getSourCream();
            toppingArray[i] += getQueso();

            toppingArray[i] = toppingArray[i].replaceAll(", $", "");    // strip out trailing blanks and commas
            //System.out.println("Your total toppings required for burrito " + i + " is: " + randomNoItems);
            double cost = 3 + itemCount * (0.5);
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String costStr = formatter.format(cost);
            System.out.println("burrito " + i + ": " + toppingArray[i] + " " + costStr);
        }
    }

    static String getRice() {
        String riceToppings = "";
        int randomChoice = 0;
        int lclCnt = 0;
        boolean addAll = false;

        for (int i=0; i< rice.length; i++){
            if (itemCount == randomNoItems) {
                // Already at limit of toppings for this burrrito
                if (lclCnt == 0){
                    return "no rice, ";
                }
                return riceToppings;
            }

            if (addAll) {
                randomChoice = 100;
            }
            else {
                randomChoice = rnd.nextInt(100);
            }
            //System.out.println("getRice: index= " + i + "  random number is: " + randomChoice + " addAll: " + addAll);
            if (randomChoice > 40){
                // add this topping?
                if (!addAll) {
                    if (rice[i].equalsIgnoreCase("none")) {
                        // no rice is added
                        return "no rice, ";
                    } else if (rice[i].equalsIgnoreCase("all")) {
                        //System.out.println("getRice: all was chosen");
                        addAll = true;
                        //continue;
                    }
                }
                // add topping

                if (!rice[i].equalsIgnoreCase("all")) {
                    //System.out.println("getRice: Incrementing Count: " + " Local count= " + lclCnt + " Global count= " + itemCount + " index i= " + i + " rice[i]: " + rice[i]);
                    itemCount++;
                    lclCnt++;
                    riceToppings += rice[i] + " rice, ";
                }
            }
        }
        if (lclCnt==0)
        {
            return ("no rice, ");
        }
        //riceToppings = riceToppings.replaceAll(", $", "");  // strips out blanks and trailing commas
        //System.out.println("Your Rice Toppings are: " + riceToppings);
        return riceToppings;
    }

    static String getMeat() {
        String toppings = "";
        int randomChoice = 0;
        int lclCnt = 0;
        boolean addAll = false;

        for (int i=0; i< meat.length; i++){
            if (itemCount == randomNoItems) {
                // Already at limit of toppings for this burrrito
                if (lclCnt == 0){
                    return "no meat, ";
                }
                return toppings;
            }
            if (addAll) {
                randomChoice = 100;
            }
            else {
                randomChoice = rnd.nextInt(100);
            }
            //System.out.println("getMeat: index= " + i + "  random number is: " + randomChoice + " addAll: " + addAll);
            if (randomChoice > 75){
                // add this topping?
                if (!addAll) {
                    if (meat[i].equalsIgnoreCase("none")) {
                        // no rice is added
                        return "no meat, ";
                    } else if (meat[i].equalsIgnoreCase("all")) {
                        //System.out.println("getMeat: all was chosen");
                        addAll = true;
                    }
                }
                // add topping
                if (!meat[i].equalsIgnoreCase("all")) {
                    //System.out.println("getMeat: Incrementing Count: " + " Local count= " + lclCnt + " Global count= " + itemCount + " index i= " + i + " meat[i]: " + meat[i]);
                    itemCount++;
                    lclCnt++;
                    toppings += meat[i] + " meat, ";
                }
            }
        }
        if (lclCnt==0)
        {
            return ("no meat, ");
        }
        //toppings = toppings.replaceAll(", $", "");  // strips out blanks and trailing commas
        //System.out.println("Your Meat Toppings are: " + toppings);
        return toppings;
    }

    static String getBeans() {
        // beans = {"none", "pinto", "black"};
        String toppings = "";
        int randomChoice = 0;
        int lclCnt = 0;

        for (int i=0; i< beans.length; i++){
            if (itemCount == randomNoItems) {
                // Already at limit of toppings for this burrrito
                if (lclCnt == 0){
                    return "no beans, ";
                }
                return toppings;
            }

            randomChoice = rnd.nextInt(100);

            //System.out.println("getBeans: index= " + i + "  random number is: " + randomChoice + " addAll: " + addAll);
            if (randomChoice > 75){
                // add this topping?
                if (beans[i].equalsIgnoreCase("none")) {
                    // no beans is added
                    return "no beans, ";
                }
                // add topping
                itemCount++;
                lclCnt++;
                toppings += beans[i] + " beans, ";
            }
        }
        if (lclCnt==0)
        {
            return ("no beans, ");
        }
        //toppings = toppings.replaceAll(", $", "");  // strips out blanks and trailing commas
        //System.out.println("Your Bean Toppings are: " + toppings);
        return toppings;
    }

    static String getSalsa() {
        String toppings = "";
        int randomChoice = 0;
        int lclCnt = 0;
        boolean addAll = false;
        //salsa = {"none", "all", "mild", "medium", "hot"};

        for (int i=0; i< salsa.length; i++){
            if (itemCount == randomNoItems) {
                // Already at limit of toppings for this burrrito
                if (lclCnt == 0){
                    return "no salsa, ";
                }
                return toppings;
            }

            if (addAll) {
                randomChoice = 100;
            }
            else {
                randomChoice = rnd.nextInt(100);
            }
            //System.out.println("getSalsa: index= " + i + "  random number is: " + randomChoice + " addAll: " + addAll);
            if (randomChoice > 75){
                // add this topping?
                if (!addAll) {
                    if (salsa[i].equalsIgnoreCase("none")) {
                        // no salsa is added
                        return "no salsa, ";
                    } else if (salsa[i].equalsIgnoreCase("all")) {
                        //System.out.println("getSalsa: all was chosen");
                        addAll = true;
                    }
                }
                // add topping
                if (!salsa[i].equalsIgnoreCase("all")) {
                    //System.out.println("getSalsa: Incrementing Count: " + " Local count= " + lclCnt + " Global count= " + itemCount + " index i= " + i + " salsa[i]: " + salsa[i]);
                    itemCount++;
                    lclCnt++;
                    toppings += salsa[i] + " salsa, ";
                }
            }
        }
        if (lclCnt==0)
        {
            return ("no salsa, ");
        }
        //toppings = toppings.replaceAll(", $", "");  // strips out blanks and trailing commas
        //System.out.println("Your salsa Toppings are: " + toppings);
        return toppings;
    }

    static String getVeggies() {
        //veggies = {"none", "all", "lettuce", "fajita"};
        String toppings = "";
        int randomChoice = 0;
        int lclCnt = 0;
        boolean addAll = false;

        for (int i=0; i< veggies.length; i++){
            if (itemCount == randomNoItems) {
                //System.out.println("No more veggies can be added since the limit of toppings has been reached for this burrrito");
                if (lclCnt == 0){
                    return "no veggies, ";
                }
                return toppings;
            }

            if (addAll) {
                randomChoice = 100;
            }
            else {
                randomChoice = rnd.nextInt(100);
            }
            //System.out.println("getVeggies: index= " + i + "  random number is: " + randomChoice + " addAll: " + addAll);
            if (randomChoice > 75){
                // add this topping?
                if (!addAll) {
                    if (veggies[i].equalsIgnoreCase("none")) {
                        // no veggies is added
                        return "no veggies, ";
                    } else if (veggies[i].equalsIgnoreCase("all")) {
                        //System.out.println("getVeggies: all was chosen");
                        addAll = true;
                    }
                }
                // add topping
                if (!veggies[i].equalsIgnoreCase("all")) {
                    //System.out.println("getVeggies: Incrementing Count: " + " Local count= " + lclCnt + " Global count= " + itemCount + " index i= " + i + " veggies[i]: " + veggies[i]);
                    itemCount++;
                    lclCnt++;
                    toppings += veggies[i] + " veggies, ";
                }
            }
        }
        if (lclCnt==0)
        {
            return ("no veggies, ");
        }
        //toppings = toppings.replaceAll(", $", "");  // strips out blanks and trailing commas
        //System.out.println("Your Veggies Toppings are: " + toppings);
        return toppings;
    }

    static String getCheese() {
        int randomChoice = 0;

        if (itemCount == randomNoItems) {
            //System.out.println("No more Cheese can be added since the limit of toppings has been reached for this burrrito");
            return "no cheese, ";
        }
        randomChoice = rnd.nextInt(100);
        if (randomChoice > 10) {
            itemCount++;
//            cheese = true;
            return "cheese, ";
        }
        else return "no cheese,";
    }

    static String getGuac() {
        int randomChoice = 0;

        if (itemCount == randomNoItems) {
            //System.out.println("No more guac can be added since the limit of toppings has been reached for this burrrito");
            return "no guac, ";
        }
        randomChoice = rnd.nextInt(100);
        if (randomChoice > 10) {
            itemCount++;
            return "guac, ";
        }
        else return "no guac,";
    }

    static String getQueso() {
        int randomChoice = 0;

        if (itemCount == randomNoItems) {
            //System.out.println("No more queso can be added since the limit of toppings has been reached for this burrrito");
            //System.out.println("No more Queso can be added since reached limit of: " + itemCount);
            return "no queso, ";
        }
        randomChoice = rnd.nextInt(100);
        if (randomChoice > 10) {
            itemCount++;
            return "queso, ";
        }
        else return "no queso,";
    }

    static String getSourCream() {
        int randomChoice = 0;

        if (itemCount == randomNoItems) {
            //System.out.println("No more Sour Cream can be added since reached limit of: " + itemCount);
            return "no sour cream, ";
        }
        randomChoice = rnd.nextInt(100);
        if (randomChoice > 10) {
            itemCount++;
            return "sour cream, ";
        }
        else return "no sour cream,";
    }
}
