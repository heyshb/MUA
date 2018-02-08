package Interpreter.Operator;

import Values.NUM;
import Values.STRING;
import Values.VALUE;
import Exception.*;

import java.util.Scanner;

public class Read extends Operator{

    public VALUE Parse()throws ParseFailException{
        Scanner cin = new Scanner(System.in);
        String tmp = cin.nextLine();
        boolean AllDigit = true;
        for (int i=0;i<tmp.length();i++){
            AllDigit &= (tmp.charAt(i) >= '0' && tmp.charAt(i) <= '9');
        }
        if (AllDigit){
            return new NUM(Integer.parseInt(tmp));
        }
        else{
            return new STRING(tmp);
        }
        //return new STRING(this.getClass().getSimpleName() + " Parse Done");
    }
}
