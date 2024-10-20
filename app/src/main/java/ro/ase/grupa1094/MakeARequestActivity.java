package ro.ase.grupa1094;

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
    enum Animal {
        CAT, DOG, BIRD
    }
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

        String[] valoriAnimal = new String[Animal.values().length];
        int nrValori = 0;
        for (Animal animal : Animal.values()) {
            valoriAnimal[nrValori++] = animal.toString();
        }
        ArrayAdapter<String> genAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, valoriAnimal);
        spnAnimal.setAdapter(genAdapter);
    }
}