import java.sql.ResultSet;
import java.sql.SQLException;

public class GpxCreator {

    //DatabaseConnector dbconn;

    public static StringBuilder createGPXFromDB() throws SQLException {
        DatabaseConnector dbconn = new DatabaseConnector();
        ResultSet results = dbconn.getSpecificTrajectory(1284);
        StringBuilder gpxOutput = new StringBuilder();

        gpxOutput.append("<gpx><trk><trkseg>");

        while (results.next()) {
            gpxOutput.append("\n<trkpt lat=\"").append(results.getDouble("lat"));
            gpxOutput.append("\" lon=\"").append(results.getDouble("lon")).append("\">");
            gpxOutput.append("</trkpt>");

        }
        gpxOutput.append("\n</trkseg></trk></gpx>");
        return gpxOutput;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(createGPXFromDB().toString());
    }
}
