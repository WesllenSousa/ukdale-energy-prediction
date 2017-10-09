
package util;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Messages {

    public void bug(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Error", JOptionPane.ERROR_MESSAGE, 
                new ImageIcon(getClass().getResource("/resources/images/bug_64x64.png")));   
    }
    
    public void sucesso(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Success", JOptionPane.INFORMATION_MESSAGE, 
                new ImageIcon(getClass().getResource("/resources/images/sucesso_64x64.png")));
    }
    
    public void aviso(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Warming", JOptionPane.WARNING_MESSAGE, 
                new ImageIcon(getClass().getResource("/resources/images/aviso_64x64.png")));
    }

    public boolean confirmacao(String mensagem){
        int conf = JOptionPane.showConfirmDialog(null, mensagem, "Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                new ImageIcon(getClass().getResource("/resources/images/confirmacao_64x64.png")));
        if(conf == JOptionPane.YES_OPTION){
            return true;
        }else{
            return false;
        }
    }
    
    public String inserirDados(String mensagem){
        return (String) JOptionPane.showInputDialog(null, mensagem, "Choose", 
                JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/resources/images/inserirDados_64x64.png")), 
                null, null);
    }
    
    public String inserirDadosComValorInicial(String mensagem, String valorInicial){
        return (String) JOptionPane.showInputDialog(null, mensagem, "Choose", 
                JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/resources/images/inserirDados_64x64.png")), 
                null, valorInicial);
    }

}
