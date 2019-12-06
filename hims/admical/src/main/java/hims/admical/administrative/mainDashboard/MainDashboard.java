package hims.admical.administrative.mainDashboard;

import hims.admical.administrative.user.CommonFields;

import javax.persistence.*;

@Entity
@Table(name = "main_dashboard")
public class MainDashboard {

    @Id
    private String mainDashboardId;

    @Column(nullable = false,unique = true)
    private String mainDashboardName;

    @Embedded
    private CommonFields commonFields;

    public String getMainDashboardId() {
        return mainDashboardId;
    }

    public void setMainDashboardId(String mainDashboardId) {
        this.mainDashboardId = mainDashboardId;
    }

    public String getMainDashboardName() {
        return mainDashboardName;
    }

    public void setMainDashboardName(String mainDashboardName) {
        this.mainDashboardName = mainDashboardName;
    }
}
