import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class WritToJSONver2 {

    private String firstName;
    private String lastName;
    private String fun;
    private String hobby;
    private LocalDate birthDate;


    public HumanToJSON toJson(Object object) throws InvocationTargetException, IllegalAccessException {


        for (Field field : object.getClass().getDeclaredFields()) {


            if (field.getAnnotations() != null) {
                Annotation[] a = field.getAnnotations();
                for (Annotation annotation : a) {
                    final Class<?> type = annotation.annotationType();
                    if (type == JsonValue.class) {
                        //System.out.println(type);
                        final Method[] m = type.getDeclaredMethods();
                        for (Method method : m) {
                            method.setAccessible(true);
                            System.out.println(method.getName());
                            System.out.println(method.invoke(annotation));

                        }
                    } else if (type == CustomDateFormat.class) {
                        //System.out.println(type);
                        final Method[] m = type.getDeclaredMethods();
                        for (Method method : m) {
                            method.setAccessible(true);
                            System.out.println(method.getName());
                            System.out.println(method.invoke(annotation));

                        }
                    }
                }
            }
            field.setAccessible(true);

//            if (field.getAnnotations() != null) {
//                 fun=hobby;}

            if (field.getName().equals("firstName")) {
                System.out.println(firstName = (String) field.get(object));
            }
            if (field.getName().equals("lastName")) {
                System.out.println(lastName = (String) field.get(object));
            }
            if (field.getName().equals("hobby")) {
                System.out.println(hobby = (String) field.get(object));
            }
            if (field.getName().equals("birthDate")) {
                System.out.println(birthDate = (LocalDate) field.get(object));
            }
            if (field.getAnnotations() != null) {
                fun = hobby;
            }
        }
//todo доделать способ создания нового объекта по условию задачи. Нужно в цикле проверить названия полей и сравнить их с названиями полей у объекта.Создать с нужными условиями.

        //create Human for JSON

        if (fun != null) {
            return new HumanToJSON.HumanToJsonBuilder().setFirstName(firstName).setLastName(lastName).setFun(fun).setBirthDate(birthDate).toCreate();
        } else return
            new HumanToJSON.HumanToJsonBuilder().setFirstName(firstName).setLastName(lastName).setHobby(hobby).setBirthDate(birthDate).toCreate();


    }
}

