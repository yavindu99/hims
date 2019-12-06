package hims.admical.administrative.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import hims.common.RecordStatus;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Embeddable
public class CommonFields {

    @Column(columnDefinition = "CHAR(10)",nullable = false,updatable = false)
    private String createdBy;

    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date createdOn = new Date();

    @Column(columnDefinition = "CHAR(10)",nullable = false)
    private String lastUpdatedBy;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date lastUpdatedOn = new Date();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecordStatus recordStatus = RecordStatus.ACTIVE;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Date lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public RecordStatus getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

//    @Embeddable
//    private static class Fk{
//
//        @ManyToOne
//        @JoinColumn(name="createdBy",insertable = false,updatable = false)
//        private User createdUser;
//
//        @ManyToOne
//        @JoinColumn(name="lastUpdatedBy",insertable = false,updatable = false)
//        private User lastUpdatedUser;
//
//
//    }
//
//    @Embedded
//    private Fk fk;


}
