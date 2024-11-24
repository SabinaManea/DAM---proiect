package ro.ase.grupa1094;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RequestsListActivity extends AppCompatActivity {
    private FloatingActionButton fabOpen;
    ListView lvRequests;
    List<Animal> animalList = new ArrayList<>();
    ActivityResultLauncher<Intent> launcher;
    private int pozitieAnimalInLIsta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_requests_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvRequests = findViewById(R.id.lvRequests);
        lvRequests.setOnItemClickListener((adapterView, view, position, l) -> {
            pozitieAnimalInLIsta = position;
            Intent intent = new Intent(getApplicationContext(), MakeARequestActivity.class);
            intent.putExtra("edit", animalList.get(pozitieAnimalInLIsta)); // Trimite animalul de editat
            launcher.launch(intent);
        });

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getData() != null) {
                if (result.getData().hasExtra("animalForIntent")) {
                    Animal animal = (Animal) result.getData().getSerializableExtra("animalForIntent");
                    if (animal != null) {
                        animalList.add(animal);
                        AnimalRequestAdapter adapter = new AnimalRequestAdapter(this, R.layout.view_animal_request, animalList, getLayoutInflater());
                        lvRequests.setAdapter(adapter);
                    }
                } else if (result.getData().hasExtra("edit")) {
                    Animal animal = (Animal) result.getData().getSerializableExtra("edit");
                    if (animal != null) {
                        Animal editedAnimal = animalList.get(pozitieAnimalInLIsta);
                        editedAnimal.setName(animal.getName());
                        editedAnimal.setEmail(animal.getEmail());
                        editedAnimal.setPhoneNumber(animal.getPhoneNumber());
                        editedAnimal.setTipAnimal(animal.getTipAnimal());
                        AnimalRequestAdapter adapter = (AnimalRequestAdapter) lvRequests.getAdapter();
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("local", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", "token1234");
        editor.apply();
        String token = sharedPreferences.getString("token", "Default");
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();

        fabOpen = findViewById(R.id.fabOpen);
        fabOpen.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MakeARequestActivity.class);
            launcher.launch(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meniu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.idOptiune1) {
            Toast.makeText(this, "OPTIUNE 1", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}