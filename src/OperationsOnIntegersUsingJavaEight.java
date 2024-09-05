import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OperationsOnIntegersUsingJavaEight {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32,15,8);
//        evenNoInList(list);
//        startingWithOne(list);
//        findDuplicates(list);
//        findFirstElement(list);
        findTotalCount(list);


    }

//    Given a list of integers, find out all the even numbers that exist in the list using Stream functions?

    static void evenNoInList(List<Integer> list)
    {
        list.stream()
                .filter(integer -> integer%2==0).forEach(System.out::println);
    }

//    Given a list of integers, find out all the numbers starting with 1 using Stream functions?

    static void startingWithOne(List<Integer> list)
    {
        list.stream()
                .map(String::valueOf).filter(s -> s.startsWith("1"))
                .forEach(System.out::println);
    }

//    How to find duplicate elements in a given integers list in java using Stream functions?

    static void findDuplicates(List<Integer> list)
    {
        Set<Integer> integers=new HashSet<>();
        list.stream()
                .filter(integer -> !integers.add(integer)).forEach(System.out::println);

    }

    // Or you can also try using distinct() keyword

    static void getDataWithoutDuplicates() {
        List<Integer> myList = Arrays.asList(1, 1, 85, 6, 2, 3, 65, 6, 45, 45, 5662, 2582, 2, 2, 266, 666, 656);
        myList.stream().distinct().forEach(noDuplicateData -> System.out.println(noDuplicateData));
    }

    public static void getDataWithoutDuplicates1() {
        List<Integer> myList = Arrays.asList(1, 1, 85, 6, 2, 3, 65, 6, 45, 45, 5662, 2582, 2, 2, 266, 666, 656);
        Set<Integer> set = new HashSet<>(myList);

        // Convert the set back to a list if needed
        List<Integer> uniqueData = set.stream().collect(Collectors.toList());

        // Print the unique elements
        uniqueData.forEach(System.out::println);
    }

//    Given the list of integers, find the first element of the list using Stream functions?

    static void findFirstElement(List<Integer> list)
    {
        System.out.println(list.stream().findFirst().get());
    }

//    find Total number of elements using stream

    static void findTotalCount(List<Integer> list)
    {
        System.out.println(list.stream().count());
    }

}
