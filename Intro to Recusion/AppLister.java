 
/**
 * Write a description of class AppLister here.
 * 
 * @author (Alexander Shapiro) 
 * @version (1/5/18)
 */
public class AppLister
{
    public static void printAppsWithIndent( String folder, int indentLevel )
    {
        // Clear previous run from terminal
        if (folder.equals("Main"))
        {
            System.out.print('\u000C');
        }
        
        System.out.print(folder);
        
        
    }
    /**
     * Given a folder name, print out the apps within the folder, one app name per line
     *
     * @param   folder the name of the folder to list
     */
    
    public static void printAppsInFolder( String folder )
    {
        printAppsWithIndent("Main", 0);
    }

    
    
     /**
     * Given a folder name, return a list of the apps AND folders in the current folder.
     *    
     * @param   folder the name containing the apps and subfolders
     * @return  a list of the apps within the folder.  Any folders will start with the 
     *          substring "FOLDER"
     */
    public static String[] getAppsInFolder( String folder )
    {
        if (folder.equals("Main"))
        {
            return new String[]{"Stocks", "Messages", "Calendar", "Photos", "FOLDERSports", "FOLDERGames" };
        }
        else if (folder.equals("Sports"))
        {
            return new String[]{"Golf", "MLB" };
        }
        else if (folder.equals("Games"))
        {
            return new String[]{"FOLDERSocial", "Doodle Jump", "Pokemon Go", "Dots" };
        }
        else if (folder.equals("Social"))
        {
            return new String[]{"Words With Friends", "Dice"};
        }
        else
        {
            return new String[]{"No Such Folder: " + folder};
        }
    }
}
