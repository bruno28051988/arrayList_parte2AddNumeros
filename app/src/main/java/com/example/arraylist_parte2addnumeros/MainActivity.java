package com.example.arraylist_parte2addnumeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText textNumber;
    private Button btnAdicionar;
    ArrayList<Integer> lista;
    ArrayAdapter<Integer> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        textNumber = findViewById(R.id.editNumber);
        btnAdicionar = findViewById(R.id.btnAdicionar);

        lista = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                lista
        );
        listView.setAdapter(adapter);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    int numero = Integer.parseInt(String.valueOf(textNumber.getText()));
                    lista.add(numero);
                    adapter.notifyDataSetChanged();
                    textNumber.setText("");
                    
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,
                            "Preencha o campo com um número",
                            Toast.LENGTH_SHORT).show();
                }






            }
        });


    }


}