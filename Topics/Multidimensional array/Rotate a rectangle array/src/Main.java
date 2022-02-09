import java.util.Scanner;

class Main {
    public void rotate() {
        Scanner scanner = new Scanner(System.in);
        String[] rectangle = scanner.nextLine().split(" ");
        int m = Integer.parseInt(rectangle[0]);
        int n = Integer.parseInt(rectangle[1]);
        String[][] original = new String[m][n];
        for (int i = 0; i < m; i++) {
            String temp = scanner.nextLine();
            original[i] = temp.split(" ");
        }
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                System.out.print(original[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main one = new Main();
        one.rotate();
    }
}