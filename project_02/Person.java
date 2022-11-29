abstract class Person {
    String firstName;
    String lastName;

    public Person() {
        this.firstName = "";
        this.lastName = "";
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }
}
