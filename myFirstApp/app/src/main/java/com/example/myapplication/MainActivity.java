package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//    private ActivityMainBinding binding;

    private Button buttonOpenWeb;
    private Button buttonCall911;
    private Button buttonOpenGallery;
    private Button buttonQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼 ID를 통해 버튼 인스턴스를 가져온다.
        buttonOpenWeb = findViewById(R.id.button1);
        buttonCall911 = findViewById(R.id.button2);
        buttonOpenGallery = findViewById(R.id.button3);
        buttonQuit = findViewById(R.id.button4);

        // 네이트 홈페이지를 여는 버튼 이벤트 리스너
        buttonOpenWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.nate.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        // 911 응급전화를 거는 버튼 이벤트 리스너
        buttonCall911.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:911"));
                startActivity(callIntent);
            }
        });

        // 갤러리를 여는 버튼 이벤트 리스너
        buttonOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivity(Intent.createChooser(intent, "Select Picture"));
            }
        });

        // 앱을 종료하는 버튼 이벤트 리스너
        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity(); // 앱을 종료한다.
            }
        });
    }
}