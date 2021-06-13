package dari.firebase.communitytest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CommunityActivity extends AppCompatActivity {

    private ImageButton back_button_community;
    private ImageButton new_write_button;
    private ImageView community_image;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.communityu_main);

        Intent intent = getIntent();

        back_button_community = (ImageButton)findViewById(R.id.back_button8);
        new_write_button = (ImageButton)findViewById(R.id.new_write_button);

        community_image = (ImageView)findViewById(R.id.community_image);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                community_image.setImageResource(R.drawable.community);
            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                community_image.setImageResource(R.drawable.community0);
            }
        }, 500);


        back_button_community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        new_write_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewPhotoActivity.class);
                startActivity(intent);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        community_image.setImageResource(R.drawable.community2);
                    }
                }, 10000);
            }
        });
    }
}
