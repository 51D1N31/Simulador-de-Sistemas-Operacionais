/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ep2;
import java.util.LinkedList;
import java.util.Scanner; 

/**
 *
 * @author sidin
 */
public class EP2 {
    
    public static void main(String[] args) {
        SistemaOperacional so1 = null, so2 = null;
        LinkedList<ParTempoProcesso> processosSO1 = new LinkedList<ParTempoProcesso>();
        LinkedList<ParTempoProcesso> processosSO2 = new LinkedList<ParTempoProcesso>();
        //Essas duas listas devem ser iguais no final
        
        int continua = 0, escalonadorCPU, escalonadorES, tipoGerenciador, quantidadeMemoria, tamanhoFatiaTempoCPU = 0, tamanhoFatiaTempoES = 0;
        
        GerenciadorDeMemoria tipoMemoria;
        Escalonador tipoEscalonadorCPU;
        Escalonador tipoEscalonadorES;
        
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("************************************");
        System.out.println("* Simulador de Sistema Operacional *");
        System.out.println("************************************\n");
        
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                System.out.println("Configuracao do primeiro sistema operacional:\n");
            } else {
                System.out.println("Configuracao do segundo sistema operacional:\n");
            }
            
        
            //começo para saber qual é o tipo do escalonador da CPU
            System.out.println("Qual o tipo do escalonador de CPU?");
            System.out.println("1) First In First Out");
            System.out.println("2) Round Robin");
            System.out.println("3) Shortest Remaining Time First");
            escalonadorCPU = scan.nextInt();

            if (escalonadorCPU == 2) {
                System.out.println("\nDigite o tamanho da fatia de tempo:");
                tamanhoFatiaTempoCPU = scan.nextInt();
            }

            switch(escalonadorCPU) {
                case 1:
                    tipoEscalonadorCPU = new EscalonadorFifo();
                    break;
                case 2:
                    tipoEscalonadorCPU = new EscalonadorRoundRobin(tamanhoFatiaTempoCPU);
                    break;
                case 3:
                    tipoEscalonadorCPU = new EscalonadorSRTF();
                    break;
                default:
                    tipoEscalonadorCPU = null;
                    break;
            }
            //fim para saber qual é o tipo de escalonador da CPU


            //começo para saber qual é o tipo de escalonador da ES
            System.out.println("\nQual o tipo do escalonador de E/S?");
            System.out.println("1) First In First Out");
            System.out.println("2) Round Robin");
            System.out.println("3) Shortest Remaining Time First");
            escalonadorES = scan.nextInt();

            if (escalonadorES == 2) {
                System.out.println("\nDigite o tamanho da fatia de tempo:");
                tamanhoFatiaTempoES = scan.nextInt();
            }

            switch(escalonadorES) {
                case 1:
                    tipoEscalonadorES = new EscalonadorFifo();
                    break;
                case 2:
                    tipoEscalonadorES = new EscalonadorRoundRobin(tamanhoFatiaTempoES);
                    break;
                case 3:
                    tipoEscalonadorES = new EscalonadorSRTF();
                    break;
                default:
                    tipoEscalonadorES = null;
                    break;
            }
            //fim para saber qual é o tipo de escalonador ES

            //começo para saber o tipo e tamanho do gerenciador de memoria
            System.out.println("\nQual o tipo de gerenciador de memoria?");
            System.out.println("1) Gerenciador tipo jarra");
            System.out.println("2) Gerenciador com fragmentos");
            tipoGerenciador = scan.nextInt();

            System.out.println("\nDigite a quantidade de memoria:");
            quantidadeMemoria = scan.nextInt();

            if (tipoGerenciador == 1) {
                tipoMemoria = new GerenciadorDeMemoriaJarra(quantidadeMemoria);
            } else {
                tipoMemoria = new GerenciadorDeMemoriaFragmentada(quantidadeMemoria);
            }
            //fim para saber o tipo e tamanho do gerenciador de memoria
            
            if (i == 0) {
                so1 = new SistemaOperacional(tipoMemoria, tipoEscalonadorCPU, tipoEscalonadorES);
                System.out.println("\nPrimeiro sistema operacional criado\n");
            } else {
                so2 = new SistemaOperacional(tipoMemoria, tipoEscalonadorCPU, tipoEscalonadorES);
                System.out.println("\nSegundo sistema operacional criado\n");
            }
        }
        
        String nomeProcesso = null;
        int tempoCPU = 0, tempoES = 0, memoriaNecessaria = 0, momentoInicio = 0;
        boolean primeiroCPU;
        
        ParTempoProcesso processo;
        
        do {
            System.out.println("\nDigite o nome do processo:");
            nomeProcesso = scan.nextLine();
            nomeProcesso = scan.nextLine();
            
            System.out.println("\nDigite o tempo de CPU:");
            tempoCPU = scan.nextInt();
            
            System.out.println("\nDigite o tempo de E/S:");
            tempoES = scan.nextInt();
            
            System.out.println("\nDigite a memoria necessaria:");
            memoriaNecessaria = scan.nextInt();
            
            System.out.println("\nO processo vai primeiro para a CPU? (true ou false)");
            primeiroCPU = scan.nextBoolean();
            
            System.out.println("\nDigite o momento no qual o processo deve iniciar a execucao:");
            momentoInicio = scan.nextInt();
            
            System.out.println("\nAdicionar mais processos?");
            System.out.println("0) Nao");
            System.out.println("1) Sim");
            
            processo = new ParTempoProcesso(momentoInicio, new Processo(nomeProcesso, primeiroCPU, tempoCPU, tempoES, memoriaNecessaria));
            
            System.out.println("nome do processo " + nomeProcesso);
            processosSO1.add(processo);
            processosSO2.add(processo);
            
            continua = scan.nextInt();
        } while(continua == 1);
        
        System.out.println("\n************************************");
        System.out.println("* Executando primeira configuracao *");
        System.out.println("************************************");
        System.out.println(processosSO1.get(1).getProcesso().getNome());
        so1.executar(processosSO1);
        
        System.out.println("\n***********************************");
        System.out.println("* Executando segunda configuracao *");
        System.out.println("***********************************");
        so2.executar(processosSO2);
        
        System.out.println("\n*****************************************");
        System.out.println("* Estatisticas da primeira configuracao *");
        System.out.println("*****************************************");
        
        so1.imprimirEstatisticas();
        
        System.out.println("\n*****************************************");
        System.out.println("* Estatisticas da primeira configuracao *");
        System.out.println("*****************************************");
        
        so2.imprimirEstatisticas();
    }
}
