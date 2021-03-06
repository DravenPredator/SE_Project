import java.sql.*;

/**
 * Created by Draven on 12/11/2015.
 */
public class RaceDAO {

    private int id;
    private final String DB_URL = "jdbc:sqlserver://localhost:50396;" + "databaseName=DUNGEON_AND_DRAGONS;";
    private final String USER = "sa";
    private final String PASSWORD = "Yhlnjlk1";

    private Connection conn = null;
    private Statement stmt = null;
    private String sql = null;
    private ResultSet rs;

    public RaceDAO() {
    }

    public void setID(String raceName)
    {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            stmt = conn.createStatement();
            sql = "SELECT ID FROM RACE WHERE NAME = '" + raceName.toUpperCase() + "'";

            rs = stmt.executeQuery(sql);


            while (rs.next()) {
                id = rs.getInt("ID");
            }


            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String getFeats(int id)
    {
        String feats = "";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            stmt = conn.createStatement();
            sql = "SELECT FEATS FROM RACE WHERE ID = " + id;
            rs = stmt.executeQuery(sql);


            while (rs.next()) {
                feats += rs.getString("FEATS");
            }


            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return feats;
    }

    public int getID()
    {
        return id;
    }
}
