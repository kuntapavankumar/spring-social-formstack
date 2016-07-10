package org.springframework.social.formstack.api;

import org.springframework.social.formstack.api.domain.Form;

import java.util.List;

/**
 * @author pavan
 */
public interface FormOperations {
    List<Form> getForms();
    Form getForm(String formId);
}
