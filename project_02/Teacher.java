public class Teacher extends Person implements Displayable {
    String subject;

    public Teacher(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String newSubject) {
        this.subject = newSubject;
    }

    @Override
    public String display() {
        return this.getFullName() + " teaches " + this.subject;
    };
}
