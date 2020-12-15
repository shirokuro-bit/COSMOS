package cosmos;

import java.io.*;
import java.util.Properties;

public class LoadConfig {
    private String DBAddress;
    public LoadConfig() {
        Properties properties = new Properties();

        String strpass = "config/test.properties";

        System.out.println(new File(".").getAbsolutePath());

        try {
            InputStream istream = new FileInputStream(strpass);
            properties.load(istream);
            DBAddress = properties.getProperty("DBaddress");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDBAddress() {
        return DBAddress;
    }
}
