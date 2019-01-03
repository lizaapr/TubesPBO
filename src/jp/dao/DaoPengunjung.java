/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.dao;

import com.mysql.jdbc.Connection;
import jp.config.Koneksi;
import jp.entity.Pengunjung;
import jp.service.ServicePengunjung;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fachr DAO = Data Access Object
 */
public class DaoPengunjung implements ServicePengunjung {

    private Connection connection;

    public DaoPengunjung() throws SQLException {
        connection = Koneksi.getConnection();
    }

    @Override
    public void insertPengunjung(Pengunjung p) throws SQLException {
        PreparedStatement st = null;
        String sql = "INSERT INTO pengunjung VALUE(?,?,?)";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, p.getIdPengunjung());
            st.setString(2, p.getNama());
            st.setString(3, p.getStatus());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }

    @Override
    public void updatePengunjung(Pengunjung p) throws SQLException {
        PreparedStatement st = null;
        String sql = "UPDATE pengunjung SET nama=?, status=? WHERE idPengunjung=?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, p.getNama());
            st.setString(2, p.getStatus());
            st.setString(3, p.getIdPengunjung());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }

    @Override
    public void deletePengunjung(Pengunjung p) throws SQLException {
        PreparedStatement st = null;
        String sql = "DELETE FROM pengunjung WHERE idPengunjung=?";

        try {
            st = connection.prepareCall(sql);
            st.setString(1, p.getIdPengunjung());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }

    @Override
    public Pengunjung getPengunjungById(String id) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        Pengunjung p = null;
        String sql = "SELECT * FROM pengunjung WHERE id=?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                p = new Pengunjung();
                p.setIdPengunjung(rs.getString("idPengunjung"));
                p.setNama(rs.getString("nama"));
                p.setStatus(rs.getString("status"));
            }
            return p;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

    @Override
    public ArrayList<Pengunjung> getPengunjung() throws SQLException {
        PreparedStatement st = null;
        ArrayList<Pengunjung> listPengunjung = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM pengunjung";

        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Pengunjung p = new Pengunjung();
                p.setIdPengunjung(rs.getString("idPengunjung"));
                p.setNama(rs.getString("nama"));
                p.setStatus(rs.getString("status"));
                listPengunjung.add(p);
            }
            return listPengunjung;
        } catch (SQLException e) {
            throw e;
        } finally {
            if(st != null){
                st.close();
            }
            if(rs != null){
                rs.close();
            }
        }
    }

}
