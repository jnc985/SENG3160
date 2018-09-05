package complexcontroller;

import java.util.ArrayList;
import java.util.List;

public class ComplexController {

    private DataProvider dataProvider;

    public ComplexController(DataProvider provider){
        this.dataProvider = provider;
    }

    public List<Integer> getAllData(){
        List<Integer> evens = dataProvider.getEvenNumbers();
        List<Integer> odds = dataProvider.getOddNumbers();

        List<Integer> result = new ArrayList<>(evens);
        result.addAll(odds);
        return result;
    }


}
