/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ep2;

/**
 *
 * @author s240370
 */
public class EscalonadorRoundRobin extends EscalonadorFifo{
    
    private int fatiaDeTempo;
    public EscalonadorRoundRobin(int fatiaDeTempo) {
        this.fatiaDeTempo = fatiaDeTempo;
    }
    
    public int getFatiaDeTempo() {
        return this.fatiaDeTempo;
    }
    
    @Override
    public boolean verificarFim() {
        if (super.verificarFim()) {
            return true;
        } else {
            if (getContadorDeTempo() >= getFatiaDeTempo()) {
                System.out.println("Fim da fatia de tempo do processo" + getParTempoProcessoAtivo().getProcesso().getNome());
                getParTempoProcessoAtivo().reduzirTempo(fatiaDeTempo);
                getProcessos().add(getParTempoProcessoAtivo());
                limparProcessoAtivo();
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Escalonador Round Robin";
    }
    
    
}
