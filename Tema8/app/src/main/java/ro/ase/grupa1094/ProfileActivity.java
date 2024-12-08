package ro.ase.grupa1094;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {
    Button btnSaveChanges;
    Button btnGoToHomepage;
    EditText etNameProfile;
    EditText etPasswordProfile;
    private boolean isEditing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNameProfile = findViewById(R.id.etNameProfile);
        etPasswordProfile = findViewById(R.id.etPasswordProfile);
        btnGoToHomepage = findViewById(R.id.btnGoToHomepage);
        btnGoToHomepage.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, HomepageActivity.class);
            startActivity(intent);
        });

        Intent editIntent = getIntent();
        if (editIntent.hasExtra("edit")) {
            isEditing = true;
            User editUser = (User) editIntent.getSerializableExtra("edit");

            etNameProfile.setText(editUser.getName());
            etPasswordProfile.setText(editUser.getPassword());
        }

        SharedPreferences sharedPreferences = getSharedPreferences("local", MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "Default");
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();

        btnSaveChanges = findViewById(R.id.btnSaveChanges);
        btnSaveChanges.setOnClickListener(view -> {
            String nume = etNameProfile.getText().toString();
            String parola = etPasswordProfile.getText().toString();

            User user = new User(nume, parola);
            Intent intent = new Intent();
            if (isEditing) {
                intent.putExtra("edit", user);
                isEditing = false;
            } else {
                intent.putExtra("userForIntent", user);
            }
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
