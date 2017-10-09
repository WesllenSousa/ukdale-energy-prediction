package view;

import entidades.Building;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import util.DateUtil;

/**
 *
 * @author Wesllen Sousa Lima,Hendrio Luis
 */
public class BuildingDataTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Date/Time", "Power"};

    public BuildingDataTableModel(ArrayList<Building> dados) {
        setLinhas(dados);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<Building> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<Building> list) {
        linhas = list;
    }

    public void adicionarLinha(Building pessoa) {
        linhas.add(pessoa);
    }

    public void removeLinha(Building pessoa) {
        linhas.remove(pessoa);
    }

    public void removeTudo() {
        linhas.clear();
    }

    //Retorna o numero de colunas no modelo
    //@see javax.swing.table.TableModel#getColumnCount()
    @Override
    public int getColumnCount() {
        return getColunas().length;
    }

    //Retorna o numero de linhas existentes no modelo
    //@see javax.swing.table.TableModel#getRowCount()
    @Override
    public int getRowCount() {
        return getLinhas().size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Building bean = (Building) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return DateUtil.formataDataYyyyMMddHHmmSS(bean.getDateTime());
                case 1:
                    return bean.getPower();
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }

}
