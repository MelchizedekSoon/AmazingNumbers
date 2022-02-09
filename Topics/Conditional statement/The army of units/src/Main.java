import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        try {
            int units = Integer.parseInt(scanner.next());
            System.out.println(category(units));
        } catch (Exception e) {
            throw new Exception("This is not a number!");
        }
    }

    public static String category(int units) {
        int packLow = 1;
        int packHigh = 19;
        int throngLow = 20;
        int throngHigh = 249;
        int zoundsLow = 250;
        int zoundsHigh = 999;
        if (units < 1) {
            return "no army";
        } else if (units >= packLow && units <= packHigh) {
            return "pack";
        } else if (units >= throngLow && units <= throngHigh) {
            return "throng";
        } else if (units >= zoundsLow && units <= zoundsHigh) {
            return "zounds";
        } else {
            return "legion";
        }
    }

}
