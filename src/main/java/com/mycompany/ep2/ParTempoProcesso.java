/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ep2;

/**
 *
 * @author sidin
 */
public class ParTempoProcesso implements Comparable<ParTempoProcesso>{
    private int tempo;
    private Processo p;
    
    ParTempoProcesso(int tempo, Processo p) {
        this.tempo = tempo;
        this.p = p;
    }
    
    public int getTempo() {
        return this.tempo;
    }
    
    public Processo getProcesso() {
        return this.p;
    }
    
    public void reduzirTempo(int tempoReducao) {
        this.tempo = tempoReducao;
    }
    
    @Override
    public int compareTo(ParTempoProcesso outroPar) {
        return getTempo() - outroPar.getTempo();
    } 
}
