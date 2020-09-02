

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FirstClassTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FirstClassTest
{
    /**
     * Default constructor for test class FirstClassTest
     */
    public FirstClassTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void yourName()
    {
        String studentName = FirstClass.yourName();
        if (studentName == null || studentName.equals(""))
        {
            System.out.println("Student did not complete the yourName method!");
            assertNotNull(studentName);
        }
        else
        {
            System.out.println("RETURN " + studentName);
        }
    }    
    @Test
    public void setAllToOne1D()
    {
        int[] arr1 = {1,1,1};
        int[] arr0 = {0,0,0};

        assertArrayEquals(arr1, FirstClass.setAllToOne1D(arr0));
    }
    
    @Test
    public void setAllToOne()
    {
        int[][] zeros = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};
        int[][] ones = {{1,1,1}, {1,1,1}, {1,1,1}, {1,1,1}};

        zeros = FirstClass.setAllToOne(zeros);
        
        for (int i = 0; i < zeros.length; i++)
        {
            assertArrayEquals(ones[i], zeros[i]);
        }

    }

    @Test
    public void setToRowColNumber()
    {
        int[][] zeros = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};
        int[][] array = {{0,1,2}, {10,11,12}, {20,21,22}, {30,31,32}};

        zeros = FirstClass.setToRowColNumber(zeros);
        
        for (int i = 0; i < zeros.length; i++)
        {
            assertArrayEquals(array[i], zeros[i]);
        }

    }

    @Test
    public void setRow2To5()
    {
        int[][] zeros = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};
        int[][] array = {{0,0,0}, {5,5,5}, {0,0,0}, {0,0,0}};

        zeros = FirstClass.setRow2To5(zeros);
        
        for (int i = 0; i < zeros.length; i++)
        {
            assertArrayEquals(array[i], zeros[i]);
        }

    }
    
    @Test
    public void setCol3To10()
    {
        int[][] zeros = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};
        int[][] array = {{0,0,10}, {0,0,10}, {0,0,10}, {0,0,10}};

        zeros = FirstClass.setCol3To10(zeros);
        
        for (int i = 0; i < zeros.length; i++)
        {
            assertArrayEquals(array[i], zeros[i]);
        }

        int[][] zeros2 = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
        int[][] array2 = {{0,0,10,0}, {0,0,10,0}, {0,0,10,0}, {0,0,10,0}, {0,0,10,0}};

        zeros2 = FirstClass.setCol3To10(zeros2);
        
        for (int i = 0; i < zeros.length; i++)
        {
            assertArrayEquals(array2[i], zeros2[i]);
        }

    }
    
    @Test
    public void setLastTo100()
    {
        int[][] zeros = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};
        int[][] array = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,100}};

        zeros = FirstClass.setLastTo100(zeros);
        
        for (int i = 0; i < zeros.length; i++)
        {
            assertArrayEquals(array[i], zeros[i]);
        }

        int[][] zeros2 = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
        int[][] array2 = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,100}};

        zeros2 = FirstClass.setLastTo100(zeros2);
        
        for (int i = 0; i < zeros.length; i++)
        {
            assertArrayEquals(array2[i], zeros2[i]);
        }

    }       
}







