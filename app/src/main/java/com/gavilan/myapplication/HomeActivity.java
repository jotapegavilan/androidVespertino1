package com.gavilan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.gavilan.myapplication.model.BaseDatos;
import com.gavilan.myapplication.model.Recordatorio;
import com.gavilan.myapplication.model.Usuario;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    TextView txtBienvenida;
    Button btnCrear;
    ListView listRecordatorios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtBienvenida = findViewById(R.id.txtBienvenida);
        btnCrear = findViewById(R.id.btnCrear);
        listRecordatorios = findViewById(R.id.listRecordatorios);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Usuario usuario = (Usuario) bundle.get("usuario");

        txtBienvenida.setText("Bienvenid@ "+usuario.getNombre()+" "+usuario.getApellido());


        ArrayAdapter<Recordatorio> adapter =  new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, BaseDatos.Recordatorios);

        listRecordatorios.setAdapter(adapter);




    }
}