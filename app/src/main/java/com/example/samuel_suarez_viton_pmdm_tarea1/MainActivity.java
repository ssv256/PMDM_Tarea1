package com.example.samuel_suarez_viton_pmdm_tarea1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.samuel_suarez_viton_pmdm_tarea1.intents.Activity2;
import com.example.samuel_suarez_viton_pmdm_tarea1.intents.Activity4;

public class MainActivity extends AppCompatActivity {
    String nombre = "admin";
    String contrasena = "admin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText TextoNombre = findViewById(R.id.editTextNombre);
        EditText TextoContrasena = findViewById(R.id.editTextContrasena);


        //Obtengo el boton de login
        Button botonLogin = findViewById(R.id.buttonLogin);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(nombre.equals(TextoNombre.getText().toString()) && contrasena.equals(TextoContrasena.getText().toString())){
                        Intent Actividad2 = new Intent(MainActivity.this, Activity2.class);
                        Actividad2.putExtra("Nombre", nombre);
                        Actividad2.putExtra("Contraseña", contrasena);

                        startActivity(Actividad2);



                }
                else {
                    Toast.makeText(MainActivity.this, "Nombre o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK){
                        Bundle modificaciones = result.getData().getExtras();
                        String nuevoNombre = modificaciones.getString("Nombre");
                        String nuevacontrasena = modificaciones.getString("Contrasena");

                        nombre = nuevoNombre;
                        contrasena = nuevacontrasena;

                        TextoNombre.setText(nombre);
                        TextoContrasena.setText(contrasena);

                    }
                }

        );

        //Obtengo el boton de modificar
        Button botonModificar = findViewById(R.id.buttonModificar);

        botonModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Actividad4 = new Intent(MainActivity.this, Activity4.class);
                activityResultLauncher.launch(Actividad4);
            }
        });











    }
}