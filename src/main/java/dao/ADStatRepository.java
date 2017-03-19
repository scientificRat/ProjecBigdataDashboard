package dao;

import dao.Repository;
import domain.AdVisitTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by sky on 2017/3/17.
 */
public class ADStatRepository extends Repository {

    public ADStatRepository(Connection dbConnection) {
        super(dbConnection);
    }


    public ArrayList<AdVisitTime> queryAll() throws SQLException {
        ArrayList<AdVisitTime> adVisitTimeArrayList = new ArrayList<>();
        String sql = "SELECT * FROM stupidrat.ad_statistic_data,stupidrat.black_list ORDER BY date_of_day DESC ,province DESC ,city DESC ,ad_id DESC ";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
        ResultSet resultSet  =preparedStatement.executeQuery();
        while (resultSet.next()){
            AdVisitTime adVisitTime = new AdVisitTime();
            adVisitTime.setDateOfDay(resultSet.getString("date_of_day"));
            adVisitTime.setProvince(resultSet.getString("province"));
            adVisitTime.setCity(resultSet.getString("city"));
            adVisitTime.setAdvertisementID(resultSet.getString("ad_id"));
            adVisitTime.setVisitTime(resultSet.getLong("visit_time"));
            adVisitTimeArrayList.add(adVisitTime);
        }
        preparedStatement.close();
        return adVisitTimeArrayList;
    }

    public ArrayList<AdVisitTime> querySome(int offset, int size) throws SQLException {
        ArrayList<AdVisitTime> adVisitTimeArrayList = new ArrayList<>();
        String sql = "SELECT * FROM stupidrat.ad_statistic_data ORDER BY date_of_day DESC LIMIT ?,?";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
        preparedStatement.setInt(1, offset);
        preparedStatement.setInt(2, size);
        preparedStatement.close();
        return adVisitTimeArrayList;
    }
}
