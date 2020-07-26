import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;


class Test {
    Test() throws IOException, ClassNotFoundException {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        Human jim = new Human("Jim", "Manson", "fishing", LocalDate.now());
        Human2 jon = new Human2("Jon", "Wait", "footbol", LocalDate.now());
        Human3 ben = new Human3("Ben", "Gann", "pirate", LocalDate.now());
        Human1 jack = new Human1("Jack", "Rodrigas", "canonir", LocalDate.now());
        FileOutputStream outputStream = new FileOutputStream("src/main/resources/save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(jon);
        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();


        //WriteToJSON writeToJSON=new WriteToJSON();
        //writeToJSON.toJson(ReadFromFile.read());
        WritToJSONver2 writToJSONver2 = new WritToJSONver2();
        writToJSONver2.toJson(ReadFromFile.read());
    }


}
