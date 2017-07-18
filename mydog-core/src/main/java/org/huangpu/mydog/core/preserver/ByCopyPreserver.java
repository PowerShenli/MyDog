package org.huangpu.mydog.core.preserver;

import org.apache.commons.io.FileUtils;
import org.huangpu.mydog.core.Preserver;
import org.huangpu.mydog.core.outputitem.CopyOutputItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.net.www.protocol.file.FileURLConnection;

import java.io.*;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by shenli on 2017/4/22.
 */
public class ByCopyPreserver implements Preserver<CopyOutputItem> {

    private static final Logger LOG = LoggerFactory.getLogger(ByCopyPreserver.class);

    @Override
    public void persistent(CopyOutputItem outputItem) {
        String cpFilePath = outputItem.getCpFilePath();
        String outputPath = outputItem.getOutputPath();
        LOG.debug("cpFilePath = {}" , cpFilePath);
        LOG.debug("outputPath = {}" , outputPath);
        URL resourceFolder = outputItem.getResourceFolder();
        ClassLoader classLoader = outputItem.getClassLoader();

        Objects.requireNonNull(cpFilePath);
        Objects.requireNonNull(resourceFolder);

        try {
            URLConnection urlConnection = resourceFolder.openConnection();
            LOG.debug("urlConnection={}", urlConnection);
            if (urlConnection instanceof JarURLConnection) {
                LOG.debug("is JarURLConnection");
                JarURLConnection jarURLConnection = (JarURLConnection) urlConnection;
                JarFile jarFile = jarURLConnection.getJarFile();
                LOG.debug("jarFile = " + jarFile);
                Enumeration<JarEntry> entrys = jarFile.entries();
                while(entrys.hasMoreElements()){
                    JarEntry entry = entrys.nextElement();
                    copyJarEntry2File(entry,cpFilePath,outputPath,classLoader);
                }
                jarFile.close();
            } else if (urlConnection instanceof FileURLConnection) {
                LOG.debug("is FileURLConnection, cpFilePath={}", cpFilePath);
//                File source = new File(resourceFolder.getPath() +"!"+ cpFilePath);
                File source = new File(resourceFolder.getPath()+ cpFilePath);
                LOG.debug("source = {}" , source);
                if (source.isDirectory()) {
                    FileUtils.copyDirectory(source, new File(outputPath));
                }
                else if (resourceFolder.getPath().endsWith(".jar")) {
                    LOG.info("source not dir and ends jar");
                    JarFile jarFile = new JarFile(resourceFolder.getPath());
                    Enumeration<JarEntry> entrys = jarFile.entries();
                    while (entrys.hasMoreElements()) {
                        JarEntry entry = entrys.nextElement();
                        copyJarEntry2File(entry, cpFilePath, outputPath, classLoader);
                    }
                }
                else{
                    File sourceFile = new File(resourceFolder.getPath()+ cpFilePath);
                    File outputFile = new File(outputPath);
                    LOG.debug("sourceFile = {}, outputFile = {}",sourceFile.getAbsolutePath(), outputFile.getAbsolutePath());
                    FileUtils.copyFile(sourceFile, outputFile);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void copyJarEntry2File(JarEntry entry, String cpFilePath, String outputPath, ClassLoader classLoader){

        String entryName = entry.getName();
        if (entryName.startsWith(cpFilePath) && !entryName.endsWith("/")) {
            URL entryUrl = classLoader.getResource(entryName);
            File outFile = new File(outputPath + entryName.substring(cpFilePath.length()));
            if(!outFile.exists()){
                if(!outFile.getParentFile().exists()){
                    LOG.debug("parent {} not exists.",outFile.getParentFile());
                    outFile.getParentFile().mkdirs();
                    LOG.debug("completed create dir {}", outFile.getParentFile());
                }
                try {
                    outFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try(InputStream  is = entryUrl.openConnection().getInputStream();
                OutputStream os = new FileOutputStream(outFile);
            ){
                byte[] buffer = new byte[1024];
                int readBytes;

                while ((readBytes = is.read(buffer)) != -1) {
                    os.write(buffer, 0, readBytes);
                }
            } catch (IOException ioe){
                LOG.error("copyJarEntry2File failed ",ioe);
                return;
            }
        }
    }


}
