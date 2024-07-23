package ra.util;

public class MyArray <T>{
    private T[] data; // mang trữ
    private int size; // kidhc thước lưu trữ

    public MyArray() {
        this.data = (T[]) new Object[10];
    }

    // mở rộng mảng
    private void resize() {
        T[] newData = (T[]) new Object[data.length+10];
        System.arraycopy(data, 0, newData, 0, data.length); // coppy mảng
        this.data = newData;
    }

    public  void add(T item){
        // kiểm tra mảng đã đầy hay chưa
        if (size == data.length){
            resize();
        }

        // thêm mới
        data[size++] = item;
    }

    public void remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        for (int i=index; i<size-1; i++){
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
    }
    public void set(int index, T item){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        data[index] = item;
    }
    public int indexOf(T item){
        for (int i=0; i<size; i++){
            if (item.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    public T get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }
    public  int size(){
        return size;
    }
}
