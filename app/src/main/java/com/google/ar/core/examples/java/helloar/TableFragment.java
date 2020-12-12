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
 * Use the {@link TableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TableFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageButton table1;
    private ImageButton table2;
    private ImageButton table3;
    private ImageButton table4;
    private ImageButton table5;
    private ImageButton table6;

    private ImageButton back_button_Table;
    public TableFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TableFragment newInstance(String param1, String param2) {
        TableFragment fragment = new TableFragment();
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
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_table, container, false);
        back_button_Table = (ImageButton)v.findViewById(R.id.back_button6);
        back_button_Table.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_place, new MainFragment());
                fragmentTransaction.commit();
            }
        });

        table1 = (ImageButton) v.findViewById(R.id.table1);
        table1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/table1.obj";
                    png_file = "models/table_texture4.png";
//                    cnt = cnt + 1;
                    isObjectReplaced = true;
                }

            }
        });
        table2 = (ImageButton) v.findViewById(R.id.table2);
        table2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/table2.obj";
                    png_file = "models/table_texture4.png";
//                    cnt = cnt + 1;
                    isObjectReplaced = true;
                }

            }
        });
        table3 = (ImageButton) v.findViewById(R.id.table3);
        table3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/table3.obj";
                    png_file = "models/table_texture6.png";
//                    cnt = cnt + 1;
                    isObjectReplaced = true;
                }

            }
        });
        table4 = (ImageButton) v.findViewById(R.id.table4);
        table4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/table4.obj";
                    png_file = "models/table_texture5.png";
                    isObjectReplaced = true;
                }
            }
        });
        table5 = (ImageButton) v.findViewById(R.id.table5);
        table5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/table5.obj";
                    png_file = "models/table_texture5.png";
                    isObjectReplaced = true;
                }
            }
        });
        table6 = (ImageButton) v.findViewById(R.id.table6);
        table6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt == 0) {
                    obj_file = "models/table6.obj";
                    png_file = "models/table_texture5.png";
                    isObjectReplaced = true;
                }
            }
        });
        return v;
    }
}