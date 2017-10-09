
import view.UkDaleForm;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.io.FileNotFoundException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template inthe editor.

 Passos:
 Validar os arquivos yaml no site: http://www.yamllint.com/
 Converter para json: http://yamltojson.com/
 Criar as classes json: http://www.jsonschema2pojo.org/

 */
/**
 *
 * @author Wesllen Sousa
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UkDaleForm form = new UkDaleForm();
                form.setVisible(true);
            }
        });

    }

}
