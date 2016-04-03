/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class Dao {

    public boolean addVictories(String player) {
        Connection connection=null;
        int ok=0, victories=0;
        DBConnector con = new DBConnector();
        try {
            connection = con.getConnection();
            String sql = "SELECT victories FROM PLAYERS";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                victories = rs.getInt("victories");
            }
            sql = "UPDATE PLAYERS set victories=? where name=?";
            victories++;
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, victories);
            pstmt.setString(2, player);
            ok=pstmt.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            con.cerrarConexion(connection);
        }
        return ok!=0;
    }
    
}
