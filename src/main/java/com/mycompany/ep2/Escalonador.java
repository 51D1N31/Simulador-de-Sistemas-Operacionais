/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ep2;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sidin
 */
public abstract class Escalonador {
    private List<ParTempoProcesso> list = new LinkedList<ParTempoProcesso>();
    private ParTempoProcesso processoAtivo;
    private Recurso recurso;
    private int contTempo;
    
    public Escalonador() {
        
    }
    
    public void adicionar(Recurso recurso) {
        if (recurso == null) {
            throw new NullPointerException("Recurso nulo");
        } else {
            if (this.recurso != null) {
                throw new IllegalArgumentException("Recurso ja adicionado");
            } else {
                this.recurso = recurso;
            }
        }
    }
    
    public Recurso getRecurso() {
        return this.recurso;
    }
    
    public boolean adicionar(int tempoRequerido, Processo processo) {
        ParTempoProcesso aux = new ParTempoProcesso(tempoRequerido, processo);
        adicionar(aux);
        return true; //ele n pediu para fazer esse return mas fazer oq ne, ele vai dar erro se n fizer
    }
    
    public abstract boolean adicionar(ParTempoProcesso par){
        
    }
    
    protected int getContadorDeTempo() {
        return this.contTempo;
    }
    
    protected ParTempoProcesso getParTempoProcessoAtivo() {
        return this.processoAtivo;
    }
    
    public List<ParTempoProcesso> getProcessos() {
        return this.list;
    }
    
    protected Processo limparProcessoAtivo() {// como que eu atribuo em uma variavel temporaria sem usar o construtor ?
        private Processo aux = new getPar
        this.processoAtivo = null;
        
    }
    
    public Processo gerenciar() {
        
    }
    
    protected abstract boolean verificarFim() {
        
    }
    
    public boolean haProcessos() {
        
    }
    
}
