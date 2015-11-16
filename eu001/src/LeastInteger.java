import java.util.Locale;
import java.util.Scanner;

/**
 * Created by eschmar on 16/11/15.
 */
public class LeastInteger {

    public static void main(String[] args) {
        System.out.println("THE LEAST INTEGER\n");

        int[] test = {4,6,7,1,3,5,8,8,4,3,5};
        System.out.println(java.util.Arrays.toString(test));

        System.out.println("\nRESULT:");
        System.out.println(min(test));

        // input tools
        //Scanner in = new Scanner(System.in);
        //in.useLocale(Locale.US);

        // read in all inputs
        //System.out.print("Amount of stations in zone 2: ");
        //int m = in.nextInt();

        System.out.println("\n");
    }

    /**
     * The min method returns the least element in a sequential
     * collection. If the collection is empty, an
     * IllegalArgumentException is thrown.
     * @param elements
     * @return int[]
     * @throws IllegalArgumentException
     */
    public static int min(int[] elements) throws IllegalArgumentException {
        if (elements.length == 0) {
            throw new IllegalArgumentException("empty collection");
        }

        // is used in trace printing 2:
        // int nofIters = 1;

        int[] sequence = elements;
        int nofPairs = sequence.length / 2;
        int nofUnpairedElements = sequence.length % 2;
        int nofPossibleElements = nofPairs + nofUnpairedElements;
        int[] partialSeq = new int[nofPossibleElements];
        int i = 0;
        int j = 0;

        while (sequence.length > 1) {
            //extract a partial sequence of possible elements
            i = 0;
            j = 0;

            while (j < nofPairs) {
                partialSeq[j++] = (sequence[i] < sequence[i + 1]) ? sequence[i] : sequence[i + 1];
                i += 2;
            }

            if (nofUnpairedElements == 1) {
                partialSeq[j] = sequence[sequence.length - 1];
            }

            // now turn to the partial sequence
            sequence = partialSeq;
            nofPairs = nofPossibleElements / 2;
            nofUnpairedElements = nofPossibleElements % 2;
            nofPossibleElements = nofPairs + nofUnpairedElements;

            // Trace printing 1 - to follow the sequence
            // System.out.println(java.util.Arrays.toString(sequence);

            // Trace printing 2 - to terminate the loop preemptively
            // (to be able to see what happens initially)
//            if (nofIters++ == 10) {
//                System.exit(0);
//            }

            //
        }

        return sequence[0];
    }
}
