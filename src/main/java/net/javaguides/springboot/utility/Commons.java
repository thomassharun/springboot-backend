package net.javaguides.springboot.utility;

import org.springframework.stereotype.Component;

import net.javaguides.springboot.model.Course;
import net.javaguides.springboot.model.Grades;
import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.model.StudentDetails;


@Component
public class Commons {
	
	
	public static double calculateGPA(Grades grds) {
        double totalPoints = 0.0;
        int totalCredits = 0;
        int[] marks = {
                (int) grds.getS1(),
                (int) grds.getS2(),
                (int) grds.getS3(),
                (int) grds.getS4(),
                (int) grds.getS5()
            };
        
        int[] credits = {
                (int) grds.getCr1(),
                (int) grds.getCr2(),
                (int) grds.getCr3(),
                (int) grds.getCr4(),
                (int) grds.getCr5()
            };
        
        for (int i = 0; i < marks.length; i++) {
            double gradePoint = convertMarksToGradePoint(marks[i]);
            totalPoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        return totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }

	public static double convertMarksToGradePoint(int marks) {
        // Conversion: Marks to Grade Point out of 10
        return (double) marks / 10.0;
    }
}
