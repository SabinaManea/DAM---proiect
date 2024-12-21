package ro.ase.grupa1094;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MakeARequestActivity extends AppCompatActivity {

    Button btnSendRequest;
    EditText etReguestName;
    EditText etReguestPhoneNumber;
    EditText etRequestEmail;
    Spinner spnAnimal;
    private boolean isEditing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_make_arequest);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etReguestName = findViewById(R.id.etReguestName);
        etReguestPhoneNumber = findViewById(R.id.etReguestPhoneNumber);
        etRequestEmail = findViewById(R.id.etRequestEmail);
        btnSendRequest = findViewById(R.id.btnSendRequest);
        spnAnimal = findViewById(R.id.spnAnimal);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.tipAnimal, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spnAnimal.setAdapter(adapter);
        Intent editIntent = getIntent();
        if (editIntent.hasExtra("edit")) {
            isEditing = true;
            Animal editAnimal = (Animal) editIntent.getSerializableExtra("edit");

            etReguestName.setText(editAnimal.getName());
            etReguestPhoneNumber.setText(editAnimal.getPhoneNumber());
            etRequestEmail.setText(String.valueOf(editAnimal.getEmail()));

            ArrayAdapter<String> editedAdapter = (ArrayAdapter<String>) spnAnimal.getAdapter();
            for (int i = 0; i < editedAdapter.getCount(); i++) {
                if (editAnimal.getTipAnimal().toString().equals(editedAdapter.getItem(i))) {
                    spnAnimal.setSelection(i);
                }
            }
        }

        SharedPreferences sharedPreferences = getSharedPreferences("local", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", "Make a request!");
        editor.apply();
        String token = sharedPreferences.getString("token", "Default");
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();

        btnSendRequest.setOnClickListener(view -> {
            String nume = etReguestName.getText().toString().trim();
            String numar = etReguestPhoneNumber.getText().toString().trim();
            String email = etRequestEmail.getText().toString().trim();

            if (nume.isEmpty()) {
                etReguestName.setError("Introduceți un nume!");
                etReguestName.requestFocus();
                return;
            }

            if (numar.isEmpty() || !numar.matches("\\d{10}")) {
                etReguestPhoneNumber.setError("Introduceți un număr de telefon valid!");
                etReguestPhoneNumber.requestFocus();
                return;
            }

            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etRequestEmail.setError("Introduceți o adresă de email validă!");
                etRequestEmail.requestFocus();
                return;
            }

            TipAnimal tipAnimal = TipAnimal.valueOf(spnAnimal.getSelectedItem().toString());
            Animal animal = new Animal(nume, numar, email, tipAnimal);

            Intent intent = new Intent();
            if (isEditing) {
                intent.putExtra("edit", animal);
                isEditing = false;
            } else {
                intent.putExtra("animalForIntent", animal);
            }

            setResult(RESULT_OK, intent);
            finish();
        });

    }
}