import java.util.*;
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
        return end - start;
    }
    public String toString(){
        String display = "[";
        int i = 0;
        if (i == 0){
            if (data [i] != null){
                display = display + data[i];
            }
            //need to better toSting if fist value no good
        }
        i ++;
        for (; i < data.length - 1; i ++){
            if (data [i] != null){
                if (data[i - 1] != null){
                    display = display + ", " + data [i];
                }
                else{
                    display = display +  data [i];
                }

            }
        }
        if (i == data.length -1 ){
            if (data [i] != null){
                display = display + ", " + data[i] + "]";
            }
            else {
                display = display +"]";
            }
        }
        return display;
    }
    public void addFirst(E element){
        if (element == null){
            throw new NullPointerException ("");
        }
            // if more space is needed
        if (end == data.length -1){
            E[] copy = (E[])new Object[data.length * 2];
            copy [0] = element;
            for (int x = 1; x < data.length + 1; x ++){
                copy [x] = data [x];
            }
            data = copy;
        }
        else {
            data [start - 1] = element;
            start --;
        }
    }

    public void addLast(E element){
        if (element == null){
            throw new NullPointerException ("");
        }
        // if more space is needed
        if (end == data.length -1){
            E[] copy = (E[])new Object[data.length * 2];
            for (int x = 0; x < data.length; x ++){
                copy [x] = data [x];
            }
            data = copy;
        }
        else {
            data [end] = element;
            end ++;
        }
    }

    public E removeFirst(){
        if (end - start == 0){
            throw new NoSuchElementException ("");
        }
        E ho = data[data.length - 1];
        data [0] = null;
        start  ++;
        return ho;
    }
    public E removeLast(){
        if (end - start == 0){
            throw new NoSuchElementException ("");
        }
        E hey = data[data.length - 1];
        data[data.length-1] = null;
        end --;
        return hey;
    }
    public E getFirst(){
        if (end - start == 0){
            throw new NoSuchElementException ("");
        }
        return data[0];
    }
    public E getLast(){
        if (end - start == 0){
            throw new NoSuchElementException ("");
        }
        return data[0];
    }
}
