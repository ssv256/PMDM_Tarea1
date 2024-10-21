package com.example.samuel_suarez_viton_pmdm_tarea1.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.samuel_suarez_viton_pmdm_tarea1.MainActivity;
import com.example.samuel_suarez_viton_pmdm_tarea1.R;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView textoBienvenida = findViewById(R.id.textViewBienvenida);

        Bundle nombre = getIntent().getExtras();
        String bienvenida = nombre.getString("Nombre");
        textoBienvenida.setText("Bienvenido: " + bienvenida);


        ImageButton imagen = findViewById(R.id.Imagen);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.tutorialspoint.com/android/android_intents_filters.htm";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);


            }
        });

        Button botonAlarma = findViewById(R.id.BotonAlarma);

        botonAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Actividad3 = new Intent(Activity2.this, Activity3.class);
                startActivity(Actividad3);

            }
        });



    }
}