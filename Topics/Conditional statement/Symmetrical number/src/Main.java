import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String a = input.substring(0, 1);
        String b = input.substring(1, 2);
        String c = input.substring(2, 3);
        String d = input.substring(3);

        if (a.equals(d) && b.equals(c)) {
            System.out.println(1);
        } else {
            System.out.println(99);
        }
    }
}
