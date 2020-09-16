import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.time.LocalDate;
@JsonAutoDetect
public class Human implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    @JsonValue(name = "fun")
    private String hobby;
    @CustomDateFormat(format = "dd-MM-yyyy")
    private LocalDate birthDate;

    public Human(String firstName, String lastName, String hobby, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobby = hobby;
        this.birthDate = birthDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHobby() {
        return hobby;
    }

    public LocalDate getBirthDate() {
        return birthDate;
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
