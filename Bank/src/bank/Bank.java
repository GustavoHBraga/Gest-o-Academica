/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author phfar
 */
public class Bank {

    private BankAccount accounts[];  //contas bancárias
    private int last;                //Último índice da conta inserida

    public Bank(String fileName) throws FileNotFoundException, IOException {

        File arquivoLeitura = new File(fileName);
        FileReader fileReader = new FileReader(arquivoLeitura);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String firstLineContent = null;
        if ((line = bufferedReader.readLine()) != null) {
            firstLineContent = line;
        }
        int arrayLength = Integer.parseInt(firstLineContent);
        accounts = new BankAccount[arrayLength];
    }

    public Bank() {
        accounts = new BankAccount[100]; //Banco no , no máximo, 100 contas
        last = 0;
    }

    public BankAccount[] getAccounts() {
        return this.accounts;
    }

    public int getLast() {
        return this.last;
    }

    //Inseri uma conta no banco
    public void addAccount(BankAccount c) {
        if (this.last < 99) {
            accounts[last] = c;
            last++;
        }
    }

    //Calcula o saldo total de todas as contas inseridas no banco
    public double getTotalBalance() {
        double soma = 0.0;
        for (int i = 0; i < last; i++) {
            soma = soma + accounts[i].getBalance();
        }
        return soma;
    }

}
