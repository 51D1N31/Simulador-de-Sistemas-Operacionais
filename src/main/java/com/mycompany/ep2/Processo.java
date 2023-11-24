/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ep2;

/**
 *
 * @author sidin
 */
public class Processo extends ContadorDeTempo{
    private String nome;
    private boolean CpuPrimeiro;
    private int tempoTotalCPU, tempoTotalES, memoriaNecessaria;
    private static int proximoId = 1;
    private final int id;
    
    private boolean setCPU = false;
    private boolean setES = false;
    
    public Processo(String nome, boolean CpuPrimeiro, int tempoTotalCPU, int tempoToalES, int memoriaNecessaria) {
        this.nome = nome;
        this.CpuPrimeiro = CpuPrimeiro;
        this.tempoTotalCPU = tempoTotalCPU;
        this.tempoTotalES = tempoTotalES;
        this.memoriaNecessaria = memoriaNecessaria;
        this.id = Processo.proximoId();
        
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public static int proximoId() {
        return proximoId++;
    }
    
    public int getId() {
        return this.id;
    }
    
    public boolean isCpuPrimeiro() {
        return this.CpuPrimeiro;
    }
    
    public int getTempoTotalCPU() {
        return this.tempoTotalCPU;
    }
    
    public int getTempoTotalES() {
        return this.tempoTotalES;
    }
    
    public int getMemoriaNecessaria() {
        return this.memoriaNecessaria;
    }
    
    public boolean isTerminouCPU() {
        if (this.setCPU == true) {
            return true;
        }
        return false;
    }
    
    public void setTerminouCPU() {
        this.setCPU = true;
    }
    
    public boolean isTerminouES() {
        if (this.setES == true) {
            return true;
        }
        return false;
    }
    
    public void setTerminouES() {
        this.setES = true;
    }
    
    @Override
    public String toString() {
        return "Processo " + getNome() + "(id: " + getId() + ") porcentagem ocioso: " + getPorcentagemOcioso() + "%";
    }
}
