import java.util.ArrayList;
import java.util.List;

/**
 * In this project you will gain more practice using the ArrayList class.
 * 
 * NOTE 1:
 *  Watch the types called for in each class carefully.
 *  Some use arrays and some use lists as parameters but NONE return an
 *  array.
 *  
 *  Just because a method takes an array as a parameter doesn't mean it
 *  that it can't return a List!
 * 
 * NOTE 2:
 *  A check the pre-conditions carefully. If a method says a parameter
 *  is unchanged then you must not modify the array or list specified
 *  in your method!
 * 
 * @author (Alexander Shapiro) 
 * @version Unit 6
 */
public class MoreStringLists
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
     * Given a string, create a list with each element split at the comma in
     * the same relative order. 
     * 
     * For example:
     *  csv = "up,down,left,right,top,bottom"
     *  
     * would return:
     *  ["up","down","left","right","top","bottom"]
     * 
     * Precondition:    csv is not null
     *                  csv.length() > 0
     *                  at least one non-comma character appears before and
     *                  after each comma
     * @param   csv a string of comma separated values
     * @return  a list of each comma separated value
     */
    public static List<String> csvList(String csv)
    {
        int count = 1;
        
        for (int i = 0; i < csv.length(); i++)
        {
            if (csv.substring(i, i+1).equals(","))
            {
                count++;
            }
        }
        
        List<String> processed = new ArrayList<String>(count);
        
        for (int i = 0; i < count; i++)
        {
            if (csv.indexOf(",") != -1)
            {
                processed.add(csv.substring(0, csv.indexOf(",")));
                csv = csv.substring(csv.indexOf(",") + 1);
            }
            else
            {
                processed.add(csv);
            }
            
        }
        
        return processed; // Change this!  
    }  

    /**
     * Given a list of names, return true if the parameter name does NOT already.
     * appear in the list.
     * 
     * Precondition:    names is not null
     *                  names.size > 0
     *                  name is not null
     * Postcondition:   names is unchanged
     *                  
     * @param   names   a list of Strings that are names
     * @param   name    the name that may be in the list    
     * @return  true if name is not found in names and false if it is found
     */
    public static boolean isUnique(List<String> names, String name)
    {
        for (String str : names)
        {
            if (str.equals(name))
            {
                return false;
            }
        }
        
        return true; // Change this!
    }

    /**
     * Given an array of names that may contain duplicates, return a list with no duplicates.
     * The names should be in the same relative order as found in the orginal array.
     * 
     * For example:
     *  {"Aaron", "Ken", "Gena", "Aaron", "Michael"}
     * would be reduced to:
     *  ["Aaron", "Ken", "Gena", "Michael"]
     * 
     * Precondition:    names is not null
     * Postcondition:   names is unchanged
     *                  
     * @param   names an array of names that may contain duplicates
     * @return  a list of names in the same relative order but with no duplicates
     */
    public static List<String> reduce(String[] names)
    {
        List<String> processed = new ArrayList<String>();
        processed.add(names[0]);
        
        for (String str : names)
        {
            boolean verdict = false;
            for (String strList : processed)
            {
                if (!str.equals(strList))
                {
                    verdict = true;
                }
                else
                {
                    verdict = false;
                    break;
                }
            }
            if (verdict)
            {
                processed.add(str);
            }
        }
        
        return processed; // Change this!
    }

    /**
     * Given two Lists of Strings return a new list that contains names that appear in both of
     * the original lists.  
     * In other words, follow these guidelines:
     * Add each name from the first list to your new list only if it
     * found in the second list. Add strings to the new list in order
     * the order they are found in the first list (names1).
     * 
     * For example:
     *  names1 = ["Aaron", "Ken", "Gena", "Michael"]
     *  names2 = ["David", "Ken", "Aaron", "Jason"]
     *  
     * would be merged into:
     *  ["Aaron", "Ken"]
     *  
     * because "Aaron" is the first name in the first list that is also found
     * in the second list it is first in the resulting list!
     * 
     * Precondition:    names1 and names2 are not null
     *                  no elements are repeated more than once in names1
     *                  no elements are repeated more than once in names2
     *                  
     * Postcondition:   names1 and names2 are unchanged
     *                  
     * @param   names1 an a list of names (no duplicates)
     * @param   names2 anotbher list of names (no duplicates)
     * @return  the names that appear in both names1 and names2 in the relative
     *          order found in names1
     */
    public static List<String> mergeDups(List<String> names1, List<String> names2)
    {
        List<String> processed = new ArrayList<String>();
        
        for (String str : names1)
        {
            boolean verdict = false;
            for (String str2 : names2)
            {
                
                if (!str.equals(str2))
                {
                    verdict = false;
                }
                else
                {
                    verdict = true;
                    break;
                }
            }
            if (verdict)
            {
                processed.add(str);
            }
        }
        
        return processed; // Change this!
    }

    /**
     * Given a String of all capital letters, return a list containing each
     * letter found in the string only once.
     * The list should be in alphabetical order. 
     *
     * HINT:    You can add elements to a list at any index so keep your list
     *          in alphabetical order as you make it!
     * 
     * For example:
     *  letters = "AARON"
     *  
     * would return:
     *  ["A", "N", "O", "R"]
     *      
     * even though the "A" is found twice it is in the list only once and the
     * remaining letters are in alphabetical order!
     * 
     * Precondition:    letters is not null
     *                  letters.length() > 0
     *                  all characters in letters are captialized
     *                  
     * @param   letters a string containing capital letters (may contain duplicates)
     * @return  each letter, once, found in letters arranged in alphabetical order
     */
    public static List<String> alphaOrder(String letters)
    {
        // Create a new array to convert the string "letters" into a list, were each element is a letter of the string
        List<String> lettersList = new ArrayList<String>();
        
        // Loop through each letter and put in into the list we made
        for (int i = 0; i < letters.length(); i++)
        {
            lettersList.add(letters.substring(i, i + 1));
        }
        
        // Make a list that we'll return
        List<String> processed = new ArrayList<String>();
        // Add the first element to get the ball rolling here
        processed.add(lettersList.get(0));
        
        // Loop through the first list we made
        for (String str : lettersList)
        {
            // Create a boolean that remembers wether or not we had a duplicate
            boolean verdict = false;
            // Loop through the second list we made (what we already have)
            for (String strList : processed)
            {
                // If it's not a duplicate, tell the boolean that it's all good
                if (!str.equals(strList))
                {
                    verdict = true;
                }
                //If there is a duplicate, tell the boolean that it's bad and then exit out of the loop
                else
                {
                    verdict = false;
                    break;
                }
            }
            // If the boolean says it's all good, add the letter from the first list into our new list
            if (verdict)
            {
                processed.add(str);
            }
        }
        
        // Loop through the second list and use a sort algorithm to organize our second list alphabetically
        for (int count = 0; count < processed.size() - 1; count++)
        {
            for (int i = 0; i < processed.size() - 1; i++)
            {
                if (processed.get(i).compareTo(processed.get(i + 1)) > 0)
                {
                    String one = processed.get(i);
                    String two = processed.get(i + 1);
                    processed.set(i, two);
                    processed.set(i+1, one);
                }
            }
        }
        
        return processed;
    }    
}

