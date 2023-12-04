/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ep2;

/**
 *
 * @author sidin
 */
public abstract class GerenciadorDeMemoria {
    private int quantidadeTotal;
    private int alocacaoMaxima;
    
    public GerenciadorDeMemoria(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }
    
    public int getQuantidadeTotal() {
        return this.quantidadeTotal;
    }
    
    public int getQuantidadeDisponivel() {
        return getQuantidadeTotal() - getQuantidadeAlocada();
    }
    
    public abstract int getQuantidadeAlocada();
    
    public double getAlocacaoAtual() {
        return 100.0*(getQuantidadeAlocada()/getQuantidadeTotal());
    }
    
    public double getAlocacaoMaxima() {
        if (alocacaoMaxima == 0) {
            return 0;
        }
        return 100.0*(getQuantidadeTotal()/alocacaoMaxima); //n garanto que isso esteja certo
    }
    
    public void atualizarAlocacaoMaxima() {
        if (alocacaoMaxima < getQuantidadeAlocada()) { //n garanto que isso esteja certo
            alocacaoMaxima = getQuantidadeAlocada();
        }
    }
    
    public abstract void alocar(int quantidadePedida);
    
    public abstract void desalocar(int quantidadePedida);
}
