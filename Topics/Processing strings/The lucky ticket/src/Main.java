import java.util.Scanner;

class Main {

    public static void ticketChecker() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        final String FIRST_SECTION = input.substring(0, 3);
        final String LAST_SECTION = input.substring(3);
        int firstTotal = 0;
        int lastTotal = 0;
        for (int i = 0; i < FIRST_SECTION.length(); i++) {
            firstTotal += Integer.parseInt(FIRST_SECTION.substring(i, i + 1));
        }
        for (int i = 0; i < LAST_SECTION.length(); i++) {
            lastTotal += Integer.parseInt(LAST_SECTION.substring(i, i + 1));
        }
        if (firstTotal == lastTotal) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }

    public static void main(String[] args) {
        ticketChecker();
    }
}
