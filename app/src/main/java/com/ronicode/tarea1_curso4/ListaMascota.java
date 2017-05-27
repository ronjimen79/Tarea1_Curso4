package com.ronicode.tarea1_curso4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ronicode.tarea1_curso4.adaptadores.PageAdaptador;
import com.ronicode.tarea1_curso4.fragments.DetalleMascota;
import com.ronicode.tarea1_curso4.fragments.PerfilFragment;
import com.ronicode.tarea1_curso4.fragments.RecyclerViewFragment;

import java.util.ArrayList;

public class ListaMascota extends AppCompatActivity {

    private Toolbar ActionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Bundle bundle;
    private SharedPreferences preferenciaID;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        bundle = getIntent().getExtras();

        if (bundle != null){

            preferenciaID = getSharedPreferences("IdSearch", Context.MODE_PRIVATE);
            editor = preferenciaID.edit();
            editor.putString("id", bundle.getString("id"));
            editor.commit();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascota);

        ActionBar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewpager();

        if (ActionBar != null){
            setSupportActionBar(ActionBar);
        }

        getSupportActionBar().setIcon(R.drawable.dog_footprint_filled);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void verFavoritos(View v){
        Intent abrir = new Intent(this, DetalleMascota.class);
        startActivity(abrir);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.itmenuContacto:
                Intent intentContacto = new Intent(this, Contacto.class);
                startActivity(intentContacto);
                break;

            case R.id.itmenuAcercade:
                Intent intentAcercaDe = new Intent(this, AcercaDe.class);
                startActivity(intentAcercaDe);
                break;

            case R.id.itmenuConfigurarcuenta:
                Intent intentConfigurarCuenta = new Intent(this, ConfigurarCuenta.class);
                startActivity(intentConfigurarCuenta);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> adicionarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewpager() {

        viewPager.setAdapter(new PageAdaptador(getSupportFragmentManager(), adicionarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.perfil_48);
    }
}
