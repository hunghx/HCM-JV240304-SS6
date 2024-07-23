package ra.entity;

import ra.util.InputMethods;

public class Classes {
    private String classId;
    private String className;
    public Classes(String classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public Classes() {
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void inputData(){
        //  nhập các thng tin
        System.out.println("Nhập id (định dạng C000)");
        this.classId = inputClassId();
        System.out.println("Nhập tên lớp");
        this.className = InputMethods.getString();
    }

    private String inputClassId(){
        String regex = "^C[0-9]{4}$";
        while (true){
            String input = InputMethods.getString();
            if (input.matches(regex)){
                return input;
            }
            System.err.println("Không đúng định dạng C001");
        }
    }

   public  void print(){
       System.out.printf("| ID : %-5s | ClassName : %-10s |\n",classId,className);
   }
}
