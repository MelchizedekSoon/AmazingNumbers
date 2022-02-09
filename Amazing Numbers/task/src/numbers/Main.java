package numbers;

import java.math.BigInteger;
import java.util.*;

public class Main {
    boolean isSingle; // if the input is one number
    boolean isMultiple; // if the input is two numbers
    boolean isMultipleSpecific; // if the input is 2 numbers and one word (a number type)
    boolean isMultipleSpecificPlural; // if the input is 2 numbers and multiple words (number types)
    boolean isErred = false;
    boolean isDisplayable = true;
    List<String> availableProperties;
    List<String> includedProperties;
    List<String> notIncludedList;
    BigInteger zero = new BigInteger("0");
    BigInteger one = new BigInteger("1");
    BigInteger two = new BigInteger("2");
    BigInteger seven = new BigInteger("7");
    BigInteger ten = new BigInteger("10");

    public void amazingNumProgram() {
        Scanner scanner = new Scanner(System.in); // Receiving user input
        System.out.println("Welcome to Amazing Numbers!"); // Printing out information on program
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be printed;");
        System.out.println("- two natural numbers and a property to search for");
        System.out.println("- two natural numbers and two properties to search for");
        System.out.println("- a property preceded by minus must not be present in numbers");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        boolean isRunning = true;
        while (isRunning) { // this will run while boolean is set to true, ends on false
            System.out.println();
            System.out.print("Enter a request: ");
            String input = scanner.nextLine(); // taking user input and placing it into String
            input = duplicateRemover(input); // taking String and checking for duplicate commands
            int spaces = input.split("\\s+").length; // checking for how many words/numbers are in input
            if (spaces == 1) {
                if (input.equals("0")) {
                    System.out.println();
                    System.out.println("Goodbye!");
                    isRunning = false;
                }
                isSingle = true;
            } else if (spaces == 2) {
                isMultiple = true;
            } else if (spaces == 3) {
                isMultipleSpecific = true;
            } else if (spaces > 3) {
                isMultipleSpecificPlural = true;
            }
            this.availableProperties = new ArrayList<>(); // creating a list to add number types
            this.notIncludedList = new ArrayList<>(); // creating a list for if input does not match one of the number types
            this.availableProperties.add("EVEN");
            this.availableProperties.add("ODD");
            this.availableProperties.add("BUZZ");
            this.availableProperties.add("DUCK");
            this.availableProperties.add("PALINDROMIC");
            this.availableProperties.add("GAPFUL");
            this.availableProperties.add("SPY");
            this.availableProperties.add("SUNNY");
            this.availableProperties.add("SQUARE");
            this.availableProperties.add("JUMPING");
            this.availableProperties.add("HAPPY");
            this.availableProperties.add("SAD");
            this.availableProperties.add("-EVEN");
            this.availableProperties.add("-ODD");
            this.availableProperties.add("-BUZZ");
            this.availableProperties.add("-DUCK");
            this.availableProperties.add("-PALINDROMIC");
            this.availableProperties.add("-GAPFUL");
            this.availableProperties.add("-SPY");
            this.availableProperties.add("-SUNNY");
            this.availableProperties.add("-SQUARE");
            this.availableProperties.add("-JUMPING");
            this.availableProperties.add("-HAPPY");
            this.availableProperties.add("-SAD");
            System.out.println();
            if (isRunning) {
                if (isSingle) {
                    BigInteger number = new BigInteger("-1"); //Creating a BigInteger number. This is used for large numbers. It's set to -1 because it must be 0 or greater. We will update this in the following code
                    try {
                        number = BigInteger.valueOf(Long.parseLong(input)); //Trying to add number, if it isn't a number, it will catch an exception and go to catch
                    } catch (NumberFormatException ignored) {
                    }
                    int numCompare = number.compareTo(zero); //We are comparing the number to 0 and if it is less, it returns -1, if equal 0, if greater 1
                    if (numCompare <= 0) { //this will be fulfilled if the int above is less than or equal to 0. This is to ensure that the number is greater or equal to 0 as required
                        System.out.println("The first parameter should be a natural number or zero.");
                    } else { //if it is greater than 0, the following will fulfill
                        System.out.println("Properties of " + number);
                        System.out.println("even: " + evenChecker(number)); //This returns a boolean of true or false, true if the number is even, false is not. This is the case for all of these checkers and their code further down
                        System.out.println("odd: " + oddChecker(number));
                        System.out.println("buzz: " + buzzChecker(number));
                        System.out.println("duck: " + duckChecker(number));
                        System.out.println("palindromic: " + palindromicChecker(number));
                        System.out.println("gapful: " + gapfulChecker(number));
                        System.out.println("spy: " + spyChecker(number));
                        System.out.println("sunny: " + sunnyChecker(number));
                        System.out.println("square: " + squareChecker(number));
                        System.out.println("jumping: " + jumpingChecker(number));
                        System.out.println("happy: " + happyChecker(number));
                        System.out.println("sad: " + sadChecker(number));
                    }
                } else {
                    String[] requestArray = input.toUpperCase().split(" "); //array of the user input
                    BigInteger startingNum = BigInteger.valueOf(Long.parseLong(requestArray[0])); //the starting number from the input
                    BigInteger numAmount = BigInteger.valueOf(Long.parseLong(requestArray[1])); //the amount of numbers required from the input
                    if (isMultiple) {
                        if (Long.parseLong(String.valueOf(startingNum)) < 0) { //number checkers again
                            System.out.println("The first parameter should be a natural number or zero.");
                        }
                        if (Long.parseLong(String.valueOf(numAmount)) <= 0) {
                            System.out.println("The second parameter should be a natural number.");
                        } else {
                            for (int i = 0; i < Long.parseLong(String.valueOf(numAmount)); i++) {
                                System.out.print(startingNum + " is ");
                                StringBuilder sb = new StringBuilder();
                                if (evenChecker(startingNum)) { //these test if the number is even, if so, it adds the text below it
                                    sb.append(" even,");
                                } else if (oddChecker(startingNum)) {
                                    sb.append(" odd,");
                                }
                                if (buzzChecker(startingNum)) {
                                    sb.append(" buzz,");
                                }
                                if (duckChecker(startingNum)) {
                                    sb.append(" duck,");
                                }
                                if (palindromicChecker(startingNum)) {
                                    sb.append(" palindromic,");
                                }
                                if (gapfulChecker(startingNum)) {
                                    sb.append(" gapful,");
                                }
                                if (spyChecker(startingNum)) {
                                    sb.append(" spy,");
                                }
                                if (sunnyChecker(startingNum)) {
                                    sb.append(" sunny,");
                                }
                                if (squareChecker(startingNum)) {
                                    sb.append(" square,");
                                }
                                if (jumpingChecker(startingNum)) {
                                    sb.append(" jumping,");
                                }
                                if (happyChecker(startingNum)) {
                                    sb.append(" happy,");
                                }
                                if (sadChecker(startingNum)) {
                                    sb.append(" sad,");
                                }
                                System.out.println(sb.toString().trim().substring(0, sb.toString().length() - 2)); //this removes the last pieces of the String so it doesn't end in "happy, " but "happy"
                                startingNum = startingNum.add(one);
                            }
                        }
                    } else if (isMultipleSpecific) {
                        String numType = requestArray[2].toUpperCase(); //The number type ("even, odd") etc.
                        int numTypeCount = 0;
                        boolean isProperty = false; //boolean to ensure that the number type the user inputs is in the available property list which includes all the even, odd options
                        for (String properties : this.availableProperties) {
                            if (properties.equals(numType)) {
                                isProperty = true;
                                break;
                            }
                        }
                        try {
                            if (Long.parseLong(String.valueOf(startingNum)) < 0) {
                                System.out.println("The first parameter should be a natural number or zero.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("The first parameter should be a natural number or zero.");
                        }
                        try {
                            if (Long.parseLong(String.valueOf(startingNum)) < 0) {
                                System.out.println("The second parameter should be a natural number.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("The second parameter should be a natural number.");
                        }
                        if (!isProperty) {
                            System.out.println("The property [" + numType + "] is wrong."); //if it is not a property, this is displayed
                            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE, JUMPING, HAPPY, SAD]");
                        } else {
                            while (numTypeCount < Long.parseLong(String.valueOf(numAmount))) {
                                StringBuilder sb = new StringBuilder(); //same as above
                                if (evenChecker(startingNum)) {
                                    sb.append(" even,");
                                } else if (oddChecker(startingNum)) {
                                    sb.append(" odd,");
                                }
                                if (buzzChecker(startingNum)) {
                                    sb.append(" buzz,");
                                }
                                if (duckChecker(startingNum)) {
                                    sb.append(" duck,");
                                }
                                if (palindromicChecker(startingNum)) {
                                    sb.append(" palindromic,");
                                }
                                if (gapfulChecker(startingNum)) {
                                    sb.append(" gapful,");
                                }
                                if (spyChecker(startingNum)) {
                                    sb.append(" spy,");
                                }
                                if (sunnyChecker(startingNum)) {
                                    sb.append(" sunny,");
                                }
                                if (squareChecker(startingNum)) {
                                    sb.append(" square,");
                                }
                                if (jumpingChecker(startingNum)) {
                                    sb.append(" jumping,");
                                }
                                if (happyChecker(startingNum)) {
                                    sb.append(" happy,");
                                }
                                if (sadChecker(startingNum)) {
                                    sb.append(" sad,");
                                }
                                String line = sb.toString().trim().substring(0, sb.toString().length() - 2);
                                if (numType.startsWith("-")) { //if the string starts with - like -EVEN, we want to go to the code under it
                                    String minus = numType.substring(1); //this makes -EVEN, EVEN so String minus = "EVEN" if numType = "-EVEN"
                                    if (!(sb.toString().toUpperCase().contains(minus))) { //this means if the String does not contain minus, because we're not including anything that is minus because that num type is excluded, then we do the code under it
                                        numTypeCount++;
                                        System.out.print(startingNum + " is ");
                                        System.out.println(line);
                                    }
                                } else if (sb.toString().toUpperCase().contains(numType)) { //if the number type doesn't start with "-" then we want to display because we want the numType included as that means the number is an even or happy or jumping number etc.
                                    numTypeCount++;
                                    System.out.print(startingNum + " is ");
                                    System.out.println(line);

                                }
                                startingNum = startingNum.add(one); //this increases the starting number by one so we can check the next number up until we have gotten all the numbers required be that 10 or 20 whatever was inputted
                            }
                        }
                    } else if (isMultipleSpecificPlural) {
                        int numTypeCount = 0;
                        boolean isIncluded;
                        for (String includedProperty : this.includedProperties) { // this is a check to see if Strings that were inputted are all contained in availableProperties
                            isIncluded = false;
                            for (String availableProperty : availableProperties) {
                                if (availableProperty.equals(includedProperty)) {
                                    isIncluded = true; //if it is we can break and set the boolean to true because it is
                                    break;
                                }
                            }
                            if (!isIncluded) { //if not, we will go here after we've searched through all available properties for matching property and then add it to the notIncluded list
                                this.notIncludedList.add(includedProperty);
                            }
                        }
                        try {
                            if (Long.parseLong(String.valueOf(requestArray[0])) <= 0) {//checking for below 0. It actually says equal to 0, it may should've been < 0
                                System.out.println("The first parameter should be a natural number or zero.");
                            }
                        } catch (NumberFormatException e) {
                            this.isErred = true;
                            System.out.println("The first parameter should be a natural number or zero.");
                        }
                        try {
                            if (Long.parseLong(String.valueOf(requestArray[1])) < 0) {// same as above
                                System.out.println("The second parameter should be a natural number.");
                            }
                        } catch (NumberFormatException e) {
                            if (!this.isErred) {
                                this.isErred = true;
                            }
                            System.out.println("The second parameter should be a natural number.");
                        }
                        if (this.notIncludedList.size() == 1) {
                            if (!this.isErred) {
                                this.isErred = true;
                            }
                            System.out.println("The property [" + this.notIncludedList.get(0) + "] is wrong.");
                            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE, JUMPING, HAPPY, SAD]");
                        } else if (this.notIncludedList.size() > 1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("[");
                            for (String notIncluded : this.notIncludedList) {
                                sb.append(notIncluded).append(", ");
                            }
                            String notListed = sb.substring(0, sb.length() - 2);
                            notListed += "]";
                            this.isErred = true;
                            System.out.println("The properties " + notListed + " are wrong.");
                            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE, JUMPING, HAPPY, SAD]");
                        }
                        if ((this.includedProperties.contains("EVEN") && this.includedProperties.contains("ODD")) || //checking if its input has even and odd as it can't be both
                                (this.includedProperties.contains("-EVEN") && this.includedProperties.contains("-ODD"))) {
                            if (!this.isErred) {
                                this.isErred = true;
                            }
                            if (this.includedProperties.contains("EVEN") && this.includedProperties.contains("ODD")) {
                                System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]");
                                System.out.println("There are no numbers with these properties.");
                            } else if (this.includedProperties.contains("-EVEN") && this.includedProperties.contains("-ODD")) {
                                System.out.println("The request contains mutually exclusive properties: [-EVEN, -ODD]");
                                System.out.println("There are no numbers with these properties.");
                            }
                        }
                        if ((this.includedProperties.contains("DUCK") && this.includedProperties.contains("SPY")) || (this.includedProperties.contains("-DUCK") && this.includedProperties.contains("-SPY"))) { //cant have duck and spy
                            if (!this.isErred) {
                                this.isErred = true;
                            }
                            if (this.includedProperties.contains("DUCK") && this.includedProperties.contains("SPY")) {
                                System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]");
                                System.out.println("There are no numbers with these properties.");
                            } else if (this.includedProperties.contains("-DUCK") && this.includedProperties.contains("-SPY")) {
                                System.out.println("The request contains mutually exclusive properties: [-DUCK, -SPY]");
                                System.out.println("There are no numbers with these properties.");
                            }
                        }
                        if ((this.includedProperties.contains("SUNNY") && this.includedProperties.contains("SQUARE")) || (this.includedProperties.contains("-SUNNY") && this.includedProperties.contains("-SQUARE"))) { //cant be sunny and square
                            if (!this.isErred) {
                                this.isErred = true;
                            }
                            if (this.includedProperties.contains("SUNNY") && this.includedProperties.contains("SQUARE")) {
                                System.out.println("The request contains mutually exclusive properties: [SUNNY, SQUARE]");
                                System.out.println("There are no numbers with these properties.");
                            } else if (this.includedProperties.contains("-SUNNY") && this.includedProperties.contains("-SQUARE")) {
                                System.out.println("The request contains mutually exclusive properties: [-SUNNY, -SQUARE]");
                                System.out.println("There are no numbers with these properties.");
                            }
                        }
                        if ((this.includedProperties.contains("SAD") && this.includedProperties.contains("HAPPY")) || //cant be sad and happy
                                (this.includedProperties.contains("-SAD") && this.includedProperties.contains("-HAPPY"))) {
                            if (!this.isErred) {
                                this.isErred = true;
                            }
                            if (this.includedProperties.contains("SAD") && this.includedProperties.contains("HAPPY")) {
                                System.out.println("The request contains mutually exclusive properties: [SAD, HAPPY]");
                                System.out.println("There are no numbers with these properties.");
                            } else if (this.includedProperties.contains("-SAD") && this.includedProperties.contains("-HAPPY")) {
                                System.out.println("The request contains mutually exclusive properties: [-SAD, -HAPPY]");
                                System.out.println("There are no numbers with these properties.");
                            }
                        }
                        propertyComparer(); //checks if input has -EVEN and EVEN type pairs i.e. -JUMPING, JUMPING
                        if (!this.isErred) { //if isErred, the boolean made to check for error is false, we will go to code below
                            while (numTypeCount < Long.parseLong(String.valueOf(numAmount))) {
                                StringBuilder sb = new StringBuilder();
                                if (evenChecker(startingNum)) { //same as before
                                    sb.append(" even,");
                                } else if (oddChecker(startingNum)) {
                                    sb.append(" odd,");
                                }
                                if (buzzChecker(startingNum)) {
                                    sb.append(" buzz,");
                                }
                                if (duckChecker(startingNum)) {
                                    sb.append(" duck,");
                                }
                                if (palindromicChecker(startingNum)) {
                                    sb.append(" palindromic,");
                                }
                                if (gapfulChecker(startingNum)) {
                                    sb.append(" gapful,");
                                }
                                if (spyChecker(startingNum)) {
                                    sb.append(" spy,");
                                }
                                if (sunnyChecker(startingNum)) {
                                    sb.append(" sunny,");
                                }
                                if (squareChecker(startingNum)) {
                                    sb.append(" square,");
                                }
                                if (jumpingChecker(startingNum)) {
                                    sb.append(" jumping,");
                                }
                                if (happyChecker(startingNum)) {
                                    sb.append(" happy,");
                                }
                                if (sadChecker(startingNum)) {
                                    sb.append(" sad,");
                                }
                                for (String property : this.includedProperties) {
                                    String minus;
                                    if (property.startsWith("-")) {
                                        minus = property.substring(1);
                                        if (sb.toString().toUpperCase().contains(minus)) {
                                            isDisplayable = false;
                                            break;
                                        }
                                    } else if (!(sb.toString().toUpperCase().contains(property))) {
                                        isDisplayable = false;
                                        break;
                                    }
                                }
                                if (isDisplayable) {
                                    numTypeCount++;
                                    System.out.print(startingNum + " is");
                                    System.out.println(sb.substring(0, sb.length() - 1));
                                }
                                isDisplayable = true;
                                startingNum = startingNum.add(one);
                            }
                        }
                    }
                }
            }
        }

    }

    public boolean evenChecker(BigInteger number) {
        String numAsString = String.valueOf(number);
        long lastDigit = Long.parseLong(numAsString.substring(numAsString.length() - 1));
        return lastDigit % 2 == 0;
    }

    public boolean oddChecker(BigInteger number) {
        String numAsString = String.valueOf(number);
        long lastDigit = Long.parseLong(numAsString.substring(numAsString.length() - 1));
        return lastDigit % 2 == 1;
    }

    public boolean buzzChecker(BigInteger number) {
        String numberAsString = String.valueOf(number);
        if (numberAsString.endsWith("7")) {
            return true;
        } else {
            if (numberAsString.length() == 1) {
                return false;
            }
            BigInteger remNum = new BigInteger(numberAsString.substring(0, numberAsString.length() - 1));
            BigInteger lastDigit = new BigInteger(numberAsString.substring(numberAsString.length() - 1));
            return remNum.subtract(lastDigit.multiply(two)).mod(seven).equals(zero);
        }
    }

    public boolean duckChecker(BigInteger number) {
        String numberAsString = String.valueOf(number);
        int zeroCount = 0;
        for (int i = 0; i < numberAsString.length(); i++) {
            if (numberAsString.charAt(i) == '0') {
                zeroCount++;
            }
        }
        if (zeroCount == 1) {
            return !numberAsString.startsWith("0");
        } else return zeroCount > 1;
    }

    public boolean palindromicChecker(BigInteger number) {
        String numberAsString = String.valueOf(number);
        StringBuilder reverseBuilder = new StringBuilder();
        for (int i = numberAsString.length() - 1; i >= 0; i--) {
            reverseBuilder.append(numberAsString.charAt(i));
        }
        return numberAsString.equals(reverseBuilder.toString());
    }

    public boolean gapfulChecker(BigInteger number) {
        String numberAsString = String.valueOf(number);
        if (numberAsString.length() >= 3) {
            BigInteger firstDigit = new BigInteger(String.valueOf(numberAsString.charAt(0))).multiply(ten);
            BigInteger lastDigit = new BigInteger(String.valueOf(numberAsString.charAt(numberAsString.length() - 1)));
            BigInteger digit = firstDigit.add(lastDigit);
            return number.mod(digit).equals(zero);
        }
        return false;
    }

    public boolean spyChecker(BigInteger number) {
        String[] numberArray = number.toString().split("");
        int sumOfNums = 0;
        int productOfNums = 1;
        for (String s : numberArray) {
            sumOfNums += Integer.parseInt(s);
            productOfNums *= Integer.parseInt(s);
        }
        return sumOfNums == productOfNums;
    }

    public boolean sunnyChecker(BigInteger number) {
        long num = Long.parseLong(String.valueOf(number.add(one)));
        return num % Math.sqrt(num) == 0;
    }

    public boolean squareChecker(BigInteger number) {
        long num = Long.parseLong(String.valueOf(number));
        return num % Math.sqrt(num) == 0;
    }

    public boolean jumpingChecker(BigInteger number) {
        String[] numArray = String.valueOf(number).split("");
        for (int i = 0; i < numArray.length - 1; i++) {
            long current = Long.parseLong(numArray[i]);
            long next = Long.parseLong(numArray[i + 1]);
            if (current > next) {
                if (current - next != 1) {
                    return false;
                }
            } else if (current < next) {
                if (next - current != 1) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean happyChecker(BigInteger number) {
        int infiniteCount = 0;
        long original = Long.parseLong(String.valueOf(number));
        String numAsString = String.valueOf(number);
        char[] numArray;
        long total;
        while (true) {
            total = 0;
            numArray = numAsString.toCharArray();
            for (char c : numArray) {
                total += Math.pow(Long.parseLong(String.valueOf(c)), 2);
            }
            if (total == 1) {
                return true;
            } else if (total == original || infiniteCount == 10) {
                return false;
            }
            numAsString = String.valueOf(total);
            infiniteCount++;
        }
    }

    public boolean sadChecker(BigInteger number) {
        int infiniteCount = 0;
        long original = Long.parseLong(String.valueOf(number));
        String numAsString = String.valueOf(number);
        char[] numArray;
        long total;
        while (true) {
            total = 0;
            numArray = numAsString.toCharArray();
            for (char c : numArray) {
                total += Math.pow(Long.parseLong(String.valueOf(c)), 2);
            }
            if (total == 1) {
                return false;
            } else if (total == original || infiniteCount == 10) {
                return true;
            }
            numAsString = String.valueOf(total);
            infiniteCount++;
        }
    }

    public void propertyComparer() {
        for (String property : this.availableProperties) {
            if ((this.includedProperties.contains("-" + property) && this.includedProperties.contains(property))) {
                if (!this.isErred) {
                    this.isErred = true;
                }
                if (this.includedProperties.contains("-" + property) && this.includedProperties.contains(property)) {
                    System.out.println("The request contains mutually exclusive properties: [" + property + ", " + "-" + property + "]");
                    System.out.println("There are no numbers with these properties.");
                }
            }
        }
    }

    public String duplicateRemover(String input) {
        String[] requestArray = input.split(" ");
        if (requestArray.length < 3) {
            return input.trim();
        }
        this.includedProperties = new ArrayList<>();
        this.includedProperties.addAll(Arrays.asList(requestArray).subList(2, requestArray.length));
        Map<String, Integer> treeMap = new TreeMap<>();
        for (String property : this.includedProperties) {
            Integer count = treeMap.get(property);
            treeMap.put(property, count == null ? 1 : count + 1);
        }
        this.includedProperties.clear();
        for (Map.Entry<String, Integer> each : treeMap.entrySet()) {
            this.includedProperties.add(each.getKey().toUpperCase());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(requestArray[0]).append(" ").append(requestArray[1]).append(" ");
        for (String property : this.includedProperties) {
            sb.append(property).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Main one = new Main();
        one.amazingNumProgram();
    }
}
