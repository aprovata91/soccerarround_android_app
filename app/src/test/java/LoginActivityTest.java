import android.content.Intent;
import android.os.Build;
import android.widget.Button;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import com.app.alex.footballbalancer.BuildConfig;
import com.app.alex.footballbalancer.LoginActivity;
import com.app.alex.footballbalancer.MainActivity;
import com.app.alex.footballbalancer.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by alex on 9/29/15.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk =18, manifest = "src/main/AndroidManifest.xml")
public class LoginActivityTest {

    private Button pressLoginButton;
    private LoginActivity loginActivity;

    @Before
    public void setUp() throws Exception{
        loginActivity = Robolectric.setupActivity(LoginActivity.class);
        pressLoginButton = (Button) loginActivity.findViewById(R.id.sign_in_button);
    }

    @Test
    public void shouldCheckIfActivityEqualsNull(){
        assertNotNull(loginActivity);
    }

    @Test
    public void clickingLogin_shouldStartMainActivity(){
        loginActivity.findViewById(R.id.sign_in_button).performClick();
        Intent expectedIntent = new Intent(loginActivity, MainActivity.class);
    }

}

