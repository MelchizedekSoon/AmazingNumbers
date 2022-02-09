import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void triChecker() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        List<Integer> sides = new ArrayList<>();
        while (count < 3) {
            sides.add(scanner.nextInt());
            count++;
        }
        int a = sides.get(0);
        int b = sides.get(1);
        int c = sides.get(2);
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        triChecker();
    }
}
