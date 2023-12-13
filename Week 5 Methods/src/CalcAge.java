import java.util.Scanner;

public class CalcAge {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("What is your birthday?");
		int month = input.nextInt();
		int day = input.nextInt();
		int year = input.nextInt(); 
		System.out.println("What is todays date?");
		int month_tod = input.nextInt();
		int day_tod = input.nextInt();
		int year_tod = input.nextInt(); 
		Calculate_Age(month,day,year,month_tod,day_tod,year_tod);
		
	}
		static void Calculate_Age(int month,int day,int year, int month_tod, int day_tod, int year_tod) {
		int birth=0;
		int tod =0;
		int age=0;
		 birth += (month*100);
		 birth += (year*10000);
	     birth += day;
	     tod += (month_tod*100);
		 tod += (year_tod*10000);
	     tod += day_tod;
	     age = tod-birth;
	     age/=10000;
		System.out.println(age);
	} 
		
	}
