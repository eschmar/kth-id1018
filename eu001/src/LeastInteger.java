import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by eschmar on 16/11/15.
 */
public class LeastInteger {
    public static final Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("THE LEAST INTEGER\n");

        // generate test input sequence
        int length = rand.nextInt(999);
        length = length < 0 ? length*(-1) : length;
        int[] testSequence = new int[length];
        for (int i = 0; i < length; i++) {
            testSequence[i] = rand.nextInt();
        }

        System.out.println("INPUT\n");
        System.out.println(java.util.Arrays.toString(testSequence));

        System.out.println("\nRESULT:");
        System.out.println(min(testSequence));

        System.out.println("\nRESULT USING UPDATE STRATEGY:");
        System.out.println(minByUpdate(testSequence));
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
        int nofIters = 1;

        int[] sequence = elements;
        int nofPairs = sequence.length / 2;
        int nofUnpairedElements = sequence.length % 2;
        int nofPossibleElements = nofPairs + nofUnpairedElements;
        int[] partialSeq = new int[nofPossibleElements];
        int i = 0;
        int j = 0;

        while (nofPossibleElements > 1) {
            // easy solution
            //partialSeq = new int[nofPossibleElements];

            //extract a partial sequence of possible elements
            i = 0;
            j = 0;

            while (j < nofPairs) {
                partialSeq[j++] = (sequence[i] < sequence[i + 1]) ? sequence[i] : sequence[i + 1];
                i += 2;
            }

            if (nofUnpairedElements == 1) {
                partialSeq[j] = sequence[nofPossibleElements - 1];
            }

            // now turn to the partial sequence
            sequence = partialSeq;
            nofPairs = nofPossibleElements / 2;
            nofUnpairedElements = nofPossibleElements % 2;
            nofPossibleElements = nofPairs + nofUnpairedElements;

            // Trace printing 1 - to follow the sequence
            System.out.println(java.util.Arrays.toString(sequence));

            // Trace printing 2 - to terminate the loop preemptively
            // (to be able to see what happens initially)
            if (nofIters++ == 10) {
                System.out.println("EXIT.");
                //System.exit(0);
            }
        }

        return sequence[0];
    }

    /**
     * The min method returns the least element in a sequential
     * collection. If the collection is empty, an
     * IllegalArgumentException is thrown.
     * @param elements
     * @return int[]
     * @throws IllegalArgumentException
     */
    public static int minByUpdate(int[] elements) throws IllegalArgumentException {
        if (elements.length == 0) {
            throw new IllegalArgumentException("empty collection");
        }

        int result = elements[0];
        for (int current : elements) {
            result = result > current ? current : result;
        }

        return result;
    }

}
