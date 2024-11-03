import java.util.ArrayList;
import java.util.Scanner;

public class studentGradeTracker {
    public static void main(String[] args) {
        // Create an ArrayList to store student grades
        ArrayList<Double> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        
        // Prompt the teacher to enter grades
        System.out.println("Enter student grades (type 'Exit' to finish):");
        
        while (true) {
            System.out.print("Enter grade: ");
            input = scanner.nextLine();
            
            // Check if the input is 'Exit'
            if (input.equalsIgnoreCase("Exit")) {
                break;
            }
            
            try {
                // Parse the input to a double and add to the list
                double grade = Double.parseDouble(input);
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'Exit' to finish.");
            }
        }

        // Check if any grades were entered
        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
        } else {
            // Calculate average, highest, and lowest grades
            double total = 0;
            double highest = grades.get(0);
            double lowest = grades.get(0);

            for (double grade : grades) {
                total += grade;
                if (grade > highest) {
                    highest = grade;
                }
                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = total / grades.size();

            // Display the results
            System.out.printf("Average grade: %.2f%n", average);
            System.out.printf("Highest grade: %.2f%n", highest);
            System.out.printf("Lowest grade: %.2f%n", lowest);
        }
        scanner.close();
    }
}