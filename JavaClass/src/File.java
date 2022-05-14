import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File {
    public static void main(String[] args) throws IOException {
        String path="C:\\Users\\Jormsie PC\\IdeaProjects\\SeleniumBatch12\\JavaClass\\config.properties";
        FileInputStream fileInputStream=new FileInputStream(path);
        Properties properties=new Properties();
        properties.load(fileInputStream);
        System.out.println(properties.get("browser"));
        System.out.println(properties.get("url"));
        properties.put("newKey", "love");
        //properties.store(fileInputStream,"Added some new fields");


    }
}
