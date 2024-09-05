import model.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService {

        public static void main(String[] args) {


            List<Student> list = Arrays.asList(
                    new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                    new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                    new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                    new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                    new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                    new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                    new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                    new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                    new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                    new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));


//            startsWithA(list);
//            groupByDeptName(list);
//            findCountByStream(list);
//            findMaxAge(list);
//            findAllDeptName(list);
//            findCountInEachDept(list);
//            stuBelowThirty(list);
//            findBwFiftyAndHundred(list);
//            findAverageAgeOfMaleAndFemale(list);
//            findDeptWithMaxStu(list);
//            findByDelhi(list);
//            findAvgRankInDept(list);
//            findHighestRankInDept(list);
//            findStudentsAndSortByRank(list);
            findSecondRankStu(list);

        }



//        Find list of students whose first name starts with alphabet A

       static void startsWithA(List<Student> list) {


           List<Student> list1 = list.stream().filter(student -> student.getFirstName().startsWith("A")).collect(Collectors.toList());
           list1.forEach(System.out::println);
       }

    //    Group The Student By Department Names

    static void groupByDeptName(List<Student> list) {

        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

//        Find the total count of student using stream

    static void findCountByStream(List<Student> list)
    {
        System.out.println(list.stream().count());
    }


//        Find the max age of student


    static void findMaxAge(List<Student> list)
    {
        System.out.println(list.stream().max(Comparator.comparing(Student::getAge)).get().getFirstName());
    }

//    Find all departments names

    static void findAllDeptName(List<Student> list)
    {
        list.stream()
                .map(Student::getDepartmantName).distinct()
                .toList()
                .forEach(System.out::println);
    }
//    Find the count of student in each department

    static void findCountInEachDept(List<Student> list)
    {
        list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName))
                .values()
                .stream()
                .filter(list2 -> !list2.isEmpty())
                .forEach(list2 -> System.out.println("Dept name: "+list2.get(0).getDepartmantName()+", Count-> "+list2.size()));

//        alternate

        Map<String, Long> countStudentInEachdept = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
        System.out.println("Student count in each department : "+countStudentInEachdept);

    }

//    Find the list of students whose age is less than 30

    static void stuBelowThirty(List<Student> list)
    {
        list.stream().filter(student -> student.getAge()<30).forEach(System.out::println);
    }

//    Find the list of students whose rank is in between 50 and 100

    static void findBwFiftyAndHundred(List<Student> list)
    {
        list.stream().filter(student -> student.getRank()>=50 && student.getRank()<=100)
                .forEach(System.out::println);
    }

//    Find the average age of male and female students

    static void findAverageAgeOfMaleAndFemale(List<Student> list)
    {
        Map<String, Double> map=list.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));

        System.out.println(map);

    }

//    Find the department who is having maximum number of students

    static void findDeptWithMaxStu(List<Student> list)
    {
       Map<String, List<Student>> studentList= list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));

        System.out.println(studentList.entrySet().stream().max(Comparator.comparing(stringListEntry -> stringListEntry.getValue().size())).get().getKey());
//      alternate

        Map.Entry<String, Long> entry = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();
        System.out.println("Department having maximum number of students : "+entry);

    }

//    Find the Students who stays in Delhi and sort them by their names

    static void findByDelhi(List<Student> list)
    {
        list.stream()
                .filter(student -> student.getCity().equals("Delhi"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .forEach(System.out::println);

    }

//    Find the average rank in all departments

    static void findAvgRankInDept(List<Student> list)
    {
        Map<String, Double> map=list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.averagingInt(Student::getRank)));

        System.out.println(map);
    }

//    Find the highest rank in each department

    static void findHighestRankInDept(List<Student> list)
    {
//        Map<String, Optional<Student>> map=
                list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.maxBy(Comparator.comparing(Student::getRank))))
                        .entrySet()
                        .stream()
                        .forEach(stringOptionalEntry ->
                                System.out.println(stringOptionalEntry.getKey()+", "+stringOptionalEntry.getValue().get().getRank()));



//        for (Map.Entry entry: map.entrySet())
//        {
//            String deptName=entry.getKey().toString();
//            Optional<Student> student= (Optional<Student>) entry.getValue();
//
//            System.out.println(deptName+", "+student.get().getRank());
//
//        }
    }

//    Find the list of students and sort them by their rank

    static void findStudentsAndSortByRank(List<Student> list)
    {
        list.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .forEach(student -> System.out.println(student.getRank()));
    }

//    Find the student who has second rank

    static void findSecondRankStu(List<Student> list)
    {
        System.out.println(list.stream()
                .sorted(Comparator.comparing(Student::getRank).reversed()).collect(Collectors.toList()).get(1).getRank());

    }



    

}
