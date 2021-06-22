package aTest.day0622rewrite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: MultiThreadCompete
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 6/22/21 1:46 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class MultiThreadCompete extends Thread{

    static final  int LOOP = 100000;
    //static int counter = 0;
    static AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void run(){
        for (int i =0;i<LOOP;i++){
            //counter++;
            counter.getAndAdd(1);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        List<MultiThreadCompete> tlist = new ArrayList<>();
        for (int i =0;i<100;i++){
            tlist.add(new MultiThreadCompete());
            tlist.get(i).start();
        }

        while (true){
            if (!tlist.stream().anyMatch(MultiThreadCompete::isAlive)) {
                System.out.println(counter);
                break;
            }
            Thread.sleep(100);
        }
    }

}
