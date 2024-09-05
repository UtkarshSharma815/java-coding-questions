import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FindMissingNoOfAnArray {



    public static void main(String[] args) {
//        int[] arr= {1,2,3,4,5,7,8,9,10};
//        System.out.println(getMissingNumber(arr));

//        System.out.println(10<<3);//10*2^3

        System.out.println(20>>2);//20/2^2
    }


    static int getMissingNumber(int[] a) {
        return IntStream.rangeClosed(1, 10).sum() - Arrays.stream(a).sum();
    }
}
