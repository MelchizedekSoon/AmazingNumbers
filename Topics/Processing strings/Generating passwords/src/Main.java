import java.util.*;

public class Main {
    private final StringBuilder sb = new StringBuilder();
    List<String> stringList = new ArrayList<>();

    public void passwordGenerator() {
        Scanner scanner = new Scanner(System.in);
        String[] numsArray = scanner.nextLine().split(" ");
        List<String> uppercase = new ArrayList<>(Integer.parseInt(numsArray[0]));
        List<String> lowercase = new ArrayList<>(Integer.parseInt(numsArray[1]));
        List<String> digits = new ArrayList<>(Integer.parseInt(numsArray[2]));
        final int uppercaseTotal = Integer.parseInt(numsArray[0]);
        final int lowercaseTotal = Integer.parseInt(numsArray[1]);
        final int digitsTotal = Integer.parseInt(numsArray[2]);
        final int symbolTotal = Integer.parseInt(numsArray[3]);
        final int letterRange = 26;
        final int digitRange = 10;
        final int uppercaseStart = 65;
        final int lowercaseStart = 97;
        final int letterRandomizer = (int) (Math.random() * letterRange);
        final int digitRandomizer = (int) (Math.random() * digitRange);
        for (int i = 0; i < uppercaseTotal; i++) {
            char upperLetter = (char) ((int) letterRandomizer + uppercaseStart);
            uppercase.add(String.valueOf(upperLetter));
        }
        for (int k = 0; k < lowercaseTotal; k++) {
            char lowerLetter = (char) ((int) letterRandomizer + lowercaseStart);
            lowercase.add(String.valueOf(lowerLetter));
        }
        for (int j = 0; j < digitsTotal; j++) {
            int digit = digitRandomizer;
            digits.add(String.valueOf(digit));
        }
        this.stringList.addAll(uppercase);
        this.stringList.addAll(lowercase);
        this.stringList.addAll(digits);
        while (this.stringList.size() != symbolTotal) {
            this.stringList.add(String.valueOf(digitRandomizer));
        }
        Collections.shuffle(this.stringList);
        this.stringList =
                isRepeat();
        for (String each : this.stringList) {
            sb.append(each);
        }
        System.out.println(sb);
    }

    public ArrayList<String> isRepeat() {
        ArrayList<String> revisedList = new ArrayList<>();
        char[] charArray = new char[this.stringList.size()];
        for (int i = 0; i < this.stringList.size(); i++) {
            charArray[i] = this.stringList.get(i).charAt(0);
        }
        for (int i = 0; i < charArray.length - 1; i++) {
            if (Objects.equals(charArray[i], charArray[i + 1])) {
                if (charArray[i + 1] == 'Z') {
                    charArray[i + 1] = 'Y';
                } else if (charArray[i + 1] == 'z') {
                    charArray[i + 1] = 'y';
                } else if (charArray[i + 1] == '9') {
                    charArray[i + 1] = '8';
                } else {
                    charArray[i + 1] = (char) (((int) charArray[i]) + 1);
                }
            }
        }
        for (Character each : charArray) {
            revisedList.add(String.valueOf(each));
        }
        return revisedList;
    }

    public static void main(String[] args) {
        Main one = new Main();
        one.passwordGenerator();
    }
}
