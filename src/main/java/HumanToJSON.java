import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.time.LocalDate;
@JsonAutoDetect
public class HumanToJSON implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String fun;
    private String hobby;
    private LocalDate birthDate;

   private  HumanToJSON(HumanToJsonBuilder humanToJsonBuilder) {
        this.firstName = humanToJsonBuilder.firstName;
        this.lastName = humanToJsonBuilder.lastName;
        this.fun = humanToJsonBuilder.fun;
        this.hobby = humanToJsonBuilder.hobby;
        this.birthDate = humanToJsonBuilder.birthDate;
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

    public String getFun() {
        return fun;
    }

    public String getHobby() {
        return hobby;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "HumanToJSON{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fun='" + fun + '\'' +
                ", hobby='" + hobby + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    //todo можно использовать паттерн builder;
   public static class HumanToJsonBuilder {

        private String firstName;
        private String lastName;
        private String fun;
        private String hobby;
        private LocalDate birthDate;

        public HumanToJsonBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public HumanToJsonBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public HumanToJsonBuilder setFun(String fun) {
            this.fun = fun;
            return this;
        }

        public HumanToJsonBuilder setHobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public HumanToJsonBuilder setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public HumanToJSON toCreate() {

            return new HumanToJSON(this);
        }
    }
}
