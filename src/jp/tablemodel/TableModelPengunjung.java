/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.tablemodel;

import java.util.ArrayList;
import jp.entity.Pengunjung;
import javax.swing.table.AbstractTableModel;


public class TableModelPengunjung extends AbstractTableModel{
    
    private ArrayList<Pengunjung> listPengunjung = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listPengunjung.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return listPengunjung.get(rowIndex).getIdPengunjung();
            case 1: return listPengunjung.get(rowIndex).getNama();
            case 2: return listPengunjung.get(rowIndex).getStatus();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id Pengunjung";
            case 1: return "Nama";
            case 2: return "Status";
            default: return null;
        }
    }
    
    public void insertPengunjung(Pengunjung p){
        listPengunjung.add(p);
        fireTableDataChanged();
    }
    
    public void updatePengunjung(int index, Pengunjung p){
        listPengunjung.set(index, p);
        fireTableDataChanged();
    }
    
    public void deletePengunjung(int index){
        listPengunjung.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(ArrayList<Pengunjung> listPengunjung){
        this.listPengunjung = listPengunjung;
        fireTableDataChanged();
    }
    
    public Pengunjung getPengunjung(int index){
        return listPengunjung.get(index);
    }
    
    public void clear(){
        listPengunjung.clear();
    }    
}

