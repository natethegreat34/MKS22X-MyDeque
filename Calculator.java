public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
        String [] str = s.split(" ", 0);
        MyDeque<Double> holder = new MyDeque<>();
        for (int x = 0; x < str.length; x ++){
            if (str[x].equals("+")){
                double b = holder.removeLast();
                double a = holder.removeLast();
                double pl = a + b;
                holder.addLast(pl);
            }
            else if (str[x].equals("-")){
                // needs to be in right order
                // 100 6 - = 94 b/c 100 - 6 = 96
                // but if it is 6 - 100 that = -96
                // so have to go to the one before, the one before
                double b = holder.removeLast();
                double a = holder.removeLast();
                double mi = a - b;
                holder.addLast(mi);
            }
            else if (str[x].equals("*")){
                double b = holder.removeLast();
                double a = holder.removeLast();
                double mu = a * b;
                holder.addLast(mu);
            }
            else if (str[x].equals("/")){
                // needs to be in right order
                // 100 25 / = 4 b/c 100 / 25 = 4
                // but if it is 25 / 100 that = .25
                // so have to go to the one before, the one before
                double b = holder.removeLast();
                double a = holder.removeLast();
                double di = a / b;
                holder.addLast(di);
            }
            else if (str[x].equals("%")){
                // needs to be in right order
                // 100 10 % = 10 b/c 100 10 % = 10
                // but if it is 10 % 100 that = 0
                // so have to go to the one before, the one before
                double b = holder.removeLast();
                double a = holder.removeLast();
                double mo = a % b;
                holder.addLast(mo);
            }
            else{
            holder.addLast(Double.parseDouble(str[x]));
            }
        }
        return holder.getFirst();
    }
}
