package dao;

import domain.Top3ofProvinces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by sky on 2017/3/18.
 */
public class EveryDayTop3Repository extends Repository {

    public EveryDayTop3Repository(Connection dbConnection) {
        super(dbConnection);
    }

    public ArrayList<Top3ofProvinces> queryAll() throws SQLException {
        ArrayList<Top3ofProvinces> top3ofProvincesArrayList = new ArrayList<>();
        String sql = "SELECT * FROM stupidrat.everyday_top3_ad_of_province ORDER BY date_of_day DESC,province ASC ";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Top3ofProvinces top3ofProvinces = new Top3ofProvinces();
            top3ofProvinces.setDateOfDay(resultSet.getString("date_of_day"));
            top3ofProvinces.setProvince(resultSet.getString("province"));
            top3ofProvinces.setTop3(resultSet.getString("top3_ad"));
            top3ofProvincesArrayList.add(top3ofProvinces);
        }
        return top3ofProvincesArrayList;
    }


}
