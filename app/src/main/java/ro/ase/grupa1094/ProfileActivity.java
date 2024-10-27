package ro.ase.grupa1094;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileActivity extends AppCompatActivity {
    Button btnSaveChanges;
    Button btnGoToHomepage;
    EditText etNameProfile;
    EditText etPasswordProfile;


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
        btnGoToHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HomepageActivity.class);
                startActivity(intent);
            }
        });

        btnSaveChanges = findViewById(R.id.btnSaveChanges);
        btnSaveChanges.setOnClickListener(view-> {
            String nume = etNameProfile.getText().toString();
            String parola = etPasswordProfile.getText().toString();

            User user = new User(nume, parola);
            // Toast.makeText(this, food.toString(), Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            intent.putExtra("userForIntent", user); //trb sa implementam in clasa Serializable
            setResult(RESULT_OK, intent);
            finish();
        });

    }

}