package com.example.tuling;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class support extends AppCompatActivity {
    private ImageView back;
    private TextView title;
    private Button tochat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        back = findViewById(R.id.open_nav);
        title = findViewById(R.id.title);
        back.setImageResource(R.drawable.back);
        tochat = findViewById(R.id.towechat);
        title.setText("赞助作者");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tochat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoWeChat();
            }
        });
    }
    private void gotoWeChat() {
        Intent intent = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent.setPackage("com.tencent.mm");
        intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        try {
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Toast.makeText(this, "你好像没有安装微信", Toast.LENGTH_SHORT).show();
        }
    }

}
