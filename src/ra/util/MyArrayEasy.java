package ra.util;

public class MyArrayEasy<T> {
    private T[] data;
    public MyArrayEasy() {
        this.data = (T[]) new Object[0];
    }


    public  void add(T item){
       T[] newArray = (T[]) new Object[size()+1];
       // sao chép các phần tử cũ sang
        System.arraycopy(data,0,newArray,0,size());
        // thêm mới phần tử vào cuối mảng mới
        newArray[size()] = item;
        // gan lại data
        data = newArray;
    }

    public void remove(int index){
        T[] newArray = (T[]) new Object[size()-1];
        // 1,2,3,4,5,6,7
        // _,_,_,_,_,_
        for (int i = 0; i <newArray.length; i++) {
            if (i<index){
                newArray[i] = data[i];
            }else {
                newArray[i] = data[i+1];
            }
        }
        data = newArray;

    }
    public void set(int index, T item){
        data[index] = item;
    }
    public int indexOf(T item){
        for (int i = 0; i < size(); i++) {
            if (data[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    public T get(int index){
      return data[index];
    }
    public  int size(){
        return data.length;
    }
}
