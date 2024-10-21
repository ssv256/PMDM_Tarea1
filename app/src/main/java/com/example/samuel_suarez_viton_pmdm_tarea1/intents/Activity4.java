package com.example.samuel_suarez_viton_pmdm_tarea1.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.samuel_suarez_viton_pmdm_tarea1.R;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText textoNombre = findViewById(R.id.editTextNombre);
        EditText textoContrasena = findViewById(R.id.editTextContrasena);
        Button botonGuardar = findViewById(R.id.buttonGuardar);

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();

                intent.putExtra("Nombre", textoNombre.getText().toString());
                intent.putExtra("Contrasena", textoContrasena.getText().toString());
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });


    }
}