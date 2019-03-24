import java.util.*;
// public static void main(String[] args) {
//
// }
public class MyDeque<E>{
    private E[] data;
    private int start, end;
    private int size = 0;
    //constructors
    @SuppressWarnings("unchecked")
    public MyDeque(){
        data = (E[])new Object[10];
        size = 0;
        start = 0;
        end = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        data = (E[])new Object[initialCapacity];
        size = initialCapacity;
        start = 0;
        end = 0;
    }

    public int size(){
        System.out.println(end + "  g g  " + start);
        return end - start;
    }

    public String toString(){
        String display = "{";
        if (size == 0){
            display = display + "}";
        }
        else{
        int i = start;
        for (; i < end - 1; i ++){
            if (data [i] != null){
                display = display + data [i] + " ";
            }
        }
        if (i == end - 1){
            if (data [i] != null){
                display = display + data[i] + "}";
            }
            else {
                display = display +"}";
            }
        }
    }
        return display;
    }


    public void addFirst(E element){
        System.out.println("help " + size );
        if (element == null){
            throw new NullPointerException ("");
        }
        // if the array has size 0
        if (size == 0){
            System.out.println("spy");
            data = (E[])new Object[10];
            data [0] = element;
            size = 10;
            start = 0;
            end = 1;
        }
        else{
            // might need to replace null values
            // if more space is needed
            // if the array is full
            if (end == size && start == 0){
                E[] copy = (E[])new Object[size * 2];
                copy [0] = element;
                for (int x = 1; x < size; x ++){
                    copy [x] = data [x - 1];
                }
                size = size * 2;
                data = copy;
                end ++;
            }
            else {
                data [start - 1] = element;
                start --;
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
            size = 10;
            start = 0;
            end = 1;
        }
        else{
            // if more space is needed
            if (end == size){
                E[] copy = (E[])new Object[size * 2];
                for (int x = 0; x < size; x ++){
                    copy [x] = data [x];
                }
                copy[size] = element;
                size = size * 2;
                data = copy;
                end ++;
            }
            else {
                data [end] = element;
                end ++;
            }
        }
    }

    public E removeFirst(){
        if (end - start == 0){
            throw new NoSuchElementException ("");
        }
        E ho = data[start];
        data [start] = null;
        start ++;
        return ho;
    }

    public E removeLast(){
        if (end - start == 0){
            throw new NoSuchElementException ("");
        }
        E hey = data[end];
        data[end] = null;
        end --;
        return hey;
    }

    public E getFirst(){
        if (end - start == 0){
            throw new NoSuchElementException ("");
        }
        else{
        return data[start];
        }
    }

    public E getLast(){
        if (end - start == 0){
            throw new NoSuchElementException ("");
        }
        else{
        return data[end];
        }
    }
}
