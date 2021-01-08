package cosmos.mariadb;

import cosmos.Run;
import org.mariadb.jdbc.internal.util.constant.Version;

import java.sql.*;
import java.util.ArrayList;

public class ConnectDB {
    Connection conn = null;
    Statement stmt = null;
    String DBAddress = Run.loadConfig.getDBAddress();

    //SQL接続用情報
    String SQL_driver = "org.mariadb.jdbc.Driver";
    String SQL_url = "jdbc:mariadb://" + DBAddress + "/room_management";
    String SQL_user = "COSMOS";
    String SQL_password = "PASSWORD";

    private int data = 0;
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> user = new ArrayList<>();
    private ArrayList<String> zaishitu = new ArrayList<>();

    public ConnectDB() {
        //JDBCドライバ
        try {
            Class.forName(SQL_driver);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Connector/J " + Version.version + "\n");

        //接続
        try {
            //接続
            System.out.print("Connecting to DB...");
            conn = DriverManager.getConnection(SQL_url, SQL_user, SQL_password);
            System.out.println(" done.");
        }catch (SQLException e) {
            e.printStackTrace();
        }

        //テーブルデータ取得
        try {
            String sql = "select * from html_output";

            stmt = conn.prepareStatement(sql);
            ResultSet hrs = stmt.executeQuery(sql);

            while (hrs.next()) {
                date.add(hrs.getString(1));
                user.add(hrs.getString(2));
                zaishitu.add(hrs.getString(3));
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
            } catch (SQLException se) {
                se.printStackTrace();
            } // do nothing
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
    public void setData(int i) {
        this.data = i;
    }
    // getter: データ数
    public int getData(){
        return this.data;
    }
    // getter: フィールドデータ
    public String getDate(int i) {
        return date.get(i);
    }
    public String getUser(int i) {
        return user.get(i);
    }
    public String getZaishitu(int i) {
        return zaishitu.get(i);
    }
}
