package com.gavilan.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.gavilan.myapplication.model.BaseDatos;
import com.gavilan.myapplication.model.Usuario;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {

    Button btnIniciar;
    EditText txtEmail, txtClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIniciar = findViewById(R.id.btnIniciar);
        txtEmail = findViewById(R.id.txtEmail);
        txtClave = findViewById(R.id.txtClave);



        GenerarObjetos();

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = txtEmail.getText().toString();
                String clave = txtClave.getText().toString();

                for( Usuario u : BaseDatos.Usuarios ){

                    if( email.equals( u.getEmail() ) && clave.equals( u.getClave() )){

                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        intent.putExtra("usuario", u );
                        startActivity(intent);
                        return;
                    }
                }
                FancyToast.makeText(MainActivity.this,
                        "Error de credenciales",
                        FancyToast.LENGTH_LONG,
                        FancyToast.ERROR,
                        false).show();


            }
        });


    }

    public void GenerarObjetos(){
        Usuario u1 =
                new Usuario(1,"Manuel","Perez","manuel@gmail.com","123");
        Usuario u2 =
                new Usuario(2,"Alejandra","García","alejandra@gmail.com","456");
        Usuario u3 =
                new Usuario(3,"Fernando","Fuentes","fernando@gmail.com","789");

        BaseDatos.Usuarios.add(u1);
        BaseDatos.Usuarios.add(u2);
        BaseDatos.Usuarios.add(u3);
    }

}

