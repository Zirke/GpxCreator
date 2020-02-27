import java.sql.ResultSet;
import java.sql.SQLException;

public class GpxCreator {

    DatabaseConnector dbconn;

    public void createGPXFromDB() throws SQLException {

        StringBuilder gpxOutput = new StringBuilder();

        /*gpxOutput.append("<gpx><trk><trkseg>)");

        *//*for(var14 = createGPXList(instructions).iterator(); var14.hasNext(); gpxOutput.append("</trkpt>")) {
            GPXEntry entry = (GPXEntry)var14.next();*//*
        gpxOutput.append("\n<trkpt lat=\"").append(*//*query for lat*//*);
        gpxOutput.append("\" lon=\"").append(*//*query for lon*//*).append("\">");

        gpxOutput.append("\n</trkseg></trk></gpx>");*/

        //return gpxOutput.toString();
    }

    public static void main(String[] args) throws SQLException {
        DatabaseConnector dbconn = new DatabaseConnector();
        ResultSet result = dbconn.yoloConnect();
        while(result.next()){
            System.out.println(result.getDouble("lat")+", "+result.getDouble("lon"));;
        }
    }
}
