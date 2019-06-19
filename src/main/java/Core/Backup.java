/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jorda
 */
public class Backup {
    
    public Backup() {
    }
    
    private static String getCurrentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY-HHmm");
        Date date = new Date();
        //System.out.println(dateFormat.format(date));
        String now = dateFormat.format(date);
        return now;
    }
    
    private static String getOS() {
        final String os = System.getProperty("os.name").toLowerCase();
        
        if (os.indexOf("win") >= 0) {
            return "win";
        }
        else if (os.indexOf("mac") >= 0) {
            return "mac";
        }
        else {
            return "unix";
        }
        
    }
    
    public boolean createBackup() {
        String os = getOS();
        Process p = null;
        try {
            File dir = new File("backups/");

            System.out.println(dir.getAbsoluteFile());
            Runtime runtime = Runtime.getRuntime();
            
            if (os.equals("win")) {
                p = runtime.exec("cmd /C mysqldump garitsdb -u garitsuser -pgaritsdb > backup" + getCurrentDateTime() +  ".sql", null, dir);
                return true;
            }
            else if (os.equals("mac") || os.equals("unix")) {
                p = runtime.exec("-sh -c mysqldump garitsdb -u garitsuser -pgaritsdb > backup" + getCurrentDateTime() +  ".sql", null, dir);
                return true;
            }
            
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = reader.readLine();


            while (line != null) {
                System.out.println(line);

                line = reader.readLine();
            }

        } catch (IOException e1) {
            e1.printStackTrace();
            return false;
        }
        return false;
    }
    
    public boolean restoreFromBackup(File backup) {
        String os = getOS();
        Process p = null;
        try {
            //System.out.println(backup.getName());
            File dir = new File("backups/");
            Runtime runtime = Runtime.getRuntime();
            
            if (os.equals("win")) {
                p = runtime.exec("cmd /C mysql -u garitsuser -pgaritsdb garitsdb < " + backup.getName(), null, dir);
            }
            else if (os.equals("mac") || os.equals("unix")) {
                p = runtime.exec("-sh -c mysql -u garitsuser -pgaritsdb garitsdb < " + backup.getName(), null, dir);
            }
            
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
}
