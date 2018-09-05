package complexDataProvidertest;

import complexcontroller.DataProvider;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class DataProviderTest {

    @Test
    public void getEvenNumbers() {
        DataProvider c = new DataProvider(20);
        List<Integer> evenNumbers = c.getEvenNumbers();
        assertThat(evenNumbers, hasSize(10));
        assertThat(evenNumbers, containsInAnyOrder(2,4,20,8,10,12,18,16,14,6));
        assertThat(evenNumbers, not(containsInAnyOrder(19, 17, 15, 13, 11, 9, 7, 5, 3, 1)));
    }

    @Test
    public void getOddNumbers() {
        DataProvider c = new DataProvider(20);
        List<Integer> odds = c.getOddNumbers();
        assertThat(odds, not(containsInAnyOrder(2,4,20,8,10,12,18,16,14,6)));
        assertThat(odds, containsInAnyOrder(19, 17, 15, 13, 11, 9, 7, 5, 3, 1));
    }

    @Test
    public void getSum() {
        DataProvider c = new DataProvider(5);
        int expectedSum = 1 + 2 + 3 + 4 + 5;
        assertThat(c.getSum(), is(expectedSum));
    }

    @Test
    public void getLargestOrSmallestEvenLength(){
        DataProvider c = new DataProvider(10);
        int largest = c.getLargestOrSmallest();
        assertThat(largest, is(10));
    }

    @Test
    public void getLargestOrSmallestOddLength(){
        DataProvider c = new DataProvider(9);
        int smallest = c.getLargestOrSmallest();
        assertThat(smallest, is(1));
    }
}