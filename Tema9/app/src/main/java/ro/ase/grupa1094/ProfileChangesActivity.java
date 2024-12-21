package ro.ase.grupa1094;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProfileChangesActivity extends AppCompatActivity {
    private static final String urlUsers = "https://jsonkeeper.com/b/SDVL";
    private FloatingActionButton fabOpen;
    ListView lvProfileChanges;
    List<User> userList = new ArrayList<>();
    ProfileChangesAdapter adapter;
    ActivityResultLauncher<Intent> launcher;
    private int pozitieUserInLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_changes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //User user1 = new User( "Mara", "123pass");
        //UserDB dbInstance = UserDB.getInstance(getApplicationContext());
        //dbInstance.getUserDAO().insertUser(user1);

        //List<User> listaUsers = dbInstance.getUserDAO().getUser();

        //ArrayAdapter<User> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaUsers);
        //listView.setAdapter(adapter2);

        lvProfileChanges = findViewById(R.id.lvProfileChanges);

        adapter = new ProfileChangesAdapter(this, R.layout.view_profile_changes, userList, getLayoutInflater());
        lvProfileChanges.setAdapter(adapter);

        lvProfileChanges.setOnItemClickListener((adapterView, view, position, l) -> {
            pozitieUserInLista = position;
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            intent.putExtra("edit", userList.get(pozitieUserInLista));
            launcher.launch(intent);
        });

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getData() != null) {
                if (result.getData().hasExtra("userForIntent")) {
                    User user = (User) result.getData().getSerializableExtra("userForIntent");
                    if (user != null) {
                        userList.add(user);
                        adapter.notifyDataSetChanged(); // Notifică adapterul pentru adăugare
                    }
                } else if (result.getData().hasExtra("edit")) {
                    User user = (User) result.getData().getSerializableExtra("edit");
                    if (user != null) {
                        User editedUser = userList.get(pozitieUserInLista);
                        editedUser.setName(user.getName());
                        editedUser.setPassword(user.getPassword());
                        adapter.notifyDataSetChanged(); // Notifică adapterul pentru editare
                    }
                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("local", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", "Change profile");
        editor.apply();
        String token = sharedPreferences.getString("token", "Default");
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();

        fabOpen = findViewById(R.id.fabOpen);
        fabOpen.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            launcher.launch(intent);
        });

        initComponente();
        userList.add(new User("Anca Maria", "pass123"));
        userList.add(new User("Delia Miau", "pass234"));
        incarcareUsersDinRetea();
    }
    private void incarcareUsersDinRetea(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                HttpsManager httpsManager = new HttpsManager(urlUsers);
                String rezultat = httpsManager.procesare();
                new Handler(getMainLooper()).post(()->{
                    preluareUsersDinJson(rezultat);
                });
            }
        };
        thread.start();
    }

    private void preluareUsersDinJson(String json) {
        userList.addAll(UserParser.parsareJson(json));
        adapter.notifyDataSetChanged();
    }


    private void initComponente(){
        lvProfileChanges = findViewById(R.id.lvProfileChanges);
        ArrayAdapter<User> adapter1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, userList);
        lvProfileChanges.setAdapter(adapter1);
    }
}
