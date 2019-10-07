package com.example.tuling;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class About extends AppCompatActivity {
    private ImageView back;
    private TextView title;
    private Button to_support;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        back = findViewById(R.id.open_nav);
        title = findViewById(R.id.title);
        back.setImageResource(R.drawable.back);
        to_support = findViewById(R.id.tosupport);
        title.setText("关于作者");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        to_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About.this,support.class);
                startActivity(intent);
            }
        });
    }

}
