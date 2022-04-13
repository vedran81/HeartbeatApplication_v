package TelemedVG.HeartbeatApplication.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "health_record")
public class HealthRecord {
    @Id
    @GeneratedValue
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfInput;
    private int systole;
    private int diastole;
    private int heartBeat;
    private String comments;

    @ManyToOne
    @JoinColumn(name = "userId")
    private AppUser appUser;

    public HealthRecord() {
    }

    public HealthRecord(AppUser user) {

        this.dateOfInput = new Date();
        this.appUser = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfInput() {
        return dateOfInput;
    }

    public void setDateOfInput(Date dateOfInput) {
        this.dateOfInput = dateOfInput;
    }

    public void setAutoDateOfInput(Date date) {
        this.dateOfInput = date;
    }

    public int getSystole() {
        return systole;
    }

    public void setSystole(int systole) {
        this.systole = systole;
    }

    public int getDiastole() {
        return diastole;
    }

    public void setDiastole(int diastole) {
        this.diastole = diastole;
    }

    public int getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(int heartBeat) {
        this.heartBeat = heartBeat;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
