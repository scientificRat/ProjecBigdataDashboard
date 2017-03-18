package dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by sky on 2017/3/14.
 */
public class UserTaskRepository extends Repository {
    public UserTaskRepository(Connection dbConnection) {
        super(dbConnection);
    }

    public void add() throws SQLException{
        String sql = "";

    }

}
