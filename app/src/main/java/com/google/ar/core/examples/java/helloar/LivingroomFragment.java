package com.google.ar.core.examples.java.helloar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import static com.google.ar.core.examples.java.helloar.MainActivity.cnt;
import static com.google.ar.core.examples.java.helloar.MainActivity.isObjectReplaced;
import static com.google.ar.core.examples.java.helloar.MainActivity.obj_file;
import static com.google.ar.core.examples.java.helloar.MainActivity.png_file;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LivingroomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LivingroomFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageButton back_button_LvRoom;
    private ImageButton bed1;
    private ImageButton bed2;
    private ImageButton bed3, bed4, bed5, bed6;
    public LivingroomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LivingroomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LivingroomFragment newInstance(String param1, String param2) {
        LivingroomFragment fragment = new LivingroomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static LivingroomFragment newInstance() {
        return new LivingroomFragment();
    }

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
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_livingroom, container, false);
        back_button_LvRoom = (ImageButton)v.findViewById(R.id.back_button1);
        back_button_LvRoom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                ((MainActivity)getActivity()).replaceFragment(MainFragment.newInstance());
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_place, new MainFragment());
                fragmentTransaction.commit();
            }
        });
        bed1 = (ImageButton) v.findViewById(R.id.bed1);
        bed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/bed1.obj";
                    png_file = "models/bed_texture1.png";
//                    cnt = cnt + 1;
                    isObjectReplaced = true;
                }

            }
        });
        bed2 = (ImageButton) v.findViewById(R.id.bed2);
        bed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/bed2.obj";
                    png_file = "models/table_texture4.png";
//                    cnt = cnt + 1;
                    isObjectReplaced = true;
                }

            }
        });
        bed3 = (ImageButton) v.findViewById(R.id.bed3);
        bed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/bed3.obj";
                    png_file = "models/bed_texture3.png";
//                    cnt = cnt + 1;
                    isObjectReplaced = true;
                }

            }
        });
        bed4 = (ImageButton) v.findViewById(R.id.bed4);
        bed4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/bed4.obj";
                    png_file = "models/table_texture4.png";
                    isObjectReplaced = true;
                }
            }
        });
        bed5 = (ImageButton) v.findViewById(R.id.bed5);
        bed5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/cube_standard.obj";
                    png_file = "models/table_texture4.png";
                    isObjectReplaced = true;
                }
            }
        });
        bed6 = (ImageButton) v.findViewById(R.id.bed6);
        bed6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/cube_standard2.obj";
                    png_file = "models/table_texture4.png";
                    isObjectReplaced = true;
                }
            }
        });


        return v;
    }
}