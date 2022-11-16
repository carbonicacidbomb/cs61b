package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE

    /**
     * checks that the results of three subsequent removeLast calls are the same.
     */
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();
        for (int i = 4; i < 7; i++) {
            a.addLast(i);
            b.addLast(i);
        }
        for (int i = 4; i < 7; i++) {
            assertEquals(a.removeLast(), b.removeLast());
        }
    }

    /**
     * make random calls to both implementations and use JUnit methods to verify
     * that they always return the same values.
     */
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> A = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                A.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                assertEquals(A.size(), B.size());
            } else if (operationNumber == 2 && A.size() > 0 && B.size() > 0) {
                // removeLast, getLast
                int getLastA = A.getLast();
                int getLastB = B.getLast();
                assertEquals(getLastA, getLastB);
                int removeLastA = A.removeLast();
                int removeLastB = B.removeLast();
                assertEquals(removeLastA, removeLastB);
            }
        }
    }
}
