import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadFromFile {
    public static void read() throws IOException, ClassNotFoundException {


    FileInputStream fileInputStream = new FileInputStream("src/main/resources/save.ser");
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

    Human savedHuman = (Human) objectInputStream.readObject();

       System.out.println(savedHuman);
}
}
