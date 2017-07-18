package org.huangpu.mydog.core.utils;

import java.io.File;

/**
 * @author ruhaibo
 * @creat 2017-07-18 14:09.
 */
public class FileUtil {


    /**
     * 删除指定目录下所有文件（包括子目录）
     *
     * @param filePath 目录路径
     * @param delSelf 是否删除目录
     * @return
     */
    public static boolean delAllFile(String filePath, boolean delSelf) {

        boolean result = false;

        if (filePath == null) return result;

        File file = new File(filePath);
        if (!file.exists()) return result;
        if (!file.isDirectory()) return result;


        File tempFile = null;
        String[] fileArray = file.list();

        for (int i = 0; i < fileArray.length; i++) {

            String childPath = fileArray[i];

            if (filePath.endsWith(File.separator)) {
                tempFile = new File(filePath + childPath);
            } else {
                tempFile = new File(filePath + File.separator + childPath);
            }


            if (tempFile.isDirectory()) {
                delAllFile(tempFile.getAbsolutePath(), true);//再删除空文件夹
            }
            if (tempFile.isFile()) {
                tempFile.delete();
            }
        }

        if (delSelf) {
            file.delete();
        }

        return true;
    }


    public static void main(String[] args) {
       // delAllFile("C:\\tmp\\deletes", true);

        String pa = "com.power.test.project.mapping";
        System.out.print(pa.replace(".",File.separator));


    }

}
