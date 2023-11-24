/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ep2;

/**
 *
 * @author sidin
 */
public class ContadorDeTempo {
    private int contTempoAtivo = 0;
    private int contTempoOcioso = 0;
    
    public void incrementarTempoAtivo() {
        this.contTempoAtivo++;
    }
    
    public void incrementarTempoOcioso() {
        this.contTempoOcioso++;
    }
    
    public int getTempoAtivo() {
        return this.contTempoAtivo;
    }
    
    public int getTempoOcioso() {
        return this.contTempoOcioso;
    }
    
    public double getPorcentagemOcioso() {
        if (this.getTempoAtivo() != 0 || this.getTempoOcioso() != 0) {
            double porcentagemOcioso = (double) this.getTempoOcioso()/(this.getTempoAtivo() + this.getTempoOcioso());
            return porcentagemOcioso*100;
        }
        return 0;
    }
}
