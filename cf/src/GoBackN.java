import java.util.Random;
import java.util.Scanner;

public class GoBackN {
    public static void goBackN(int noOfFrames, int windowSize) {
        int i = 1;
        Random random = new Random();

        while (i <= noOfFrames) {
            for (int k = i; k < i + windowSize && k <= noOfFrames; k++) {
                System.out.println("Sending Frame " + k + "...");
            }

            if (i == noOfFrames) {
                System.out.println("Acknowledgment for Frame " + i + " received");
                break;
            }

            for (int j = i; j < i + windowSize && j <= noOfFrames; j++) {
                int random_number = j + random.nextInt(windowSize);

                int it = i;
                while (it < random_number && it < it + windowSize) {
                    System.out.println("Acknowledgment for Frame " + it + " received");
                    it++;
                }

                if (it < it + windowSize) {
                    System.out.println("Timeout!! Frame Number " + random_number + " not Received");
                    System.out.println("Retransmitting Window...");
                }
                i = random_number;

                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter no. of frames: ");
        int noOfFrames = scanner.nextInt();

        System.out.print("Enter window size: ");
        int windowSize = scanner.nextInt();

        goBackN(noOfFrames, windowSize);
    }
}