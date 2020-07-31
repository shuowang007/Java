package Singletone;

import java.io.IOException;
import java.util.Properties;

public class Singleton3 {
    public static final Singleton3 INSTANCE;
    private String info;
    static {
        try {
            Properties properties = new Properties();
            properties.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));
            INSTANCE = new Singleton3(properties.getProperty("info"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private Singleton3(String info){
        this.info = info;
    }//构造器需要初始化的时候用这种单例模式
}
