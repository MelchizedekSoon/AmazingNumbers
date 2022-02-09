import java.util.*;

public class Main {

    public void euphoniousWord() {
        Scanner scanner = new Scanner(System.in);
        int minCharCount = 0;
        String word = scanner.nextLine();
        String[] vowelArray = word.split("[^aeiouy]");
        String[] consonantArray = word.split("[aeiouy]");
        List<String> discordBits = new ArrayList<>();
        for (String s : vowelArray) {
            if (s.length() >= 3) {
                discordBits.add(s);
            }
        }
        for (String s : consonantArray) {
            if (s.length() >= 3) {
                discordBits.add(s);
            }
        }
        for (String discordBit : discordBits) {
            for (int j = 0; j < discordBit.length() - 1; ) {
                if (j + 2 < discordBit.length()) {
                    j += 2;
                    minCharCount++;
                } else {
                    j++;
                }
            }
        }
        System.out.println(minCharCount);
    }

    public static void main(String[] args) {
        Main one = new Main();
        one.euphoniousWord();
    }
}
