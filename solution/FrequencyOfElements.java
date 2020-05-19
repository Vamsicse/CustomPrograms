import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Problem: Find frequency of elements
 * Approach: Use streams or hashmap or arrays(fastest)
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class FrequencyOfElements {

    public static void main(String[] args) {
        FrequencyOfElements obj = new FrequencyOfElements();
        int[] arr = {1,2,2,3};
        obj.printFrequencyUsingStream(arr);
        System.out.println("---------------");
        obj.printFrequencyUsingArrays(arr);
    }

    private void printFrequencyUsingArrays(int arr[]) {
        int n = arr.length;
        // Subtract 1 from every element so that the elements become in range from 0 to n-1
        for (int j = 0; j < n; j++)
            arr[j] = arr[j] - 1;

        // Use every element arr[i] as index and add 'n' to element present at arr[i]%n to keep track of count of occurrences of arr[i]
        for (int i = 0; i < n; i++)
            arr[arr[i] % n] = arr[arr[i] % n] + n;

        // To print counts, simply print number of times n was added at index corresponding to every element
        for (int i = 0; i < n; i++)
            System.out.println( (i+1) + "->" + arr[i]/n);
    }

    private void printFrequencyUsingStream(int arr[]) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);
        Map<Integer, Long> collect1 = list.stream().collect(groupingBy(Function.identity(), counting()));
        Map<Integer, Integer> collect2 = list.stream().collect(groupingBy(Function.identity(), summingInt(e -> 1)));
        for(Integer i:collect1.keySet()){
            System.out.println(i + "-" + collect1.get(i));
        }
    }


}
