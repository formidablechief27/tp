import java.util.*;
public class CN {
	static Scanner SC = new Scanner(System.in);
	public static void main(String args[]) {
		System.out.println("Enter Size of Window (n)");
		int n = SC.nextInt();
		System.out.println("Enter total number of frames");
		int total = SC.nextInt(); // Total number of frames to be transmitted
		int start = 1;
		int end = n;
		transmit_n(1, n);
		while(true) {
			Random var = new Random();
			int r = var.nextInt(2);
//			System.out.println("Recieved Acknowledgement for Frame " + start + " ?");
//			int r = SC.nextInt();
			// 0 = yes ; 1 = no
			if(r == 0) {
				System.out.println("Acknowledgment for Frame " + start + " is Recieved");
				start++;
				end++;
				if(start > total) break;
				if(end <= total) transmit(end);
			}
			if(r == 1) {
				System.out.println("Acknowledgment for Frame " + start + " is not Recieved");
				System.out.print("Re");
				transmit_n(start, end);
			}
			System.out.println();
		}
	}
	
	public static void transmit_n(int start, int end) {
		System.out.print("Transmitting Frames .. ");
		for(int i=start;i<=end;i++) System.out.print(i + " ");
		System.out.println();
	}
	
	public static void transmit(int frame) {
		System.out.println("Transmitting Frame " + frame);
	}
}