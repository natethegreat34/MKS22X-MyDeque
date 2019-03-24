import java.util.*;
// public static void main(String[] args) {
//
// }
public class MyDeque<E>{
    private E[] data;
    private int start, end;
    private int size = end - start;
    @SuppressWarnings("unchecked")
    public MyDeque(){
        data = (E[])new Object[10];
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        data = (E[])new Object[initialCapacity];
    }
    public int size(){
        return size;
    }
    public String toString(){
        String display = "{";
        int i = start;
        for (; i < end; i ++){
            if (data [i] != null){
                display = display + data [i] + " ";
            }
        }
        if (i == end){
            if (data [i] != null){
                display = display + data[i] + "}";
            }
            else {
                display = display +"}";
            }
        }
        return display;
    }
    public void addFirst(E element){
        System.out.println("help " + data.length );
        if (element == null){
            throw new NullPointerException ("");
        }
        if (size == 0){
            System.out.println("spy");
            data = (E[])new Object[10];
            data [0] = element;
                size ++;
        }
        else{
            // if more space is needed
        if (end == data.length -1){
            E[] copy = (E[])new Object[data.length * 2];
            size = data.length * 2;
            copy [0] = element;
            for (int x = 1; x < data.length + 1; x ++){
                copy [x] = data [x - 1];
            }
            data = copy;
        }
        else {
            data [start - 1] = element;
            start --;
            size ++;
        }
        }
    }

    public void addLast(E element){
        if (element == null){
            throw new NullPointerException ("");
        }
        if (size == 0){
            System.out.println("spy");
            data = (E[])new Object[10];
            data [0] = element;
            System.out.println(this.toString());
            size ++;
        }
        else{
        // if more space is needed
        if (end == data.length -1){
            E[] copy = (E[])new Object[data.length * 2];
            size = data.length * 2;
            for (int x = 0; x < data.length; x ++){
                copy [x] = data [x];
            }
            copy[data.length] = element;
            data = copy;
        }
        else {
            data [end] = element;
            size ++;
            end ++;
        }
    }
}

    public E removeFirst(){
        if (size == 0){
            throw new NoSuchElementException ("");
        }
        E ho = data[size - 1];
        data [0] = null;
        start  ++;
        size --;
        return ho;
    }
    public E removeLast(){
        if (size == 0){
            throw new NoSuchElementException ("");
        }
        E hey = data[data.length - 1];
        data[data.length-1] = null;
        end --;
        size --;
        return hey;
    }
    public E getFirst(){
        if (size == 0){
            throw new NoSuchElementException ("");
        }
        return data[0];
    }
    public E getLast(){
        if (size == 0){
            throw new NoSuchElementException ("");
        }
        return data[0];
    }
}
