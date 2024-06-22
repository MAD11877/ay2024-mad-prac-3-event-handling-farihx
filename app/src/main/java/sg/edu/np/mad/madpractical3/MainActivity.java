package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        User user = (User) getIntent().getSerializableExtra("user");

        TextView tvName = findViewById(R.id.titleTextView);
        TextView tvDescription = findViewById(R.id.descriptionTextView);
        tvName.setText(user.getName() + " " + user.getId());
        tvDescription.setText(user.getDescription());

        Button btnFollow = findViewById(R.id.followButton);
        btnFollow.setText(user.isFollowed() ? "UNFOLLOW" : "FOLLOW");

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.isFollowed()) {
                    showToast("Unfollowed");
                    btnFollow.setText("FOLLOW");
                    user.setFollowed(false);
                } else {
                    showToast("Followed");
                    btnFollow.setText("UNFOLLOW");
                    user.setFollowed(true);
                }
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}