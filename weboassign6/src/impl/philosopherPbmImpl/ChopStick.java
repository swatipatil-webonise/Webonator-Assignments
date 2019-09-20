package impl.philosopherPbmImpl;

public class ChopStick {
    public int chopsticks;
    public ChopStick() {
        this.chopsticks = 3;
    }

    synchronized public void useChopStick() {
        this.chopsticks = this.chopsticks - 2;
        System.out.println(Thread.currentThread().getName() + " is done.");
        this.chopsticks = 3;
    }
}
