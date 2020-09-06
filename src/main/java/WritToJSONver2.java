import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WritToJSONver2 {

    void toJson(Object object) throws InvocationTargetException, IllegalAccessException {

        for (Field field : object.getClass().getDeclaredFields()) {


            if (field.getAnnotations() != null) {
                Annotation[] a = field.getAnnotations();
                for (Annotation annotation : a) {
                    final Class<?> type = annotation.annotationType();
                    if (type == JsonValue.class) {
                        System.out.println(type);
                        final Method[] m = type.getDeclaredMethods();
                        for (Method method : m) {
                            method.setAccessible(true);
                            System.out.println(method.getName());
                            System.out.println(method.invoke(annotation));
                        }
                    } else if (type == CustomDateFormat.class) {
                        System.out.println(type);
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
            System.out.println(field.getName() + " -  " + field.get(object));

        }


    }
}
