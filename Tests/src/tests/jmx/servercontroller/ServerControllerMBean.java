package tests.jmx.servercontroller;

/**
 * Created by sdaribazaron on 2016-03-08.
 */
/**
 * @author Yuriy Bura
 * @version $Id: $
 */
public interface ServerControllerMBean{
    public int getCorePoolSize();
    public void setCorePoolSize(int corePoolSize);
    public int getMaxPoolSize();
    public void setMaxPoolSize(int maxPoolSize);
    public int getRejectedCount();
    public int getActiveThreads();
    public int getPassiveThreads();
    public int getTotalThreads();
    public void flushRejected();
}