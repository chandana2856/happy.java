import java.util.Scanner;

public class happy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Special Number Game!");
        System.out.println("Rules:");
        System.out.println("1. Enter a number.");
        System.out.println("2. The program will check for various specialities.");
        System.out.println("3. If your number has more than 3 specialities, you win!");
        System.out.println("\nSpecialities:");

       
        System.out.println("1. Armstrong Number: Sum of cubes of digits equals the number.");
        System.out.println("2. Neon Number: Sum of digits of square equals the number.");
        System.out.println("3. Abundant Number: Sum of proper divisors is greater than the number.");
        System.out.println("4. Prime Number: Divisible only by 1 and itself.");
        System.out.println("5. Palindrome Number: Reads the same forwards and backwards.");
        System.out.println("6. Perfect Number: Sum of proper divisors equals the number.");
        System.out.println("7. Twin Prime: Prime number with a prime gap of 2.");
        System.out.println("8. Sophie Germain Prime: Both the number and 2 * number + 1 are prime.");
        System.out.println("9. Sophie Positive Number: Both the number and 2 * number + 1 are prime and positive");
        System.out.println("10. Circular Prime: Remains prime after cyclically permuting its digits.");
        System.out.println("11. Emirp: A prime that is still prime when its digits are reversed.");
        System.out.println("12. Odd Number: Not divisible by 2.");

        System.out.print("\nEnter 0 to learn the rules and specialities. Enter any other number to start the game: ");
        int choice = scanner.nextInt();

        if (choice == 0) {
            
            System.out.println("\nGame rules and specialities details provided. Start the game when you're ready!");
        } else {
           
            
             
            System.out.println("\nEnter a number to check its specialities: ");
            int userNumber = scanner.nextInt();

           
      

        

       
        int specialitiesCount = countSpecialities(userNumber);

       
        if (specialitiesCount > 3) {
            System.out.println("Congratulations! You win. Your number has " + specialitiesCount + " specialities.");
        } else {
            System.out.println("Sorry, you lose. Your number has " + specialitiesCount + " specialities.");
        }
       
        }

        scanner.close();
    }

   
    private static int countSpecialities(int number) {
        int count = 0;
        
        if (isOdd(number)) {
            count++;
        }

        if (isArmstrong(number)) {
            count++;
        }

        if (isNeon(number)) {
            count++;
        }

        if (isAbundant(number)) {
            count++;
        }

        if (isPrime(number)) {
            count++;
        }

        if (isPalindrome(number)) {
            count++;
        }

        if (isPerfect(number)) {
            count++;
        }
   if (isTwinPrime(number)) {
            count++;
        }

        if (isSophieGermainPrime(number)) {
            count++;
        }

        if (isCircularPrime(number)) {
            count++;
        }

        if (isEmirp(number)) {
            count++;
        }

       

        return count;
    }

   
    static boolean isTwinPrime(int number) {
        return (isPrime(number) && isPrime(number + 2)) || (isPrime(number) && isPrime(number - 2));
    }

   
    static boolean isSophieGermainPrime(int number) {
        return isPrime(number) && isPrime(2 * number + 1);
    }
     static boolean isOdd(int number) {
        return number % 2 != 0;}

   
    static boolean isCircularPrime(int number) {
        String numStr = Integer.toString(number);
        int len = numStr.length();

        for (int i = 0; i < len; i++) {
            if (!isPrime(Integer.parseInt(numStr.substring(i) + numStr.substring(0, i)))) {
                return false;
            }
        }

        return true;
    }

    
    static boolean isEmirp(int number) {
        String numStr = Integer.toString(number);
        int reversed = Integer.parseInt(new StringBuilder(numStr).reverse().toString());

        return isPrime(number) && isPrime(reversed) && number != reversed;
    }

       
    
    static boolean isArmstrong(int number) {
        int o, r, result = 0, n = 0;

        o = number;
        while (o != 0) {
            o /= 10;
            ++n;
        }

        o = number;
        while (o != 0) {
            r = o % 10;
            result += Math.pow(r, n);
            o /= 10;
        }

        return result == number;
    }

    
     static boolean isNeon(int number) {
        int square = number * number;
        int digitSum = 0;

        while (square > 0) {
            digitSum += square % 10;
            square /= 10;
        }

        return digitSum == number;
    }

    
      static boolean isAbundant(int number) { int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum > number;
    }

    
     static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
  static boolean isPalindrome(int number) {
        int o = number;
        int r = 0;

        while (o != 0) {
            int digit = o % 10;
            r = r * 10 + digit;
            o /= 10;
        }

        return number == r;
    }

     static boolean isPerfect(int number) {
        int sum = 1;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }


}