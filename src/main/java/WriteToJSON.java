import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class WriteToJSON {

    void toJson(Object object) {

        for (Field field : object.getClass().getDeclaredFields()) {

            if (field.getAnnotation(JsonValue.class) != null ) {
                try {
                    System.out.println("Object annotated field name - " + field.getName());
                    field.setAccessible(true);
                    System.out.println("Object annotated field value - " + field.get(object));
                    Annotation[] annotation = field.getAnnotations();
                    for (Annotation annotation1 : annotation) {
                        System.out.println("The object is annotated: ");
                        System.out.println(annotation1 + "  " + annotation1.annotationType());
                        final Class<?> type = annotation1.annotationType();
                        final Method m= type.getMethod("name");
                        m.setAccessible(true);
                        System.out.println("Field - "+ m.getName()+" : "+"Value - " + m.invoke(annotation1));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (field.getAnnotation(CustomDateFormat.class) != null ) {
                try {
                    System.out.println("Object annotated field name - " + field.getName());
                    field.setAccessible(true);
                    System.out.println("Object annotated field value - " + field.get(object));
                    Annotation[] annotation = field.getAnnotations();
                    for (Annotation annotation1 : annotation) {
                        System.out.println("The object is annotated: ");
                        System.out.println(annotation1 + "  " + annotation1.annotationType());
                        final Class<?> type = annotation1.annotationType();
                        final Method m= type.getMethod("format");
                        m.setAccessible(true);
                        System.out.println("Field - "+ m.getName()+" : "+"Value - " + m.invoke(annotation1));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }
}