public class SortArray {
    public static void main(String[] args) {
        Integer [] input = new Integer[] {2, 3, 4, 5};
        sortMyArray(input);
    }
    public void sortMyArray(Integer [] input) {
        Set<Integer> set1 = new HashSet<Integer> ();
        Set<Integer> set2 = new HashSet<Integer> ();
        int sum1,sum2,arr_idx;
        sum1 = sum2 = arr_idx = 0;
        while (arr_idx < input.length){
            if(sum1<sum2){
                set1.append(arr[arr_idx]);
                sum1 += arr[arr_idx];
            }
            else {
                set2.append(arr[arr_idx]);
                sum2 += arr[arr_idx];
                arr_idx += 1;
            }
        }
        System.out.println(set1);
        System.out.println(set2);
    }
}
