package www.shopeasy.com;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by Kihiu.
 */

public class RegisterActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^" +
            "(?=.*[0-9])" + //at least one digit
            "(?=.*[a-z])" + //at least one lower case letter
            "(?=.*[A-Z])" + //at least one upper case letter
            "(?=.*[a-zA-Z])" + //any letter
            //"(?=.*[@#$%^&+=])" +  //at least one special character
            "(?=\\S+$)" +  //no white spaces
            ".{8,}" + // at least 8 characters
            "$");
    private static final Pattern REG_NO = Pattern.compile("^" +
            "(?=.*[0-9])" + //at least one digit
            //"(?=.*[a-z])" + //at least one lower case letter
            //"(?=.*[A-Z])" + //at least one upper case letter
            "(?=.*[a-zA-Z])" + //any letter
            "(?=.*[/])" +  //at least one special character
            "(?=\\S+$)" +  //no white spaces
            ".{8,}" + // at least 8 characters
            "$");

    private static Pattern EMAIL = Pattern.compile(
            "[a-zA-Z0-9._-]" +
                    "+@[a-z]+\\.+[a-z]+");

    private EditText signupInputFirstName,signupInputLastName, signupInputEmail,
            signupInputPassword, passConfirmation;
    private Button btnSignup;
    private TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //To avoid auto popping of the keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        signupInputFirstName =  findViewById(R.id.signup_input_FirstName);
        signupInputLastName =  findViewById(R.id.signup_input_LastName);
        signupInputEmail =  findViewById(R.id.signup_input_email);
        signupInputPassword =  findViewById(R.id.signup_input_password);
        passConfirmation = findViewById(R.id.signup_input_confirmation);

        loginLink =  findViewById(R.id.login_link);
        btnSignup =  findViewById(R.id.btn_signup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String first_name = signupInputFirstName.getText().toString();
                final String last_name = signupInputLastName.getText().toString();
                final String email = signupInputEmail.getText().toString();
                final String pass = signupInputPassword.getText().toString();
                final String passConfirm = passConfirmation.getText().toString();

                //First Name Validation
                if (first_name.isEmpty()){
                    signupInputFirstName.setError("Field can't be empty!");
                }

                //Last Name Validation
                if (last_name.isEmpty()){
                    signupInputLastName.setError("Field can't be empty!");
                }
                //Validation of Inputs
                //Email Validation
                if (email.isEmpty()){
                    signupInputEmail.setError("Field can't be empty!");
                }else if (!EMAIL.matcher(email).matches()){
                    signupInputEmail.setError("Invalid Email!");
                    //Password Validation
                }else if (pass.isEmpty()){
                    signupInputPassword.setError("Field can't be empty!");
                }else if (!PASSWORD_PATTERN.matcher(pass).matches()){
                    signupInputPassword.setError("Password too weak!");
                } else if (!passConfirm.equals (pass)) {
                    passConfirmation.setError("Passwords must be similar!");
                } else {
                    Toast.makeText(getApplicationContext(),"Getting you registered", Toast.LENGTH_LONG).show();
                }

            }
        });
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginLink.setLinkTextColor(Color.RED);
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
