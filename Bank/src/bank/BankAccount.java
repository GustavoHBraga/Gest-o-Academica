/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author phfar
 */
public class BankAccount {

    private static int lastAccountNumber = 1000;
    private String owner;
    private int accountNumber;
    private double balance;
    private String password;

    //Criar uma bancária com saldo = 0
    public BankAccount(String owner) {
        this(owner, 0);
    }

    //Criar uma conta bancária com dado número e um dado saldo saldo
    public BankAccount(String owner, double balance) {
        lastAccountNumber++;
        this.accountNumber = lastAccountNumber;
        this.balance = balance;
        this.owner = checkName(owner);
        this.password = makePassword();
    }

    //Método que realiza um depósito, de uma determinada quantia, em uma conta bancária
    public void deposit(double amount) {
        double newBalance = balance + amount;
        balance = newBalance;
    }

    //Método que realiza um saque, de uma determinada quantia, em uma conta bancária
    public void withdraw(double amount) {
        double newBalance = balance - amount;
        balance = newBalance;
    }

    public void transfer(double ammount, BankAccount target) {
        this.withdraw(ammount);
        target.deposit(ammount);
    }

    public static String checkName(String owner) {
        if (owner.matches("[a-zA-Z]+")) {
            return owner;
        } else {
            throw new Error("Nome inválido, deve conter somente caracteres");
        }

    }

    public static String makePassword() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            str.append(randomLetter());
        }
        for (int i = 0; i < 4; i++) {
            str.append(randomDigit());
        }
        return str.toString();
    }

    public static String randomLetter() {
        String alphabet = "abcdefghijklmnopqrstuvxwyz";
        int num = (int) (Math.random() * alphabet.length());
        char c = alphabet.charAt(num);
        return String.valueOf(c);

    }

    public static String randomDigit() {
        int num = (int) (Math.random() * 10);
        return String.valueOf(num);
    }

    //Obtem o saldo da conta bancária
    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public static int getLastAccountNumber() {
        return lastAccountNumber;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return " ===================== "
                + "\nConta de: " + owner
                + "\nNúmero da conta: " + accountNumber
                + "\nSaldo: R$" + balance
                + "\nSenha: " + password
                + "\n ===================== ";
    }

}
