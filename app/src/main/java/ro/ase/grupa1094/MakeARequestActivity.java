package ro.ase.grupa1094;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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

        btnSendRequest.setOnClickListener(view->{
            String nume = etReguestName.getText().toString();
            int numar = Integer.parseInt(etReguestPhoneNumber.getText().toString());
            String email = etRequestEmail.getText().toString();
            Animal animal = Animal.valueOf(spnAnimal.getSelectedItem().toString());
            AdoptionRequest adoptionRequest = new AdoptionRequest(nume, numar, email, animal);
            Intent intent = getIntent();
            intent.putExtra("adoptionRequestForIntent", adoptionRequest);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}