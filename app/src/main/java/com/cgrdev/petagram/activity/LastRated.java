package com.cgrdev.petagram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.cgrdev.petagram.R;
import com.cgrdev.petagram.adapter.MascotaAdaptador;
import com.cgrdev.petagram.pojo.Mascota;

import java.util.ArrayList;
import java.util.Collections;

public class LastRated extends AppCompatActivity {

    private RecyclerView listaMascotasFavoritas;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_rated);

        toolbar = (Toolbar) findViewById(R.id.toolbarLastRated);
        if (toolbar != null) setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotasFavoritas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFavoritas.setLayoutManager(llm);

        // Como es una lista 'dummy', simplemente reordenamos al azar e inicializamos adaptador
        Collections.shuffle(MainActivity.getMascotas());
        inicializarAdaptador(MainActivity.getMascotas());
    }

    private void inicializarAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas, false);
        listaMascotasFavoritas.setAdapter(mascotaAdaptador);
    }

}
