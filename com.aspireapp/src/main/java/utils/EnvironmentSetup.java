package utils;

import controllers.BaseMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.util.Properties;

/**
 * @Author Vinit Kumar
 */
public class EnvironmentSetup extends BaseMethod {

    public static void environmentSetup() {
        try {
            Properties properties = new Properties();
            properties.setProperty("Author", "Vinit Kumar");
            properties.setProperty("Browser", Browser);
            properties.setProperty("OS", OSName);
            properties.setProperty("OS Architecture", OSArchitecture);
            properties.setProperty("OS Bit", OSBit);
//            properties.setProperty("Java Version", Runtime.class.getPackage().getImplementationVersion());
//            properties.setProperty("Host Name", InetAddress.getLocalHost().getHostName());
            properties.setProperty("Host IP Address", InetAddress.getLocalHost().getHostAddress());

            File file = new File("./src/main/resources/environment.properties");
            FileOutputStream fileOut = new FileOutputStream(file);
            properties.store(fileOut, "Environment Setup");
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
