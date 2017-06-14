package org.huangpu.mydog.core.utils;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 * Created by shenli on 2017/6/9.
 */
public class FileMonitor {

    FileAlterationMonitor monitor = null;
    public FileMonitor(long interval) throws Exception {
        monitor = new FileAlterationMonitor(interval);
    }

    public void monitor(String path, FileAlterationListener listener) {
        FileAlterationObserver observer = new FileAlterationObserver(new File(path));
        monitor.addObserver(observer);
        observer.addListener(listener);
    }
    public void stop() throws Exception{
        monitor.stop();
    }
    public void start() throws Exception {
        monitor.start();
    }
    public static void main(String[] args) throws Exception {
        FileMonitor m = new FileMonitor(5000);
        m.monitor("/tmp/myDog1/output/src/",new FileListener());
        m.start();
    }
}
