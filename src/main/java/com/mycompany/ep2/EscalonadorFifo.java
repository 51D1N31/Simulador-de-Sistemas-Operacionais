/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ep2;

/**
 *
 * @author s240370
 */
public class EscalonadorFifo extends Escalonador{
    @Override
    public boolean adicionar(ParTempoProcesso par) {
        
        if (getParTempoProcessoAtivo().getTempo() == 0) {
            throw new IllegalArgumentException("Tempo requerido zero");
        } else{
            getProcessos().add(par);
            return true;
        }
    }
    
    @Override
    public boolean verificarFim() {
        if (getContadorDeTempo() == getParTempoProcessoAtivo().getTempo()) {
            return true;
        } 
        return false;
    }
    
    @Override
    public String toString() {
        return "Escalonador First In First Out";
    }
}
