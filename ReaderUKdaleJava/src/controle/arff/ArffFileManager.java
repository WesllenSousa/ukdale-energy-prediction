package controle.arff;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

/**
 *
 * @author hendr
 */
public class ArffFileManager {

    public static String patternNominalClass(ArrayList<String> list) {
        String pattern = "";
        int size = list.size();
        int i = 0;
        pattern = "{";
        for (String l : list) {
            if (i < size - 1) {
                pattern = pattern + l + ",";
            } else {
                pattern = pattern + l;
            }
            i++;
        }
        pattern = pattern + "}";

        return pattern;
    }

    public static String patternData(ArrayList<String> list) {
        String pattern = "";
        int size = list.size();
        int i = 0;

        for (String l : list) {
            if (i < size - 1) {
                pattern = pattern + l + ",";
            } else {
                pattern = pattern + l;
            }
            i++;
        }

        return pattern;
    }

}
