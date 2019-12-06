package hims.admical.administrative.designation;

import hims.admical.administrative.user.CommonFields;
import hims.admical.administrative.user.User;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="designation")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int designationId;

    @Column(nullable = false,unique = true)
    private String designation;

    @Column(nullable = false,unique = true)
    private String designationShortTitle;

    @OneToMany(targetEntity = User.class,mappedBy = "designation",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Collection<User> userList;

    @Embedded
    private CommonFields commonFields;

    public int getDesignationId() {
        return designationId;
    }

    public void setDesignationId(int designationId) {
        this.designationId = designationId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignationShortTitle() {
        return designationShortTitle;
    }

    public void setDesignationShortTitle(String designationShortTitle) {
        this.designationShortTitle = designationShortTitle;
    }

    public Collection<User> getUserList() {
        return userList;
    }

    public void setUserList(Collection<User> userList) {
        this.userList = userList;
    }
}
