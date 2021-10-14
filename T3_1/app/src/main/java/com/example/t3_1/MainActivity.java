package com.example.t3_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.example.t3_1.adapter.ContactoAdapter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;

    private String nombre[]={"Raul Ramirez ","Samuel Mosqueira","Ruben Huaman","Miguel Lopez","Maria Fernandez","Pedro Infante","Luis Cueva","David Hernandez","Carlos Gutierrez","Gustavo Mantilla"};
    private String celular[]={"960998212","960882145","960885478","950285440","950241128","950830477","960558711","960880577","960821102","960821103"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list= findViewById(R.id.lista_contacto);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        List<String> nombre= Arrays.asList("Raul Ramirez ","Samuel Mosqueira","Ruben Huaman","Miguel Lopez","Maria Fernandez","Pedro Infante","Luis Cueva","David Hernandez","Carlos Gutierrez","Gustavo Mantilla");
        List<String> numero=Arrays.asList("960998212","960882145","960885478","950285440","950241128","950830477","960558711","960880577","960821102","960821103");
        ContactoAdapter adapter=new ContactoAdapter(nombre,numero);
        list.setAdapter(adapter);
    }
}