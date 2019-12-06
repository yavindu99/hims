package hims.patunscal.clinic;


import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class Level3Element {

    @NotNull(message = "level3_element_key_is_required")
    @NotEmpty(message = "level3_element_key_must_not_be_empty")
    private String key;

    @NotNull(message = "level3_element_value_is_required")
    @NotEmpty(message = "level3_element_value_must_not_be_empty")
    private String value;

    @Valid
    private List<Level4Element> optionList = new ArrayList<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Level4Element> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Level4Element> optionList) {
        this.optionList = optionList;
    }
}
