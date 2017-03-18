package domain;

import java.io.Serializable;

/**
 * Created by sky on 2017/3/18.
 */
public class BlackUserRow implements Serializable{
    private String dateOfDay;
    private String userID;

    public String getDateOfDay() {
        return dateOfDay;
    }

    public void setDateOfDay(String dateOfDay) {
        this.dateOfDay = dateOfDay;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
