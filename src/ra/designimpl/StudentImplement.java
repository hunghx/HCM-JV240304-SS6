package ra.designimpl;

import ra.design.IStudentDesign;
import ra.entity.ClassWithStudent;
import ra.entity.Classes;
import ra.entity.Students;
import ra.util.MyArray;
import ra.util.MyArrayEasy;

import  static ra.designimpl.ClassesImplement.classList;

public class StudentImplement implements IStudentDesign {
    private static MyArrayEasy<Students> studentList =  new MyArrayEasy<>();
    static {
        // khởi tạo dữ liệu mẫu
        Classes c1 = new Classes("C0001","JV240304");
        Classes c2 = new Classes("C0002","JV231129");
        classList.add(c1);
        classList.add(c2);

        Students s1 = new Students("S001","Nguyen Van A",19,"HN",c1);
        Students s2 = new Students("S002","Nguyen Van B",19,"HN",c2);
        Students s3 = new Students("S003","Nguyen Van C",19,"HN",c1);
        Students s4 = new Students("S004","Nguyen Van D",19,"HN",c2);
        Students s5 = new Students("S005","Nguyen Van E",19,"HN",c1);

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
    }
    @Override
    public void getClassWithTotalStudents() {
        // tính tổng số hc sinh từng lớp
        MyArray<ClassWithStudent> classWithStudentList = new MyArray<>();
        for (int i = 0; i < studentList.size(); i++) {
            int index = indexOfByClassId(studentList.get(i).getClasses().getClassId(),classWithStudentList);
            if (index != -1){
                // tng số lượng lên 1
                ClassWithStudent old = classWithStudentList.get(index);
                old.setTotalStudents(old.getTotalStudents()+1);
            }else {
                ClassWithStudent newClaseStudent = new ClassWithStudent(studentList.get(i).getClasses(),1);
                classWithStudentList.add(newClaseStudent);
            }
        }

        // in ra
        if (classWithStudentList.size()>0){
            for (int i = 0; i < classWithStudentList.size(); i++) {
                ClassWithStudent element = classWithStudentList.get(i);
                System.out.printf("|ClassName : %-10s | totalStudents : %-4s |\n",element.getClasses().getClassName(),element.getTotalStudents());

            }
        }
    }
    private int indexOfByClassId(String classId, MyArray<ClassWithStudent> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getClasses().getClassId().equals(classId)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void getClassWithTotalStudentsEasy() {
        // cách dễ hon
        // đếm số lượng sinh viên theo mã lớp học
        // duyet từng class để tính số sinh viên cua từng lớp
        for (int i = 0; i < classList.size(); i++) {
            Classes element = classList.get(i);
            int count = countTotalStudentByClasses(element.getClassId());
            System.out.printf("|Classname : %-10s| TotalStudent : %-4s |\n",element.getClassName(),count);
        }

    }

    private static int countTotalStudentByClasses(String classId) {
        int count = 0;
        for (int i =0; i< studentList.size(); i++){
            Students element = studentList.get(i); // lấy ra ptu dang duyệt tại ví trí
            if (element.getClasses().getClassId().equals(classId)){
                count++;
            }
        }
        return count;
    }

    @Override
    public void add(Students students) {
        studentList.add(students);
        System.out.println("Thêm moois thành công");
    }

    @Override
    public void update(Students students) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Students findById(String id) {
        return null;
    }

    @Override
    public void display() {
     //
        if (studentList.size()==0){
            System.err.println("Danh sách rỗng");
            return;
        }
        for (int i = 0; i < studentList.size() ; i++) {
            studentList.get(i).print();
        }
    }
}
