package com.helloworld.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.helloworld.R;

public class CountActivity extends AppCompatActivity {
    private int mCount;
    private  int n1 = 1;
    private int n2 = 0;
    private TextView mShowCount;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mShowCount = (TextView) findViewById(R.id.show_count);
        mEditText = findViewById(R.id.editText_fib);

        n1 = 0;
        n2 = 1;
    }

    public void  showToast(View view){
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {

        int max = Integer.parseInt(mEditText.getText().toString());

        if (mCount >= max){
            Toast.makeText(this, R.string.toast_max_message, Toast.LENGTH_SHORT).show();
            return;
        }

        int fib;
        if (mCount == 0){
            fib = 1;
        } else {
            fib = n1 + n2;
        }
        n2 = n1;
        n1 = fib;
        mCount++;

        mShowCount.setText(String.valueOf(n2));
    }

    public void countDown(View view){
        mCount = 1;
        n1 = 1;
        n2 = 0;
        mShowCount.setText(String.valueOf(n2));
    }
}