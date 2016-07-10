package org.springframework.social.formstack.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.formstack.api.Formstack;

/**
 * @author pavan
 */
public class FormstackConnectionFactory extends OAuth2ConnectionFactory<Formstack> {

    public FormstackConnectionFactory(String clientId, String clientSecret) {
        super(Formstack.FORMSTACK_PROVIDER_NAME, new FormstackServiceProvider(clientId, clientSecret), new FormstackAdapter());
    }
}
