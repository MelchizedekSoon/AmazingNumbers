import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start = 0;
        int[][] twoDimArray = new int[n][n];
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = start; j < twoDimArray.length; j++) {
                twoDimArray[i][j] = Math.abs(j-i);
                System.out.print(twoDimArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}