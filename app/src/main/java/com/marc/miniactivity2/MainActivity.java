package com.marc.miniactivity2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView form1;
    private TextView form2;
    private TextView inicialText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        form1 = findViewById(R.id.byeMessage);
        form2 = findViewById(R.id.repetitions);
        inicialText = findViewById(R.id.textInicial);

        btn = (Button) findViewById(R.id.button);

        // Quan cliquem el botó -->
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numero;
                String text1 = form1.getText().toString();
                try {
                    numero = Integer.parseInt(form2.getText().toString());
                } catch (Exception e) {
                    numero = 1;
                }
                Intent intent = new Intent(MainActivity.this, Activity2.class);

                if (form1.getText().toString().isEmpty()) {
                    intent.putExtra("namesaludo", "Default BYE");
                    intent.putExtra("reps", numero);
                } else {
                    intent.putExtra("namesaludo", text1);
                    intent.putExtra("reps", numero);
                }

                startActivityForResult(intent, 2);

            }
        });
    }

    // Esperarem el resultat de l'intent, comprovarem que tot estigui bé i el plasmarem al text inicial que teniem en aquesta activity on hi deie 'Hello World!!'
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2){
            if (resultCode == RESULT_OK){
                String result = data.getStringExtra("messageReturn");
                inicialText.setText(result);
            }
        }
    }
}