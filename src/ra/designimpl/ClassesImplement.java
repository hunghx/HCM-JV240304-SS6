package ra.designimpl;

import ra.design.IClassesDesign;
import ra.entity.Classes;
import ra.util.MyArray;

public class ClassesImplement implements IClassesDesign {
    public static MyArray<Classes> classList = new MyArray<>();
    @Override
    public void add(Classes classes) {
        classList.add(classes);
    }

    @Override
    public void update(Classes classes) {
        classList.set(classList.indexOf(findById(classes.getClassId())),classes);
        System.out.println("Cập nhật thanh công");
    }
    public Classes findById(String id){
        for (int i = 0; i < classList.size(); i++) {
            if (classList.get(i).getClassId().equals(id)){
                return classList.get(i);
            }
        }
        return  null;
    }

    @Override
    public void delete(String id) {
        Classes classes = findById(id);
        if (classes != null){
            classList.remove(classList.indexOf(classes));
            System.out.println("Đã xóa thành công");
        }else{
            System.err.println("Id không tôn tại");
        }
    }

    @Override
    public void display() {
        if (classList.size() == 0) {
            System.err.println("Danh sách rỗng");
            return;
        }
        for (int i = 0; i < classList.size(); i++) {
            classList.get(i).print();
        }
    }
}
