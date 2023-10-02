package com.example.hw7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hw7.R;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer first, second, result;
    private Boolean isOperationClick;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberclıck(View view) {
        if (view.getId() == R.id.AC) {
            textView.setText("0");
        } else {
            String textButton = ((Button) view).getText().toString();
            if (textView.getText().toString().equals("0") || isOperationClick) {
                textView.setText(textButton);
            } else {
                textView.append(textButton);
            }
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        if (view.getId() == R.id.plus) {
            first = Integer.valueOf(textView.getText().toString());
            operation="+";
        } else if (view.getId() == R.id.minus) {
            operation = "-";
            first = Integer.valueOf(textView.getText().toString());
        } else if (view.getId()==R.id.x) {
            operation ="*";
            first = Integer.valueOf(textView.getText().toString());
        } else if (view.getId()==R.id.delenie) {
            operation ="/";
            first = Integer.valueOf(textView.getText().toString());


        } else if (view.getId() == R.id.ravno) {
          second = Integer.valueOf(textView.getText().toString());
            if (operation.equals("-")) {
                result = first - second;
                textView.setText(result.toString());
            }
            else if(operation.equals("+")){
                result=first+second;
                textView.setText(result.toString());
            } else if (operation.equals("*")) {
                result=first*second;
                textView.setText(result.toString());

            } else if (operation.equals("/")) {
                result=first/second;
                textView.setText(result.toString());

            }

        }
        isOperationClick = true;
    }
}