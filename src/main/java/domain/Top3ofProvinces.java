package domain;

import java.io.Serializable;

/**
 * Created by sky on 2017/3/18.
 */
public class Top3ofProvinces implements Serializable {

    private String dateOfDay;
    private String province;
    private String top3;

    public String getTop3() {
        return top3;
    }

    public void setTop3(String top3) {
        this.top3 = top3;
    }

    public String getDateOfDay() {
        return dateOfDay;
    }

    public void setDateOfDay(String dateOfDay) {
        this.dateOfDay = dateOfDay;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }



}
