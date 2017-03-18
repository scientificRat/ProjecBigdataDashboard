package dao;

import domain.PerMinuteAdVisit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by sky on 2017/3/18.
 */
public class PerMinuteADVisitRepository extends Repository {

    public PerMinuteADVisitRepository(Connection dbConnection) {
        super(dbConnection);
    }

    public ArrayList<PerMinuteAdVisit> query() throws SQLException {
        String sql = "SELECT * FROM stupidrat.per_minute_ad_visit WHERE date_sub(current_timestamp,INTERVAL 1 HOUR)<=date_of_minute ";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<PerMinuteAdVisit> perMinuteAdVisits = new ArrayList<>();
        while (resultSet.next()) {
            PerMinuteAdVisit perMinuteAdVisit = new PerMinuteAdVisit();
            perMinuteAdVisit.setTime(resultSet.getString("date_of_minute"));
            perMinuteAdVisit.setAdvertisementID(resultSet.getString("ad_id"));
            perMinuteAdVisit.setVisitTime(resultSet.getLong("visit_time"));
            perMinuteAdVisits.add(perMinuteAdVisit);
        }
        preparedStatement.close();
        return perMinuteAdVisits;
    }
}
