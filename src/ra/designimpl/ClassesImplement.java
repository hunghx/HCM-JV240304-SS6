package ra.designimpl;

import ra.design.IClassesDesign;
import ra.entity.Classes;
import ra.util.MyArray;

public class ClassesImplement implements IClassesDesign {
    private static MyArray<Classes> classList = new MyArray<>();
    @Override
    public void add(Classes classes) {
        classList.add(classes);
    }

    @Override
    public void update(Classes classes) {

    }

    @Override
    public void delete(String id) {

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
