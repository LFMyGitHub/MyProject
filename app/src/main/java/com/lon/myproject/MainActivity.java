package com.lon.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/myproject/mainactivity")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.test_arouter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/mainlibrary/mainactivity").navigation();
            }
        });

        Button btn1 = findViewById(R.id.test_arouter1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/chatlibrary/mainactivity").navigation();
            }
        });

        Button btn2 = findViewById(R.id.test_arouter2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/minelibrary/mainactivity").navigation();
            }
        });

        Button btn3 = findViewById(R.id.test_arouter3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/newslibrary/mainactivity").navigation();
            }
        });

        Button btn4 = findViewById(R.id.test_arouter4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/shoplibrary/mainactivity").navigation();
            }
        });
    }
}
