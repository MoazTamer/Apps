package com.example.registerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textView = findViewById(R.id.textView);
//        textView.setText("");

    }

    public void Facebook_Url(View view) {
        Intent Facebook = new Intent(Intent.ACTION_VIEW);
        Facebook.setData(Uri.parse("https://www.facebook.com/moaztamer8"));
        startActivity(Facebook);
    }
    public void LinkIn_Url(View view) {
        Intent LinkIn = new Intent(Intent.ACTION_VIEW);
        LinkIn.setData(Uri.parse("https://www.linkedin.com/in/moaz-tamer-8365591bb/"));
        startActivity(LinkIn);
    }

}