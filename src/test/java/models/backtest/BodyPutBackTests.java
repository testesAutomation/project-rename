package models.backtest;

import config.Paraments;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyPutBackTests {
    public String company;
    public String title;
    public String conclusion;

    public BodyPutBackTests(){
        company = Paraments.BACKTESTS_COMPANY.toString();
        title =  Paraments.BACKTESTS_TITLE.toString();
        conclusion = Paraments.BACKTESTS_CONCLUSION.toString();
    }

    public BodyPutBackTests invalidBody(){
        String invalidParam = "";
        String invalidParam2 = "";
        return this;
    }
}
