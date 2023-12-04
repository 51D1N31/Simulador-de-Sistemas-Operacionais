/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ep2;

/**
 *
 * @author sidin
 */
public class GerenciadorDeMemoriaFragmentada extends GerenciadorDeMemoria{
    
    private class Fragmento {
        
        private int posicaoInicial, posicaoFinal, tamanhoFragmento;
        
        public Fragmento(int posicaoInicial, int posicaoFinal, int tamanhoFragmento) {
            this.posicaoInicial = posicaoInicial;
            this.posicaoFinal = posicaoFinal;
            this.tamanhoFragmento = tamanhoFragmento;
        }
    }
    public GerenciadorDeMemoriaFragmentada(int quantidadeTotal) {
        super(quantidadeTotal);
    }
    
    
    
    public void alocar(int quantidadepedida) {
        
    }
    
    public void desalocar(int quantidadePedida) {
        
    }
    
    public int getQuantidadeAlocada() {
        return 0;
    }
}
