import java.util.Scanner;
public class palindrome {

	public static void main(String[] args) {
		int number=0;
		int swap=0;
		Scanner input = new Scanner(System.in);
		System.out.println("Please input any number");
		number = input.nextInt();
		Reverse_Digits(number);
	}
		static void Reverse_Digits(int number) {
		int swap = 0;
		for(; number != 0; number /= 10) {
			    int digit = number % 10;
			    swap = swap * 10 + digit;
			    }
		System.out.println(swap);
	}

		
}
