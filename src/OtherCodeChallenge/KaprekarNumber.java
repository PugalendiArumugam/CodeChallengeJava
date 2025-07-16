import java.util.Scanner;

public class KaprekarNumber {
    public static boolean isKaprekar(int num) {
        if (num == 1) {
            return true;
        }

        int square = num * num;
        String strSquare = Integer.toString(square);
        int len = strSquare.length();

        for (int i = 1; i < len; i++) {
            String leftPart = strSquare.substring(0, i);
            String rightPart = strSquare.substring(i);

            int left = (leftPart.isEmpty()) ? 0 : Integer.parseInt(leftPart);
            int right = (rightPart.isEmpty()) ? 0 : Integer.parseInt(rightPart);

            if (left + right == num && right != 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        if (isKaprekar(num)) {
            System.out.println(num + " is a Kaprekar number.");
        } else {
            System.out.println(num + " is NOT a Kaprekar number.");
        }
    }

}
