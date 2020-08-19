package hackerrank.grading_students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradingStudents {

    public static void main(String[] args) {
        List<Integer> grades = new ArrayList<>();
        grades.add(73);
        grades.add(67);
        grades.add(38);
        grades.add(33);
        System.out.println(gradingStudents(grades));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        for (int i = 0; i < grades.size(); i ++) {
            int grade = grades.get(i);
            if (grade >= 38)
                if (grade % 5 != 0) {
                    int dividedBy5 = grade / 5;
                    if (((dividedBy5 + 1) * 5) - grade < 3) {
                        grade = (dividedBy5 + 1) * 5;
                    }

                    grades.set(i, grade);
                }
        }

        return grades;
    }
}
