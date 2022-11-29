public class Student extends Person implements Displayable {
    int studentId;
    int finalGrade;

    public Student(String firstName, String lastName, int studentId, int finalGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.finalGrade = finalGrade;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int newStudentId) {
        this.studentId = newStudentId;
    }

    public int getFinalGrade() {
        return this.finalGrade;
    }

    public void setFinalGrade(int newFinalGrade) {
        this.finalGrade = newFinalGrade;
    }

    @Override
    public String display() {
        return "Student ID: " + this.studentId + "\t" + this.getFullName() + " Final Grade: " + this.finalGrade;
    }
}
