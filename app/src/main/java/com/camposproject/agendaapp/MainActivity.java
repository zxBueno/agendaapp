package com.camposproject.agendaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private Button btnCadastrar, btnConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Chamando classe superior
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Modificando a tela, reconhecendo os botões

        this.btnCadastrar = findViewById(R.id.btnCadastrar); // Botão Cadastrar - Referencia
        this.btnConsulta = findViewById(R.id.btnConsultar); // Botão Consultar - Referencia

        // Ativar os botões

        this.btnCadastrar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CadastrarActivity.class);
            startActivity(intent);
        }); // Fim do botão Cadastrar

        this.btnConsulta.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ConsultarActivity.class);
            startActivity(intent);
        }); // Fim do botão Consulta

    } // Fim do onCreate


} // Fim do MainActivity
