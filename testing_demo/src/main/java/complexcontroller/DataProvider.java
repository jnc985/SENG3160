package complexcontroller;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private List<Integer> data;

    public DataProvider(int max){
        data = new ArrayList<Integer>();
        for(int i = 1; i <= max; i++){
            data.add(i);
        }
    }

    /**
     * Return a list of all the even numbers from the data
     * @return
     */
    public List<Integer> getEvenNumbers(){
        List<Integer> evens = new ArrayList<Integer>();
        for(Integer i : data){
            if(i % 2 == 0){
                evens.add(i);
            }
        }
        return evens;
    }

    /**
     * Returns a list of all the odd numbers from the data
     * @return
     */
    public List<Integer> getOddNumbers(){
        List<Integer> odds = new ArrayList<Integer>();
        for(Integer i : data){
            if(i % 2 != 0){
                odds.add(i);
            }
        }
        return odds;
    }

    /**
     * Returns the sum of all th enumbers in the data
     * @return
     */
    public int getSum(){
        int sum = 0;
        for(Integer i : data){
            sum += i;
        }
        return sum;
    }

    /**
     * If the size of the data is even we return the largest value
     * Otherwise we return the smalles value
     * @return
     */
    public int getLargestOrSmallest(){
        if(data.size() % 2 == 0){
            //Return the last value
            return data.get(data.size()-1);
        }
        else{
            return data.get(0);
        }
    }
}
