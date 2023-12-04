/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ep2;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author s240370
 */
public class SistemaOperacional {
    private LinkedList<Processo> processosTerminados;
    private Escalonador cpu;
    private Escalonador es; 
    private GerenciadorDeMemoria memoria;
    private int tempoAtual;
    private Processo processoCPU, processoES;
    private double ociosidadeCPU, ociosidadeES;
    
    public SistemaOperacional(GerenciadorDeMemoria mem, Escalonador escalonadorCPU, Escalonador escalonadorES) {
        this.processosTerminados = new LinkedList<>();
        this.cpu = escalonadorCPU;
        this.ociosidadeCPU = 0;
        this.ociosidadeES = 0;
        this.es = escalonadorES;
        this.memoria = mem;
        this.tempoAtual = 0;
        
        cpu.adicionar(new Recurso("CPU"));
        es.adicionar(new Recurso("dispositivo de E/S"));
    }
    
    public SistemaOperacional(int capacidadeMemoria) {
        this(new GerenciadorDeMemoriaJarra(capacidadeMemoria), new EscalonadorFifo(), new EscalonadorFifo());
    }
    
    public GerenciadorDeMemoria getGerenciadorDeMemoria() {
        return this.memoria;
    }
    
    public Escalonador getEscalonadorCPU() {
        return this.cpu;
    }
    
    public Escalonador getEscalonadorES() {
        return this.es;
    }
    
    public List<Processo> getProcessosFinalizados() {
        return this.processosTerminados;
    }
    
    public int getTempoAtual() {
        return this.tempoAtual;
    }
    
    public void adicionarProcesso(Processo processo) {
        if (processo == null) {
            throw new NullPointerException("Processo nulo");
        }
        try {
            memoria.alocar(processo.getMemoriaNecessaria());
        } catch(IllegalArgumentException e) {
            System.out.println("Nao foi possivel adicionar processo " + processo.getNome() + " " + e.getMessage());
            return;
        }
        if (processo.isCpuPrimeiro()) {
            cpu.adicionar(processo.getTempoTotalCPU(), processo);
        } else {
            es.adicionar(processo.getTempoTotalES(), processo);
        }
        System.out.println("Processo " + processo.getNome() + " adicionado");
    }
    
    public void executarPasso() {
        if (getTempoAtual() == 0) {
            System.out.println("Processando tempo t=" + getTempoAtual());
        }
        
        processoCPU = cpu.gerenciar();
        if (processoCPU != null) {
            processoCPU.setTerminouCPU();
            if (!processoCPU.isTerminouES()) {
                es.adicionar(processoCPU.getTempoTotalES(), processoCPU);
                System.out.println("Processo " + processoCPU.getNome() + " enviado ao dispositivo de E/S");
            } else {
                System.out.println("Processo " + processoCPU.getNome() + " terminou de executar");
                processosTerminados.add(processoCPU);
                memoria.desalocar(processoCPU.getMemoriaNecessaria());
            }
        }
        
        processoES = es.gerenciar();
        if (processoES != null) {
            processoES.setTerminouES();
            if (!processoES.isTerminouCPU()) {
                cpu.adicionar(processoES.getTempoTotalCPU(), processoES);
                System.out.println("Processo " + processoES.getNome() + " enviado a CPU");
            } else {
                System.out.println("Processo " + processoES.getNome() + " terminou de executar");
                processosTerminados.add(processoES);
                memoria.desalocar(processoES.getMemoriaNecessaria());
            }
        }
        this.tempoAtual++;
        System.out.println(" ");
    }
    
    public void executar() {
        if (getTempoAtual() == 0) {
            executar(new LinkedList<>());
        }
    }
    
    public void executar(LinkedList<ParTempoProcesso> listaProcessos) {
        listaProcessos.sort(null);
        while(cpu.haProcessos() || es.haProcessos() || !listaProcessos.isEmpty()) {
            while(!listaProcessos.isEmpty() && listaProcessos.peek().getTempo() == getTempoAtual()) {
                ParTempoProcesso processo = listaProcessos.pollFirst();
                adicionarProcesso(processo.getProcesso());
            }
            executarPasso();
            //teste para pegar o valor de ociosidade
            //if (cpu.getParTempoProcessoAtivo() != null) {
                //if (cpu.getParTempoProcessoAtivo().getProcesso().getPorcentagemOcioso() >= ociosidadeCPU) {
               //     ociosidadeCPU = cpu
             //   }
            //}
            //fim do teste
        }
        System.out.println("Nao ha mais processos para executar");
    }
    
    public void imprimirEstatisticas() { //com toda certeza isso aqui está errado
        String tipoMemoria = null;
        if (memoria instanceof GerenciadorDeMemoriaFragmentada) {
            tipoMemoria = "Fragmentada";
        } else {
            tipoMemoria = "Jarra";
        }
        
        System.out.println("Tempo de execucao total: " + getTempoAtual());
        System.out.println("Ociosidade de CPU: " + cpu.getContadorDeTempo() + ""
                + "% (" + cpu.toString() + ")");
        System.out.println("Ociosidade de E/S: " + es.getContadorDeTempo() +
                "% (" + es.toString() + ")");
        System.out.println("Uso maximo de memoria: " + memoria.getAlocacaoMaxima() + "% (" + tipoMemoria + ")");
        System.out.println("Processos finalizados:");
        for(Processo pro : processosTerminados) {
            System.out.println(pro.toString());
        }
    }
}
