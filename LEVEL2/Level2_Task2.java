import java.util.Scanner;

public class Level2_Task2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter your password: ");
    String password = scanner.nextLine();
    scanner.close();

    int score = checkPasswordStrength(password);

    String strength;
    if (score < 3) {
      strength = "Weak";
    } else if (score < 6) {
      strength = "Moderate";
    } else {
      strength = "Strong";
    }

    System.out.println("Your password strength is: " + strength);
    System.out.println("  - Score: " + score);
  }

  public static int checkPasswordStrength(String password) {
    int score = 0;

   
    if (password.length() >= 8) {
      score++;
    }

   
    if (password.matches(".*[A-Z].*")) {
      score++;
    }

   
    if (password.matches(".*[a-z].*")) {
      score++;
    }

   
    if (password.matches(".*[0-9].*")) {
      score++;
    }

    
    if (password.matches(".*[!@#$%^&*()-+].*")) {
      score++;
    }

    return score;
  }
 
}
