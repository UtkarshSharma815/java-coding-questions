import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindPairsOfSum {


    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,7,8,9,10};
        int targetSum=9;
        findPairs(arr,targetSum);

    }




    public static void findPairs(int[] array, int targetSum) {
        List<Integer> list = Arrays.stream(array).boxed().toList();
        Set<Set<Integer>> uniquePairs = list.stream()
                .flatMap(i -> list.stream()
                        .filter(j -> i + j == targetSum && i < j)
                        .map(j -> Set.of(j, i)))
                .collect(Collectors.toSet());

        uniquePairs.forEach(System.out::println);
    }

}
