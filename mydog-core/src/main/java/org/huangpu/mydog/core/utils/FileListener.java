package org.huangpu.mydog.core.utils;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by shenli on 2017/6/9.
 */
public class FileListener implements FileAlterationListener {
    @Override
    public void onStart(FileAlterationObserver fileAlterationObserver) {
//        System.out.println("FileListener.onStart");
    }

    @Override
    public void onDirectoryCreate(File file) {
        System.out.println("FileListener.onDirectoryCreate");
    }

    @Override
    public void onDirectoryChange(File directory) {
        System.out.println("onDirectoryChange:" + directory.getName());
        try {
            TimeUnit.SECONDS.sleep(4);
            Runtime.getRuntime().exec("/tmp/build.sh");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDirectoryDelete(File file) {
        System.out.println("FileListener.onDirectoryDelete");
    }

    @Override
    public void onFileCreate(File file) {
        System.out.println("FileListener.onFileCreate");
    }

    @Override
    public void onFileChange(File file) {
        System.out.println("FileListener.onFileChange");
    }

    @Override
    public void onFileDelete(File file) {
        System.out.println("FileListener.onFileDelete");
    }

    @Override
    public void onStop(FileAlterationObserver fileAlterationObserver) {
//        System.out.println("FileListener.onStop");
    }
}
