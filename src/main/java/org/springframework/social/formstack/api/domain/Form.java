package org.springframework.social.formstack.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author pavan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Form {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
