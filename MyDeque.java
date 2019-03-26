import java.util.*;
public class MyDeque<E>{
    private E[] data;
    private int start, end, size;

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
        int i = start;
        String display = "{";
        if (data.length == 0){
            display = display + "}";
            return display;
        }
        if (size == 0){
            if (data [i] != null){
                display = display + data[i] + "}";
                return display;
            }
            return display + "}";
        }
        if (start > end){
            for (; i < data.length; i ++){
                if (data [i] != null){
                    display = display + data [i] + " ";
                }
            }
        }
        i = 0;
        for (; i < end; i ++){
            if (data [i] != null){
                display = display + data [i] + " ";
            }
        }
        if (i == end){
            if (data [i] != null){
                display = display + data[i] + "}";
            }
        }
        else {
            display = display +"}";
        }
        return display;
    }


    public void addFirst(E element){
        // the error is when the arraylist is [0, null, null, null]
        // ^^end != data.length, because nulls make the data.length bigger

        // System.out.println("help " + data.length );
        if (element == null){
            throw new NullPointerException ("");
        }
        // if the array has data.length 0
        if (size == 0){
            // System.out.println("spy");
            data = (E[])new Object[10];
            data [0] = element;
            size = 1;
            start = 0;
            end = 0;
        }
        else if (size == 1){
            E o = data [0];
            data = (E[])new Object[10];
            data [0] = element;
            data [1] = o;
            size = 2;
            start = 0;
            end = 1;
        }
        else{
            // might need to replace null values
            // if more space is needed
            // if the array is full
            if (end == data.length - 1&& start == 0){
                E[] copy = (E[])new Object[data.length * 2];
                copy [0] = element;
                for (int x = 1; x < data.length; x ++){
                    copy [x] = data [x - 1];
                }
                size ++;
                data = copy;
                end ++;
            }
            else { //if there is space
                start--;
                data[start] = element;
                size ++;
            }
        }
    }

    public void addLast(E element){
        if (element == null){
            throw new NullPointerException ("");
        }
        if (size == 0){
            // System.out.println("spy");
            data = (E[])new Object[10];
            data [0] = element;
            size = 1;
            start = 0;
            end = 0;
        }
        else{// what is start is in front of end
            // if more space is needed
            if (end == data.length - 1 && start == 0){
                E[] copy = (E[])new Object[data.length * 2];
                for (int x = 0; x < data.length; x ++){
                    copy [x] = data [x];
                }
                copy[end + 1] = element;
                data = copy;
                end ++;
                size ++;
            }
            else if (data [end + 1] == null){
                    data [end + 1] = element;
                    end ++;
                    size ++;
                }
            }
        }

    public E removeFirst(){
        if (size == 0){
            throw new NoSuchElementException ("");
        }
        E ho = data[start];
        data [start] = null;
        if (start == data.length -1){
            start = 0;
        }
        else{
            start ++;
        }
        size --;
        return ho;
    }

    public E removeLast(){
        if (size == 0){
            throw new NoSuchElementException ("");
        }
        E hey = data[end];
        data[end] = null;
        if (end == 0){
            end = data.length -1;
        }
        else{
            end --;
        }
        size --;

        return hey;
    }

    public E getFirst(){
        if (size == 0){
            throw new NoSuchElementException ("");
        }
        else{
        return data[start];
        }
    }

    public E getLast(){
        if (size == 0){
            throw new NoSuchElementException ("");
        }
        else{
        return data[end];
        }
    }
}
