package sg.edu.np.mad.madpractical3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView androidLogoImageView = findViewById(R.id.androidLogoImageView);

        androidLogoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomInt = random.nextInt(999999);

                User user = new User("Fariha Tasnim", "MAD Developer :P", randomInt, false);

                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setPositiveButton("CLOSE", null);
                builder.setNegativeButton("VIEW", (dialog, which) -> {
                    Intent intent = new Intent(ListActivity.this, MainActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}