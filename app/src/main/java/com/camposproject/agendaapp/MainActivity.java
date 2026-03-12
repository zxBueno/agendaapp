package com.camposproject.agendaapp;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
public EditText codigo;
public EditText data;
public EditText descricao;
public EditText assunto;

public int cod;
public String assunt;
public Date dat;
public String desc;
public Registro registro;

    public Boolean resultadoVerificacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    } // Fim do método

    // Coletar os dados do formulario

    public void coletarDadosFormulario(View view){
        this.codigo     = findViewById(R.id.codigo); // Coletando dados da tela e passando para a variavel codigo
        this.assunto    = findViewById(R.id.assunto); // Coletando dados da tela e passando para a variavel codigo
        this.data       = findViewById(R.id.data); // Coletando dados da tela e passando para a variavel codigo
        this.descricao  = findViewById(R.id.descricao); // Coletando dados da tela e passando para a variavel codigo

        this.resultadoVerificacao = this.verificarVazio(codigo, assunto, data, descricao); // Verificando se os campos estão vazios
        if(this.resultadoVerificacao == true) {
            this.preencherCampos();

        } else {
            this.cod        = Integer.parseInt(this.codigo.getText().toString());
            this.assunt     = this.assunto.getText().toString();
            this.desc       = this.descricao.getText().toString();

        } // Fim if

    } // Fim do coletarDadosFormulario

    public Boolean verificarVazio(EditText código, EditText assunto, EditText data, EditText descricao) {
        if(codigo.getText().toString().isEmpty()        ||
                assunto.getText().toString().isEmpty()  ||
                data.getText().toString().isEmpty()     ||
                descricao.getText().toString().isEmpty()
        ){
            return true;
        } // Fim do if
        return false;

    } // Fim do Método

    // Método que envia a mensagem de campo em branco
    public void preencherCampos(){
        Toast.makeText(getApplicationContext(), "Preencha os campos com dados validos!", Toast.LENGTH_SHORT);
    } // Fim do Método

    public Boolean converterData(EditText dataCampo) {
        Date dataNova = new Date(); // Instanciando a classe DATA
        // Realizar a conversão de EDITTEXT - OObjeto para um dado tipo DATA
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()); // Define o padrão de data que quero visualizar
        dataFormatada.setLenient(false); // Evitando datas invalidas, por exemplo: 31/02/2026
        // Guardar o dado do EditText em um campo String
        String dataTexto = dataCampo.getText().toString();
        try {
            this.dat = dataFormatada.parse(dataTexto); // Armazena a data formatada
            return true; // A conversão funcionou
        } catch (ParseException e) {
            Toast.makeText(this, "Data Invalida", Toast.LENGTH_SHORT).show();
        } // Fim do Catch
        return false;

    } // Fim do Método

    // Esse método é o que de fato cadastra no banco de dados
    public void cadastrar(View view) {
        this.coletarDadosFormulario(view); // Chamando um método de coleta de dados
        if(this.resultadoVerificacao != true && this.converterData(this.data) != false){
          this.registro = new Registro(this.cod, this.assunt, this.dat, this.desc); // Cria o objeto registro

            this.db.collection("/registro").add(registro).addOnSucessListener(
                    documentReference -> {
                        Toast msg = Toast.makeText(getApplicationContext(), "Cadastrado com sucesso", Toast.LENGTH_SHORT);
                        msg.setGravity(Gravity.CENTER, 0, 50);
                        msg.show();

                    }).addOnFailureListener(e->{
                  Log.e("Firebase", "Erro", e);});
    } // Fim do cadastrar
   }

} // Fim da classe