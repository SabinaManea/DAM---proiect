package ro.ase.grupa1094;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {

    EditText etUsername2;
    EditText etEmail;
    EditText etPhoneNumber;
    EditText etPassword2;
    Button btnSignUp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etUsername2 = findViewById(R.id.etUsername2);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etPassword2 = findViewById(R.id.etPassword2);
        btnSignUp2 = findViewById(R.id.btnSignUp2);

        btnSignUp2.setOnClickListener(v -> {
            String username = etUsername2.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhoneNumber.getText().toString().trim();
            String password = etPassword2.getText().toString().trim();

            if (validateInputs(username, email, phone, password)) {
                Toast.makeText(SignUpActivity.this, "Te-ai înregistrat cu succes!", Toast.LENGTH_SHORT).show();

                // Redirecționează utilizatorul către MainActivity
                Intent intent = new Intent(SignUpActivity.this, HomepageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean validateInputs(String username, String email, String phone, String password) {
        if (TextUtils.isEmpty(username)) {
            etUsername2.setError("Introduceți un nume de utilizator!");
            etUsername2.requestFocus();
            return false;
        } else if (username.length() < 3) {
            etUsername2.setError("Numele trebuie să aibă cel puțin 3 caractere!");
            etUsername2.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Introduceți o adresă de email!");
            etEmail.requestFocus();
            return false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Introduceți o adresă de email validă!");
            etEmail.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(phone)) {
            etPhoneNumber.setError("Introduceți un număr de telefon!");
            etPhoneNumber.requestFocus();
            return false;
        } else if (!phone.matches("^[0-9]{10}$")) {
            etPhoneNumber.setError("Numărul de telefon trebuie să conțină 10 cifre!");
            etPhoneNumber.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword2.setError("Introduceți o parolă!");
            etPassword2.requestFocus();
            return false;
        } else if (password.length() < 6) {
            etPassword2.setError("Parola trebuie să aibă cel puțin 6 caractere!");
            etPassword2.requestFocus();
            return false;
        }

        return true;
    }
}
