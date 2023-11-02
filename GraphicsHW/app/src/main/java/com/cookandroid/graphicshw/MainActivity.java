package com.cookandroid.graphicshw;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private SingleTouchView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawView = (SingleTouchView) findViewById(R.id.drawView);


        Button redButton = findViewById(R.id.redBtn);
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawView.changePenColor(Color.RED);
            }
        });

        Button blueButton = findViewById(R.id.blueBtn);
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawView.changePenColor(Color.BLUE);
            }
        });

        // 지우개 버튼
        Button eraseButton = findViewById(R.id.eraseButton);
        eraseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼이 클릭되면 지우개 모드를 토글합니다.
                drawView.setErase(!drawView.isErase());
            }
        });


        // 초록색 버튼
        Button greenButton = findViewById(R.id.greenBtn);
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawView.changePenColor(Color.parseColor("#43A047")); // 컬러 코드로 색상 설정
                drawView.setErase(false); // 지우개 모드 해제
            }
        });

        // 노란색 버튼
        Button yellowButton = findViewById(R.id.yellowBtn);
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawView.changePenColor(Color.parseColor("#FDD835")); // 컬러 코드로 색상 설정
                drawView.setErase(false); // 지우개 모드 해제
            }
        });


    }
}







