package com.camposproject.agendaapp;

import java.util.Date;

public class Registro{
    private int codigo;
    private String assunto;
    private Date dataEvento;
    private String descricao;

    // Criar Construtor - Sem Parametro

    public Registro(){
        this.codigo = 0;
        this.assunto = "";
        this.dataEvento = new Date(); //0000/00/00 Padrao Amaricano
        this.descricao = "";

} // Fim do Construtor - Sem Parametro

    public.Registro(int codigo, String assunto, Date dataEvento, String descricao) {
        this.codigo = codigo;
        this.assunto = assunto;
        this.dataEvento = dataEvento;
        this.descricao = descricao;

} // Fim do Método

// Métodos Gets e Sets
// Inicio Gets

public int getCodigo() {
        return this.codigo;

} // Fim do getCodigo

public int getAssunto() {
        return this.assunto;

} // Fim do getAssunto

public Date getDataEvento() {
        return this.dataEvento;

} // Fim do getDataEvento

public String getDescricao(){
        return this.descricao;

} // Fim do getDescricao
// Fim dos gets

// Inicio dos Sets

public void setCodigo(int codigo){
        this.codigo = codigo;
} // Fim do setCodigo

public void setAssunto(String assunto){
        this.assunto = assunto;
} // Fim do setAssunto

public void setDataEvento(Date dataEvento){
        this.dataEvento = dataEvento;
} // Fim do setDataEvento

public void setDescricao(String descricao){
        this.descricao = descricao;
} // Fim do setDescricao
// Fim dos Sets





} //Fim da Classe
