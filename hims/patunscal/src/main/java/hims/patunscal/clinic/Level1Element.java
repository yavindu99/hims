package hims.patunscal.clinic;

import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class Level1Element {

    @NotNull(message = "level1_element_key_is_required")
    @NotEmpty(message = "level1_element_key_must_not_be_empty")
    private String key;

    @NotNull(message = "level1_element_value_is_required")
    @NotEmpty(message = "level1_element_value_must_not_be_empty")
    private String value;

    @Valid
    private List<Level2Element> optionList = new ArrayList<>();

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

    public List<Level2Element> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Level2Element> optionList) {
        this.optionList = optionList;
    }
}
