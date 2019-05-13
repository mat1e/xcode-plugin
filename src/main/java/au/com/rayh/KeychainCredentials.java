package au.com.rayh;

import java.io.IOException;

import javax.annotation.CheckForNull;

import org.kohsuke.stapler.DataBoundConstructor;

import com.cloudbees.plugins.credentials.CredentialsScope;
import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials;

import hudson.Extension;
import hudson.util.Secret;

/**
 * Apple developer profile, which consists of any number of PKCS12 of the private key
 * and the certificate for code signing, and mobile provisioning profiles.
 *
 * @author Kohsuke Kawaguchi
 */
public class KeychainCredentials extends BaseStandardCredentials {
    /**
     * Password of the Keychain.
     */
    private Secret password;
    private String keychainPath;
    private boolean inSearchPath = false;

    @DataBoundConstructor
    public KeychainCredentials(@CheckForNull CredentialsScope scope, @CheckForNull String id, @CheckForNull String description,
    		@CheckForNull String keychainPath, @CheckForNull boolean inSearchPath, @CheckForNull Secret password) throws IOException {
        super(scope, id, description);
        this.password= password;
        this.keychainPath = keychainPath;
        this.inSearchPath = inSearchPath;
    }

    public Secret getPassword() {
        return password;
    }

    public String getKeychainPath() {
        return keychainPath;
    }

    public boolean isInSearchPath() {
        return inSearchPath;
    }

    @Extension
    public static class DescriptorImpl extends BaseStandardCredentialsDescriptor {
        @Override
        public String getDisplayName() {
            return "Apple Keychain";
        }
    }
}
