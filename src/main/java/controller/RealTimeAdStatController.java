package controller;

import dao.ADStatRepository;
import dao.BlackListRepository;
import dao.EveryDayTop3Repository;
import dao.PerMinuteADVisitRepository;
import domain.AdVisitTime;
import domain.BlackUserRow;
import domain.PerMinuteAdVisit;
import domain.Top3ofProvinces;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utility.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by sky on 2017/3/18.
 */
@RestController
@RequestMapping(value = "/real-time", produces = "application/json; charset=utf-8")
public class RealTimeAdStatController extends JsonPageController {

    @RequestMapping("/ad-stat/all")
    public String queryAllStat() throws SQLException {
        Connection dbConnection = DBHelper.getDBConnection();
        ADStatRepository repository = new ADStatRepository(dbConnection);
        ArrayList<AdVisitTime> adVisitTimeArrayList = repository.queryAll();
        dbConnection.close();
        return gson.toJson(adVisitTimeArrayList);
    }

    @RequestMapping("/blackList/all")
    public String queryWholeBlackList() throws SQLException {
        Connection dbConnection = DBHelper.getDBConnection();
        BlackListRepository repository = new BlackListRepository(dbConnection);
        ArrayList<BlackUserRow> blackUserRowArrayList = repository.queryAll();
        dbConnection.close();
        return gson.toJson(blackUserRowArrayList);
    }

    @RequestMapping("/top3/all")
    public String queryEveryDayTop3() throws SQLException {
        Connection dbConnection = DBHelper.getDBConnection();
        EveryDayTop3Repository repository = new EveryDayTop3Repository(dbConnection);
        ArrayList<Top3ofProvinces> top3ofProvincesArrayList = repository.queryAll();
        dbConnection.close();
        return gson.toJson(top3ofProvincesArrayList);
    }


    @RequestMapping("/per-minute/all")
    public String queryPerMinuteAdVisitOfRecentHour() throws SQLException {
        Connection dbConnection = DBHelper.getDBConnection();
        PerMinuteADVisitRepository repository = new PerMinuteADVisitRepository(dbConnection);
        ArrayList<PerMinuteAdVisit> rst = repository.query();
        dbConnection.close();
        return gson.toJson(rst);
    }

}
