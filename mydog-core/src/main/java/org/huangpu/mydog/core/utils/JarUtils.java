package org.huangpu.mydog.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.net.www.protocol.file.FileURLConnection;

import java.io.*;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by shenli on 2017/6/14.
 */
public class JarUtils {

    private static final Logger LOG = LoggerFactory.getLogger(JarUtils.class);

    public static void loadRecourseFromJar(String path, String recourseFolder, ClassLoader classLoader) throws IOException {
        if (!path.startsWith("/")) {
            throw new IllegalArgumentException("The path has to be absolute (start with '/').");
        }

        if (path.endsWith("/")) {
            throw new IllegalArgumentException("The path has to be absolute (cat not end with '/').");
        }

        int index = path.lastIndexOf('/');

        String filename = path.substring(index + 1);
        String folderPath = recourseFolder + path.substring(0, index + 1);

        // If the folder does not exist yet, it will be created. If the folder
        // exists already, it will be ignored
        File dir = new File(folderPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // If the file does not exist yet, it will be created. If the file
        // exists already, it will be ignored
        filename = folderPath + filename;
        File file = new File(filename);

        if (!file.exists() && !file.createNewFile()) {
            LOG.error("create file :{} failed", filename);
            return;
        }

        // Prepare buffer for data copying
        byte[] buffer = new byte[1024];
        int readBytes;

        // Open and check input stream
        URL url = classLoader.getResource(path);
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();

        if (is == null) {
            throw new FileNotFoundException("File " + path + " was not found inside JAR.");
        }

        // Open output stream and copy data between source file in JAR and the
        // temporary file
        OutputStream os = new FileOutputStream(file);
        try {
            while ((readBytes = is.read(buffer)) != -1) {
                os.write(buffer, 0, readBytes);
            }
        } finally {
            // If read/write fails, close streams safely before throwing an
            // exception
            os.close();
            is.close();
        }
    }


        /**
         * 当前运行环境资源文件是在jar里面的
         * @param jarURLConnection
         * @throws IOException
         */
    private static void copyJarResources(JarURLConnection jarURLConnection, ClassLoader classLoader) throws IOException{
        JarFile jarFile = jarURLConnection.getJarFile();
        Enumeration<JarEntry> entrys = jarFile.entries();
        while(entrys.hasMoreElements()){
            JarEntry entry = entrys.nextElement();
            if (entry.getName().startsWith(jarURLConnection.getEntryName()) && !entry.getName().endsWith("/")) {
                loadRecourseFromJar("/"+entry.getName(),"/tmp/mydogx/",classLoader);
            }
        }
        jarFile.close();
    }

    public static void loadRecourseFromJarByFolder(String folderPath, ClassLoader classLoader) throws IOException {
        URL url = classLoader.getResource(folderPath);
        URLConnection urlConnection = url.openConnection();
        if(urlConnection instanceof FileURLConnection){
            copyFileResources(url,folderPath,classLoader);
        }else if(urlConnection instanceof JarURLConnection){
            copyJarResources((JarURLConnection)urlConnection, classLoader);
        }
    }


    /**
     * 当前运行环境资源文件是在文件里面的
     * @param url
     * @param folderPath
     * @throws IOException
     */
    private static void copyFileResources(URL url,String folderPath, ClassLoader classLoader) throws IOException{
        File root = new File(url.getPath());
        if(root.isDirectory()){
            File[] files = root.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    loadRecourseFromJarByFolder(folderPath+"/"+file.getName(),classLoader);
                } else {
                    loadRecourseFromJar(folderPath+"/"+file.getName(),"/tmp/mydogx",classLoader);
                }
            }
        }
    }


}
