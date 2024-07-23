package ra.design;

public interface IGenericCrud <T,E> {
    void add(T t);
    T findById(E id);
    void update(T t);
    void delete(E id);
    void display();
}
