package org.springframework.social.formstack.api.impl;

import org.springframework.social.formstack.api.FormOperations;
import org.springframework.social.formstack.api.Formstack;
import org.springframework.social.formstack.api.UserOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;

/**
 * @author pavan
 */
public class FormstackTemplate extends AbstractOAuth2ApiBinding implements Formstack {

    private FormOperations formOperations;
    private UserOperations userOperations;

    public FormstackTemplate(String accessToken) {
        super(accessToken);
        this.formOperations = new FormTemplate(getRestTemplate(), isAuthorized());
        this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
    }

    @Override
    public FormOperations formOperations() {
        return formOperations;
    }

    @Override
    public UserOperations userOperations() {
        return userOperations;
    }
}
