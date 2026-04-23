package com.camposproject.agendaapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ConsultarActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RegistroAdapter adapter; // Referencia a classe REGISTROADPTER
    private List<Registro> lista = new ArrayList<>(); // Array List para armazenar os dados no programa
    private FirebaseFirestore db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        recycler = findViewById(R.id.recyclerRegistros);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RegistroAdapter(lista);
        recycler.setAdapter(adapter);

    } // Fim do onCreate



} // Fim da ConsultarActivity
