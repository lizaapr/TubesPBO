package jp.service;

import jp.entity.Pengunjung;
import java.sql.SQLException;
import java.util.ArrayList;


public interface ServicePengunjung {
    
    public void insertPengunjung(Pengunjung p) throws SQLException;
    public void updatePengunjung(Pengunjung p) throws SQLException;
    public void deletePengunjung(Pengunjung p) throws SQLException;
    public Pengunjung getPengunjungById(String idPengunjung) throws SQLException;
    public ArrayList<Pengunjung> getPengunjung() throws SQLException;
    
}
