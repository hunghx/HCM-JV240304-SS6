package ra.run;

import ra.design.IClassesDesign;
import ra.design.IStudentDesign;
import ra.designimpl.ClassesImplement;
import ra.designimpl.StudentImplement;
import ra.entity.Classes;
import ra.entity.Students;
import ra.util.InputMethods;

public class Main {
    private static IClassesDesign classDesign = new ClassesImplement();
    private static IStudentDesign studentDesign = new StudentImplement();

    public static void main(String[] args) {
        // hiển thị menu tổng
        while (true) {
            showMenu();
            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    // menu class
                    classManagement();
                    break;
                case 2:
                    // menu student
                    studentManagement();
                    break;
                case 3:
//                    thoát
                    break;
                default:
                    System.err.println("lựa chọn ko hợp lệ");
            }
            if (choice == 3) {
                break;
            }
        }

    }

    // quản lí lớp học

    protected static void classManagement() {
        while (true) {
            showMenuClasses();
            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    classDesign.display();
                    break;
                case 2:
                    Classes newClass = new Classes();
                    // nhập thông tin
                    newClass.inputData();
                    classDesign.add(newClass);
                    System.out.println("Thêm ới thành công");
                    break;
                case 3:
                    System.out.println("Nhập id của lớp cần sửa thông tin");
                    String idEdit = InputMethods.getString();
                    // lấy ra thoogn tin cu
                    Classes oldClass = classDesign.findById(idEdit);
                    if (oldClass==null){
                        System.err.println("ID ko tồn tại");
                    }else {
                        // chỉnh suwar thông tin
                        System.out.println("Thông tin cũ");
                        oldClass.print();
                        System.out.println("Nhập tên lớp mới");
                        oldClass.setClassName(InputMethods.getString());

                        classDesign.update(oldClass);
                    }

                    break;
                case 4:
                    // xóa nhập id của lớp cần xóa
                    System.out.println("Nhập id lớp cần xóa");
                    String idDel = InputMethods.getString();
                    classDesign.delete(idDel);
                    break;
                case 5:
                    break;
                default:
                    System.err.println("lựa chọn ko hợp lệ");
            }
            if (choice == 5) {
                break;
            }
        }
    }

    protected static void studentManagement() {
        while (true) {
            showMenuStudent();
            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    studentDesign.display();
                    break;
                case 2:
                    // thêmmowisi
                    Students s = new Students();
                    s.inputData();
                    studentDesign.add(s);
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    studentDesign.getClassWithTotalStudentsEasy();
                    break;
                case 6:
                    break;
                default:
                    System.err.println("lựa chọn ko hợp lệ");
            }
            if (choice == 6) {
                break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("-----------------MENU----------------");
        System.out.println("1. Quan lí lớp");
        System.out.println("2. Quan lí học sinh");
        System.out.println("3. Thoát");
    }

    private static void showMenuClasses() {
        System.out.println("-----------------MENU CLASS----------------");
        System.out.println("1. Hển thị danh sách lớp");
        System.out.println("2. Thêm mơi lơp hoc");
        System.out.println("3. Cập nhật thông tin");
        System.out.println("4. Xóa lớp");
        System.out.println("5. Quay lại");
    }

    private static void showMenuStudent() {
        System.out.println("-----------------MENU STUDENT----------------");
        System.out.println("1. Hiê thị danh sách học sinh");
        System.out.println("2. Thêm mới học sinh");
        System.out.println("3. Cập nhật thông tin");
        System.out.println("4. Xóa học sinh");
        System.out.println("5. Thống kê số học sinh từng lơp");
        System.out.println("6. Quay lại");
    }


}
