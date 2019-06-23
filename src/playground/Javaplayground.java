package playground;

public class Javaplayground {
    public static void main(String args[])
    {
        System.out.println(Person.N_EYES);//DIRECTLY CALLED WITHOUT MAKING OBJECTS
    }
}
class Person{
    public static final int N_EYES = 2;//const that does not rely on an instance of a class

}
