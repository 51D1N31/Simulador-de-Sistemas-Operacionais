/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ep2;

/**
 *
 * @author s240370
 */
public class EscalonadorSRTF extends EscalonadorFifo{
    
    @Override 
    public boolean adicionar(ParTempoProcesso par) {
        try {
            super.adicionar(par);
            getProcessos().sort(null);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Houve um erro: " + e.getMessage()); 
            return false;
        }
    }
    
    @Override 
    public String toString() {
        return "Escalonador Shortest Remaining Time First";
    }
    
}
