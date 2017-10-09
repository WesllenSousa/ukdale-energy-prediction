/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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
import java.nio.channels.FileChannel;
import java.util.HashSet;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Wesllen Sousa
 */
public class FileUtil {

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

    public static void criarDiretorioComArquivo(File arquivo) {
        if (arquivo.exists()) {
            System.out.println("File already exists");
        } else {
            arquivo.mkdirs();
        }
    }

    public static void criarDiretorioComArquivoSemPerguntar(File arquivo) {
        if (arquivo.exists()) {
            deletarDiretorio(arquivo);
        }
        arquivo.mkdirs();
    }

    public static Boolean deletarDiretorioArquivo(File dirArq) {
        if (dirArq.isFile()) {
            return deletarArquivo(dirArq);
        } else if (dirArq.isDirectory()) {
            return deletarDiretorio(dirArq);
        }
        return false;
    }

    public static Boolean deletarDiretorio(File diretorio) {
        boolean result = true;
        if (diretorio.exists() && diretorio.isDirectory()) {
            File[] files = diretorio.listFiles();
            File file;
            for (int i = 0; i < files.length; i++) {
                file = files[i];
                if (file.isFile()) {
                    result = file.delete() && result;
                } else if (file.isDirectory()) {
                    result = deletarDiretorio(file) && result;
                }
            }
            result = diretorio.delete() && result;
        } else {
            result = false;
        }
        return result;
    }

    public static Boolean deletarArquivo(File file) {
        if (file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static Boolean deletarArquivosDiretorio(File diretorio) {
        boolean result = true;
        if (diretorio.exists() && diretorio.isDirectory()) {
            File[] files = diretorio.listFiles();
            File file;
            for (int i = 0; i < files.length; i++) {
                file = files[i];
                if (file.isFile()) {
                    result = file.delete() && result;
                } else if (file.isDirectory()) {
                    result = deletarDiretorio(file) && result;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    public static String extrairNomeArquivoDiretorio(String path) {
        String ArqDir = "";
        for (int i = (path.length() - 1); i >= 0; i--) {
            char caracter = path.charAt(i);
            if (caracter == '/' || caracter == '\\') {
                break;
            }
            ArqDir += caracter;
        }
        String r = "";
        for (int i = (ArqDir.length() - 1); i >= 0; i--) {
            char caracter = ArqDir.charAt(i);
            r += caracter;
        }
        return r;
    }

    public static HashSet<String> listarArquivosEDiretorio(File diretorio) {
        HashSet<String> hashSet = new HashSet<>();
        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            int length = arquivos.length;
            for (int i = 0; i < length; ++i) {
                File f = arquivos[i];
                if (f.isFile()) {
                    hashSet.add(f.getName());
                } else if (f.isDirectory()) {
                    hashSet.add(f.getName());
                }
            }
        }
        return hashSet;
    }

    public static HashSet<String> listarDiretorios(File diretorio) {
        HashSet<String> hashSet = new HashSet<>();
        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            int length = arquivos.length;
            for (int i = 0; i < length; ++i) {
                File f = arquivos[i];
                if (f.isDirectory()) {
                    hashSet.add(f.getName());
                }
            }
        }
        return hashSet;
    }

    public static HashSet<String> listarArquivos(File diretorio) {
        HashSet<String> hashSet = new HashSet<>();
        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            int length = arquivos.length;
            for (int i = 0; i < length; ++i) {
                File f = arquivos[i];
                if (f.isFile()) {
                    hashSet.add(f.getName());
                }
            }
        }
        return hashSet;
    }

    public static Boolean verificarDiretorioExiste(File file) {
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean verificarSeArquivoDiretorioExiste(File file) {
        if (file.exists()) {
            return true;
        } else {
            return true;
        }
    }

    public static TreeNode listarArquivosEDiretorioJTree(DefaultMutableTreeNode raiz, File diretorio) {
        File[] files = diretorio.listFiles();
        File file;
        for (int i = 0; i < files.length; i++) {
            file = files[i];
            if (file.isFile()) {
                DefaultMutableTreeNode filho = new DefaultMutableTreeNode(file.getName());
                filho.setAllowsChildren(false);
                raiz.add(filho);
            } else if (file.isDirectory()) {
                DefaultMutableTreeNode filho = new DefaultMutableTreeNode(file.getName());
                raiz.add(filho);
                listarArquivosEDiretorioJTree(filho, file);
            }
        }
        return raiz;
    }

    public static String extensaoArquivo(String arquivo) {
        return arquivo.substring(arquivo.lastIndexOf('.') + 1);
    }

    public static void copiarArquivo(String origem, String destino) {
        try {
            FileChannel o = new FileInputStream(new File(origem)).getChannel();
            FileChannel d = new FileOutputStream(new File(destino)).getChannel();
            d.transferFrom(o, 0, o.size());
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static Integer contarArquivos(File diretorio) {
        Integer cont = 0;
        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            int length = arquivos.length;
            for (int i = 0; i < length; ++i) {
                File f = arquivos[i];
                if (f.isFile()) {
                    cont++;
                }
            }
        }
        return cont;
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

    public Boolean gravarArquivo(String texto, String diretorio) {
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

    public static Boolean gravarArquivoBytes(String texto, File diretorio) {
        byte bytes[] = texto.getBytes();
        try (FileOutputStream local = new FileOutputStream(diretorio)) {
            local.write(bytes);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public String extrairColuna(String separador, String diretorio, int coluna) {
        String colunaExtraida = "";
        try (BufferedReader buffer = readFile(diretorio)) {
            String linha;
            int cont = 0;
            while ((linha = buffer.readLine()) != null) {
                String[] colunas = linha.split(separador);
                Integer valor = Math.round(Float.parseFloat(colunas[coluna - 1]));
                colunaExtraida += valor + ",";
                cont++;
                if (cont == 100) {
                    colunaExtraida += "\n";
                    cont = 0;
                }
            }
            buffer.close();
            return colunaExtraida;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public void excluirColuna(String separador, String source, String fileInput, String fileOutput, int coluna) {
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
