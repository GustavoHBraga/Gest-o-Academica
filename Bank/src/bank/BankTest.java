/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.Scanner;

/**
 *
 * @author phfar
 */
public class BankTest {

    public static Scanner entrada;

    public static void mostrarInfo(BankAccount[] contas) {
        System.out.println("\nContas de todos os clientes:");
        for (int i = 0; i < contas.length; i++) {
            System.out.println("[" + i + "]" + contas[i]);
        }
    }

    public static void interacaoSacar(BankAccount[] contas) {
        boolean clienteValido = false;
        int indiceConta = -1;
        while (!clienteValido) {
            mostrarInfo(contas);
            System.out.print("O	saque será efetuado na conta de	qual cliente? (0 a "
                    + (contas.length - 1) + "):	");
            indiceConta = entrada.nextInt();
            if (indiceConta >= 0 && indiceConta < contas.length) {
                clienteValido = true;
            } else {
                System.out.println("Índice de cliente	inválido!");
            }
        }
        System.out.print("Qual o valor do saque?");
        double saque = entrada.nextDouble();
        contas[indiceConta].withdraw(saque);
    }

    public static void interacaoDepositar(BankAccount[] contas) {
        boolean clienteValido = false;
        int indiceConta = -1;
        while (!clienteValido) {
            mostrarInfo(contas);
            System.out.println("O saque será depósito na conta de qual cliente? (0 a "
                    + (contas.length - 1) + "): ");

            indiceConta = entrada.nextInt();
            if (indiceConta >= 0 && indiceConta < contas.length) {
                clienteValido = true;
            } else {
                System.out.println("Índice de cliente inválido!");
            }
        }
        System.out.println("Qual o valor do depósito? ");
        double deposito = entrada.nextDouble();
        contas[indiceConta].deposit(deposito);
        System.out.println("Depósito finalizado.\n");
    }

    public static void interacaoTransferir(BankAccount[] contas) {
        boolean clienteValido1 = false;
        boolean clienteValido2 = false;
        int indiceConta1 = -1;
        int indiceConta2 = -1;
        while (!clienteValido1 && !clienteValido2) {
            mostrarInfo(contas);
            System.out.println("A transferencia será realizada da conta de qual cliente? (0 a "
                    + (contas.length - 1) + "): ");
            indiceConta1 = entrada.nextInt();
            System.out.println("A transferencia será realizada para conta de qual cliente? (0 a "
                    + (contas.length - 1) + "): ");
            indiceConta2 = entrada.nextInt();

            if ((indiceConta1 >= 0 && indiceConta1 < contas.length) && ((indiceConta2 >= 0 && indiceConta2 < contas.length))) {
                clienteValido1 = true;
                clienteValido2 = true;
            } else {
                System.out.println("Índice de cliente inválido!");
            }

        }
        System.out.println("Qual o valor de transferencia? ");
        double transferencia = entrada.nextDouble();
        contas[indiceConta1].transfer(transferencia, contas[indiceConta2]);
        System.out.println("Depósito finalizado.\n");

    }

    public static void main(String[] args) {
        BankAccount[] contas = new BankAccount[5];
        contas[0] = new BankAccount("Marcos", 1000.00);
        contas[1] = new BankAccount("Julia", 250.00);
        contas[2] = new BankAccount("Joao", 2500.00);
        contas[3] = new BankAccount("Roberto", 3000.00);
        contas[4] = new BankAccount("Janana", 4500.00);

        entrada = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("Escolha	uma operação: ");
            System.out.println("(1) mostrar informações	de todas as contas ");
            System.out.println("(2) sacar ");
            System.out.println("(3) depositar ");
            System.out.println("(4) transferir ");
            System.out.println("(5) sair ");
            System.out.print("Opção escolhida: ");
            int escolha = entrada.nextInt();
            System.out.println();
            switch (escolha) {
                case 1:
                    mostrarInfo(contas);
                    break;
                case 2:
                    interacaoSacar(contas);
                    break;
                case 3:
                    interacaoDepositar(contas);
                    break;
                case 4:
                    interacaoTransferir(contas);
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida ");
            }
            System.out.println();
        }
        System.out.println("Fim do programa ");
    }
}
