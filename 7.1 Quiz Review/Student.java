import java.util.*;
public class Student
{
    private String name = "unknown";
    private double grade = 100.00;
    private int citizenship = 4;
    private boolean isBored = false;
    
    public Student()
    {
        // Do something
    }
    
    public Student(String setName)
    {
        name = setName;
    }
    
    public Student(String setName, double setGrade)
    {
        name = setName;
        grade = setGrade;
    }
    
    public Student(String setName, double setGrade, int setCitizenship)
    {
        name = setName;
        grade = setGrade;
        citizenship = setCitizenship;
    }
    
    public Student(String setName, double setGrade, int setCitizenship, boolean setIsBored)
    {
        name = setName;
        grade = setGrade;
        citizenship = setCitizenship;
        isBored = setIsBored;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getGrade()
    {
        return grade - 10;
    }
    
    public int getCitizenship()
    {
        return citizenship;
    }
    
    public boolean getIsBored()
    {
        return isBored;
    }
    
    public void doAssignment()
    {
        if (grade > 90)
        {
            grade -= 3;
        }
        grade++;
        citizenship++;
        isBored = true;
    }
    
    public void takeTest()
    {
        grade -= 7;
        if (isBored = true)
        {
            citizenship += 2;
        }
    }
    
    public void fallAsleep()
    {
        citizenship -= 3;
        isBored = true;
        if (citizenship > 0)
        {
            grade -= 3;
        }
        else
        {
            grade -= 5;
        }
    }
    
    public static List<Student> issueDetention(ArrayList<Student> students)
    {
        List<Student> badStudents = new ArrayList<Student>();
        for (Student student : students)
        {
            if (student.getGrade() < 70 && (student.getCitizenship() < 0 || student.getIsBored()))
            {
                badStudents.add(student);
            }
        }
        
        return badStudents;
    }
}
