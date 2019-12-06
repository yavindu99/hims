package hims.admical.clinic.cl_data_element;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cl_data_element")
public class ClDataElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dataElementId;

    @Column(unique = true,nullable = false)
    private String uid;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToMany
    @JoinTable(name = "cl_default_data_element",
            joinColumns = {@JoinColumn(name = "dataElementId")},
            inverseJoinColumns = {@JoinColumn(name = "defaultDataElementId")})
    @JsonBackReference(value = "defaultElements")
    private List<ClDataElement> clDefaultDataElementList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "cl_child_data_element",
                joinColumns = {@JoinColumn(name = "dataElementId")},
                inverseJoinColumns = {@JoinColumn(name = "childDataElementId")})
    @PrimaryKeyJoinColumn
    private List<ClDataElement> clChildDataElementList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "cl_data_element_category",
            joinColumns = {@JoinColumn(name = "dataElementId")},
            inverseJoinColumns = {@JoinColumn(name = "categoryId")})
    @JsonBackReference(value = "categoryElements")
    private  Set<ClDataElement> clDataElementCategorySet = new HashSet<>();

    public int getDataElementId() {
        return dataElementId;
    }

    public void setDataElementId(int dataElementId) {
        this.dataElementId = dataElementId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ClDataElement> getClDefaultDataElementList() {
        return clDefaultDataElementList;
    }

    public void setClDefaultDataElementList(List<ClDataElement> clDefaultDataElementList) {
        this.clDefaultDataElementList = clDefaultDataElementList;
    }

    public List<ClDataElement> getClChildDataElementList() {
        return clChildDataElementList;
    }

    public void setClChildDataElementList(List<ClDataElement> clChildDataElementList) {
        this.clChildDataElementList = clChildDataElementList;
    }

    public Set<ClDataElement> getClDataElementCategorySet() {
        return clDataElementCategorySet;
    }

    public void setClDataElementCategorySet(Set<ClDataElement> clDataElementCategorySet) {
        this.clDataElementCategorySet = clDataElementCategorySet;
    }

}