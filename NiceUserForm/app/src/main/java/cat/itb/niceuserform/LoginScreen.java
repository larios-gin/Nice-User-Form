package cat.itb.niceuserform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginScreen extends AppCompatActivity {

    EditText username, password;
    TextInputLayout textFieldPassword, textFieldUsername;
    Button buttonLogin, buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        textFieldUsername = findViewById(R.id.textFieldUsername);
        textFieldPassword = findViewById(R.id.textFieldPassword);

        buttonLogin = findViewById(R.id.loginButton);
        buttonRegister = findViewById(R.id.registerButton);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString().length() < 8) {
                    textFieldPassword.setError("Password must have at least 8 characters");
                }
                if (username.getText().toString().isEmpty()){
                    textFieldUsername.setError("Required field");
                } else {
                    Intent LoginIntent = new Intent(LoginScreen.this, WelcomeScreen.class);
                    LoginIntent.putExtra("username", username.getText().toString());
                    startActivity(LoginIntent);
                }
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterIntent = new Intent(LoginScreen.this, RegisterScreen.class);
                startActivity(RegisterIntent);
            }
        });
    }
}
