import java.util. 
public class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello World!");

        int age = 33;
        // capital is a class and num has more methods to use in this class
        Integer num = 44;
        // a string MUST have double quotes
        String firstName = "Ashley";
        // single character needs single quotes, must also ALWAYS include ; at the end of the line
        char c = 'a';
        boolean t = true;
        System.out.println(age);

        // this array has a fixed length and cannot be added to deleted from. only use if you know its not going to change
        String[] myArray = {"Hello", "hi", "everyone"};

        // an array with 10 values in it
        int[10] numArray;

        int[] numArray = {1,2,3,4,5};

        // this creates an array
        ArrayList <String> myStringList = new ArrayList<string>();
        // add stuff to the array
        myStringList.add("first");
        myStringList.add("second");
        System.out.println(myStringList);

        // for loop example prints hello hi and everyone on sep lines
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

        // a for loop without an index. still prints hello hi everyone
        for(String elem : myArray){
            System.out.println(elem);
        }

        // invoking the AnotherFile from a sep file
        // somethingElse is outside of our program in anotherFile and we are invoking AnotherFile.
        AnotherFile somethingElse = new AnotherFile();
        // stored the return value from sayHello of the AnotherFile into the variable x 
        String x = somethingElse.sayHello();
        // prints
        System.out.println(x);

        // calls on sum from AnotherFile passes arguments 4 and 7 and prints from sum.
        int myNum = somethingElse.sum(4, 7);
        System.out.println(myNum)

    }
}