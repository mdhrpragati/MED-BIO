package com.example.rishika.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class FamilyDescription extends AppCompatActivity {

    Toolbar mToolbar1;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_description);

        mToolbar1 = (Toolbar) findViewById(R.id.toolbar);
        imageView1 = (ImageView) findViewById(R.id.imageView6);

        mToolbar1.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp); // Set the icon

        // Icon click listener
        mToolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FamilyDescription.this,Family.class);
                startActivity(i);
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mToolbar1.setTitle(bundle.getString("family"));

            if (mToolbar1.getTitle().toString().equalsIgnoreCase("Acanthaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.acanthaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Acoraceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.acoraceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Amaranthaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.amaranthaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Anacardiaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.anacardiaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Apiaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.apiaceae));
            }else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Apocynaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.apocynaceae));
             } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Araliaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.araliaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Arecaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.arecaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Aristolochiaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.aristolochiaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Asclepiadaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.asclepiadaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Asparagaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.asparagaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Asphodelaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.asphodelaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Asteraceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.asteraceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Berberidaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.berberidaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Betulaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.betulaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Burseraceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.burseraceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Caesulpinaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.caesulpinaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Calophyllaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.calophyllaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Cannabaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.cannabaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Caprifoliaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.caprifoliaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Colchicaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.colchicaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Combretaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.combretaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Convolvulaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.convolvulaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Cucurbitaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.cucurbitaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Cucurbits")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.cucurbits));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Cypress")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.cypress));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Daisy")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.daisy));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Dioscoreaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.dioscoreaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Elaeocarpaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.elaeocarpaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Ericaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.ericaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Euphorbiaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.euphorbiaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Fabaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.fabaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Gentianaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.gentianaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Geraniaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.geraniaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Gesneriaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.gesneriaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Grasses")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.grasses));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Hippocastanaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.hippocastanaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Hypericaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.hypericaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Hypoxidaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.hypoxidaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Iridaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.iridaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Juglandaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.juglandaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Lamiaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.lamiaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Lauraceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.lauraceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Legumes")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.legumes));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Liliaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.liliaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Linaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.linaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Loganiaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.loganiaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Lycopodiaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.lycopodiaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Lythraceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.lythraceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Mallows")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.mallows));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Malvaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.malvaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Martyniaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.martyniaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Meliaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.meliaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Menispermaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.menispermaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Moraceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.moraceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Morchellaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.morchellaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Myricaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.myricaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Myristicaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.myristicaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Myrtaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.myrtaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Nelumbonaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.nelumbonaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Nightshade")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.nightshade));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Nyctaginaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.nyctaginaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Oleaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.oleaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Ophiocordycipitaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.ophiocordycipitaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Orchidaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.orchidaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Papaveraceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.papaveraceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Parmeliaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.parmeliaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Phyllanthaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.phyllanthaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Pinaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.pinaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Piperaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.piperaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Plantaginaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.plantaginaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Plumbaginaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.plumbaginaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Polypodiaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.polypodiaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Primulaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.primulaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Pteridaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.pteridaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Punicaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.punicaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Ranunculaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.ranunculaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Rhamnaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.rhamnaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Rubiaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.rubiaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Rutaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.rutaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Santalaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.santalaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Sapindaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.sapindaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Saxifragaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.saxifragaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Sedges")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.sedges));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Smilacaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.smilacaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Taxaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.taxaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Trilliaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.trilliaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Umbelifers")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.umbelifers));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Verbenaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.verbenaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Vitaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.vitaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Zingiberaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.zingiberaceae));
            } else if (mToolbar1.getTitle().toString().equalsIgnoreCase("Zygophyllaceae")) {
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.zygophyllaceae));}

            }

        }
    }

