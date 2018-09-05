package complexcontrollertest;

import complexcontroller.ComplexController;
import complexcontroller.DataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.core.Every.everyItem;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)  //You can use this OR include @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
public class ComplexControllerTest {

    @Mock
    DataProvider dataProvider;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAllDataCallsGetEvenandGetOdd(){
        //Create a mock data provider to inject into our controller
        ComplexController cc = new ComplexController(dataProvider);
        List<Integer> data = cc.getAllData();
        verify(dataProvider).getEvenNumbers();
        verify(dataProvider).getOddNumbers();
    }

    @Test
    public void getAllDataReturnsAllData(){
        //Mock the get odd and even methods
        List<Integer> expectedEvens = Arrays.asList(2,4,12,16,22);
        List<Integer> expectedOdds = Arrays.asList(1,7,13,11,17);

        when(dataProvider.getEvenNumbers()).thenReturn(expectedEvens);
        when(dataProvider.getOddNumbers()).thenReturn(expectedOdds);

        ComplexController cc = new ComplexController(dataProvider);
        List<Integer> allData = cc.getAllData();

        assertThat(expectedEvens, everyItem(isIn(allData)));
        assertThat(expectedOdds, everyItem(isIn(allData)));
    }
}