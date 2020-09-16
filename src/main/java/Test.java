import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;


class Test {



    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        // записываем тестовый файл
        Human jim = new Human("Jim", "Manson", "fishing", LocalDate.now());
        Human2 jon = new Human2("Jon", "Wait", "footbol", LocalDate.now());
        Human3 ben = new Human3("Ben", "Gann", "pirate", LocalDate.now());
        Human1 jack = new Human1("Jack", "Rodrigas", "canons", LocalDate.now());

        FileOutputStream outputStream = new FileOutputStream("src/main/resources/save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        //тестируем запись и вычитку разных форматов
        objectOutputStream.writeObject(jim);
        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();


        WritToJSONver2 writToJSONver2 = new WritToJSONver2();

        //писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

       //это объект Jackson, который выполняет сериализацию
       ObjectMapper mapper = new ObjectMapper();

       // сама сериализация: 1-куда, 2-что
       mapper.writeValue(writer,writToJSONver2.toJson(ReadFromFile.read()));

//        //преобразовываем все записанное во StringWriter в строку
        String result = writer.toString();
        System.out.println(result);
    }


}
