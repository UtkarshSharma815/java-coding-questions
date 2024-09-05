import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CodingInterviewQuestions {


    public static void main(String[] args) {

//        reverseString("Utkarsh");
//        findLargestInArray(new int[]{1,3,2,9,7});
//        checkIfPrime(7);
//        findFactorial(3);
//        removeDuplicatesFromArray(new int[]{1, 2, 3, 1, 2, 4, 5});
//        findSecondLargest(new int[]{1, 5, 3, 9, 7});
//        checkIfAnagram("silent", "csjdbcjbsd");
//        findFirstNonRepeatingChar("leetcode");
//        checkIfPalindrome("racecar");
//        findMaxSumSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});

//        fibonacci
//        int n=10;
//        for (int i=0; i<n;i++)
//        {
//            System.out.println(fibonacci(i) + " ");
//        }

//        swapWithoutThird(10,20);
        checkVowel("tkrsh");

    }

//    Write a program to reverse a string in Java.

    static void reverseString(String str)
    {
        StringBuilder stringBuilder= new StringBuilder(str);
        System.out.println(stringBuilder.reverse());

    }

//    Write a program to find the largest number in an array in Java.

    static void findLargestInArray(int[] arr)
    {

        System.out.println(Arrays.stream(arr).max().getAsInt());


        int max=arr[0];

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }

        System.out.println(max);

    }

//    3. Write a program to check if a given number is prime in Java.

    static void checkIfPrime(int n)
    {
        boolean isPrime=true;

        for(int i=2; i<=Math.sqrt(n); i++)
        {
            if(n%i==0)
            {
                isPrime=false;
                break;
            }
        }
        if(isPrime)
        {
            System.out.println(" is prime");
        }
        else
        {
            System.out.println(" no is prime");
        }
    }

//    4. Write a program to find the factorial of a given number in Java.

    static void findFactorial(int n)
    {
        int fact = 1;

        for(int i=1; i<=n; i++)
        {
            fact*=i;
        }

        System.out.println(fact);
    }

//    Write a program to remove duplicate elements from an array in Java.

    static void removeDuplicatesFromArray(int[] arr)
    {
        Set<Integer> integers= new HashSet<>();

        for(int i : arr)
        {
            integers.add(i);
        }

        Integer[] array=integers.toArray(new Integer[integers.size()]);

        System.out.println(Arrays.toString(array));
    }

//    6. Write a program to find the second largest number in an array in Java.

    static void findSecondLargest(int[] arr)
    {
        int max=Integer.MIN_VALUE;
        int secondMax= Integer.MIN_VALUE;

        for(int i=0;i <arr.length; i++)
        {
            if(arr[i]>max)
            {
                secondMax=max;
                max=arr[i];
            } else if (arr[i]>secondMax && arr[i]!=max) {

                secondMax=arr[i];

            }
        }
        System.out.println(secondMax);
    }

//    7. Write a program to check if two strings are anagrams in Java.

    static void checkIfAnagram(String str1, String str2)
    {
        char[] arr1=str1.toCharArray();
        char[] arr2= str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if(Arrays.equals(arr1,arr2))
        {
            System.out.println("anagram");
        }
        else {
            System.out.println("not");
        }
    }

//    Write a program to find the first non-repeating character in a string in Java

    static void findFirstNonRepeatingChar(String str)
    {

        int[] freq= new int[26];

        for(int i=0; i<str.length();i++)
        {
            freq[str.charAt(i)-'a']++;
        }

        for (int j=0; j<str.length();j++)
        {
            if(freq[str.charAt(j)-'a']==1)
            {
                System.out.println("first non repeat char "+ str.charAt(j));
                return;
            }
        }

        System.out.println("no non rpeact chr");

    }

//    10. Write a program to check if a given string is a palindrome in Java.

    static void checkIfPalindrome(String str)
    {
        int i=0;
        int j=str.length()-1;

        while(i<j)
        {
            if(str.charAt(i)!=str.charAt(j))
            {
                System.out.println("not palindrome");
                return;
            }
            i++;
            j--;
        }

        System.out.println("palindrome");
    }

//    13. Write a program to find the maximum sum subarray in an array in Java.

    static void findMaxSumSubArray(int[] arr)
    {
        int maxSum=Integer.MIN_VALUE;
        int currentSum=0;

        for(int i=0; i<arr.length; i++)
        {
            currentSum=currentSum+arr[i];

            if(currentSum>maxSum)
            {
                maxSum=currentSum;
            }
            if(currentSum<0)
            {
                currentSum=0;
            }
        }

        System.out.println(maxSum);
    }

//    fibonacci sequence

    static int fibonacci(int n)
    {
        if(n<=1)
            return n;

        return fibonacci(n-1)+ fibonacci(n-2);
    }

//    15. How do you swap two numbers without using a third variable in Java?

    static void swapWithoutThird(int a, int b)
    {

        System.out.println("before swap" + "a: "+a+" b: "+b);

        b=a+b;
        a=b-a;
        b=b-a;

        System.out.println("after swap" + "a: "+a+" b: "+b);

    }

//    16. Write a Java program to check if a vowel is present in a string.

    static void checkVowel(String string)
    {

        if(string.toLowerCase().matches(".*[aeiou].*"))
        {
            System.out.println("vowel");
        }
        else {
            System.out.println("no");
        }

    }

}
