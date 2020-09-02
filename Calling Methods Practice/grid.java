
/**
 * Practice calling an existing method drawGrid.  Your instructions are below in the draw() and drawGrid() methods.
 *    Search for "TASK" to find them.  There are 4 tasks.
 * 
 * @author (Alexander Shapiro) 
 * @version (1/3/2018)
 */
public class grid
{
    public static void draw()
    {
        System.out.print('\u000C');  // Clear the terminal.  Leave this line alone so that you get a clean
                                     // terminal each time that you run.
        
        // TASK Step 1 : Add code here to call the drawGrid method to draw a 4 by 4 grid, each element of size 2.
        //     Do not copy/paste code from drawGrid here, it is simply a method call
        
        //drawGrid(4,4,2);
        
        
        // TASK Step 2 :  Add code here to call the drawGrid method to draw a 5 by 5 grid, each element of size 3
        //     Do not copy/paste code from drawGrid here, it is simply a method call

        drawGrid(5,5,3);
    }

     /**
     * Draw a grid using the output terminal
     * 
     *   TASK Step 3 : Notice how the drawGrid method is pretty complicated?   
     *                 Simplify it by making a new method called drawRow to draw the dash "-" characters as a row.   
     *                 Notice that there are two sections inside of drawGrid that repeat code to do that!   That is why this is a great
     *                 candidate for a new method.  Move this repeated code into your drawRow method and then call that new method from drawGrid.
     * 
     *   TASK Step 4 Extra credit : When drawGrid() is asked to draw a 5x5 grid of size 3, place an X character at the center of the grid.
     * 
     * 
     * @param  xDimension the number of columns in the grid 
     * @param  yDimension the number of rows in the grid 
     * @param  size the size of each grid element
     * @return  void
     */
    public static void drawGrid(int xDimension, int yDimension, int size)
    {
        for (int y = 0; y < yDimension; y++)
        {
            drawRow(xDimension, size);
            System.out.println();
            for (int i = 0; i < size-1; i++)
            {
               for (int x = 0; x < xDimension; x++)
               {
                   System.out.print("|");
                   for (i = 0; i < size-1; i++)
                   {
                       if ((xDimension == 5 && yDimension == 5 && size == 3) && (y == 2 && x == 2))
                       {
                           System.out.print("X ");
                           i++;
                       } else {
                           System.out.print(" ");
                       }
                   }
                   
                }
                System.out.println("|");
            }
        }
        drawRow(xDimension,size);

        System.out.println();
    }
    
    public static void drawRow(int xDimension, int size)
    {
        System.out.print("-");
        for (int x = 0; x < xDimension; x++)
        {
            for (int i = 0; i < size; i++)
            {
                System.out.print("-");
            }
        }
    }
}
