package tests.jmx.hello2;

/**
 * Created by sdaribazaron on 2016-03-31.
 */
/*
 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Sun Microsystems nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/*
 * Main.java - main class for the Hello MBean and QueueSampler MXBean example.
 * Create the Hello MBean and QueueSampler MXBean, register them in the platform
 * MBean server, then wait forever (or until the program is interrupted).
 */

import java.beans.ConstructorProperties;
import java.lang.management.ManagementFactory;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanServer;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;
public class Main {
    /*
     * For simplicity, we declare "throws Exception". Real programs will usually
     * want finer-grained exception handling.
     */
    public static void main(String[] args) throws Exception {
        // Get the Platform MBean Server
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // Construct the ObjectName for the Hello MBean we will register
        ObjectName mbeanName = new ObjectName("com.example:type=Hello");

        // Create the Hello World MBean
        Hello mbean = new Hello();

        // Register the Hello World MBean
        mbs.registerMBean(mbean, mbeanName);

        // Construct the ObjectName for the QueueSampler MXBean we will register
        ObjectName mxbeanName = new ObjectName("com.example:type=QueueSampler");

        // Create the Queue Sampler MXBean
        Queue<String> queue = new ArrayBlockingQueue<String>(10);
        queue.add("Request-1");
        queue.add("Request-2");
        queue.add("Request-3");
        QueueSampler mxbean = new QueueSampler(queue);

        // Register the Queue Sampler MXBean
        mbs.registerMBean(mxbean, mxbeanName);

        // Wait forever
        System.out.println("Waiting for incoming requests...");
        Thread.sleep(Long.MAX_VALUE);
    }
}

/*
 * QueueSample.java - Java type representing a snapshot of a given queue. It
 * bundles together the instant time the snapshot was taken, the queue size and
 * the queue head.
 */

interface QueueSamplerMXBean {
    public QueueSample getQueueSample();

    public void clearQueue();
}

class QueueSample {

    private final Date date;
    private final int size;
    private final String head;

    @ConstructorProperties( { "date", "size", "head" })
    public QueueSample(Date date, int size, String head) {
        this.date = date;
        this.size = size;
        this.head = head;
    }

    public Date getDate() {
        return date;
    }

    public int getSize() {
        return size;
    }

    public String getHead() {
        return head;
    }
}

/*
 * Hello.java - MBean implementation for the Hello MBean. This class must
 * implement all the Java methods declared in the HelloMBean interface, with the
 * appropriate behavior for each one.
 */

class QueueSampler implements QueueSamplerMXBean {

    private Queue<String> queue;

    public QueueSampler(Queue<String> queue) {
        this.queue = queue;
    }

    public QueueSample getQueueSample() {
        synchronized (queue) {
            return new QueueSample(new Date(), queue.size(), queue.peek());
        }
    }

    public void clearQueue() {
        synchronized (queue) {
            queue.clear();
        }
    }
}/*
   * HelloMBean.java - MBean interface describing the management operations and
   * attributes for the Hello World MBean. In this case there are two
   * operations, "sayHello" and "add", and two attributes, "Name" and
   * "CacheSize".
   */

interface HelloMBean {
    // -----------
    // operations
    // -----------

    public void sayHello();

    public int add(int x, int y);

    // -----------
    // attributes
    // -----------

    // a read-only attribute called Name of type String
    public String getName();

    // a read-write attribute called CacheSize of type int
    public int getCacheSize();

    public void setCacheSize(int size);
}

class Hello extends NotificationBroadcasterSupport implements HelloMBean {

    public void sayHello() {
        System.out.println("hello, world");
    }

    public int add(int x, int y) {
        return x + y;
    }

    /*
     * Getter for the Name attribute. The pattern shown here is frequent: the
     * getter returns a private field representing the attribute value. In our
     * case, the attribute value never changes, but for other attributes it might
     * change as the application runs. Consider an attribute representing
     * statistics such as uptime or memory usage, for example. Being read-only
     * just means that it can't be changed through the management interface.
     */
    public String getName() {
        return this.name;
    }

    /*
     * Getter for the CacheSize attribute. The pattern shown here is frequent: the
     * getter returns a private field representing the attribute value, and the
     * setter changes that field.
     */
    public int getCacheSize() {
        return this.cacheSize;
    }

    /*
     * Setter for the CacheSize attribute. To avoid problems with stale values in
     * multithreaded situations, it is a good idea for setters to be synchronized.
     */
    public synchronized void setCacheSize(int size) {
        int oldSize = this.cacheSize;
        this.cacheSize = size;

    /*
     * In a real application, changing the attribute would typically have
     * effects beyond just modifying the cacheSize field. For example, resizing
     * the cache might mean discarding entries or allocating new ones. The logic
     * for these effects would be here.
     */
        System.out.println("Cache size now " + this.cacheSize);

    /*
     * Construct a notification that describes the change. The "source" of a
     * notification is the ObjectName of the MBean that emitted it. But an MBean
     * can put a reference to itself ("this") in the source, and the MBean
     * server will replace this with the ObjectName before sending the
     * notification on to its clients.
     *
     * For good measure, we maintain a sequence number for each notification
     * emitted by this MBean.
     *
     * The oldValue and newValue parameters to the constructor are of type
     * Object, so we are relying on Tiger's autoboxing here.
     */
        Notification n = new AttributeChangeNotification(this, sequenceNumber++,
                System.currentTimeMillis(), "CacheSize changed", "CacheSize", "int",
                oldSize, this.cacheSize);

    /*
     * Now send the notification using the sendNotification method inherited
     * from the parent class NotificationBroadcasterSupport.
     */
        sendNotification(n);
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };
        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name,
                description);
        return new MBeanNotificationInfo[] { info };
    }

    private final String name = "Reginald";
    private int cacheSize = DEFAULT_CACHE_SIZE;
    private static final int DEFAULT_CACHE_SIZE = 200;

    private long sequenceNumber = 1;
}