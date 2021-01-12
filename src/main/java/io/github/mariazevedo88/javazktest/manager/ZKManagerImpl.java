package io.github.mariazevedo88.javazktest.manager;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import io.github.mariazevedo88.javazktest.connection.ZKConnection;

public class ZKManagerImpl implements ZKManager {
    
	private static ZooKeeper zkeeper;
    private static ZKConnection zkConnection;

    public ZKManagerImpl() {
        initialize();
    }

    /**
     * Initialize connection 
     */
    private void initialize() {
        try {
            zkConnection = new ZKConnection();
            zkeeper = zkConnection.connect("localhost");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            zkConnection.close();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Object getZNodeData(String path, boolean watchFlag) {
        try {
            byte[] b = null;
            b = zkeeper.getData(path, null, null);
            String data = new String(b, "UTF-8");
            System.out.println(data);
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void create(String path, byte[] data) throws KeeperException, InterruptedException {
        zkeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Override
    public void update(String path, byte[] data) throws KeeperException, InterruptedException {
        int version = zkeeper.exists(path, true).getVersion();
        zkeeper.setData(path, data, version);
    }

	@Override
	public void delete(String path) throws KeeperException, InterruptedException {
		zkeeper.delete(path, zkeeper.exists(path, true).getVersion());
	}
}
