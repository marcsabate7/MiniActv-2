package com.marc.miniactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private TextView text;
    String ampliacio = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        text = (TextView) findViewById(R.id.textSecondActivity);
        Button btn2 = (Button) findViewById(R.id.buttonBack);


        // Agafem les dades del intent i les tractem
        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String saludo = bundle.getString("namesaludo");
            int repeticions = bundle.getInt("reps");

            for(int i = 0;i<repeticions; i=i+1){
                ampliacio +=saludo;
            }
            text.setText(ampliacio);

        }else{
            Toast.makeText(Activity2.this,"It is empty!!",Toast.LENGTH_LONG).show();
            text.setText("No ha escrit res el usuari");
        }

        // Quan cliquem el boto acabem el intent i tornem a la pantalla anterior retornant el saludo
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("messageReturn",ampliacio);
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }






}