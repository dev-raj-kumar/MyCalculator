package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //we would take whole expression as a string then apply all the operations over it
    String s="";
    //below method to display in the textview
    private void display(String disp){
        TextView textview = (TextView) findViewById(R.id.text_view);
        textview.setText(""+disp);
    }
    public void buttonac(View view){
        s="";                              //to clear the textview
        display(s);
    }
    public void buttonc(View view){
         s=s.substring(0,s.length()-1);    //to clear the last character
         display(s);
    }
    public void buttonmod(View view){
        s=s+"%";
        display(s);
    }
    public void buttondiv(View view){
        s=s+"/";
        display(s);
    }
    public void buttonmul(View view){
        s=s+"*";
        display(s);
    }
    public void buttonsub(View view){
        s=s+"-";
        display(s);
    }
    public void buttonadd(View view){
        s=s+"+";
        display(s);
    }
    public void button7(View view){
        s=s+"7";
        display(s);
    }
    public void button8(View view){
        s=s+"8";
        display(s);
    }
    public void button9(View view){
        s=s+"9";
        display(s);
    }
    public void button4(View view){
        s=s+"4";
        display(s);
    }
    public void button5(View view){
        s=s+"5";
        display(s);
    }
    public void button6(View view){
        s=s+"6";
        display(s);
    }
    public void button1(View view){
        s=s+"1";
        display(s);
    }
    public void button2(View view){
        s=s+"2";
        display(s);
    }
    public void button3(View view){
        s=s+"3";
        display(s);
    }
    public void button0(View view){
        s=s+"0";
        display(s);
    }
    public void buttondot(View view){
        s=s+".";
        display(s);
    }
    public void buttonequals(View view){
        float a,b;       // a to store the LHS operand and b to store the RHS operand for a operator
        float ans=0;     //stores the final answer of the calculation
        String n="";     //used to store the operands
        s=s+"+";         //the last operation should also be carried
        char x,y;        // x to store the operand and y to store each character
        int i;           //for the loop
        n=n+s.charAt(0); //to take care of the initial minus sign
        for( i=1;i<s.length();i++)
        {
            y=s.charAt(i);
            //below condition to check whether any operator is encountered or not
            if(y!='+'&&y!='-'&&y!='/'&&y!='*'&&y!='%')
                n=n+y;
            else
                break;
        }
        a=Float.valueOf(n);
        n="";           //to again make it available to store the operand
        x=s.charAt(i);

        for(int j=i+1;j<s.length();j++) {
            y = s.charAt(j);
            if (y != '+' && y != '-' && y != '/' && y != '*' && y != '%')
                n = n + y;
            else {
                b = Float.valueOf(n);      //below nested if else to carry the required operation
                if (x == '+')
                    ans = a + b;
                else if (x == '-')
                    ans = a - b;
                else if (x == '*')
                    ans = a * b;
                else if (x == '/')
                    ans = a / b;
                else
                    ans = a % b;
                a = ans;                  //to further carry on any operation on the answer
                n = "";
                x = y;               //x=y to store the operator for the next operation
            }
        }
        display(s.substring(0,s.length()-1)+"\n Ans:   "+ans);
        s=""+ans;//to continue further operations on the result
    }
}
