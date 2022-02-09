import java.util.*;

public class Main {

    public static void nearestNumbers() {
        Scanner scanner = new Scanner(System.in);
        String[] integersAsStrings = scanner.nextLine().split(" ");
        int[] integers = new int[integersAsStrings.length];
        for (int i = 0; i < integersAsStrings.length; i++) {
            integers[i] = Integer.parseInt(integersAsStrings[i]);
        }
        int compareNumber = scanner.nextInt();
        List<Integer> nearestNumbers = new ArrayList<>();
        int closestDistance = Integer.MAX_VALUE;
        for (int each : integers) {
            if (each == compareNumber) {
                closestDistance = 0;
            } else if (each > compareNumber) {
                if (each - compareNumber < closestDistance) {
                    closestDistance = each - compareNumber;
                }
            } else {
                if (compareNumber - each < closestDistance) {
                    closestDistance = compareNumber - each;
                }
            }
        }
        for (int each : integers) {
            if (each == compareNumber - closestDistance) {
                nearestNumbers.add(each);
            } else if (each == compareNumber + closestDistance) {
                nearestNumbers.add(each);
            }
        }
        Collections.sort(nearestNumbers);
        for (Integer each : nearestNumbers) {
            System.out.print(each + " ");
        }
    }

    public static void main(String[] args) {
        nearestNumbers();
    }
}
