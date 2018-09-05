package basiccontrollertest;

import basiccontroller.Controller;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ControllerTest {

    private Controller controller;

    @Before
    public void createController(){
        this.controller = new Controller(20);
    }

    @Test
    public void getEvenNumbers() {
        List<Integer> evenNumbers = controller.getEvenNumbers();
        assertThat(evenNumbers.size(), is(10));
    }

    @Test
    public void getOddNumbers() {
        List<Integer> odds = controller.getOddNumbers();
        assertThat(odds.size(), is(10));
    }

    @Test
    public void getSum() {
        Controller c = new Controller(5);
        int expectedSum = 1 + 2 + 3 + 4 + 5;
        assertThat(c.getSum(), is(expectedSum));
    }

    @Test
    public void getLargestOrSmallestEvenLength(){
        Controller c = new Controller(10);
        int largest = c.getLargestOrSmallest();
        assertThat(largest, is(10));
    }

    @Test
    public void getLargestOrSmallestOddLength(){
        Controller c = new Controller(9);
        int smallest = c.getLargestOrSmallest();
        assertThat(smallest, is(1));
    }
}