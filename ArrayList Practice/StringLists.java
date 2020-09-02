import java.util.ArrayList;
import java.util.List;

/**
 * In this project you will learn to use the ArrayList class.
 * Some of the problems below are ones that we've seen in the past.  Don't just copy/paste
 * from your original solution, solve it again!  It's good practice.
 * First you will complete each method using an array.   
 * Next you will complete the the same method immediately following the array problem 
 * except this time you will use an ArrayList.
 * 
 * Here is a quick reference to the Java List methods.  E represents any Java object type:
 *   int size()                   returns the number of elements in the List
 *   
 *   boolean add(E obj)           appends obj to end of list; returns true
 *   
 *   void add(int index, E obj)   inserts obj at position index (0 <= index <= size)
 *                                  moving elements at position index and higher
 *                                  to the right (adds 1 to their indices) and adjusts size
 *                                  
 *   E get(int index)             gets the element at the specified index
 *   
 *   E set(int index, E obj)      replaces the element at position index with obj.
 *                                  returns the element formerly at the specified position
 *                                  
 *   E remove(int index)          removes element from position index, moving elements 
 *                                  at position index + 1 and higher to the left (subtracts 1 
 *                                  from their indices) and adjusts size.  
 *                                  Returns the element formerly at the specified position
 * 
 * @author (Alexander Shapiro) 
 * @version Unit 6
 */
public class StringLists
{
    /**
     * Simply return your name as a String, last name then first name, separated by a comma
     *
     * @return your name as a String
     */
    public static String yourName()
    {
        return "Shapiro, Alexander"; 
    }

    /**
     * Given 2 arrays of Strings, return true if they are exactly the same
     *
     * @param a1 an array of Strings
     * @param a2 an array of Strings
     * @return true if the arrays contain the same data.
     * 
     */
    public static boolean arraysAreEqual(String[] a1, String[] a2) 
    {
        boolean verdict = true;
        if (a1.length == a2.length)
        {
            for (int i = 0; i < a1.length; i++)
            {
                if (a1[i].equals(a2[i]))
                {
                    verdict = true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            verdict = false;
        }
        return verdict;
    }
    
    /**
     * Given 2 Lists of Strings, return true if they are exactly the same
     *
     * @param a1 a List of Strings
     * @param a2 a List of Strings
     * @return true if the Lists contain the same data.
     * 
     */
    public static boolean arraysAreEqual(List<String> a1, List<String> a2) 
    {
        boolean verdict = true;
        if (a1.size() == a2.size())
        {
            for (int i = 0; i < a1.size(); i++)
            {
                if ((a1.get(0)).equals(a2.get(0)))
                {
                    verdict = true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            verdict = false;
        }
        return verdict;
    }
    
    /**
     * Given a String, return an array of Strings where each character is a single element.
     *
     * @param s is a String
     * @return an array of strings where each character in s is an element of the returned array
     * 
     */    
    public static String[] strToArr(String s) 
    {
        String[] chars = new String[s.length()];
        for (int i = 0; i < s.length(); i++)
        {
            chars[i] = s.substring(i,i+1);
        }
        return chars;
    }

    /**
     * Given a String, return a List of Strings where each character is a single element.
     *
     * @param s is a String
     * @return a List of strings where each character in s is an element of the returned List
     * 
     */    
    public static List<String> stringToArr(String s) 
    {
        List<String> chars = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++)
        {
            chars.add(s.substring(i,i+1));
        }
        return chars;
    }    
    
    /**
     * Return the INDEX of the first occurrence of a String within an array. 
     * If the String is not stored in the array then return -1.
     *
     * @param strings an array of Strings
     * @return this index in strings of where matchString first appears.  -1 if matchString is not found
     * 
     */     
    public static int firstOccursAtIndex(String[] strings, String matchString) 
    {
        for (int i = 0; i < strings.length; i++)
        {
            if (strings[i].equals(matchString) == true)
            {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Return the INDEX of the first occurrence of a String within a List. 
     * If the String is not stored in the List then return -1.
     *
     * @param strings a List of Strings
     * @return this index in strings of where matchString first appears.  -1 if matchString is not found
     * 
     */     
    public static int firstOccursAtIndex(List<String> strings, String matchString) 
    {
        for (int i = 0; i < strings.size(); i++)
        {
            if (strings.get(i).equals(matchString) == true)
            {
                return i;
            }
        }
        return -1;
    }   
    
    /**
     * Given an array of Strings, return a NEW copy of the array except that in the new array
     * the first and the last elements have their positions exchanged.
     *
     * @param strings an array of Strings
     * @return a new array of Strings that is the same as strings except that the first and last elements are exchanged
     * 
     */     
    public static String[] swapFirstLast(String[] strings) 
    {
        String first = strings[0];
        String last = strings[strings.length-1];
        strings[0] = last;
        strings[strings.length-1] = first;
        return strings;  // you should return the same array that is the parameter
    }    
    
    /**
     * Given a List of Strings, return the same List except but with the first and the 
     * last elements have their exchanged.
     *
     * @param strings a List of Strings
     * @return strings with the first and last elements are exchanged
     * 
     */     
    public static List<String> swapFirstLast(List<String> strings) 
    {
        String first = strings.remove(0);
        String last = strings.remove(strings.size()-1);
        strings.add(0, last);
        strings.add(first);
        return strings;  // you should return the same array that is the parameter
    }        
    
    /**
     * Given an array of Strings, return an array with the target String removed
     * Create a new array to store the new smaller array
     *
     * @param strings an array of Strings
     * @param target the String to remove
     * 
     * @return a new array of Strings that has target removed
     * 
     */     
    public static String[] removeTarget(String[] strings, String target) 
    {
        // Since you are resizing the array, you should create a new one to return
        int count = 0;
        for (int i = 0; i < strings.length; i++)
        {
            if (strings[i].equals(target))
            {
                count++;
            }
        }
        
        String[] strs = new String[strings.length-count];
        int idx = 0;
        for (int i = 0; i < strings.length; i++)
        {
            if (!strings[i].equals(target))
            {
                strs[idx] = strings[i];
                idx++;
            }
        }
        
        return strs;
    }       
    
    /**
     * Given a List of Strings, return a List with the target String removed
     * No need to create a new list with the String removed, just modify the strings parameter directly
     * WARNING: This can be tricky! If you are using a for loop, what happens when you remove
     * an item based on the current index?
     *
     * @param strings a List of Strings
     * @param target the String to remove
     * 
     * @return the list with the target String removed
     * 
     */     
    public static List<String> removeTarget(List<String> strings, String target) 
    {
        for (int i = 0; i < strings.size(); i++)
        {
            if (strings.get(i).equals(target))
            {
                strings.remove(i);
                i--;
            }
        }

        return strings;   // you should return the same array that is the parameter
    }           
}



