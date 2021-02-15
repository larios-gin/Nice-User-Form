package cat.itb.niceuserform;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterScreen extends AppCompatActivity {

    EditText username, password, repeat_password, email, name, surnames, birth_date;
    TextInputLayout tetxFieldUsername, textFieldPassword, tetxFieldRepeatPassword, tetxFieldEmail, tetxFieldName, tetxFieldSurnames, tetxFieldBirthDate;
    Spinner genderSpinner;
    CheckBox termsAndConditions;
    Button buttonLogin, buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repeat_password = findViewById(R.id.repeat_password);
        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        surnames = findViewById(R.id.surnames);
        birth_date = findViewById(R.id.birth_date);

        tetxFieldUsername = findViewById(R.id.TextFieldUsername);
        textFieldPassword = findViewById(R.id.TextFieldPassword);
        tetxFieldRepeatPassword = findViewById(R.id.TextFieldRepeat_password);
        tetxFieldEmail = findViewById(R.id.TextFieldEmail);
        tetxFieldName = findViewById(R.id.TextFieldName);
        tetxFieldSurnames = findViewById(R.id.TextFieldSurnames);
        tetxFieldBirthDate = findViewById(R.id.TextFieldBirth_date);

        birth_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        genderSpinner = findViewById(R.id.gender_spinner);

        termsAndConditions = findViewById(R.id.terms_and_conditions);

        buttonLogin = findViewById(R.id.loginButton);
        buttonRegister = findViewById(R.id.registerButton);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().isEmpty()){
                    tetxFieldUsername.setError("Required field");
                }
                else if (password.getText().toString().length() < 8) {
                    textFieldPassword.setError("Password must have at least 8 characters");
                }
                else if (!repeat_password.getText().toString().equals(password.getText().toString())){
                    tetxFieldRepeatPassword.setError("Passwords must be equals");
                }
                else if (email.getText().toString().isEmpty()){
                    tetxFieldEmail.setError("Required field");
                }
                else if (name.getText().toString().isEmpty()){
                    tetxFieldName.setError("Required field");
                }
                else if (surnames.getText().toString().isEmpty()){
                    tetxFieldSurnames.setError("Required field");
                }
                else if (birth_date.getText().toString().isEmpty()){
                    tetxFieldBirthDate.setError("Required field");
                }
                else if (!termsAndConditions.isChecked()){
                    Toast.makeText(RegisterScreen.this, "You need to accept the \"terms & conditions\" to continue", Toast.LENGTH_SHORT).show();
                }else {
                    Intent RegisterIntent = new Intent(RegisterScreen.this, WelcomeScreen.class);
                    RegisterIntent.putExtra("username", username.getText().toString());
                    startActivity(RegisterIntent);
                }
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegisterScreen.this, LoginScreen.class);
                startActivity(LoginIntent);
            }
        });
    }

    private void showDatePickerDialog(){
        DataPicker newFragment = DataPicker.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                birth_date.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");

    }
}
