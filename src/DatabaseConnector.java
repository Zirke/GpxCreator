import javax.management.Query;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;



public class DatabaseConnector {

    private Statement stmt = null;
    private Connection conn = null;
    private String host = "db2-astep.cs.aau.dk";
    private int port = 5432;
    private String db = "driver_identification_db";
    private String user = "abi";
    private String password = "blackpower";

    /**
     * Method for Connecting to the database
     *
     * @return Boolean describing if the connection was successful
     */
    private boolean connectToDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager
                    .getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db + "",
                            user, password);
            if (!conn.isClosed()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Connection to the database failed" + host + port + db + user + password + conn + "--" + e.getLocalizedMessage());
        }
        return false;
    }

    /**
     * Method for closing connection to the database
     *
     * @return Boolean describing if closing the connection was successful
     */
    private boolean closeConnection() {
        try {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Cannot close a database connection while not connected" + host + port + db + user + password + conn + "--" + e.getSQLState());
        }
        return false;
    }

    public ResultSet getSpecificTrajectory(int trajectory) throws SQLException {
        ResultSet results = null;
        if(connectToDatabase()){
            String query = "select lat,lon from trajectorypoint where trajectory = "+trajectory;
            stmt = conn.createStatement();
            results = stmt.executeQuery(query);
        }

        return results;
    }
}