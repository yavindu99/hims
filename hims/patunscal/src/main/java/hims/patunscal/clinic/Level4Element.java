package hims.patunscal.clinic;


import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Component
public class Level4Element {

    @NotNull(message = "level4_element_key_is_required")
    @NotEmpty(message = "level4_element_key_must_not_be_empty")
    private String key;

    @NotNull(message = "level4_element_value_is_required")
    @NotEmpty(message = "level4_element_value_must_not_be_empty")
    private String value;

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
}
