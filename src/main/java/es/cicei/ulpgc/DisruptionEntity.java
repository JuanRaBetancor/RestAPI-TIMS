package es.cicei.ulpgc;

import javax.persistence.*;

@Entity
@Table(name = "disruptions")
public class DisruptionEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column(length = 20048)
    private String location;
    @Column(length = 20048)
    private String status;
    @Column(length = 20048)
    private String severity;
    @Column(length = 20048)
    private String category;
    @Column(length = 20048)
    private String startingtime;
    @Column(length = 20048)
    private String endtime;
    @Column(length = 20048)
    private String comments;
    @Column(length = 20048)
    private String currentupdate;
    @Column(length = 20048)
    private String lat;
    @Column(length = 20048)
    private String lon;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStartingtime() {
        return startingtime;
    }

    public void setStartingtime(String startingtime) {
        this.startingtime = startingtime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCurrentupdate() {
        return currentupdate;
    }

    public void setCurrentupdate(String currentupdate) {
        this.currentupdate = currentupdate;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
