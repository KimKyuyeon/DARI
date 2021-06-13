package dari.firebase.communitytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NewPhotoActivity extends AppCompatActivity {
    private ImageButton back_button_community;
    private ImageView _image;
    private EditText title_input;
    private Button upload_button;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newphoto_activity);

        Intent intent = getIntent();

        back_button_community = (ImageButton)findViewById(R.id.back_button8);
        _image = (ImageView)findViewById(R.id.newphoto_image);
        title_input = (EditText)findViewById(R.id.newphoto_title);
        upload_button = (Button)findViewById(R.id.newphoto_btn_upload);

        _image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _image.setImageResource(R.drawable.sofa);
            }
        });

/*        back_button_community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/
        upload_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
