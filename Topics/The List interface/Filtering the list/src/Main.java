import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void oddReverse(List<Integer> ints) {
        List<Integer> oddInts = new ArrayList<>();   
        for (int i = 0; i < ints.size(); i++) {
            if (i % 2 != 0) {
                oddInts.add(ints.get(i));
            }
        }
        for (int i = oddInts.size() - 1; i >= 0; i--) {
            System.out.print(oddInts.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] list = scanner.nextLine().split("\\s");
        Integer[] intList = new Integer[list.length];
        for (int i = 0; i < list.length; i++) {
            intList[i] = Integer.parseInt(list[i]);
        }
        List<Integer> ints = new ArrayList<>(List.of(intList));
        oddReverse(ints);
    }
}
