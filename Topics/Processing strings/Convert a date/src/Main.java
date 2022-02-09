import java.util.Scanner;

class Main {
    public void dateConverter() {
        Scanner scanner = new Scanner(System.in);
        String[] date = scanner.nextLine().split("-");
        String dateConverted = date[1] + "/" + date[2] + "/" + date[0];
        System.out.println(dateConverted);
    }

    public static void main(String[] args) {
        Main one = new Main();
        one.dateConverter();
    }
}