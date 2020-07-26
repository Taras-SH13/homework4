import java.io.Serializable;
import java.time.LocalDate;

public class Human2 implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;

    private String hobby;

    private LocalDate birthDate;

    public Human2(String firstName, String lastName, String hobby, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobby = hobby;
        this.birthDate = birthDate;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}


