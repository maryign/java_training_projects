package Testing.test.java.ArrayVector;

import org.junit.Test;
//import ru.ncedu.java.tasks.ArrayVector.ArrayVectorImpl;
import Testing.main.java.ArrayVector.ArrayVectorImpl;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Mari on 26.09.2016.
 */
public class TestArrayVector {
    double[] arr = {2.3, 3.4, 4.3, 5.4, 6.4};
    ArrayVectorImpl v1 = new ArrayVectorImpl();
    double[] arr2 = {2.3, 3.4, 4.3, 5.4, 6.4};
    ArrayVectorImpl v2 = new ArrayVectorImpl();

    @Test
    public void clonetest() {
        v1.set(arr);
        assertTrue("Not equals2", v1.get().equals(v1.clone().get()));
    }

    @Test
    public void getset2Test() {
        v1.set(arr);
        v1.set(1, 11.5);
        assertTrue("Not equals1", 11.5 == v1.get(1));
        v1.set(0, 11.5);
        assertTrue("Not equals2", 11.5 == v1.get(0));
    }


    @Test
    public void MinMaxTest() {
        v1.set(arr);
        assertTrue("Not equals", 2.3 == v1.getMin());
        assertTrue("Not equals", 6.4 == v1.getMax());
    }

    @Test
    public void MultTest() {
    v1.set(arr);
    v1.mult(2.5);
    assertTrue("Not equals",v1.get(1)==3.4*2.5);
    }

//    @Test
//    public void NormTest() {
//
//    }
//
//    @Test
//    public void ScalarMultTest() {
//    }

    @Test
    public void SortTest() {
        v1.set(arr);
        v1.sortAscending();
        assertTrue("Not equals", v1.get(0) == v1.getMin() && v1.get(v1.getSize() - 1) == v1.getMax());
    }

    @Test
    public void SumTest() {
        v1.set(arr);
        v2.set(arr2);
        v1.sum(v2);
        assertTrue("Not equals", v1.get(1) == 4.6 && v1.get(4) == 12.8);
    }
}