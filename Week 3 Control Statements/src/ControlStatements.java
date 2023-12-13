import java.util.Scanner;

public class ControlStatements {

	public static void main(String[] args) {
		String operator = "Add";
		Scanner input = new Scanner(System.in);
		int Num1 = 0;
		int Num2 = 0;
		System.out.println("Please enter the first number");
		Num1 = input.nextInt();
		System.out.println("Please enter the second number");
		Num2 = input.nextInt();
		System.out.println("What operator would you like to use?(+,-,*,/,%)");
		operator = input.nextLine();
		operator = input.nextLine();
		switch (operator) {
		case "+" : System.out.println("Your final answer is " + (Num1+Num2));
		break;
		case "-" : System.out.println("Your final annswer is " + (Num1-Num2));
		break;
		case "*" : System.out.println("Your final annswer is " + (Num1*Num2));
		break;
		case "/" : System.out.println("Your final annswer is " + (Num1/Num2));
		break;
		case "%" : System.out.println("Your final annswer is " + (Num1%Num2));
		break;
		}
		
		

	}

}
