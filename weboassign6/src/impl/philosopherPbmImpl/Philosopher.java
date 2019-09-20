package impl.philosopherPbmImpl;

public class Philosopher implements Runnable {
    ChopStick chopStick;

    public Philosopher(ChopStick chopStick) {
        this.chopStick = chopStick;
    }

    public void run() {
        if (chopStick.chopsticks != 3) {
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
            }
        } else {
            chopStick.useChopStick();
        }
    }

}
