package org.springframework.social.formstack.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author pavan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormstackProfile {
    String id;
    String name;

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
