package dao;

import domain.BlackUserRow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by sky on 2017/3/18.
 */
public class BlackListRepository extends Repository {
    public BlackListRepository(Connection dbConnection) {
        super(dbConnection);
    }

    public ArrayList<BlackUserRow> queryAll() throws SQLException {
        String sql = "SELECT * FROM stupidrat.black_list";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<BlackUserRow> blackUserRowArrayList = new ArrayList<>();
        while (resultSet.next()) {
            BlackUserRow blackUserRow = new BlackUserRow();
            blackUserRow.setDateOfDay(resultSet.getString("dateOfDay"));
            blackUserRow.setUserID(resultSet.getString("user_id"));
            blackUserRowArrayList.add(blackUserRow);
        }
        return blackUserRowArrayList;
    }
}
