import java.util.Scanner;

class Main {

    public boolean groundhogParty(int cupCount, boolean isWeekend) {

        int weekendLow = 15;
        int weekendHigh = 25;
        int weekdayLow = 10;
        int weekdayHigh = 20;

        if (isWeekend) {
            return cupCount >= weekendLow && cupCount <= weekendHigh;
        } else return cupCount >= weekdayLow && cupCount <= weekdayHigh;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        // You can use scanner.nextBoolean() to read a boolean value
        int cupCount = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();
        Main main = new Main();
        System.out.println(main.groundhogParty(cupCount, isWeekend));
    }
}
