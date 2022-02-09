import java.util.Scanner;

class Main {

    public void minimumDesks() {
        Scanner scanner = new Scanner(System.in);
        int totalStudents = 0;
        int classOne = scanner.nextInt();
        int classTwo = scanner.nextInt();
        int classThree = scanner.nextInt();
        totalStudents += classOne / 2 + classOne % 2;
        totalStudents += classTwo / 2 + classTwo % 2;
        totalStudents += classThree / 2 + classThree % 2;
        System.out.println(totalStudents);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.minimumDesks();
    }
}
