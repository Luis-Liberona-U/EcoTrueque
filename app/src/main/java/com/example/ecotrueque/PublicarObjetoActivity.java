package com.example.ecotrueque;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PublicarObjetoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_publicar_objeto);

        EditText edtNombreObjeto = findViewById(R.id.edtNombreObjeto);

        RadioGroup rgCategoria = findViewById(R.id.rgCategoria);

        Button btnPublicar = findViewById(R.id.btnPublicar);

        btnPublicar.setOnClickListener(v -> {

            String nombreObjeto = edtNombreObjeto.getText().toString().trim();

            if (nombreObjeto.isEmpty()){
                edtNombreObjeto.setError("Ingrese el nombre del objeto");
                edtNombreObjeto.requestFocus();
                return;
            }

            int idCategoriaSeleccionada = rgCategoria.getCheckedRadioButtonId();

            if (idCategoriaSeleccionada == -1){
                Toast.makeText(PublicarObjetoActivity.this,
                        "Seleccione una opcion",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            RadioButton rbCategoriaSeleccionada = findViewById(idCategoriaSeleccionada);

            String categoria = rbCategoriaSeleccionada.getText().toString();

            Intent intent = new Intent(
                    PublicarObjetoActivity.this,
                    DetalleObjetoActivity.class
            );

            intent.putExtra("NOMBRE_OBJETO", nombreObjeto);
            intent.putExtra("CATEGORIA_OBJETO", categoria);

            startActivity(intent);







        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}