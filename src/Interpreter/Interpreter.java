package Interpreter;

import java.util.ArrayList;
import java.util.HashMap;

import Exception.ParseFailException;
import Exception.KeyNotFoundException;
import Exception.ProgramTerminalException;
import Interpreter.Operator.*;
import Values.*;
import Values.VALUE;


public class Interpreter {

    public final static int STR_TYPE = 1;
    public final static int NUM_TYPE = 2;
    public final static int LIST_TYPE = 3;
    public final static int BOOL_TYPE = 4;
    public final static int MAX_RECURSIVE_DEP = 20;
    public static HashMap<String,VALUE>[] ValueMap = new HashMap[MAX_RECURSIVE_DEP];
    public static HashMap<String,Operator> OperatorMap = new HashMap<String,Operator>();
    //public static HashMap<String,VALUE>Value = new HashMap<>();
    public static int RecursiveDep;
    public static Reader[] reader = new Reader[MAX_RECURSIVE_DEP];
    VALUE FunctionResult = new STRING("Return Nothing");
    public boolean SubProgram = false;

    public int checkKey(String key){
        for (int i=RecursiveDep;i>=1;i--)
            if (ValueMap[i].containsKey(key) && ValueMap[i].get(key) != null){
                return i;
            }
        return 0;
    }

    public VALUE GetValue(String key) throws KeyNotFoundException{
        int keydep = checkKey(key);
        if (keydep == 0) throw new KeyNotFoundException(key);
        return ValueMap[keydep].get(key);
    }

    public void InsertValue(int dep,String key,VALUE V){
        ValueMap[dep].put(key,V);
    }

    public void EraseValue(String key){
        for (int i=RecursiveDep;i>=1;i--)
            if (ValueMap[i].containsKey(key) && ValueMap[i].get(key) != null){
                ValueMap[i].remove(key);
                return;
            }
        throw new KeyNotFoundException(key);
    }

    public static void Init() {
        for (int i = 0; i < MAX_RECURSIVE_DEP; i++) {
            Interpreter.ValueMap[i] = new HashMap<>();
            reader[i] = new Reader();
            reader[i].ReadFromKeyboard = (i == 1);
        }
        RecursiveDep = 1;
        OperatorMap.put("add",new Add());
        OperatorMap.put("and",new And());
        OperatorMap.put("butfirst",new ButFirst());
        OperatorMap.put("butlast",new ButLast());
        OperatorMap.put("div",new Div());
        OperatorMap.put("eq",new Eq());
        OperatorMap.put("erall",new Erall());
        OperatorMap.put("erase",new Erase());
        OperatorMap.put("first",new First());
        OperatorMap.put("gt",new Gt());
        OperatorMap.put("if",new If());
        OperatorMap.put("int",new Int());
        OperatorMap.put("isbool",new IsBool());
        OperatorMap.put("isempty",new IsEmpty());
        OperatorMap.put("islist",new IsList());
        OperatorMap.put("isname",new IsName());
        OperatorMap.put("isnumber",new IsNumber());
        OperatorMap.put("isword",new IsWord());
        OperatorMap.put("join",new Join());
        OperatorMap.put("last",new Last());
        OperatorMap.put("list",new List());
        OperatorMap.put("lt",new Lt());
        OperatorMap.put("make",new Make());
        OperatorMap.put("mod",new Mod());
        OperatorMap.put("mul",new Mul());
        OperatorMap.put("not",new Not());
        OperatorMap.put("or",new Or());
        OperatorMap.put("poall",new Poall());
        OperatorMap.put("print",new Print());
        OperatorMap.put("random",new RandomGen());
        OperatorMap.put("read",new Read());
        OperatorMap.put("readlinst",new ReadLinst());
        OperatorMap.put("repeat",new Repeat());
        OperatorMap.put("run",new Run());
        OperatorMap.put("save",new Save());
        OperatorMap.put("sentence",new Sentence());
        OperatorMap.put("sqrt",new Sqrt());
        OperatorMap.put("sub",new Sub());
        OperatorMap.put("thing",new Thing());
        OperatorMap.put("wait",new Wait());
        OperatorMap.put("word",new Word());
    }

    public Interpreter(){
    }

    public Interpreter(String Code){
        SubProgram = true;
        reader[RecursiveDep].Code = Code;
        reader[RecursiveDep].StringPos = 0;
    }

    boolean IsList(String list){
        int BracketCount = 0;
        if (list.charAt(0) != '[') return false;
        for (int i=0;i<list.length();i++){
            if (list.charAt(i) == '[') BracketCount++;
            if (list.charAt(i) == ']') BracketCount--;
            if (i < list.length() - 1 && BracketCount == 0) return false;
        }
        return BracketCount == 0;
    }

