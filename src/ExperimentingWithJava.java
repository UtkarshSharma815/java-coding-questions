public class ExperimentingWithJava {


    public static void main(String[] args) throws Exception {

//        System.out.println(returnCheck());
        exceptionCheck();

    }

    static String returnCheck()
    {
        try {
            return "Hi";
        }
        catch (Exception exception)
        {
            return "hello";
        }
        finally {
            return "hey";
        }
    }

    static void exceptionCheck() throws Exception {
        try {
            System.out.println("hi");
            throw new Exception();
        }
        catch (Exception exception)
        {
            System.out.println("hello");
            throw new Exception();
        }
        finally {
            System.out.println("bye");
            throw new RuntimeException();
        }
    }


}
