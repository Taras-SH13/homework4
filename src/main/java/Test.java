import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;


class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Human bob = new Human("Bob", "Robson", "Tennis", LocalDate.now());
        Human jon = new Human("Jon", "Wait", "footbol", LocalDate.now());


        FileOutputStream outputStream = new FileOutputStream("src/main/resources/save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(bob);
        objectOutputStream.writeObject(jon);


        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();
        ReadFromFile.read();
    }


}
