package ra.entity;

public class ClassWithStudent {
    private Classes classes;
    private int totalStudents;

    public ClassWithStudent() {
    }

    public ClassWithStudent(Classes classes, int totalStudents) {
        this.classes = classes;
        this.totalStudents = totalStudents;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }
}
