package zk.jclient.sample.zk_native;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author windeaker
 * @Description zookeeper 数据节点操作。
 * @Date 20/8/12
 */
public class ZookeeperNodeHandle implements Watcher {
    CountDownLatch countDownLatch;

    ZooKeeper zooKeeper;
    //用以在多个线程中保存节点状态信息
    public static Stat stat;

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    public void setZooKeeper(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
            System.out.println("session established");
            try {
                switch (event.getType()) {
                    case NodeChildrenChanged:
                        System.out.println("NodeChildrenChanged:" + event.getPath());
                        System.out.println("NodeChildrenChanged:" + this.zooKeeper.getChildren(event.getPath(), true));//重复注册通知
                        break;
                    case NodeDataChanged:
                        System.out.println("event path:"+event.getPath());
                        byte[] datas=zooKeeper.getData(event.getPath(),true,stat);//注册通知只能通知一次，下次需要再次注册。
                        System.out.println("new data:"+new String(datas, StandardCharsets.UTF_8));
                        System.out.println("stat after change data:[" +
                                " cZxid:"+ stat.getCzxid()+
                                " ctime:"+new Date(stat.getCtime())+
                                " mZxid:"+stat.getMzxid()+
                                " mtime:"+new Date(stat.getMtime())+
                                " pZxid:"+stat.getPzxid()+
                                " cversion:"+stat.getCversion()+
                                " dataVersion:"+stat.getVersion()+
                                " aclVersion:"+stat.getAversion()+
                                " ephemeralOwner:"+stat.getEphemeralOwner()+
                                " dataLength:"+stat.getDataLength()+
                                " numChildren:"+stat.getNumChildren()+"]");
                        break;
                    default:
                        break;
                }
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public ZookeeperNodeHandle(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = initConnection();
//        createZNodeWithSync(zooKeeper);
//        createZNodeWithAsync(zooKeeper);
//        deleteZNode(zooKeeper);
//        getChildrenSync(zooKeeper);
//        getChildrenAsync(zooKeeper);
//        getDataSync(zooKeeper);
//        getDataAsync(zooKeeper);
//        updateDataSync(zooKeeper);
        updateDataAsync(zooKeeper);
    }



    public static ZooKeeper initConnection() throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZookeeperNodeHandle watcher = new ZookeeperNodeHandle(countDownLatch);
        ZooKeeper zooKeeper = new ZooKeeper("192.168.199.120:2181", 5000, watcher);
        watcher.setZooKeeper(zooKeeper);
        stat = new Stat();
        countDownLatch.await();
        return zooKeeper;
    }

    /**
     * 同步方式创建znode
     *
     * @throws IOException
     * @throws InterruptedException
     * @throws KeeperException
     */
    public static void createZNodeWithSync(ZooKeeper zooKeeper) throws IOException, InterruptedException, KeeperException {
        String ephemeralPath = zooKeeper.create("/demo/ephemeral",//znode
                "windeaker_ephemeral".getBytes(),//znode 数据
                ZooDefs.Ids.OPEN_ACL_UNSAFE, //开放所有权限
                CreateMode.EPHEMERAL);//非持久化节点
        System.out.println(ephemeralPath);
        String ephemeralSeqPath = zooKeeper.create("/demo/ephemeralSeq",//znode
                "windeaker_ephemeral_seq".getBytes(),//znode 数据
                ZooDefs.Ids.OPEN_ACL_UNSAFE, //开放所有权限
                CreateMode.EPHEMERAL_SEQUENTIAL);//非持久化顺序节点
        System.out.println(ephemeralSeqPath);

        String persistentPath = zooKeeper.create("/demo/persistent",//znode
                "windeaker_persistent".getBytes(),//znode 数据
                ZooDefs.Ids.OPEN_ACL_UNSAFE, //开放所有权限
                CreateMode.PERSISTENT);//持久化节点
        System.out.println(persistentPath);

        String persistentSeqPath = zooKeeper.create("/demo/persistentSeq",//znode
                "windeaker_persistent_seq".getBytes(),//znode 数据
                ZooDefs.Ids.OPEN_ACL_UNSAFE, //开放所有权限
                CreateMode.PERSISTENT_SEQUENTIAL);//非持久化顺序节点
        System.out.println(persistentSeqPath);
        Thread.sleep(100000);
    }

    /**
     * 异步方式创建znode
     *
     * @throws IOException
     * @throws InterruptedException
     * @throws KeeperException
     */
    public static void createZNodeWithAsync(ZooKeeper zooKeeper) throws IOException, InterruptedException, KeeperException {
        //确保异步创建回调能打印出来
        final CountDownLatch latch = new CountDownLatch(1);
        String context = "context";
        zooKeeper.create("/demo/async",//znode
                "windeaker".getBytes(),//znode 数据
                ZooDefs.Ids.OPEN_ACL_UNSAFE, //开放所有权限
                CreateMode.PERSISTENT,//持久化节点
//                new AsyncCallback.StringCallback() {
//                    @Override
//                    public void processResult(int rc, String path, Object ctx, String name) {
//                        System.out.println("rc:" + rc + " path:" + path + " ctx:" + ctx + " name:" + name);
//                        latch.countDown();
//                    }
//                }
                (rc, path, ctx, name) -> {
                    System.out.println("response code:" + rc + " path:" + path + " context:" + ctx + " name:" + name);
                    latch.countDown();
                }, context);
        latch.await();
    }

    public static void deleteZNode(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        zooKeeper.delete("/demo/deleting_node", 0);
    }

    public static void getChildrenSync(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        List<String> paths = zooKeeper.getChildren("/demo", true);//true为注册通知。通知只会通知一次，触发一次后，需要重复注册
        System.out.println(paths);
        Thread.sleep(200000);//将主线程挂起
    }

    public static void getChildrenAsync(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        zooKeeper.getChildren("/demo", true, new AsyncCallback.ChildrenCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, List<String> children) {
                System.out.println("response code:" + rc + " path:" + path + " context:" + ctx + " childrens:" + children);
            }
        }, "ctx");//true为注册通知。通知只会通知一次，触发一次后，需要重复注册
        Thread.sleep(200000);//将主线程挂起
    }

    public static void getDataSync(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        byte[] datas = zooKeeper.getData("/demo/childa", true, stat);
        System.out.println("data: "+new String(datas));
        System.out.println("stat before change data:[" +
                " cZxid:"+ stat.getCzxid()+
                " ctime:"+new Date(stat.getCtime())+
                " mZxid:"+stat.getMzxid()+
                " mtime:"+new Date(stat.getMtime())+
                " pZxid:"+stat.getPzxid()+
                " cversion:"+stat.getCversion()+
                " dataVersion:"+stat.getVersion()+
                " aclVersion:"+stat.getAversion()+
                " ephemeralOwner:"+stat.getEphemeralOwner()+
                " dataLength:"+stat.getDataLength()+
                " numChildren:"+stat.getNumChildren()+"]");
        Thread.sleep(200000);//将主线程挂起
    }

    public static void getDataAsync(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        zooKeeper.getData("/demo/childa", true, (rc, path, ctx, data, stat) -> {
            System.out.println("response code:" + rc + " path:" + path + " context:" + ctx);
            System.out.println("data: "+new String(data));
            System.out.println("stat before change data:[" +
                    " cZxid:"+ stat.getCzxid()+
                    " ctime:"+new Date(stat.getCtime())+
                    " mZxid:"+stat.getMzxid()+
                    " mtime:"+new Date(stat.getMtime())+
                    " pZxid:"+stat.getPzxid()+
                    " cversion:"+stat.getCversion()+
                    " dataVersion:"+stat.getVersion()+
                    " aclVersion:"+stat.getAversion()+
                    " ephemeralOwner:"+stat.getEphemeralOwner()+
                    " dataLength:"+stat.getDataLength()+
                    " numChildren:"+stat.getNumChildren()+"]");
        },"context");//同上，注册通知后只能通知一次，后面需要重新注册
        Thread.sleep(200000);//将主线程挂起
    }

    public static void updateDataSync(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {

        // dataversion 如果不指定最新的，说明这个数据已经过期，需要更新数据后，并获取最新的dataversion，并对最新的dataversion更新。参考cas算法
        Stat stat1= zooKeeper.setData("/demo/childa", "lanfeng".getBytes(), 6);
        System.out.println("stat after change data without event:[" +
                " cZxid:"+ stat1.getCzxid()+
                " ctime:"+new Date(stat1.getCtime())+
                " mZxid:"+stat1.getMzxid()+
                " mtime:"+new Date(stat1.getMtime())+
                " pZxid:"+stat1.getPzxid()+
                " cversion:"+stat1.getCversion()+
                " dataVersion:"+stat1.getVersion()+
                " aclVersion:"+stat1.getAversion()+
                " ephemeralOwner:"+stat1.getEphemeralOwner()+
                " dataLength:"+stat1.getDataLength()+
                " numChildren:"+stat1.getNumChildren()+"]");
    }

    public static void updateDataAsync(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        zooKeeper.setData("/demo/childa", "lanfeng async".getBytes(), 7, new AsyncCallback.StatCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, Stat stat1) {
                System.out.println("response code:" + rc + " path:" + path + " context:" + ctx);
                System.out.println("stat after change data without event:[" +
                        " cZxid:"+ stat1.getCzxid()+
                        " ctime:"+new Date(stat1.getCtime())+
                        " mZxid:"+stat1.getMzxid()+
                        " mtime:"+new Date(stat1.getMtime())+
                        " pZxid:"+stat1.getPzxid()+
                        " cversion:"+stat1.getCversion()+
                        " dataVersion:"+stat1.getVersion()+
                        " aclVersion:"+stat1.getAversion()+
                        " ephemeralOwner:"+stat1.getEphemeralOwner()+
                        " dataLength:"+stat1.getDataLength()+
                        " numChildren:"+stat1.getNumChildren()+"]");
            }
        },"context");
        Thread.sleep(200000);//将主线程挂起
    }

    public static void nodeExistSync(ZooKeeper zooKeeper){
//        zooKeeper.exists(/de)

    }



}
