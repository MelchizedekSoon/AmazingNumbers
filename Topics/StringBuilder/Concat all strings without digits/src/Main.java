import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String each : strings) {
            for (int i = 0; i < each.length(); i++) {
                char temp = each.charAt(i);
                switch (temp) {
                    case '0':
                    case '2':
                    case '1':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        break;
                    default:
                        sb.append(temp);
                        break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings =
                scanner.nextLine().split("\\s+");
        String result =
                concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}