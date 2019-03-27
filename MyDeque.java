import java.util.*;
public class MyDeque<E>{
    private E[] data;
    private int start, end, size;
    private int i;

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
        // problem is that end isn't changing
        // edit: fixed
        int e = data.length - 1;
        // System.out.println( "-------------------------------------------------------");
        // System.out.println("adding" + element);
        // System.out.println("Start: " +  start);
        // System.out.println("End: " +  end);
        // System.out.println("Size: " +  size);
        // System.out.println("Length " +  data.length);
        // System.out.println("before re-size: " +  this.toString());

        // System.out.println("sad bot" + this.toString() + i + start + "  " +end);
         if (element == null){
             throw new NullPointerException ("");
         }
         // if there is nothing in the list, make a new list with a new element
         else if (size == data.length){
             // System.out.println(this.toString() + "data");
                 resizer();
                              // System.out.println(this.toString() + "copy" + data.length);
                 start = data.length - 1;
                 data[start] = element;
                 end = e;
                 size ++;

                // System.out.println(this.toString() + "copy");
                // System.out.println("Start: " +  start);
                // System.out.println("End: " +  end);
                // System.out.println("Length: " +  data.length);
                // System.out.println("]]]]]]]]]");
             }
             else if (size == 0){
                 // System.out.println("spy");
                 data = (E[])new Object[10];
                 data [0] = element;
                 size = 1;
                 start = 0;
                 end = 0;
             }
             else if (start == 0 && end != data.length - 1){
                 // if there is room on the other side, move start over there
                 start = data.length - 1;
                 data [start] = element;
                 size ++;
             }
             else if (data [start - 1] == null){
                 // if all else fails, if there is room to add normally do that
                     data [start - 1] = element;
                     start --;
                     size ++;
                 }
                 // System.out.println("after re-size: " +  this.toString());
                 // System.out.println( "-------------------------------------------------------");
     }
    public void addLast(E element){
        // same as add first but inverted
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
        else if (size == data.length){
            resizer ();
            end ++;
            data [end] = element;
            start = 0;
            size ++;
            }
        else if (end == data.length -1 && start != 0){
                end = 0;
                data [end] = element;
                size ++;
            }
        else if (data [end + 1] == null){
                    data [end + 1] = element;
                    end ++;
                    size ++;
                }
        }
private void resizer(){
    E[] copy = (E[])new Object[data.length * 2];
    // if like [1,2,3,start,end, 7 8]
    if (size > 1 && end - start == 1){
        int y = 0;
        for (int x =  start; x >= 0; x --){
                copy [y] = data [x];
                y ++;
        }
        for (int x =  data.length - 1; x >= end; x --){
                copy [y] = data [x];
                y ++;
        }
    }
    // if like [start, 1, 2, 3, 4, end]
    else if (start == 0 && end == data.length - 1){
        for (int x =  0; x <= end; x ++){
                copy [x] = data [x];
        }
    }

    // if like [1,2,3,end,start, 7 8]
    else if (start > end){
        int y = 0;
        for (int x =  start; x < data.length; x ++){
                copy [y] = data [x];
                y ++;
        }
        for (int x =  0; x <= end; x ++){
                copy [y] = data [x];
                y ++;
        }

    }
       data = copy;
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
