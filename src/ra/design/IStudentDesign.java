package ra.design;

import ra.entity.Students;

public interface IStudentDesign extends IGenericCrud<Students,String> {
    // thống kê
    void getClassWithTotalStudents();
}
