package com.cgrdev.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cgrdev.petagram.R;
import com.cgrdev.petagram.adapter.MiMascotaAdapter;
import com.cgrdev.petagram.pojo.RatedPicture;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class MyPetFragment extends Fragment {

    private RecyclerView listaMascotasRated;
    private ArrayList<RatedPicture> mascotasRated;


    public void setMascotasRated(ArrayList<RatedPicture> mascotasRated) {
        this.mascotasRated = mascotasRated;
    }

    public MyPetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_pet, container, false);

        listaMascotasRated = (RecyclerView) v.findViewById(R.id.rvMyPet);

        GridLayoutManager glm = new GridLayoutManager(v.getContext(), 3);

        listaMascotasRated.setLayoutManager(glm);

        inicializaAdaptador();

        return v;
    }

    private void inicializaAdaptador() {

        MiMascotaAdapter miMascotaAdapter = new MiMascotaAdapter(mascotasRated);
        listaMascotasRated.setAdapter(miMascotaAdapter);
    }

}