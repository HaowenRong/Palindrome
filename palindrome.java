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

  private static boolean isPalindromeRecursive(String palindrome) {
    int palindromeLength = palindrome.length();
    
    // if the length of the sliced string is in range of 0 - 1, return true
    if (palindromeLength >= 0 && palindromeLength <= 1) {
      return true;
    }
    
    char currStartChar = palindrome.charAt(0);
    char currEndChar   = palindrome.charAt(palindromeLength - 1);
    
    System.out.println(palindrome);
    System.out.printf("%c | %c %n", currStartChar, currEndChar);
    
    // return false if either of the current chars are not the same
    if (currStartChar != currEndChar) {
      return false;
    }
    
    // remove the first and last characters of the string and call function again using new string
    String slicedPalindrome = palindrome.substring(1, palindrome.length() - 1);
    isPalindromeRecursive(slicedPalindrome);
    
    return true;
  }
}

