import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        int longest = 0;
        for (String each : list) {
            if (each.length() > longest) {
                longest = each.length();
            }
        }
        for (int i = 0; i < list.toArray().length; i++) {
            for (int j = 0; j < list.toArray().length; j++) {
                if (list.get(j).length() == longest) {
                    list.set(i, list.get(j));
                }
            }
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}