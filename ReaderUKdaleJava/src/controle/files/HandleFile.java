/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Wesllen Sousa
 */
public class HandleFile {

    public static BufferedReader readFile(String diretorio) {
        try {
            File f = new File(diretorio);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
            return buffer;
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public Boolean saveFile(String texto, String diretorio) {
        try (OutputStream output = new FileOutputStream(new File(diretorio));
                OutputStreamWriter osw = new OutputStreamWriter(output);
                BufferedWriter write = new BufferedWriter(osw)) {
            write.write(texto);
            write.close();
            osw.close();
            output.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public static Boolean saveFile(String diretorio, InputStream contents) {
        try {
            InputStreamReader input = new InputStreamReader(contents);
            BufferedReader reader = new BufferedReader(input);
            OutputStream output = new FileOutputStream(new File(diretorio));
            OutputStreamWriter osw = new OutputStreamWriter(output);
            BufferedWriter write = new BufferedWriter(osw);
            String s = reader.readLine();
            while (s != null) {
                write.write(s);
                s = reader.readLine();
            }
            reader.close();
            input.close();
            write.close();
            osw.close();
            output.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public static Boolean saveFileBytes(String texto, File diretorio) {
        byte bytes[] = texto.getBytes();
        try (FileOutputStream local = new FileOutputStream(diretorio)) {
            local.write(bytes);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public void replaceInFile(String source, String fileInput, String fileOutput, String oldString, String newString) {
        try (BufferedReader buffer = readFile(source + fileInput);
                OutputStream output = new FileOutputStream(new File(source + fileOutput));
                OutputStreamWriter osw = new OutputStreamWriter(output);
                BufferedWriter write = new BufferedWriter(osw)) {
            String linha = buffer.readLine();
            while (linha != null) {
                String novaLinha = linha.replace(oldString, newString) + "\n";
                write.write(novaLinha);
                linha = buffer.readLine();
            }
            write.close();
            osw.close();
            output.close();
            buffer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void extractColumn(String separador, String source, String fileInput, String fileOutput, int coluna) {
        try (BufferedReader buffer = readFile(source + fileInput);
                OutputStream output = new FileOutputStream(new File(source + fileOutput));
                OutputStreamWriter osw = new OutputStreamWriter(output);
                BufferedWriter write = new BufferedWriter(osw)) {
            String linha = buffer.readLine();
            String novaLinha = "";
            while (linha != null) {
                String[] colunas = linha.split(separador);
                for (int i = 0; i < colunas.length; i++) {
                    if (i == (coluna - 1)) {
                        continue;
                    }
                    if ((i + 1) == colunas.length) {
                        novaLinha += colunas[i] + "\n";
                    } else if (coluna == colunas.length && (i + 2) == colunas.length) {
                        novaLinha += colunas[i] + "\n";
                    } else {
                        novaLinha += colunas[i] + ",";
                    }
                }
                write.write(novaLinha);
                linha = buffer.readLine();
                novaLinha = "";
            }
            write.close();
            osw.close();
            output.close();
            buffer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
