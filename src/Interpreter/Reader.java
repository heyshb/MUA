package Interpreter;

import Interpreter.Operator.Read;

import java.util.Scanner;

public class Reader {
    public String Code = "";
    public Scanner cin = new Scanner(System.in);
    public int StringPos = 0;
    public int LineNum = 0;
    public boolean ReadFromKeyboard;
    public boolean HasReserve = false;
    public char ReserveChar;

    private char CheckBracket(char c){
        if (c == '[' || c == '('){
            HasReserve = true;
            ReserveChar = ' ';
            return c;
        }
        if (c == ']' || c == ')'){
            HasReserve = true;
            ReserveChar = c;
            return ' ';
        }
        return c;
    }

    public char GetNextChar(){
        if (HasReserve){
            HasReserve = false;
            return ReserveChar;
        }
        if (    ReadFromKeyboard && (
                Code.equals("") ||
                StringPos == Code.length() - 1 ||
                (StringPos < Code.length() - 2 && Code.charAt(StringPos + 1) == '/' && Code.charAt(StringPos + 2) == '/'))) {
            while(true) {
                Code = cin.nextLine();
                if ((!(Code.length() >= 2 && Code.charAt(0) == '/' && Code.charAt(1) == '/')) &&
                    (!Code.equals(""))){
                    break;
                }
            }
            Code = Code + ' ';
            //System.out.println(Code);
            LineNum++;
            StringPos = 0;
            return CheckBracket(Code.charAt(0));
        }
        else{
            StringPos++;
            if (StringPos == Code.length())
                return ' ';
            else
                return CheckBracket(Code.charAt(StringPos));
        }
    }
}
