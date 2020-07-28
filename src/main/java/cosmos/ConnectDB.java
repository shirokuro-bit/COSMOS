package cosmos;

import org.mariadb.jdbc.internal.util.constant.Version;

import java.sql.*;
import java.util.ArrayList;

public class ConnectDB extends Thread{
    Connection conn = null;
    Statement stmt = null;
    //SQL接続用情報
    String driver = "org.mariadb.jdbc.Driver";
    String url = "jdbc:mariadb://192.168.2.104/mysql";
    String usern = "root";
    String password = "password";

    private int data = 0;//
    private ArrayList<String> test = new ArrayList<>();

    public ConnectDB() {
        //JDBCドライバ
        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Connector/J " + Version.version + "\n");

        //接続
        try {
            //接続
            System.out.print("Connecting to DB...");
            conn = DriverManager.getConnection(url, usern, password);
            System.out.println(" done.");
        }catch (SQLException e) {
            e.printStackTrace();
        }

        //テーブルデータ取得
        try {
            String sql = "SELECT * FROM ○○○○";//○○○○はテーブル名
            //stmt = conn.createStatement();
            stmt = conn.prepareStatement(sql);
            ResultSet hrs = stmt.executeQuery(sql);

            while (hrs.next()) {
                test.add(hrs.getString(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        //切断
        finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {} // do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try

        System.out.println("\nGoodbye!");
    }

    // setter: データ数
    public void setData(int i) {this.data = i;}
    // getter: データ数
    public int getData(){return this.data;}
    // getter: フィールドデータ
    public String getTest(int i){return this.test.get(i);}
}
