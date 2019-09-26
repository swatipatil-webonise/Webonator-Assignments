import java.util.Scanner;

public class PingPongApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char checkWhetherContinueOrNot = 'y';
        do {
            System.out.println("Enter the string you want to pong : ");
  	    System.out.println((scanner.next()).reverse());
            System.out.println("Do you want to continue the game :");
            checkWhetherContinueOrNot = scanner.next().charAt(0);
        }
        while(checkWhetherContinueOrNot == 'y');
    }
}

