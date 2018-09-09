package com.example.bryan_desktop.formulario;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout usu,pass;
    Button valida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        setTitle("INGRESO DE USUARIO");

        usu = (TextInputLayout) findViewById(R.id.til_USU);
        pass = (TextInputLayout) findViewById(R.id.til_PASS);
        valida = (Button) findViewById(R.id.btn_validar);

        //VALIDA QUE LOS CAMPOS NO ESTÉN VACIOS

        valida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario=usu.getEditText().getText().toString();
                String clave=pass.getEditText().getText().toString();

                if(usuario.isEmpty()||clave.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "CAMPO VACÍO",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(usuario.equals("bryan")&&clave.equals("admin"))
                    {
                        Toast.makeText(LoginActivity.this, "BIENVENIDO BRYAN",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this,ListActivity.class);
                        intent.putExtra("nombre", "Bryan Soto");
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "DATOS INCORRECTOS",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
