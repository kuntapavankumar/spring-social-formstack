package org.springframework.social.formstack.connect;

import org.springframework.social.formstack.api.Formstack;
import org.springframework.social.formstack.api.impl.FormstackTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @author pavan
 */
public class FormstackServiceProvider extends AbstractOAuth2ServiceProvider<Formstack> {

    public FormstackServiceProvider(String clientId, String clientSecret) {
        super(new OAuth2Template(clientId, clientSecret, "https://www.formstack.com/api/v2/oauth2/authorize", "https://www.formstack.com/api/v2/oauth2/token"));
        ((OAuth2Template) getOAuthOperations()).setUseParametersForClientAuthentication(true);
    }

    @Override
    public Formstack getApi(String accessToken) {
        return new FormstackTemplate(accessToken);
    }
}
