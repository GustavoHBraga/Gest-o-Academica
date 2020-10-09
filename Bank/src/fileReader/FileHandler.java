/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author phfar
 */
public class FileHandler {

    public static String reader(String path) throws IOException {
        String content = "";
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            try {
                line = bufferedReader.readLine();
                while (line != null) {
                    content += line + "\n";
                    line = bufferedReader.readLine();
                }
                fileReader.close();
                return content;
            } catch (IOException e) {
                System.out.println("Erro: Não foi possível ler o arquivo");
                return "";
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

    public static boolean writer(String path, String text) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(path);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(text);
            printWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
