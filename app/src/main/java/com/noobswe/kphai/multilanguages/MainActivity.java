package com.noobswe.kphai.multilanguages;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    CoordinatorLayout rootLayout;
    ImageButton imbKhaoSoii, imbKhaoNiew, imbPapaya, imbLarb, imbKhaoLarm, imbKhaoG, imbMieng, imbFer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        Configuration config = getBaseContext().getResources().getConfiguration();
        String lang = settings.getString("LANG", "");
        if (! "".equals(lang) && ! config.locale.getLanguage().equals(lang)) {
            Locale locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources()
                    .updateConfiguration(config,
                            getBaseContext().getResources().getDisplayMetrics());
        }
        setContentView(R.layout.activity_main);

        initInstances();
        onClickListener();

    } // end of OnCreate----------------------------------------------------------------------------


    private void initInstances() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        rootLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle(getString(R.string.app_name));

        imbKhaoSoii = (ImageButton) findViewById(R.id.imb_khao_soii);
        imbKhaoNiew = (ImageButton) findViewById(R.id.imb_khao_niew);
        imbPapaya = (ImageButton) findViewById(R.id.imb_papaya);
        imbLarb = (ImageButton) findViewById(R.id.imb_larb);
        imbKhaoLarm = (ImageButton) findViewById(R.id.imb_khao_larm);
        imbKhaoG = (ImageButton) findViewById(R.id.imb_khao_g);
        imbMieng = (ImageButton) findViewById(R.id.imb_mieng);
        imbFer = (ImageButton) findViewById(R.id.imb_fer);

    } // end of Method initInstances----------------------------------------------------------------

    private void onClickListener() {

        imbKhaoSoii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("A", R.string.khaosoii);
                startActivity(intent);
            }
        });

        imbKhaoNiew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("B", R.string.khaoniew);
                startActivity(intent);
            }
        });

        imbPapaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("C", R.string.papaya_salat);
                startActivity(intent);
            }
        });

        imbLarb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("D", R.string.larb);
                startActivity(intent);
            }
        });

        imbKhaoLarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("E", R.string.khaolarm);
                startActivity(intent);
            }
        });

        imbKhaoG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("F", R.string.khao_g);
                startActivity(intent);
            }
        });

        imbMieng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("G", R.string.mieng);
                startActivity(intent);
            }
        });

        imbFer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("H", R.string.fer);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_change_language) {
            showChangeLanguageDialog();
            return true;
        } else if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            intent.putExtra("test", getResources().getString(R.string.language_setting));
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showChangeLanguageDialog() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.language_dialog, null);
        dialogBuilder.setView(dialogView);

        final Spinner spinner1 = (Spinner) dialogView.findViewById(R.id.spinner1);

        dialogBuilder.setTitle(getResources().getString(R.string.lang_dialog_title));
        dialogBuilder.setIcon(R.drawable.ic_language_teal_500_18dp);
        //dialogBuilder.setMessage(getResources().getString(R.string.lang_dialog_message));
        dialogBuilder.setPositiveButton(getResources()
                .getString(R.string.change),
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        int languageType = spinner1.getSelectedItemPosition();
                        switch(languageType) {
                            case 0: //English
                                PreferenceManager
                                        .getDefaultSharedPreferences(getApplicationContext())
                                        .edit().putString("LANG", "en").apply();
                                setLangRecreate("en");
                                return;
                            case 1: //Lao
                                PreferenceManager
                                        .getDefaultSharedPreferences(getApplicationContext())
                                        .edit().putString("LANG", "lo").apply();
                                setLangRecreate("lo");
                                return;
                            default: //By default set to english
                                PreferenceManager
                                        .getDefaultSharedPreferences(getApplicationContext())
                                        .edit().putString("LANG", "en").apply();
                                setLangRecreate("en");
                                return;
                        }
                    }
        });
        dialogBuilder.setNegativeButton(getResources()
                .getString(R.string.cancel),
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void setLangRecreate(String language) {
        Configuration config = getBaseContext().getResources().getConfiguration();
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        config.locale = locale;
        getBaseContext().getResources()
                .updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }


}// end of Main Class-------------------------------------------------------------------------------
