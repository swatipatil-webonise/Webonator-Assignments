import impl.philosopherPbmImpl.ChopStick;
import impl.FileServices;
import impl.philosopherPbmImpl.Philosopher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static FileServices services = new FileServices();

    public static void main(String[] args) {
       try{
           String searchWord = "swati";
           services.searchWord(new BufferedReader(new FileReader("/home/webonise/input.txt")), searchWord);
           services.copyOneFileIntoOther(new BufferedReader(new FileReader("/home/webonise/input.txt")), new FileWriter("/home/webonise/output.txt"));

           System.out.println("\nPhilosopher's problem starts . ");
           ChopStick chopStick = new ChopStick();
           Thread philosopher1 = new Thread(new Philosopher(chopStick), "Sunny");
           Thread philosopher2 = new Thread(new Philosopher(chopStick), "Aditi");
           Thread philosopher3 = new Thread(new Philosopher(chopStick), "Swati");
           Thread philosopher4 = new Thread(new Philosopher(chopStick), "Vaibhav");
           philosopher1.start();
           philosopher2.start();
           philosopher1.join();
           philosopher3.start();
           philosopher2.join();
           philosopher4.start();
           philosopher3.join();
       }catch(Exception e) {
           e.printStackTrace();
       }


    }
}
