import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    while(true) {
      System.out.println("Enter a string");

      String palindrome = scanner.nextLine();
      System.out.printf("Is \"%s\" a palindrome? %b %n%n", palindrome, isPalindrome(palindrome));
    }

  }
  private static boolean isPalindrome(String palindrome) {
    for (int i = 0; i < palindrome.length(); i++) {
      int currEndChar = palindrome.length() - i - 1;
      
      System.out.printf("+%d %c | -%d %c %n", (i + 1), palindrome.charAt(i), (currEndChar + 1), palindrome.charAt(currEndChar));
      
      // if the char index become the same or cross eachother
      if (i == currEndChar || i > currEndChar) {
        break;
      }
      
      // return if characters are not the same
      if (palindrome.charAt(i) != palindrome.charAt(currEndChar)) {
        return false;
      }
    }
    return true;
  }
}