    public VALUE ParseFunction(VALUE Function)throws ParseFailException{
        if (Function.TYPE != LIST_TYPE) throw new ParseFailException();
        ArrayList<String> ParameterName = new ArrayList<>();
        String FunctionBody = Function.tostr();
        if (FunctionBody.charAt(2) != '[') throw new ParseFailException();
        int BracketCount = 0;
        int List1End = -1;
        for (int i=2;i<FunctionBody.length();i++){
            if (FunctionBody.charAt(i) == '[') BracketCount++;
            if (FunctionBody.charAt(i) == ']') BracketCount--;
            if (BracketCount == 0){
                List1End = i;
                break;
            }
        }
        //[ [ ] [ ] ]
        if (List1End == -1 || List1End + 5 >= FunctionBody.length()) throw new ParseFailException("Syntax Error");
        if (!IsList(FunctionBody.substring(List1End + 2, FunctionBody.length() - 2))) throw new ParseFailException("Syntax Error");
        String[] Names = FunctionBody.substring(3,List1End).split(" ");
        for (int i=0;i<Names.length;i++){
            if (Names[i].length() > 0){
                ParameterName.add(Names[i]);
            }
        }
        String Code = FunctionBody.substring(List1End + 3, FunctionBody.length() - 3);
        ValueMap[RecursiveDep + 1].clear();
        for (int i=0;i<ParameterName.size();i++){
            //InsertValue(RecursiveDep + 1,ParameterName.get(i),ParameterValues.get(i));
            InsertValue(RecursiveDep + 1,ParameterName.get(i),ParseValue());
        }
        return ExecuteCode(Code);
    }

    private boolean IsSpace(char c){
        return c == ' ' || c == '\t' || c == '\n';
    }

    public char GetNextNonSpace(){
        while(true){
            char tmp = reader[RecursiveDep].GetNextChar();
            if (!IsSpace(tmp)){
                return tmp;
            }
        }
    }

    public VALUE ParseList()
    {
        ArrayList<String> Res= new ArrayList<>();
        int BracketCount = 1;
        while(true){
            String tmp = ReadWord();
            if (tmp.equals("[")) BracketCount++;
            if (tmp.equals("]")) BracketCount--;
            if (BracketCount == 0) break;
            Res.add(tmp);
        }
        return new LIST(Res);
    }

    public VALUE ParseExpression()throws ParseFailException{
        VALUE v1,v2,Result;
        v1 = ParseValue();
        String Calc = ReadWord();
        v2 = ParseValue();
        if (v1.TYPE != NUM_TYPE || v2.TYPE != NUM_TYPE) throw new ParseFailException();
        double V1 = v1.tonum(), V2 = v2.tonum();
        switch (Calc.charAt(0)){
            case '+':
                Result = new NUM(V1 + V2);
                break;
            case '-':
                Result = new NUM(V1 - V2);
                break;
            case '*':
                Result = new NUM(V1 * V2);
                break;
            case '/':
                Result = new NUM(V1 / V2);
                break;
            case '%':
                Result = new NUM(Math.round(V1) % Math.round(V2));
                break;
            default:
                throw new ParseFailException();
        }
        if (ReadWord().charAt(0) != ')') throw new ParseFailException();
        return Result;
    }

    public VALUE ExecuteCode(String Code){
        RecursiveDep++;
        Interpreter ExeInterpreter = new Interpreter(Code);
        VALUE Result = ExeInterpreter.run();
        RecursiveDep--;
        return Result;
    }

    public String ReadWord(){
        StringBuilder Code = new StringBuilder("");
        Code.append(GetNextNonSpace());
        while(true){
            char NextChar = reader[RecursiveDep].GetNextChar();
            if (IsSpace(NextChar)){
                break;
            }
            Code.append(NextChar);
        }
        return Code.toString();
    }

    public VALUE ParseValue() throws KeyNotFoundException, ParseFailException, ProgramTerminalException{
        String Operate = ReadWord();
        //System.out.println(Operate);
        switch (Operate.charAt(0)){
            case ':':
                return GetValue(Operate.substring(1,Operate.length()));
            case '[':
                return ParseList();
            case '(':
                return ParseExpression();
            case ']':
                return new STRING("ListEnd");
            case ')':
                return new STRING("ExpEnd");
            case '\"':
                return new STRING(Operate.substring(1,Operate.length()));
        }
        if (Operate.equals("output"))
        {
            return FunctionResult = ParseValue();
        }
        if (Operate.equals("stop")){
            throw new ProgramTerminalException();
        }
        if (Operate.charAt(0) >= '0' && Operate.charAt(0) <= '9'){
            return new NUM(Double.parseDouble(Operate));
        }
        if (OperatorMap.get(Operate) != null){
            return OperatorMap.get(Operate).Parse();
        }
        for (int i=RecursiveDep;i>=1;i--){
            if (ValueMap[i].get(Operate) != null){
                return ParseFunction(ValueMap[i].get(Operate));
            }
        }
        throw new ParseFailException("Can't Resolve Method " + Operate);
    }

    public VALUE run(){
        try {
            if (!SubProgram) {
                while (true) {
                    ParseValue();
                }
            } else {
                while (reader[RecursiveDep].StringPos < reader[RecursiveDep].Code.length() - 1) {
                    ParseValue();
                }
            }
        }catch (ProgramTerminalException e){

        }
        return FunctionResult;
    }
}