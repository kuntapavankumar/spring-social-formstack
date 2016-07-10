package org.springframework.social.formstack.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.formstack.api.Formstack;
import org.springframework.social.formstack.api.domain.FormstackProfile;

/**
 * @author pavan
 */
public class FormstackAdapter implements ApiAdapter<Formstack> {
    @Override
    public boolean test(Formstack formstack) {
        try {
            formstack.formOperations().getForms();
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(Formstack formstack, ConnectionValues connectionValues) {
        FormstackProfile profile = formstack.userOperations().getUserProfile();
        connectionValues.setProviderUserId(profile.getId());
        connectionValues.setDisplayName(profile.getName());
    }

    @Override
    public UserProfile fetchUserProfile(Formstack formstack) {
        FormstackProfile userProfile = formstack.userOperations().getUserProfile();
        return new UserProfileBuilder().setName(userProfile.getName()).build();
    }

    @Override
    public void updateStatus(Formstack formstack, String s) {

    }
}
