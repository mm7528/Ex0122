package com.example.ex0122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    String st;
    String hint = "";
    double sum=0,num=0;
    int sign=-1;
    Button plusB, divideB, multiplyB, equalB, minusB, resetB, credits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        plusB = findViewById(R.id.plusB);
        divideB = findViewById(R.id.divideB);
        multiplyB = findViewById(R.id.multiplyB);
        equalB = findViewById(R.id.equalB);
        minusB = findViewById(R.id.minusB);
        resetB = findViewById(R.id.resetB);
        credits = findViewById(R.id.credits);

    }

    public boolean inputCheck(String st)
    {
        boolean numeric;

        numeric = st.matches("-?\\d+(\\.\\d+)?");

        if(numeric)
            return true;
        else
            Toast.makeText(this, "Wrong Input): Try again please", Toast.LENGTH_SHORT).show();
            return false;
    }

    public double solve(double num1,double num2,int sign)
    {
        if(sign==1)
        {
            sum=num1+num2;
        }
        else if(sign==2)
        {
            sum=num1-num2;
        }
        else if(sign==3)
        {
            sum=num1/num2;
        }
        else if(sign==4)
        {
            sum=num1*num2;
        }
        return sum;
    }


    public void plusButton(View view) {
       st = et1.getText().toString();
       if(sign==-1) {
           if (inputCheck(st)) {
               sum = Double.parseDouble(st);
               sign = 1;
           }

       }
       else if(sign==5)
       {
           Toast.makeText(this, "the first number is:" + sum + " and the sign is now: +, please add another number", Toast.LENGTH_LONG).show();
           sign = 1;
       }
       else
       {
           if (inputCheck(st)) {
               num = Double.parseDouble(st);
               sum=solve(sum,num,sign);
               sign = 1;
           }
       }
        et1.setText("");
        et1.setHint(""+sum);

    }

    public void minusButton(View view) {
        st = et1.getText().toString();
        if(sign==-1) {
            if (inputCheck(st)) {
                sum = Double.parseDouble(st);
                sign = 2;
            }

        }
        else if(sign==5)
        {
            Toast.makeText(this, "the first number is:" + sum + " and the sign is now: -, please add another number", Toast.LENGTH_LONG).show();
            sign = 2;
        }
        else
        {
            if (inputCheck(st)) {
                num = Double.parseDouble(st);
                sum=solve(sum,num,sign);
                sign = 2;
            }
        }
        et1.setText("");
        et1.setHint(""+sum);
    }

    public void divideButton(View view) {
        st = et1.getText().toString();
        if(sign==-1) {
            if (inputCheck(st)) {
                sum = Double.parseDouble(st);
                sign = 3;
            }

        }
        else if(sign==5)
        {
            Toast.makeText(this, "the first number is:" + sum + " and the sign is now: :, please add another number", Toast.LENGTH_LONG).show();
            sign = 3;
        }
        else
        {
            if (inputCheck(st)) {
                num = Double.parseDouble(st);
                sum=solve(sum,num,sign);
                sign = 3;
            }
        }
        et1.setText("");
        et1.setHint(""+sum);
    }

    public void multiplyButton(View view) {
        st = et1.getText().toString();
        if(sign==-1) {
            if (inputCheck(st)) {
                sum = Double.parseDouble(st);
                sign = 4;
            }

        }
        else if(sign==5)
        {
            Toast.makeText(this, "the first number is:" + sum + " and the sign is now: *, please add another number", Toast.LENGTH_LONG).show();
            sign = 4;
        }
        else
        {
            if (inputCheck(st)) {
                num = Double.parseDouble(st);
                sum=solve(sum,num,sign);
                sign = 4;
            }
        }
        et1.setText("");
        et1.setHint(""+sum);
    }

    public void equalButton(View view) {
        st = et1.getText().toString();
        if (sign!=-1 && sign!=5) {
            if (inputCheck(st)) {
                num = Double.parseDouble(st);
                sum = solve(sum, num, sign);
                String text = "" + sum;
                et1.setText("");
                et1.setHint(text);
            }
            sign=5;
        }
        else {
            Toast.makeText(this, "You can't press equal without entering an exercise", Toast.LENGTH_SHORT).show();
            sign=-1;
        }



    }

    public void resetButton(View view) {
        //to reset the calculator
        et1.setText("");
        sum=0;
        num=0;
        sign=-1;
        hint ="";
        et1.setHint(hint);
    }

    public void creditsButton(View view) {
        Intent si = new Intent(this,SecondActivity2.class);
        si.putExtra("sum",sum);
        startActivity(si);
    }

}