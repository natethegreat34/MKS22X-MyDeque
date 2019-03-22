public class MyDeque<E>{
    private E[] data;
    private int size, start, end;

    @SuppressWarnings("unchecked")
    public MyDeque(){
        data = (E[])new Object[10];
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        data = (E[])new Object[initialCapacity];
    }
    public int size(){
        return data.length;
    }
    public String toString(){
        String display = "[";
        int i = 0;
        for (; i < data.length - 1; i ++){
            display = display + data [i] + ", ";
        }
        if (i == data.length -1 ){
            display = display + data[i] + "]";
        }
    }
    public void addFirst(E element){
        if (E == null){
            throw new NullPointerException ("");
        }
            // if more space is needed
        if (end == data.length -1){
            E [] copy = new E [data.length * 2];
            copy [0] = E;
            for (int x = 1; x < data.length + 1; x ++){
                copy [x] = data [x];
            }
            data = copy;
        }
        else {
            data [start - 1] = E;
            start --;
        }
    }

    public void addLast(E element){
        if (E == null){
            throw new NullPointerException ("");
        }
        // if more space is needed
        if (end == data.length -1){
            E [] copy = new E [data.length * 2];
            for (int x = 0; x < data.length; x ++){
                copy [x] = data [x];
            }
            data = copy;
        }
        else {
            data [end] = E;
            end ++;
        }
    }

    public E removeFirst(){
        if (data.length == 0){
            throw new NoSuchElementException ("");
        }
        data [0] = 0;
        start  ++;
        return data;
    }
    public E removeLast(){
        if (data.length == 0){
            throw new NoSuchElementException ("");
        }
        data[data.length-1] = 0;
        end --;
        return data;
    }
    public E getFirst(){
        if (data.length == 0){
            throw new NoSuchElementException ("");
        }
        return data[0];
    }
    public E getLast(){
        if (data.length == 0){
            throw new NoSuchElementException ("");
        }
        return data[0];
    }
}
