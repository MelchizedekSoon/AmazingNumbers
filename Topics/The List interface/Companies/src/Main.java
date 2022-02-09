import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] companyList = scanner.nextLine().split(" ");
        List<String> companyArrayList = new ArrayList<>(List.of(companyList));
        System.out.println(companyArrayList);
    }
}