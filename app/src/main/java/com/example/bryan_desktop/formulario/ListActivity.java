package com.example.bryan_desktop.formulario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    //VARIABLES
    ListView lista;
    //CREANDO VARIABLE ARRAY
    ArrayList participantes;
    //CREANDO ADAPTADOR
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //CAMBIANDO TITULO AL ACITIVTY
        setTitle("LISTA DE PARTICIPANTES");
        //REFERENCIANDO VARIABLES CON COMPONENTES
        lista = (ListView) findViewById(R.id.lv_participantes);

        //CREANDO EL ARRAY LISTA Y AGREGANDO VALORES
        participantes = new ArrayList<String>();
        participantes.add("Bryan");
        participantes.add("Edward");
        participantes.add("Wendy");

        //CREACIÓN DE ADAPTADOR DE ARRAY
        adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, participantes);

        //AGREGANDO ADAPTADOR A LISTVIEW
        lista.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.add_item:
                //
                Toast.makeText(ListActivity.this,"Agregando nuevo item",Toast.LENGTH_LONG).show();
                participantes.add("Nombre Nuevo");
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
