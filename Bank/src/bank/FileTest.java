/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import fileReader.FileHandler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author phfar
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        //String file = "teste.txt";
        /*String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n"
                + "Phasellus nibh neque, placerat non augue eu, condimentum dictum\r\n"
                + "diam. Suspendisse id bibendum augue. Aenean lobortis velit sapien,\r\n"
                + "at varius dolor gravida a. Mauris a nisi ipsum. Donec eleifend est\r\n"
                + "ac varius ultricies. Fusce vel dictum mi. Mauris eu eleifend elit.\r\n"
                + "Aliquam feugiat, leo id scelerisque tempor, ante est vulputate nunc,\r\n"
                + "non aliquam sem arcu vel lectus. Maecenas varius eu massa in suscipit.\r\n"
                + "Duis vitae arcu a sem cursus tincidunt a non sapien. Donec auctor\r\n"
                + "elit arcu, id malesuada diam egestas id. Sed efficitur nunc nec metus\r\n"
                + "molestie pretium. Maecenas at eros auctor, consectetur sem a, imperdiet\r\n"
                + "lacus. Proin ac elit ut massa hendrerit cursus sit amet sed nunc.\r\n"
                + "Duis eu urna ipsum.\r\n"
                + "Vestibulum risus elit, tincidunt et nulla at, congue tincidunt diam.\r\n"
                + "Curabitur posuere vel magna et posuere. Curabitur at magna commodo,\r\n"
                + "rutrum nisl at, hendrerit justo. Nunc quis pellentesque urna. Praesent\r\n"
                + "sodales magna ut pellentesque luctus. Lorem ipsum dolor sit amet, consectetur\r\n"
                + "adipiscing elit. Duis ac rutrum leo. Donec gravida ligula placerat mauris\r\n"
                + "elementum, et ultricies nulla volutpat. Nullam risus libero, tempus viverra\r\n"
                + "auctor vel, rhoncus in ante. Ut ultrices commodo gravida. Etiam tempor metus\r\n"
                + "nec orci varius volutpat. Proin nisi tortor, mollis nec nunc quis, ornare consectetur\r\n"
                + "ante. Morbi ultricies urna id massa sodales facilisis quis at arcu. Nam mollis\r\n"
                + "dignissim nisi, a commodo metus dictum vitae. Vivamus sit amet lacinia purus.\r\n";

        if (FileHandler.writer(file, text)) {
            System.out.println("Arquivo salvo com sucesso!");
        }else{
            System.out.println("Erro ao salvar o arquivo!");
        }*/
        String file = "entrada.txt";
        String text = FileHandler.reader(file);
        if (text.isEmpty()) {
            System.out.println("Erro ao ler o arquivo");
        } else {
            System.out.println(text);
        }

        


        /*String text = FileHandler.reader(file);
        if (text.isEmpty()) {
            System.out.println("Erro ao ler o arquivo");
        }else{
            System.out.println(text);
        }*/
        //String fileConfig = "conf.con";
        /*String name = "Pedro";
        String login = "admin";
        String version = "1.0.5";
        
        String print = name+";"+login+";"+version;
        FileHandler.writer(fileConfig, print);*/

 /*String content = FileHandler.reader(fileConfig);
        String content1 = content.split(";")[0];
        String content2 = content.split(";")[1];
        String content3 = content.split(";")[2];
        
        System.out.println("Nome: " + content1);
        System.out.println("Login: " + content2);
        System.out.println("Versão: " + content3);*/
    }

}
