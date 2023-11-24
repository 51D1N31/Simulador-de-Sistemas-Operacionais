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
    private LinkedList<ParTempoProcesso> list = new LinkedList<>();
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
    
    public abstract boolean adicionar(ParTempoProcesso par);
    
    protected int getContadorDeTempo() {
        return this.contTempo;
    }
    
    protected ParTempoProcesso getParTempoProcessoAtivo() {
        return this.processoAtivo;
    }
    
    public List<ParTempoProcesso> getProcessos() {
        return this.list;
    }
    
    protected Processo limparProcessoAtivo() {
        Processo aux = getParTempoProcessoAtivo().getProcesso();
        this.processoAtivo = null;
        return aux;
    }
    
    public Processo gerenciar() {
        //Remover processos da fila - inicio 
        if(getParTempoProcessoAtivo() == null){
            this.processoAtivo = list.peekFirst();
            list.pollFirst();
            this.contTempo = 0;
        }
        //fim
        
        //Contabilizar a atividade ou ociosidade do recurso e dos processos:
        if (getParTempoProcessoAtivo() == null) {
            this.contTempo++;
        } else {
            this.recurso.incrementarTempoAtivo();
        }
        for(ParTempoProcesso p: list) {
            p.getProcesso().incrementarTempoOcioso();
        }
        if (getParTempoProcessoAtivo() != null) {
            getParTempoProcessoAtivo().getProcesso().incrementarTempoAtivo();
        }
        this.contTempo++;
        //fim
        
        //Imprimir estado da execução:
        if (getParTempoProcessoAtivo() == null) {
            return null;
        } else {
            System.out.println("Recurso " + this.recurso.getNome() + " (tamanho da fila: " + list.size() + ") processo " + this.getParTempoProcessoAtivo().getProcesso().getNome() +
                    " " + this.contTempo/this.getParTempoProcessoAtivo().getTempo());
        }
        //fim
        
        //Verificar se o processo ativo ja terminou: 
        if (verificarFim()) {
            return limparProcessoAtivo();
        }
        else {
            return null;
        }
        //fim
    }
    
    protected abstract boolean verificarFim();
    
    public boolean haProcessos() {
        return getParTempoProcessoAtivo() != null;
    }
    
}
