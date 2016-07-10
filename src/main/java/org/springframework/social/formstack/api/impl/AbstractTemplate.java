package org.springframework.social.formstack.api.impl;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.formstack.api.Formstack;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;

/**
 * @author pavan
 */
public abstract class AbstractTemplate {


    private static final String API_URL_BASE = "https://www.formstack.com/api/v2/";
    private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();

    private final boolean isAuthorized;

    public AbstractTemplate(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public void requireAuthorization() {
        if (!isAuthorized) {
            throw new MissingAuthorizationException(Formstack.FORMSTACK_PROVIDER_NAME);
        }
    }

    protected URI buildUri(String path) {
        return buildUri(path, EMPTY_PARAMETERS);
    }

    protected URI buildUri(String path, String parameterName, String parameterValue) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set(parameterName, parameterValue);
        return buildUri(path, parameters);
    }

    protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
        return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters).build();
    }
}
