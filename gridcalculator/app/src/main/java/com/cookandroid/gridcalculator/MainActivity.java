package com.cookandroid.gridcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText operand1EditText, operand2EditText;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView resultTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText, Button, TextView 초기화
        operand1EditText = findViewById(R.id.operand_1_editText);
        operand2EditText = findViewById(R.id.operand_2_editText);
        btnAdd = findViewById(R.id.plus_button);
        btnSub = findViewById(R.id.minus_button);
        btnMul = findViewById(R.id.multiply_button);
        btnDiv = findViewById(R.id.divide_button);
        resultTextView = findViewById(R.id.result_textView);

        // 버튼에 클릭 리스너 등록
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // EditText에서 입력값 가져오기
        String operand1Str = operand1EditText.getText().toString().trim();
        String operand2Str = operand2EditText.getText().toString().trim();

        // 입력값이 비어 있는지 확인
        if (operand1Str.isEmpty() || operand2Str.isEmpty()) {
            Toast.makeText(this, "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        // 입력값을 정수로 변환
        int operand1 = Integer.parseInt(operand1Str);
        int operand2 = Integer.parseInt(operand2Str);
        int result = 0;

        // 클릭된 버튼에 따라 계산 수행
        if (view.getId() == R.id.plus_button) {
            result = operand1 + operand2;
        } else if (view.getId() == R.id.minus_button) {
            result = operand1 - operand2;
        } else if (view.getId() == R.id.multiply_button) {
            result = operand1 * operand2;
        } else if (view.getId() == R.id.divide_button) {
            // 0으로 나누는지 확인
            if (operand2 == 0) {
                Toast.makeText(this, "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
                return;
            }
            result = operand1 / operand2;
        }

        // 결과를 TextView에 표시
        resultTextView.setText("계산 결과 : " + result);
    }
}