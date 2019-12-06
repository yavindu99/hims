package hims.admical.administrative.user;

import hims.admical.administrative.designation.Designation;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(columnDefinition = "CHAR(10)")
    private String username;

    @Column(columnDefinition = "CHAR(15)",nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String nic;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false,unique = true)
    private String employeeRegNo;

    @Column(nullable = false,unique = true)
    private String mohRegNo;

    @ManyToOne
    @JoinColumn(name = "designation",nullable = false)
    private Designation designation;

    @Embedded
    private CommonFields commonFields;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeRegNo() {
        return employeeRegNo;
    }

    public void setEmployeeRegNo(String employeeRegNo) {
        this.employeeRegNo = employeeRegNo;
    }

    public String getMohRegNo() {
        return mohRegNo;
    }

    public void setMohRegNo(String mohRegNo) {
        this.mohRegNo = mohRegNo;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }
}
