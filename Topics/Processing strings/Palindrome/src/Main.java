import java.util.Scanner;

class Main {
    public void palindromeChecker() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String halfOne;
        String halfTwo;
        halfOne = input.substring(0, input.length() / 2);
        if (input.length() % 2 == 0) {
            halfTwo = input.substring(input.length() / 2);
        } else {
            halfTwo = input.substring(input.length() / 2 + 1);
        }
        int k = halfOne.length() - 1;
        boolean isPalindrome = true;
        for (int i = 0; i < halfOne.length(); i++, k--) {
            if (halfOne.charAt(i) != halfTwo.charAt(k)) {
                isPalindrome = false;
                System.out.println("no");
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("yes");
        }
    }

    public static void main(String[] args) {
        Main one = new Main();
        one.palindromeChecker();
    }
}