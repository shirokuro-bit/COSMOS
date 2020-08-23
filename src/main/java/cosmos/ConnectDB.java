package cosmos;

import org.mariadb.jdbc.internal.util.constant.Version;

import java.sql.*;
import java.util.ArrayList;

public class ConnectDB extends Thread{
    Connection conn = null;
    Statement stmt = null;
    //SQL接続用情報
    String driver = "org.mariadb.jdbc.Driver";
    String url = "jdbc:mariadb://192.168.11.7/room_management";
    String usern = "COSMOS";
    String password = "PASSWORD";

    private int data = 0;//
    private ArrayList<String> test = new ArrayList<>();
    String[][] Data = new String[3][3];

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
            String sql = "SELECT time, name, zaishitu FROM zaishitu,username WHERE zaishitu.rfid_id=username.rfid_id";
            //stmt = conn.createStatement();
            stmt = conn.prepareStatement(sql);
            ResultSet hrs = stmt.executeQuery(sql);

            while (hrs.next()) {
                test.add(hrs.getString(1));
                test.add(hrs.getString(2));
                test.add(hrs.getString(3));
            }
            System.out.print(test.get(0));
            System.out.print(test.get(1));
            System.out.println(test.get(2));
            System.out.print(test.get(3));
            System.out.print(test.get(4));
            System.out.println(test.get(5));
            System.out.print(test.get(6));
            System.out.print(test.get(7));
            System.out.println(test.get(8));
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
