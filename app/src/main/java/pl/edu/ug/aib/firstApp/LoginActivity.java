package pl.edu.ug.aib.firstApp;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

import pl.edu.ug.aib.firstApp.data.EmailAndPassword;
import pl.edu.ug.aib.firstApp.data.User;

@EActivity(R.layout.activity_login)
public class LoginActivity extends ActionBarActivity {
    @ViewById
    EditText email;
    @ViewById
    EditText password;


    @Bean@NonConfigurationInstance
    RestLoginBackgroundTask restLoginBackgroundTask;


    ProgressDialog ringProgressDialog;

    @AfterViews
    void init() {

        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Loading...");
        ringProgressDialog.setIndeterminate(true);

    }



    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
    public void loginSuccess(User user) {
        ringProgressDialog.dismiss();
        FirstActivity_.intent(this).user(user).start();
    }



    @Click
    void loginClicked()    {
        ringProgressDialog.show();
        EmailAndPassword emailAndPassword = new EmailAndPassword();
        emailAndPassword.email = email.getText().toString();
        emailAndPassword.password = password.getText().toString();
        restLoginBackgroundTask.login(emailAndPassword);
    }



}
