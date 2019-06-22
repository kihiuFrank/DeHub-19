package www.shopeasy.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by Kihiu.
 */

public class MainActivity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^" +
            "(?=.*[0-9])" + //at least one digit
            "(?=.*[a-z])" + //at least one lower case letter
            "(?=.*[A-Z])" + //at least one upper case letter
            "(?=.*[a-zA-Z])" + //any letter
            //"(?=.*[@#$%^&+=])" +  //at least one special character
            "(?=\\S+$)" +  //no white spaces
            ".{8,}" + // at least 8 characters
            "$");

    private static Pattern EMAIL = Pattern.compile(
            "[a-zA-Z0-9._-]" +
                    "+@[a-z]+\\.+[a-z]+");


    EditText loginInputEmail, loginInputPassword;
    Button btnlogin;
    TextView linkSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //To avoid auto popping of the keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        loginInputEmail = findViewById(R.id.login_input_email);
        loginInputPassword = findViewById(R.id.login_input_password);
        btnlogin = findViewById(R.id.btn_login);
        linkSignup = findViewById(R.id.registration_link);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = loginInputEmail.getText().toString();
                final String pass = loginInputPassword.getText().toString();

                //Validation of Inputs
                //Email Validation
                if (email.isEmpty()){
                    loginInputEmail.setError("Field can't be empty!");
                }else if (!EMAIL.matcher(email).matches()){
                    loginInputEmail.setError("Invalid Email!");
                    //Password Validation
                }else if (pass.isEmpty()){
                    loginInputPassword.setError("Field can't be empty!");
                }else if (!PASSWORD_PATTERN.matcher(pass).matches()){
                    loginInputPassword.setError("Password too weak!");
                } else {
                    Toast.makeText(getApplicationContext(), "Logging you in...", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(i);
                }
            }
        });

        linkSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
