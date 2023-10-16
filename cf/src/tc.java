import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class tc {
	public static void main(String args[]) {
		try {
			FileWriter f  = new FileWriter("text.txt");
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter p = new PrintWriter(b);
			Random random = new Random();
	        int randomNumber = random.nextInt((int)1e4) + 1;
	        p.print(randomNumber + " ");
	        long rand = random.nextInt((int)1e9) + 1; 
	        for(int i=0;i<randomNumber;i++) {
	        	rand = random.nextInt((int)1e9) + 1; 
	        	p.print(rand + " ");
	        }
			p.close();
			b.close();
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
