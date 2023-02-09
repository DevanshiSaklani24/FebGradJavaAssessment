import java.util.*;
import java.util.stream.*;
import java.lang.Math;
public class SortArray1 {
    public static void main(String[] args) {
        Integer [] input = new Integer[] {2,7,3,8,11,12};
        SortArray1 obj = new SortArray1();
        Arrays.sort(input, Collections.reverseOrder());
        //System.out.println(Arrays.toString(input));
        obj.sortMyArray(input);
    }
    public void sortMyArray(Integer [] input) {
        Set<Integer> set1 = new HashSet<Integer> ();
        Set<Integer> set2 = new HashSet<Integer> ();
        //Set<Integer> set3 = new HashSet<Integer> ();
        List<Integer> aList = new ArrayList<Integer>();
        int sum1,sum2,arr_idx;
        sum1 = sum2 = arr_idx = 0;
        while (arr_idx < input.length){
            if(sum1<sum2){
                set1.add(input[arr_idx]);
                sum1 += input[arr_idx];
                arr_idx+=1;
            }
            else {
                set2.add(input[arr_idx]);
                sum2 += input[arr_idx];
                arr_idx += 1;
            }
        }
        aList.addAll(set1);
        aList.addAll(set2);

        System.out.println(aList);
        System.out.println("the difference is "+Math.abs(sum1-sum2));

    }
}
