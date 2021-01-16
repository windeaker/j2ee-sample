package zk.java.api.sample;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/10
 */
public class ZookeeperConstructorUsageSimple implements Watcher {

    private static CountDownLatch countDownLatch=new CountDownLatch(1);

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Received watcher event:"+watchedEvent);
        if (watchedEvent.getState()== Event.KeeperState.SyncConnected){
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper=new ZooKeeper("192.168.199.120:2181",5000,new ZookeeperConstructorUsageSimple());
            System.out.println("zk state:"+zooKeeper.getState());
            countDownLatch.await();
            System.out.println("zookeeper session established");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
