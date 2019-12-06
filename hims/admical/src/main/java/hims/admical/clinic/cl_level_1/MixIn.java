package hims.admical.clinic.cl_level_1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hims.admical.clinic.cl_level_2.ClLevel2;

import java.util.List;

abstract class MixIn {

    @JsonIgnore  private List<ClLevel2> clLevel2List;

    public List<ClLevel2> getClLevel2List() {
        return clLevel2List;
    }

    public void setClLevel2List(List<ClLevel2> clLevel2List) {
        this.clLevel2List = clLevel2List;
    }
}
