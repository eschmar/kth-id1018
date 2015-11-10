import java.util.Scanner;
import static java.lang.System.out;

/**
 * Created by eschmar on 10/11/15.
 */
public class OperationsWithNaturalNumbersGivenAsStrings {
    public static void main(String[] args) {
        out.println("OPERATIONS ON NATURAL NUMBERS IN CHARACTER STRINGS");

        // enter two natural numbers
        Scanner in = new Scanner(System.in);
        out.println("two natural numbers:");
        String tal1 = in.next();
        String tal2 = in.next();
        out.println();

        // add the numbers and show the result
        String sum = add(tal1, tal2);
        show(tal1, tal2, sum, '+');

        // subtract the numbers and show the result
        String difference = subtract(tal1, tal2);
        show(tal1, tal2, difference, '-');
    }

    /**
     * The add method accepts two natural numbers represented
     * as character strings and returns their sum as a
     * character string.
     * @param num1
     * @param num2
     * @return String
     */
    public static String add(String num1, String num2) {
        //String resultCheck = "" + (Double.parseDouble(num1) + Double.parseDouble(num2));

        String[] a1 = num1.split("");
        String[] a2 = num2.split("");

        int length = Math.max(a1.length, a2.length);
        String[] result = new String[length];
        int cOut = 0;

        for (int i = 0; i < length; i++) {
            int i1 = a1.length - i -1;
            int i2 = a2.length - i -1;

            int s1 = i1 >= 0 ? Integer.parseInt(a1[i1]) : 0;
            int s2 = i2 >= 0 ? Integer.parseInt(a2[i2]) : 0;

            result[length - i - 1] = Integer.toString((s1 + s2 + cOut) % 10);
            cOut = Double.valueOf(Math.floor((s1 + s2 + cOut) / 10)).intValue();
        }

        return String.join("", result);
    }

    /**
     * The subtract method accepts two natural numbers
     * represented as character strings and retusn their
     * difference as a character string.
     * The first number is not smaller than the second.
     * @param num1
     * @param num2
     * @return String
     */
    public static String subtract(String num1, String num2) {
        //String resultCheck = "" + (Double.parseDouble(num1) - Double.parseDouble(num2));

        String[] a1 = num1.split("");
        String[] a2 = num2.split("");

        int length = Math.max(a1.length, a2.length);
        String[] result = new String[length];
        int cOut = 0;

        for (int i = 0; i < length; i++) {
            int i1 = a1.length - i -1;
            int i2 = a2.length - i -1;

            int s1 = i1 >= 0 ? Integer.parseInt(a1[i1]) : 0;
            int s2 = i2 >= 0 ? Integer.parseInt(a2[i2]) : 0;

            int temp = s1 - s2 + cOut;
            if (temp < 0) {
                result[length - i - 1] = Integer.toString(temp + 10);
                cOut = -1;
            }else {
                result[length - i - 1] = Integer.toString(temp);
                cOut = 0;
            }
        }

        return String.join("", result);
    }

    /**
     * The show method presents two natural numbers, and
     * operator and the result string.
     * @param num1
     * @param num2
     * @param result
     * @param operator
     */
    public static void show(String num1, String num2, String result, char operator) {
        // set an appropriate length on numbers and result
        int len1 = num1.length();
        int len2 = num2.length();
        int len = result.length();

        int maxLen = Math.max(Math.max(len1, len2), len);
        num1 = setLen(num1, maxLen - len1);
        num2 = setLen(num2, maxLen - len2);
        result = setLen(result, maxLen - len);

        // show the expression
        out.println("  " + num1);
        out.println("" + operator + " " + num2);
        for (int i = 0; i < maxLen + 2; i++) {
            out.print("-");
        }
        out.println("\n  " + result + "\n");
    }

    public static String setLen(String s, int nofSpaces) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i< nofSpaces; i++) {
            sb.insert(0, " ");
        }

        return sb.toString();
    }
}
