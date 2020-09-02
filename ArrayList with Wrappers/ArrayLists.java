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
 * 
 * @author (Alexander Shapiro) 
 * @version Unit 6
 */
public class ArrayLists
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
     * Given an array of doubles, return the square root of the value at the given index
     *
     * Preconditions:   array is not null
     *                  array.length > 0
     *                  index >= 0
     *                  index < array.length
     * Postcondition: Do not modify the values in the array
     *
     * @param array An array of doubles
     * @param index The index of the value to return the square root of
     * @return the square root of the value at index position 
     * 
     */
    public static double valueSqRoot(double[] array, int index) 
    {
        return Math.sqrt(array[index]);
    }


    /**
     * Given a List of Doubles, return the square root of the value at the given index
     *
     * Preconditions:   list is not null
     *                  list.size() > 0
     *                  index >= 0
     *                  index < list.size()
     * Postcondition: Do not modify the values in the List
     *
     * @param list ArrayList of Doubles
     * @param index The index of the value to return the square root of
     * @return the square root of the value at index position 
     * 
     */
    public static Double listValueSqRoot(List<Double> list, int index) 
    {
        return Math.sqrt(list.get(index).doubleValue());
    }    
    
    /**
     * Given an array of integer values, return the value stored at the given index unless 
     * the index is out of bounds in which case return -1 instead.
     *
     * Preconditions:   array is not null
     *                  array.length > 0
     * Postcondition: Do not modify the values in the array arr
     *
     * @param arr An array of integers
     * @param index The index of the value to return the value
     * @return the value at the index position, -1 if the index is out of bounds of the array
     * 
     */    
    public static int safeGet(int[] arr, int index) 
    {
        if (index >= arr.length || index < 0)
        {
            return -1;
        }
        else
        {
            return arr[index];
        }
    }

    /**
     * Given a List of Integer values, return the value stored at the given index unless 
     * the index is out of bounds in which case return -1 instead.
     * 
     * Preconditions:   list is not null
     *                  list.size() > 0
     * Postcondition: Do not modify the values in the List
     * 
     * @param list A List of Integers
     * @param index The index of the value to return the value
     * @return the value at the index position, -1 if the index is out of bounds of the array
     * 
     */    
    public static Integer listSafeGet(List<Integer> list, int index) 
    {
        if ( index >= list.size() || index < 0)
        {
            return -1;
        }
        else
        {
            return list.get(index);
        }
    }    
    
    /**
     * Given an array of integer values, return the average of all values in the array
     *
     * Preconditions:   array is not null
     *                  array.length > 0
     * Postcondition: Do not modify the values in the array
     *
     * @param array An array of integers
     * @return the avarage of all values in the array
     * 
     */    
    public static double avgArray(int[] array) 
    {
        double sum = 0;
        
        for (int i : array)
        {
            sum += i;
        }
        
        int len = array.length;
        
        return sum/len;
    }

    /**
     * Given a List of Integer values, return the avarage of all values in the List
     *
     * Preconditions:   list is not null
     *                  list.size() > 0
     * Postcondition: Do not modify the values in the List
     *
     * @param List of Integers
     * @return the average of all values in the List
     * 
     */    
    public static Double avgList(List<Integer> list) 
    {
        double sum = 0;
        
        for (int i : list)
        {
            sum += i;
        }
        
        int len = list.size();
        
        return sum/len;
    }    

    
    /**
     * Given a starting number, return an array of integers starting with the first number.
     * The array will consist of the number of elements specified by "count". 
     * The first element of the array is firstNumber and each subsequent number counts up by 2.
     *
     * Example:
     * for parameter values
     *  firstnumber : 3
     *  count : 4
     *  the return array should be { 3, 5, 7, 9 }
     *  
     *
     * Precondition: none
     * Postcondition: none
     *
     * @param firstNumber The value of the first element of the returned array
     * @param count The number of elements to include in the returned array
     * @return the array of count elements, starting with firstNumber and counting up by 2
     * 
     */    
    public static int[] byTwoArray(int firstNumber, int count) 
    {
        int[] array = new int[count];
        
        for (int i = 0; i < array.length; i++)
        {
            array[i] = firstNumber + (2 * i);
        }
        
        return array;
    }
    
    /**
     * Given a starting number, return a List of Integers starting with the first number.
     * The List will consist of the number of elements specified by "count". 
     * The first element of the List is firstNumber and each subsequent number counts up by 2.
     * 
     * Example:
     * for parameter values
     *  firstnumber : 3
     *  count : 4
     *  the return List should be { 3, 5, 7, 9 }
     * 
     * Precondition: none
     * Postcondition: none
     * 
     * @param firstNumber The value of the first element of the returned List
     * @param count The number of elements to include in the returned List
     * @return the List of count elements, starting with firstNumber and counting up by 2
     * 
     */    
    public static List<Integer> byTwoList(int firstNumber, int count) 
    {
        List<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < count; i++)
        {
            list.add(firstNumber + (2 * i));
        }
        
        return list;
    }    
    
    
    /**
     * Given an array of doubles, return an array with the all values greater than target changed to -1.0
     *
     *
     * Preconditions:   nums is not null
     *                  nums.length > 0
     * Postcondition: You may change the nums array directly.  There is no need to create and return a new array
     *
     * @param nums An array of doubles
     * @param target The maximimum allowable value in the array.  
     * 
     * @return a new array of doubles that has values greater than target changed to -1.0
     * 
     */     
    public static double[] replaceAboveTarget(double[] nums, double target) 
    {
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > target)
            {
                nums[i] = -1.0;
            }
        }
        
        return nums;
    }         
    
    /**
     * Given a List of Doubles, return a List with the all values greater than target changed to -1.0
     *
     * Preconditions:   list is not null
     *                  list.size() > 0
     * Postcondition: You may change the nums List directly.  There is no need to create and return a new List
     *
     * @param nums A List of doubles
     * @param target The maximimum allowable value in the array.  
     * 
     * @return a new List of doubles that has values greater than target changed to -1.0
     * 
     */     
    public static List<Double> listReplaceAboveTarget(List<Double> nums, Double target) 
    {
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums.get(i) > target)
            {
                nums.set(i, -1.0);
            }
        }
        
        return nums;
    }             
    
    /**
     * Given an array of doubles, return an array with the all values less than target removed
     *
     * Preconditions:   nums is not null
     *                  nums.length > 0
     * Postcondition: Do not modify the contents of the nums array.  Create and return a new array 
     *
     * @param nums An array of doubles
     * @param target The minimum allowable value in the returned array
     * 
     * @return a new array of doubles that has values less than target removed
     * 
     */     
    public static double[] removeBelowTarget(double[] nums, double target) 
    {
        int lower = 0;
        for (double i : nums)
        {
            if (i < target)
            {
                lower++;
            }
        }
        
        double[] sorted = new double[nums.length - lower];
        
        int idx = 0;
        for (double i : nums)
        {
            if (i >= target)
            {
                sorted[idx] = i;
                idx++;
            }
        }
        
        return sorted;
    }             
    
    
    /**
     * Given a List of Doubles, return an array with the all values less than target removed
     * Do NOT create a new List to return
     * 
     * Preconditions:   list is not null
     *                  list.size() > 0
     * Postcondition: Do not create a new List to return, simply modify the nums List.
     *
     * @param nums A List of doubles
     * @param target The minimum allowable value in the returned List
     * 
     * @return nums that has values less than target removed
     * 
     */     
    public static List<Double> listRemoveBelowTarget(List<Double> nums, Double target) 
    {
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums.get(i) < target)
            {
                nums.remove(i);
                i--;
            }
        }
        return nums;
    }         
}





