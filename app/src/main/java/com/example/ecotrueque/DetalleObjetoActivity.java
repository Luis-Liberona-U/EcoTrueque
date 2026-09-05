package com.example.ecotrueque;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalleObjetoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle_objeto);

        TextView txtNombreDetalle = findViewById(R.id.txtNombreDetalle);

        TextView txtCategoriaDetalle = findViewById(R.id.txtCategoriaDetalle);

        Button btnVolverMenu = findViewById(R.id.btnVolverMenu);

        /* Esto recibe los datos */

        Intent intentRecibido = getIntent();

        String nombreObjeto = intentRecibido.getStringExtra("NOMBRE_OBJETO");
        String categoriaObjeto = intentRecibido.getStringExtra("CATEGORIA_OBJETO");

        /* Mostrar Datos */

        txtNombreDetalle.setText("Objeto: " + nombreObjeto);
        txtCategoriaDetalle.setText("Categoría: " + categoriaObjeto);


        btnVolverMenu.setOnClickListener(v -> {

            Intent intentMenu = new Intent(
                    DetalleObjetoActivity.this,
                    MenuPrincipalActivity.class
            );

            intentMenu.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
            );

            startActivity(intentMenu);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}