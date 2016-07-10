package org.springframework.social.formstack.api;

import org.springframework.social.ApiBinding;

/**
 * @author pavan
 */
public interface Formstack extends ApiBinding {

    public static final String FORMSTACK_PROVIDER_NAME = "formstack";

    FormOperations formOperations();

    UserOperations userOperations();

}
