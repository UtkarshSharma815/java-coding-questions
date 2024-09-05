import java.util.Arrays;

public class MergeSortedArrays {


    public static void main(String[] args) {


        int[] arr1 = {1,3,8,10,15};
        int [] arr2={2,5,7,12,14};

        mergeArrays(arr1,arr2);





    }

    static void mergeArrays(int [] arr1, int[] arr2)
    {

        int[] arr3= new int[arr1.length+ arr2.length];

        int i=0;
        int j=0;
        int k=0;

        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]<=arr2[j])
            {
                arr3[k++]=arr1[i++];
            }
            else {
                arr3[k++]=arr2[j++];
            }
        }

        while (i<arr1.length)
        {
            arr3[k++]=arr1[i++];
        }

        while (j<arr1.length)
        {
            arr3[k++]=arr1[j++];
        }


        System.out.println(Arrays.toString(arr3));


    }




}
