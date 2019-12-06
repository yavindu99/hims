package hims.patunscal.clinic;

import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class Level2Element {

    @NotNull(message = "level2_element_key_is_required")
    @NotEmpty(message = "level2_element_key_must_not_be_empty")
    private String key;

    @NotNull(message = "level2_element_value_is_required")
    @NotEmpty(message = "level2_element_value_must_not_be_empty")
    private String value;

    @Valid
    private List<Level3Element> optionList = new ArrayList<>();

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

    public List<Level3Element> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Level3Element> optionList) {
        this.optionList = optionList;
    }
}
