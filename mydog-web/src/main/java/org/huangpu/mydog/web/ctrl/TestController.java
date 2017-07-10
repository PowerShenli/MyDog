package org.huangpu.mydog.web.ctrl;

import org.huangpu.mydog.core.MyDogPlugin;
import org.huangpu.mydog.core.flow.FlowController;
import org.huangpu.mydog.core.plugins.GenerateContext;
import org.huangpu.mydog.web.vo.MyDogPluginsParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.www.protocol.file.FileURLConnection;

import java.io.*;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by shenli on 2017/6/12.
 */
@Controller
public class TestController {

    @RequestMapping(value = "hello")
    @ResponseBody
    public String hello(){
        return "Wo!";
    }

    @RequestMapping(value = "testParam",method = RequestMethod.POST)
    @ResponseBody
    public String testParam(@RequestBody() MyDogPluginsParams myDogPluginsParams) {
    	System.out.println(myDogPluginsParams);
    	return "ok";
    }
    
    @RequestMapping(value = "testcl")
    @ResponseBody
    public String testCL(){
        MyDogPlugin entityUiPlugin = GenerateContext.getPluginByMetadataType("entityui");

        URL url = entityUiPlugin.getClass().getProtectionDomain().getCodeSource().getLocation();
        ClassLoader classLoader = entityUiPlugin.getClass().getClassLoader();
        String putputFolder = "/tmp/mydogx/";
        try {
            String recourseFolder = URLDecoder.decode(url.getPath(), "utf-8");
            System.out.println("recourseFolder = " + recourseFolder);

            URLConnection urlConnection = url.openConnection();
            System.out.println("urlConnection = " + urlConnection);
            if (urlConnection instanceof JarURLConnection) {
                System.out.println("is JarURLConnection");
                JarURLConnection jarURLConnection = (JarURLConnection) urlConnection;
                JarFile jarFile = jarURLConnection.getJarFile();
                System.out.println("jarFile = " + jarFile);
                Enumeration<JarEntry> entrys = jarFile.entries();
                System.out.println("entrys = " + entrys);
                while(entrys.hasMoreElements()){
                    JarEntry entry = entrys.nextElement();
                    if (entry.getName().startsWith(jarURLConnection.getEntryName()) && !entry.getName().endsWith("/")) {
//                        loadRecourseFromJar("/"+entry.getName());
                        System.out.println("entry.name = " + entry.getName());
                        String entryName = entry.getName();
                        if (entryName.startsWith("templates/bootstrap")) {
                            URL entryUrl = classLoader.getResource(entryName);
                            System.out.println("entryUrl = " + entryUrl);
                            InputStream is = entryUrl.openConnection().getInputStream();
                            byte[] buffer = new byte[1024];
                            int readBytes;
                            File outFile = new File(putputFolder + entryName.substring("templates/bootstrap".length()));
                            if(!outFile.exists()){
                                if(!outFile.getParentFile().exists()){
                                    outFile.getParentFile().mkdirs();
                                }
                                outFile.createNewFile();
                            }
                            OutputStream os = new FileOutputStream(outFile);
                            try {
                                while ((readBytes = is.read(buffer)) != -1) {
                                    os.write(buffer, 0, readBytes);
                                }
                            } finally {
                                os.close();
                                is.close();
                            }
                        }
                    }
                }
                jarFile.close();
            } else if (urlConnection instanceof FileURLConnection) {
                System.out.println("is FileURLConnection,,,in testcl");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "";
    }

    @RequestMapping("testFlow")
    @ResponseBody
    public String testFlow(){
        String s = new FlowController().startGenerate(makeIntput());
        return s;
    }

    private String makeIntput() {
        URL resource = getClass().getClassLoader().getResource("all_in_one.json");
        String allMetaJson = null;
        try {
            InputStream is = resource.openConnection().getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String s="";
            while((s=br.readLine())!=null)
                sb.append(s);
            allMetaJson = sb.toString();
            System.out.println("allMetaJson = " + allMetaJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allMetaJson;
    }


}
