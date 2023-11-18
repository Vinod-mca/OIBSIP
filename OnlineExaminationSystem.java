import java.util.Scanner;

class User {
    String username;
    String password;
    // Other profile information

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to update profile
    public void updateProfile() {
        // Add code to update profile information
        System.out.println("Profile updated successfully!");
    }
}

class Exam {
    // Sample MCQs
    String[] questions = {
        "What is the capital of France?",
        "What is the largest planet in our solar system?"
    };

    String[][] options = {
        {"Paris", "London", "Berlin", "Rome"},
        {"Earth", "Jupiter", "Mars", "Saturn"}
    };

    char[] correctAnswers = {'A', 'B'};

    // Method to take the exam
    public void takeExam(User user) {
        // Add code for timer and auto-submit
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            for (int j = 0; j < options[i].length; j++) {
                System.out.println((char) ('A' + j) + ". " + options[i][j]);
            }

            System.out.print("Your answer: ");
            char userAnswer = Character.toUpperCase(scanner.next().charAt(0));

            // Check if the answer is correct
            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("Exam completed!");
        // Add code for auto-submit and closing session
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        // Sample usage
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        // Create user
        User user = new User(username, password);

        // Login
        // Add code to check login credentials and authenticate the user

        // Update profile
        user.updateProfile();

        // Take exam
        Exam exam = new Exam();
        exam.takeExam(user);

        // Logout
        // Add code for logging out and closing the session
    }
}
