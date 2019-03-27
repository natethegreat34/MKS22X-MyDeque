public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
        String [] str = s.split(" ", 0);
        MyDeque<Integer> holder = new MyDeque<>();
        for (int x = 0; x < str.length; x ++){
            if (str[x].equals("+")){
                int pl = holder.removeLast() + holder.removeLast();
                holder.addLast(pl);
            }
            else if (str[x].equals("-")){
                int mi = holder.removeLast() - holder.removeLast();
                holder.addLast(mi);
            }
            else if (str[x].equals("*")){
                int mu = holder.removeLast() * holder.removeLast();
                holder.addLast(mu);
            }
            else if (str[x].equals("/")){
                int di = holder.removeLast() / holder.removeLast();
                holder.addLast(di);
            }
            else if (str[x].equals("%")){
                int mo = holder.removeLast() % holder.removeLast();
                holder.addLast(mo);
            }
            else{
            holder.addLast(Integer.parseInt(str[x]));
            }
        }
        return holder.getFirst();
    }
}
