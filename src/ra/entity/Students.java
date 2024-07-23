package ra.entity;

import ra.util.InputMethods;
import  static ra.designimpl.ClassesImplement.classList;
public class Students {
    // props
    private String id;
    private String name;
    private int age;
    private  String address;

    private Classes classes ; // has a
    // constructors
    // getter/ setter
    // i/o data

    public Students() {
    }

    public Students(String id, String name, int age, String address, Classes classes) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.classes = classes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
    public  void print(){
        System.out.printf("|ID : %-5s |Name: %-15s |Age: %-3s |Address: %-10s | ClassName :%-10s |\n",id,name,age,address,classes!=null?classes.getClassName():"NULL");
    }
    public void inputData(){
        System.out.println("nhập id");
        this.id = InputMethods.getString();
        System.out.println("Nhập tên");
        this.name = InputMethods.getString();
        System.out.println("Nập tuổi");
        this.age = InputMethods.getInteger();
        System.out.println("Nhập địa chi");
        this.address = InputMethods.getString();
        // nhâp class
        for (int i = 0; i <classList.size() ; i++) {
            System.out.printf("%d . %s\n",i+1,classList.get(i).getClassName()); // 1. JV230304
        }
        // bắt người ta nhập vào ựa chọn
        System.out.println("Nhập lớp cho sinh viên ");
        int index  = InputMethods.getInteger();
        if (index>=1 && index <= classList.size()){
            this.classes = classList.get(index-1);
        }

    }

}
