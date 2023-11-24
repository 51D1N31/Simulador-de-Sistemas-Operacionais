/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ep2;

/**
 *
 * @author sidin
 */
public class GerenciadorDeMemoriaJarra extends GerenciadorDeMemoria{
    private int quantidadeAlocada;
    
    public GerenciadorDeMemoriaJarra (int quantidadeTotal) {
        super(quantidadeTotal);
        quantidadeAlocada = 0;
    }
    
    public void alocar(int quantidadePedida) {
        if (quantidadePedida < getQuantidadeDisponivel()) {
            quantidadeAlocada += quantidadePedida;
        } else {
            throw new IllegalArgumentException("Memoria insuficiente");
        }
    }
    
    public void desalocar(int quantidadePedida) { 
        //não entendi o anunciado para implementar esse metodo
    }
    
    public int getQuantidadeAlocada() {
        return this.quantidadeAlocada;
    }
}
