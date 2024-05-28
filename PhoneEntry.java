import java.util.Objects;

public class PhoneEntry {
    private String name;
    private String surname;
    private String phone;
    private String type;
    private boolean isMultiple;

    public PhoneEntry(String name, String surname, String phone, String type) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.type = type;
    }

    public PhoneEntry(String name, String surname, String phone, String type, boolean isMultiple) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.type = type;
        this.isMultiple = isMultiple;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getType() {
        return type;
    }

    public boolean isMultiple() {
        return isMultiple;
    }

    public void setMultiple(boolean multiple) {
        isMultiple = multiple;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneEntry that = (PhoneEntry) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname)
                && Objects.equals(phone, that.phone) && Objects.equals(type, that.type)
                && (isMultiple == that.isMultiple);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phone, type, isMultiple);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", isMultiple='" + isMultiple + '\'' +
                '}';
    }

    public String outputString() {
        if (isMultiple) {
            return String.format("%s %s %s %s *", name, surname, phone, type);
        }
        return String.format("%s %s %s %s", name, surname, phone, type);
    }
}
