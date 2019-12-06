package hims.admical.administrative.institute;

import hims.common.Confirmation;
import hims.admical.administrative.user.CommonFields;

import javax.persistence.*;

@Entity
@Table(name = "institute")
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instituteId;

    @Column(nullable = false,unique = true)
    private String instituteName;

    private String instituteShortCode;

    private Confirmation isInstituteMine = Confirmation.NO;

    @ManyToOne
    @JoinColumn(name = "instituteType",nullable = false)
    private InstituteType instituteType;

    @ManyToOne
    @JoinColumn(name = "instituteMOHId",nullable = false)
    private InstituteMOHId instituteMOHId;

    @Embedded
    private CommonFields commonFields;

    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
        this.instituteId = instituteId;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getInstituteShortCode() {
        return instituteShortCode;
    }

    public void setInstituteShortCode(String instituteShortCode) {
        this.instituteShortCode = instituteShortCode;
    }

    public Confirmation getIsInstituteMine() {
        return isInstituteMine;
    }

    public void setIsInstituteMine(Confirmation isInstituteMine) {
        this.isInstituteMine = isInstituteMine;
    }

    public InstituteType getInstituteType() {
        return instituteType;
    }

    public void setInstituteType(InstituteType instituteType) {
        this.instituteType = instituteType;
    }

    public InstituteMOHId getInstituteMOHId() {
        return instituteMOHId;
    }

    public void setInstituteMOHId(InstituteMOHId instituteMOHId) {
        this.instituteMOHId = instituteMOHId;
    }
}
