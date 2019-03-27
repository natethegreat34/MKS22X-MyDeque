public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
        String str = s.split(" ", 0);
        MyDeque [] holder = new MyDeque [str.size];
        for (int x = 0; x < str.size(); x ++){
            if (str.substring(x, x +1).equals("+")){
                int pl = holder.removeLast() + holder.removeLast();
                holder.addLast(pl);
            }
            else if (str.substring(x, x +1).equals("-")){
                int mi = holder.removeLast() - holder.removeLast();
                holder.addLast(mi);
            }
            else if (str.substring(x, x +1).equals("*")){
                int mu = holder.removeLast() * holder.removeLast();
                holder.addLast(mu);
            }
            else if (str.substring(x, x +1).equals("/")){
                int di = holder.removeLast() / holder.removeLast();
                holder.addLast(di);
            }
            else if (str.substring(x, x +1).equals("%")){
                int mo = holder.removeLast() % holder.removeLast();
                holder.addLast(mo);
            }
            else{
            holder [x] = Integer.parseInt(str.substring(x, x +1));
            }
        }
    }
}
