package org.springframework.social.formstack.api.impl;

import org.springframework.social.formstack.api.FormOperations;
import org.springframework.social.formstack.api.domain.Form;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pavan
 */
public class FormTemplate extends AbstractTemplate implements FormOperations {

    private final RestTemplate restTemplate;

    public FormTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(isAuthorized);
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Form> getForms() {
        return new ArrayList<Form>();
    }

    @Override
    public Form getForm(String formId) {
        requireAuthorization();
        return restTemplate.getForObject(buildUri("form.json"), Form.class);
    }
}
