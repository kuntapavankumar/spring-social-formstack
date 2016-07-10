package org.springframework.social.formstack.api.impl;

import org.springframework.social.formstack.api.UserOperations;
import org.springframework.social.formstack.api.domain.FormstackProfile;
import org.springframework.web.client.RestTemplate;

/**
 * @author pavan
 */
public class UserTemplate extends AbstractTemplate implements UserOperations {

    private final RestTemplate restTemplate;

    public UserTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(isAuthorized);
        this.restTemplate = restTemplate;
    }

    @Override
    public FormstackProfile getUserProfile() {
        requireAuthorization();
        return restTemplate.getForObject(buildUri("user.json"), FormstackProfile.class);
    }
}
