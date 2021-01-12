package io.github.mariazevedo88.javazktest.manager;

import org.apache.zookeeper.KeeperException;

public interface ZKManager {
	
	/**
     * Create a Znode and save some data
     * 
     * @param path
     * @param data
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void create(String path, byte[] data) throws KeeperException, InterruptedException;

    /**
     * Get ZNode Data
     * 
     * @param path
     * @param boolean watchFlag
     * @throws KeeperException
     * @throws InterruptedException
     */
    public Object getZNodeData(String path, boolean watchFlag);

    /**
     * Update the ZNode Data
     * 
     * @param path
     * @param data
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void update(String path, byte[] data) throws KeeperException, InterruptedException;
    
    /**
     * Remove the ZNode Data
     * 
     * @param path
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void delete(String path) throws KeeperException, InterruptedException;

}
