/**
 * This class was used to create the examples in the guided lesson
 * Chapter 5: Recursion, 2.3_Following Method Calls
 * 
 * @author Mr. Middler 
 * @version 12/2/2016
 */
public class FollowingMethodCalls
{
    public static int able(int local)
    {
        System.out.println("\u000Cable:local = " + local); 
        local += 1;
        return local;
    }

    public static int baker(int local)
    {
        System.out.println("\u000Cbaker:local = " + local);
        local = able(local * 2);
        return local;
    }

    public static int charlie(int local)
    {
        System.out.println("\u000Ccharlie:local = " + local);
        able(local);
        return baker(local);
    }

    public static int dog(int local)
    {
        System.out.println("\u000Cdog:local = " + local);
        return baker(local) + able(local);
    }
}