package oProducerConsumer;

/**
 * 多线程顺序打印ABC
 */
public class JoinTest {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB(threadA);
        ThreadC threadC = new ThreadC(threadB);
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class ThreadA extends Thread{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.print("A");
    }

}
class ThreadB extends Thread{
    private ThreadA threadA;
    public ThreadB(ThreadA threadA){
        this.threadA =threadA;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            threadA.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.print("B");
    }

}
class ThreadC extends Thread{
    private ThreadB threadB;
    public ThreadC(ThreadB threadB){
        this.threadB =threadB;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            threadB.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.print("C");
    }
}