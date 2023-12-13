import java.util.Arrays;
import java.security.SecureRandom;
public class count {

	public static void main(String[] args) {
		int x;
		int counts[] = {0,0,0,0,0,0,0,0,0,0};
		SecureRandom sc = new SecureRandom();
		for (int i=0; i<1000000; i++) {
			x = sc.nextInt(10);
			if(x==0) {
			counts[0]++;
			}
			else if (x==1) {
			counts[1]++;
			}
			else if (x==2) {
			counts [2]++;
			}
			else if (x==3) {
			counts [3]++;
			}
			else if (x==4) {
			counts [4]++;
			}
			else if (x==5) {
			counts[5]++;
			}
			else if (x==6) {
			counts[6]++;
			}
			else if (x==7) {
			counts[7]++;
			}
			else if (x==8) {
			counts[8]++;
			}
			else {
			counts[9]++;
			}
			
	}
		System.out.println("The Frequency of each roll from 1-10 is:");
		for(int i=0; i<10; i++) {
			System.out.println(counts[i]);
}
}
}

