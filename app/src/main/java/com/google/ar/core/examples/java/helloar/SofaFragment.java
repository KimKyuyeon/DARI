package com.google.ar.core.examples.java.helloar;

import android.media.Image;
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
 * Use the {@link SofaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SofaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageButton sofa1;
    private ImageButton sofa2;
    private ImageButton sofa3;
    private ImageButton sofa4;
    private ImageButton sofa5;
    private ImageButton sofa6;

    private ImageButton back_button_Sofa;
    public SofaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SofaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SofaFragment newInstance(String param1, String param2) {
        SofaFragment fragment = new SofaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_sofa, container, false);
        back_button_Sofa = (ImageButton)v.findViewById(R.id.back_button5);
        back_button_Sofa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_place, new MainFragment());
                fragmentTransaction.commit();
            }
        });

        sofa1 = (ImageButton) v.findViewById(R.id.sofa1);
        sofa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/sofa1.obj";
                    png_file = "models/bed_texture3.png";
//                    cnt = cnt + 1;
                    isObjectReplaced = true;
                }

            }
        });
        sofa2 = (ImageButton) v.findViewById(R.id.sofa2);
        sofa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/sofa2.obj";
                    png_file = "models/table_texture5.png";
//                    cnt = cnt + 1;
                    isObjectReplaced = true;
                }

            }
        });
        sofa3 = (ImageButton) v.findViewById(R.id.sofa3);
        sofa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/sofa3.obj";
                    png_file = "models/table_texture5.png";
//                    cnt = cnt + 1;
                    isObjectReplaced = true;
                }

            }
        });
        sofa4 = (ImageButton) v.findViewById(R.id.sofa4);
        sofa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/sofa4.obj";
                    png_file = "models/table_texture4.png";
                    isObjectReplaced = true;
                }
            }
        });
        sofa5 = (ImageButton) v.findViewById(R.id.sofa5);
        sofa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/sofa5.obj";
                    png_file = "models/bed5.png";
                    isObjectReplaced = true;
                }
            }
        });
        sofa6 = (ImageButton) v.findViewById(R.id.sofa6);
        sofa6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/sofa6.obj";
                    png_file = "models/table_texture6.png";
                    isObjectReplaced = true;
                }
            }
        });
        return v;
    }
}