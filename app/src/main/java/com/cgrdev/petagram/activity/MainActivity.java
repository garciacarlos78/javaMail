package com.cgrdev.petagram.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cgrdev.petagram.R;
import com.cgrdev.petagram.adapter.PageAdapter;
import com.cgrdev.petagram.fragment.MyPetFragment;
import com.cgrdev.petagram.fragment.MainFragment;
import com.cgrdev.petagram.pojo.Mascota;
import com.cgrdev.petagram.pojo.RatedPicture;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    private static ArrayList<Mascota> mascotas;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        inicializaMascotas();
        setupViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }


    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new MainFragment());
        MyPetFragment myPetFragment = new MyPetFragment();
        myPetFragment.setMascotasRated(mascotas.get(4).getRatedPictures());
        fragments.add(myPetFragment);

        return fragments;
    }

    private void setupViewPager () {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_icon);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        int id = item.getItemId();

        // Switch para controlar el menú presionado
        switch (id) {
            case R.id.btFavoritos:
                // Creamos intent
                Intent intent = new Intent(this, LastRated.class);

                // Iniciamos la nueva Activity
                startActivity(new Intent(this, LastRated.class));
                return true;

            case R.id.mContacto:
                startActivity(new Intent(this,Contacto.class));
                break;

            case R.id.mAcercaDe:
                startActivity(new Intent(this,AcercaDe.class));
                break;
        }

        return super.onOptionsItemSelected(item);
     }

    private void inicializaMascotas() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(1, R.drawable.dog_3,"Tobías"));
        mascotas.add(new Mascota(2, R.drawable.dog_2,"Jeremías"));
        mascotas.add(new Mascota(3, R.drawable.dog_gimp,"Gimpy"));
        mascotas.add(new Mascota(4, R.drawable.beaver_1,"Alvin"));
        mascotas.add(new Mascota(5, R.drawable.ghost_1,"Casper"));

        // Inicializo con más fotos rateadas la que va a ser mi mascota
        Resources r = getResources();
        for (int i = 2; i <= 10; i++) {
            int randomRate = (int) (Math.random() * 100);
            mascotas.get(4).addRatedPicture(new RatedPicture(
                    r.getIdentifier("ghost_"+i, "drawable", "com.cgrdev.petagram"), randomRate));

        }
    }
}
