/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {

    Connection conn = null;
    String url = "jdbc:derby:CardJitsu;create=true"; //url of the DB host
    String dbusername = "pdc";  //your DB username
    String dbpassword = "pdc";  //your DB password

    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";
            // System.out.println(statement.executeUpdate("DROP TABLE UserInfo"));

            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (username VARCHAR(12), password VARCHAR(12), wins INT, losses INT)");
            }
            statement.close();
        } catch (Throwable e) {
            System.out.println(e);
        }
    }

    public Data checkName(String username, String password) {
        Data data = new Data(); // Initialize an instance of Data.
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT username, password, wins, losses FROM UserInfo WHERE username = '" + username + "'");
            if (rs.next()) {
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");
                /**
                 * If the username exists in the USERINFO table, and the
                 * password is correct, change the value of relating attributes
                 * of data. Otherwise, keep loginFlag as false.
                 */
                if (password.compareTo(pass) == 0) {
                    data.loginFlag = true;
                    
                    data.wins = rs.getInt("wins");
                    data.losses = rs.getInt("losses");
                    data.username = rs.getString("username");
                    data.player = new Player(username);
                } else {
                    data.loginFlag = false;
                }
            } else {
                /**
                 * If the username does not exist in the USERINFO table, then
                 * create a new account by using the inputted username and
                 * password.
                 */
                System.out.println("no such user, creating new user");
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES('" + username + "', '" + password + "', 0, 0)");
                data.loginFlag = true;
                
                data.wins = 0;
                data.losses = 0;
                data.username = username;
                data.player = new Player(username);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data; //Back to checkName() of Model.java.
    }

    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {

            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
        }
        return flag;
    }

    public void saveStats(int wins, int losses, String username) {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET wins=" + wins + " WHERE username='" + username + "'");
            statement.executeUpdate("UPDATE UserInfo SET losses=" + losses + " WHERE username='" + username + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
