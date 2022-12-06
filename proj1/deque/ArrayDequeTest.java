package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {
    @Test
    public void randomizedTest() {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        ArrayDeque<Integer> A = new ArrayDeque<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                A.addLast(randVal);
            } else if (operationNumber == 1) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                L.addFirst(randVal);
                A.addFirst(randVal);
            } else if (operationNumber == 2 && L.size() > 0 && A.size() > 0) {
                // removeLast, getLast
                int getLastL = L.get(L.size() - 1);
                int getLastA = A.get(A.size() - 1);
                assertEquals(getLastA, getLastL);
                int removeLastA = A.removeLast();
                int removeLastL = L.removeLast();
                assertEquals(removeLastA, removeLastL);
            } else if (operationNumber == 3 && L.size() > 0 && A.size() > 0) {
                int getFirstL = L.get(0);
                int getFirstA = A.get(0);
                assertEquals(getFirstA, getFirstL);
                int removeFirstA = A.removeFirst();
                int removeFirstL = L.removeFirst();
                assertEquals(removeFirstA, removeFirstL);
            }
        }
    }

}
