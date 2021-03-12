package com.google.ar.core.examples.java.helloar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SidemenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SidemenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String name;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private interface PictuteListener {
        void onProfilePictureUpdated();
    }

    private PictuteListener pictureListener;
    private final int PICK_IMAGE = 100;
    private FirebaseUser firebaseUser;

    private de.hdodenhof.circleimageview.CircleImageView imageView1;
    private ImageView imageView;


    private ImageButton back_button_Sidemenu;
    public SidemenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SidemenuFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static SidemenuFragment newInstance(String param1, String param2) {
        SidemenuFragment fragment = new SidemenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private TextView user_email;
    private TextView user_name;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_sidemenu, container, false);
        back_button_Sidemenu = (ImageButton)v.findViewById(R.id.back_button7);
        user_email = v.findViewById(R.id.email);
        user_name=v.findViewById(R.id.name);
        imageView=v.findViewById(R.id.profile_image);

        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            firebaseUser = firebaseAuth.getCurrentUser();
        }
        if (firebaseUser != null) {
            // Name, email address, and profile photo Url
            // Get a reference to your user
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("server/path/to/profile");
            String name = firebaseUser.getDisplayName();
            String email = firebaseUser.getEmail();
            user_name.setText(name);
            user_email.setText(email);
            user_name.setText(firebaseUser.getDisplayName());

//            for (UserInfo profile : firebaseUser.getProviderData()) {
//                // Id of the provider (ex: google.com)
//                String providerId = profile.getProviderId();
//
//                // UID specific to the provider
//                String uid = profile.getUid();
//
//                // Name, email address, and profile photo Url
//                String email = profile.getEmail();
//
//
//                DatabaseReference Db=FirebaseDatabase.getInstance().getReference();
//                DatabaseReference Users = Db.child("Users").child(uid).child("name");
//                Users.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        name = snapshot.getValue().toString();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//                user_name.setText(name);
//                user_email.setText(email);
//            }



            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openGallery();
                }
            });
            pictureListener = new PictuteListener() {
                @Override
                public void onProfilePictureUpdated() {
                    Uri uri = firebaseUser.getPhotoUrl();
                    Glide.with(getActivity()).load(uri).into(imageView);
                }
            };
            Uri profilePicture = firebaseUser.getPhotoUrl();
            Glide.with(this).load(profilePicture).placeholder(R.drawable.profile_image).into(imageView);

        }

        back_button_Sidemenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_place, new MainFragment());
                fragmentTransaction.commit();
            }
        });

        ListView listview ;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter() ;

        listview = (ListView) v.findViewById(R.id.listview);
        listview.setAdapter(adapter);

        // My page
        adapter.addItem(ContextCompat.getDrawable(v.getContext(), R.drawable.menu_mypage2), "My page") ;
        // Wishlist
        adapter.addItem(ContextCompat.getDrawable(v.getContext(), R.drawable.menu_like2), "Wishlist") ;
        // Share
        adapter.addItem(ContextCompat.getDrawable(v.getContext(), R.drawable.menu_share2), "Community") ;
        // Share
        adapter.addItem(ContextCompat.getDrawable(v.getContext(), R.drawable.menu_setting2), "Setting") ;
        // Share
        adapter.addItem(ContextCompat.getDrawable(v.getContext(), R.drawable.menu_logout2), "Logout") ;

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 2)
                {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_place, new CommunityFragment());
                    fragmentTransaction.commit();
                }
            }
        });

        return v;
    }
    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE) {
            final Uri imageUri = data.getData();
            updateUserProfilePicture(imageUri);
        }
    }

    private void updateUserProfilePicture(final Uri uri) {

        UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                .setPhotoUri(uri)
                .build();

        firebaseUser.updateProfile(profileChangeRequest)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            onChangedProfilePicture(uri);
                        }
                    }
                });
    }

    public void onChangedProfilePicture(Uri uri) {
        Glide.with(this).load(uri)
                .placeholder(R.drawable.profile_image)
                .into(imageView);

    }
}