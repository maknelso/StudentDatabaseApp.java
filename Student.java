package studentdatabaseapp;

/*
- Ask how many new students to add to db
- User should be prompted to enter name and yr for each student
- Student should have 5 digit unique ID with first number being their grade level
- Student can enroll in: History, Mathematics, English, Chemistry, Computer Science
- Each course costs $600 to enroll
- Student should be able to view their balance and pay tuition
- To see status of student: see name, ID, course enrolled, tuition balance due
*/
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0; 
    // static - property is not specific to an object, it belongs to the CLASS, not instance of the object
    private static int costOfCourse = 600;
    private static int id = 1000; 

    // Constructor - prompts user to enter student's name and year
    public Student(){
        // Prompt user 
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student's first name: ");
        this.firstName = in.nextLine(); //nextLine takes a String

        System.out.print("Enter student's last name: ");
        this.lastName = in.nextLine();

        System.out.print("1 - Freshman\n2 - Sophomore \n3 - Junior \n4 - Senior\nEnter student's year: ");
        this.gradeYear = in.nextInt();

        setStudentID();
    }

    // Generate an unique ID
    private void setStudentID(){
        // increment id 
        id++;
        // Grade Level + ID
        this.studentID = gradeYear + "" + id; // "" treats this as a String
    }

    // Enroll in courses
    public void enroll(){
        // Get inside a loop, user hits 0
        // do-while loop
        do{
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if(!course.equals("Q")){
                courses = courses + "\n " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }
            // if String is equal to "Q"
            else{
                break;
            } 
        } while (1 != 0); // forever true condition for do-while loop
    }

    // View balance
    public void viewBalance(){
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    // Pay tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    // Show status of student
    // toString() is an in-built method in Java that returns the value given to it in string format
    public String toString(){
        return "Name: " + firstName + " " + lastName + 
            "\nGrade Level: " + gradeYear +
            "\nStudent ID: " + studentID + 
            "\nCourses Enrolled: " + courses +      
            "\nBalance: $" + tuitionBalance;
    }
}
