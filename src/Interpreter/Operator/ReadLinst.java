package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.STRING;
import Values.VALUE;
import Exception.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadLinst extends Operator{

    public VALUE Parse()throws ParseFailException{
        Scanner cin = new Scanner(System.in);
        String tmp = cin.nextLine();
        String[] strings = tmp.substring(1,tmp.length() - 1).split(" ");
        ArrayList<String>spl = new ArrayList<>();
        for (int i=0;i<strings.length;i++){
            if (strings[i].length() > 0){
                spl.add(strings[i]);
            }
        }
        return new Values.LIST(spl);
        //return new STRING(this.getClass().getSimpleName() + " Parse Done");
    }
}
