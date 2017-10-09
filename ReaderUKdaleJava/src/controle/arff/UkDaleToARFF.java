package controle.arff;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entidades.Building;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import util.DateUtil;

/**
 *
 * @author Hendrio
 */
public class UkDaleToARFF {

    public final String ARFF = ".arff";
    private final String SYMBOL = "@";
    private final String RELATION = "RELATION";
    private final String ATTRIBUTE = "ATTRIBUTE";
    private final String DATA = "DATA";
    private final String DATE = "DATE";
    private final String NUMERIC = "NUMERIC";
    private final String NOMINAL = "NOMINAL";
    private final String SPACE = " ";

    private File createFile(String name) {
        File f = new File(name);
        try {
            f.createNewFile();
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }

    public void listUkDaleToARFF(String dir, String relationName, ArrayList<String> listAttribute, ArrayList<Building> listData) throws IOException {
        //ExampleManager manager = new ExampleManager();
        File f = createFile(dir + File.separator + relationName + ARFF);
        
        System.out.println(f.getAbsolutePath());

        FileWriter fileWriter = new FileWriter(f.getAbsolutePath());
        System.out.println("Writting... Relation");
        try (BufferedWriter buffer = new BufferedWriter(fileWriter)) {
            /*
             *RELATION NAME
             */
            buffer.write(SYMBOL + RELATION + SPACE + relationName + "\n\n");
            /////////////////////////////////////////////////////////////////////
            /*
             *ATTRIBUTE LIST WITH NAME AND TYPES
             */
            System.out.println("Writting... Attributes");
            for (String attribute : listAttribute) {
                switch (attribute) {
                    case "timestamp":
                        buffer.write(SYMBOL + ATTRIBUTE + SPACE + attribute + SPACE); //year
                        buffer.write(DATE);
                        buffer.write(" \"yyyy-MM-dd HH:mm:ss\"");
                        break;
                    case "power":
                        buffer.write(SYMBOL + ATTRIBUTE + SPACE + attribute + SPACE); //year
                        buffer.write(NUMERIC);
                        break;
                }
                buffer.write("\n");
            }
            buffer.write("\n\n");
            /////////////////////////////////////////////////////////////////////
                /*
             *DATA LIST
             */
            System.out.println("Writting... Data");
            ArrayList<String> instance;
            buffer.write(SYMBOL + DATA + "\n");
            for (Building example : listData) {
                instance = new ArrayList<>();
                instance.add("\"" + DateUtil.formataDataYyyyMMddHHmmSS(example.getDateTime()) + "\"");
                instance.add(example.getPower().toString());
                buffer.write(ArffFileManager.patternData(instance));
                buffer.write("\n");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("End of writting...");
    }
    
    
    
}
