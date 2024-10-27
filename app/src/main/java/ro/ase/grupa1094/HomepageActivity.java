package ro.ase.grupa1094;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomepageActivity extends AppCompatActivity {

    Button btnChangeProfile;
    Button btnMakeARequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    btnMakeARequest = findViewById(R.id.btnMakeARequest);
    btnChangeProfile = findViewById(R.id.btnChangeProfile);
    btnChangeProfile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(HomepageActivity.this, ProfileChangesActivity.class);
            startActivity(intent);
        }
    });
    btnMakeARequest.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(HomepageActivity.this, RequestsListActivity.class);
            startActivity(intent);
        }
    });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meniu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.idOptiune1){
            Intent intent = new Intent(HomepageActivity.this, ProfileActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.idOptiune2) {
            Intent intent1 = new Intent(HomepageActivity.this, MakeARequestActivity.class);
            startActivity(intent1);
        } else if(item.getItemId() == R.id.idOptiune3){
            Intent intent2 = new Intent(HomepageActivity.this, AboutUsActivity.class);
            startActivity(intent2);
        }
        return true;
    }

}