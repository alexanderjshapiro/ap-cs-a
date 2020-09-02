
/**
 * Write a description of class FollowingRecursiveCalls here.
 * 
 * @author (Your Name here) 
 *
 */
public class FollowingRecursiveCalls
{
public static int nPowE(int n, int e)
{
    if (e == 0)
    {
        return 1;
    }
    return n * nPowE(n, e - 1);
}

public static void forwardBack(String s)
{
    if (s.length() > 0)
    {
        System.out.print(s.substring(0,1));
        forwardBack(s.substring(1));
        System.out.print(s.substring(0,1));
    }
}

public static boolean isPal(String s)
{
    int sLen = s.length();
    if (sLen < 2)
    {
        return true;
    }
    if (s.substring(0,1).equals(s.substring(sLen - 1)))
    {
        return isPal(s.substring(1, sLen - 1));
    }
    return false;
}

public static void mystery_01(int n)
{
    if (n > 0)
    {
        System.out.print(n % 10);
        mystery_01(n / 10);
    }
}

public static int mystery_02(int n)
{
    if (n == 0) return 0;
    return (n % 10) + mystery_02(n / 10);
}

public static String mystery_03(String s)
{
    int sLen = s.length();
    if (sLen == 0)
    {
        return s;
    }
    return s + mystery_03(s.substring(sLen / 2));
}

public static String mystery_04(String s)
{
    int sLen = s.length();
    if (sLen == 1)
    {
        return s;
    }
    return s + mystery_04(s.substring(sLen / 2));
}

public static void mystery_05(String s)
{
    int sLen = s.length();
    if (s.length() > 0)
    {
        System.out.print(s.substring(sLen - 1));
        mystery_05(s.substring(0, sLen - 1));
    }
}
public static int mystery_06(int n)
{
    if (n == 0) return 0;
    return n % 2 + mystery_06(n / 10);
}
public static String mystery_07(String s, String f)
{
 int fLen = f.length();
 int i = s.indexOf(f);
 if (i == -1) return s;
 return mystery_07(s.substring(0, i) + s.substring(i + fLen), f);
}

public static String mystery_08(String s)
{
    int sLen = s.length();
    if (sLen == 1) return s;
    return mystery_08(s.substring(sLen / 2)) + mystery_08(s.substring(0, sLen / 2));
}

public static int mystery_09(int n)
{
    if (n == 0) return 0;
    int d = n % 10;
    if (d % 2 == 0)
    {
        return mystery_09(n - 1);
    }
    else
    {
        return d + mystery_09(n / 10);
    }
}

public static int mystery_10(int n)
{
    if (n < 2)
    {
        return 1;
    }
    return mystery_10(n - 1) + mystery_10(n - 2);
}

}
