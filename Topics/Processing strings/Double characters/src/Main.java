import java.util.Scanner;

class Main {

    public static void doubler() {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split("");
        StringBuilder sb = new StringBuilder();
        for (String s : inputArray) {
            sb.append(s).append(s);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        doubler();
    }
}