package TelemedVG.HeartbeatApplication.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class HealthRecord {
    private int id;
    private Date dateOfInput;
    private int systole;
    private int diastole;
    private int heartBeat;
    private String comments;


    public HealthRecord() {
    }

}
