package com.example.bryan_desktop.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre,mail,phone;
    RadioButton masc,fem;
    CheckBox ra,ia,dm,dw;
    Button grabar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //REFERENCIANDO COMPONENTES
        nombre= (EditText) findViewById(R.id.et_nom);
        mail= (EditText) findViewById(R.id.et_mail);
        phone= (EditText) findViewById(R.id.et_cel);
        masc= (RadioButton) findViewById(R.id.rad_mas);
        fem= (RadioButton) findViewById(R.id.rad_fem);
        ra= (CheckBox) findViewById(R.id.chk_ra);
        ia= (CheckBox) findViewById(R.id.chk_ia);
        dm= (CheckBox) findViewById(R.id.chk_dm);
        dw= (CheckBox) findViewById(R.id.chk_dw);
        grabar= (Button) findViewById(R.id.btn_save);

        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Obteniedo valores de los RadioButton
                String gen="Género: ";
                if(masc.isChecked())
                {
                    gen=gen+masc.getText()+"\n";
                }
                else if(fem.isChecked())
                {
                    gen=gen+fem.getText()+"\n";
                }
                else
                {
                    gen=gen+"No definido \n";
                }

                //Obteniedo checks de los checkbox
                String chk="Intereses: \n";
                int num=0;
                if(ra.isChecked())
                {
                    chk=chk+"~"+ra.getText()+"\n";
                    num++;
                }
                if(ia.isChecked())
                {
                    chk=chk+"~"+ia.getText()+"\n";
                    num++;
                }
                if(dm.isChecked())
                {
                    chk=chk+"~"+dm.getText()+"\n";
                    num++;
                }
                if(dw.isChecked())
                {
                    chk=chk+"~"+dw.getText();
                    num++;
                }
                if(num==0)
                {
                    chk=chk+"Ninguno seleccionado";
                }

                //Obteniedo Valores de los EditText
                String msj;
                msj = "Nombre: "+nombre.getText()+"\n"+
                        gen+
                        "Correo: "+mail.getText()+"\n"+
                        "Celular: "+phone.getText()+"\n"+
                        chk;
                Toast.makeText(MainActivity.this,""+msj, Toast.LENGTH_LONG).show();

                //CREANDO EL INTENT CON EL PARAMETRO DEL NOMBRE PARA AGREGAR AL LIST ACTIVITY
                Intent intent = new Intent(MainActivity.this,ListActivity.class);
                ListActivity.participantes.add(nombre.getText());

                //BLANQUEO DE CAMPOS
                nombre.setText("");
                mail.setText("");
                phone.setText("");
                masc.setChecked(false);
                fem.setChecked(false);
                ra.setChecked(false);
                ia.setChecked(false);
                dm.setChecked(false);
                dw.setChecked(false);

                //IR A LIST ACTIVITY
                startActivity(intent);
            }
        });

    }
}
