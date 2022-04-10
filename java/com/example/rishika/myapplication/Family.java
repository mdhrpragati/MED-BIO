package com.example.rishika.myapplication;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class Family extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_family);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ExpandableListView expandbleLis = (ExpandableListView) findViewById(R.id.lv1);
        expandbleLis.setDividerHeight(2);
        expandbleLis.setGroupIndicator(null);
        expandbleLis.setClickable(true);

        setGroupData();
        setChildGroupData();

        NewAdapter mNewAdapter = new NewAdapter(groupItem, childItem);
        mNewAdapter
                .setInflater(
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),
                        this);
        expandbleLis.setAdapter(mNewAdapter);
    }

    public void setGroupData() {
        groupItem.add("Acanthaceae");
        groupItem.add("Acoraceae");
        groupItem.add("Amaranthaceae");
        groupItem.add("Anacardiaceae");
        groupItem.add("Apiaceae");
        groupItem.add("Apocynaceae");
        groupItem.add("Araliaceae");
        groupItem.add("Arecaceae");
        groupItem.add("Aristolochiaceae");
        groupItem.add("Asclepiadaceae");
        groupItem.add("Asparagaceae");
        groupItem.add("Asphodelaceae");
        groupItem.add("Asteraceae");
        groupItem.add("Berberidaceae");
        groupItem.add("Betulaceae");
        groupItem.add("Burseraceae");
        groupItem.add("Caesulpinaceae");
        groupItem.add("Calophyllaceae");
        groupItem.add("Cannabaceae");
        groupItem.add("Caprifoliaceae");
        groupItem.add("Colchicaceae");
        groupItem.add("Combretaceae");
        groupItem.add("Convolvulaceae");
        groupItem.add("Cucurbitaceae");
        groupItem.add("Cucurbits");
        groupItem.add("Cypress");
        groupItem.add("Daisy");
        groupItem.add("Dioscoreaceae");
        groupItem.add("Elaeocarpaceae");
        groupItem.add("Ericaceae");
        groupItem.add("Euphorbiaceae");
        groupItem.add("Fabaceae");
        groupItem.add("Gentianaceae");
        groupItem.add("Geraniaceae");
        groupItem.add("Gesneriaceae");
        groupItem.add("Grasses");
        groupItem.add("Hippocastanaceae");
        groupItem.add("Hypericaceae");
        groupItem.add("Hypoxidaceae");
        groupItem.add("Iridaceae");
        groupItem.add("Juglandaceae");
        groupItem.add("Lamiaceae");
        groupItem.add("Lauraceae");
        groupItem.add("Legumes");
        groupItem.add("Liliaceae");
        groupItem.add("Linaceae");
        groupItem.add("Loganiaceae");
        groupItem.add("Lycopodiaceae");
        groupItem.add("Lythraceae");
        groupItem.add("Mallows");
        groupItem.add("Malvaceae");
        groupItem.add("Martyniaceae");
        groupItem.add("Meliaceae");
        groupItem.add("Menispermaceae");
        groupItem.add("Moraceae");
        groupItem.add("Morchellaceae");
        groupItem.add("Myricaceae");
        groupItem.add("Myristicaceae");
        groupItem.add("Myrtaceae");
        groupItem.add("Nelumbonaceae");
        groupItem.add("Nightshade");
        groupItem.add("Nyctaginaceae");
        groupItem.add("Oleaceae");
        groupItem.add("Ophiocordycipitaceae");
        groupItem.add("Orchidaceae");
        groupItem.add("Papaveraceae");
        groupItem.add("Parmeliaceae");
        groupItem.add("Phyllanthaceae");
        groupItem.add("Pinaceae");
        groupItem.add("Piperaceae");
        groupItem.add("Plantaginaceae");
        groupItem.add("Plumbaginaceae");
        groupItem.add("Polypodiaceae");
        groupItem.add("Primulaceae");
        groupItem.add("Pteridaceae");
        groupItem.add("Punicaceae");
        groupItem.add("Ranunculaceae");
        groupItem.add("Rhamnaceae");
        groupItem.add("Rubiaceae");
        groupItem.add("Rutaceae");
        groupItem.add("Santalaceae");
        groupItem.add("Sapindaceae");
        groupItem.add("Saxifragaceae");
        groupItem.add("Sedges");
        groupItem.add("Smilacaceae");
        groupItem.add("Taxaceae");
        groupItem.add("Trilliaceae");
        groupItem.add("Umbelifers");
        groupItem.add("Verbenaceae");
        groupItem.add("Vitaceae");
        groupItem.add("Zingiberaceae");
        groupItem.add("Zygophyllaceae");

    }

    ArrayList<String> groupItem = new ArrayList<String>();
    ArrayList<Object> childItem = new ArrayList<Object>();

    public void setChildGroupData() {
/**
 * Add Data For Acanthaceae
 */
        ArrayList<String> child = new ArrayList<String>();
        child.add("Adhatoda vasica");
        child.add("Andrographis paniculata");
        childItem.add(child);

        /**
         * Add Data For Acoraceae
         */
        child = new ArrayList<String>();
        child.add("Acorus calamus");
        childItem.add(child);
        /**
         * Add Data For Amaranthaceae
         */
        child = new ArrayList<String>();
        child.add("Achyranthes aspera");
        childItem.add(child);
        /**
         * Add Data For Anacardiaceae
         */
        child = new ArrayList<String>();
        child.add("Buchanania lanzan");
        child.add("Pistacia integerrima");
        childItem.add(child);
        /**
         * Add Data For Apiaceae
         */
        child = new ArrayList<String>();
        child.add("Selinum tenuifolium");
        childItem.add(child);
        /**
         * Add Data For Apocynaceae
         */
        child = new ArrayList<String>();
        child.add("Alstonia scholaris");
        child.add("Calotropis procera");
        child.add("Hemidesmus indicus");
        child.add("Holarrhena antidysenterica");
        child.add("Ichnocarpus frutescens");
        child.add("Rauwolfia serpentina");
        childItem.add(child);
        /**
         * Add Data For Araliaceae
         */
        child = new ArrayList<String>();
        child.add("Panax pseudo-ginseng");
        childItem.add(child);
        /**
         * Add Data For Arecaceae
         */
        child = new ArrayList<String>();
        child.add("Areca catechu");
        childItem.add(child);
        /**
         * Add Data For Aristolochiaceae
         */
        child = new ArrayList<String>();
        child.add("Aristolochia indica");
        childItem.add(child);
        /**
         * Add Data For asclepiadaceae
         */
        child = new ArrayList<String>();
        child.add("Leptadenia reticulata");
        childItem.add(child);
        /**
         * Add Data For Asparagaceae
         */
        child = new ArrayList<String>();
        child.add("Asparagus racemosus");
        childItem.add(child);
        /**
         * Add Data For Asphodelaceae
         */
        child = new ArrayList<String>();
        child.add("Aloe barbadensis");
        childItem.add(child);/**

         * Add Data For Asteraceae
         */
        child = new ArrayList<String>();
        child.add("Anacyclus pyrethrum");
        child.add("Artemisia dubia");
        childItem.add(child);/**

         * Add Data For berberidaceae
         */
        child = new ArrayList<String>();
        child.add("Berberis aristata");
        child.add("Podophyllum hexandrum");
        childItem.add(child);
        /**
         * Add Data For Betulaceae
         */
        child = new ArrayList<String>();
        child.add("Betula utilis");
        childItem.add(child);
        /**
         * Add Data For Burseraceae
         */
        child = new ArrayList<String>();
        child.add("Commiphora mukul/hook");
        childItem.add(child);
        /**
         * Add Data For Caesulpinaceae
         */
        child = new ArrayList<String>();
        child.add("Cassia tora");
        childItem.add(child);
        /**
         * Add Data For Calophyllaceae
         */
        child = new ArrayList<String>();
        child.add("Mesua ferrea");
        childItem.add(child);
        /**
         * Add Data For Cannabaceae
         */
        child = new ArrayList<String>();
        child.add("Cannabis sativa");
        childItem.add(child);
        /**
         * Add Data For Caprifoliaceae
         */
        child = new ArrayList<String>();
        child.add("Nardostachys jatamansi");
        child.add("Valeriana wallichi");
        childItem.add(child);
        /**
         * Add Data For Colchicaceae
         */
        child = new ArrayList<String>();
        child.add("Gloriosa superba");
        childItem.add(child);
        /**
         * Add Data For Combretaceae
         */
        child = new ArrayList<String>();
        child.add("Terminalia arjuna");
        child.add("Terminalia belerica");
        child.add("Terminalia chebula");
        childItem.add(child);
        /**
         * Add Data For Convolvulaceae
         */
        child = new ArrayList<String>();
        child.add("Evolvulus alsinoides");
        childItem.add(child);
        /**
         * Add Data For Cucurbitaceae
         */
        child = new ArrayList<String>();
        child.add("Trichosanthes triuspidata");
        childItem.add(child);
        /**
         * Add Data For Cucurbits
         */
        child = new ArrayList<String>();
        child.add("Momordica charantia");
        childItem.add(child);
        /**
         * Add Data For Cypress
         */
        child = new ArrayList<String>();
        child.add("Juniperous communis");
        childItem.add(child);
        /**
         * Add Data For Daisy
         */
        child = new ArrayList<String>();
        child.add("Saussurea lappa");
        child.add("Carthamus tinctorious");
        child.add("Chamomilla recutita");
        child.add("Inula racemosa");
        childItem.add(child);
        /**
         * Add Data For Dioscoreaceae
         */
        child = new ArrayList<String>();
        child.add("Dioscorea deltoidea");
        childItem.add(child);
        /**
         * Add Data For Elaeocarpaceae
         */
        child = new ArrayList<String>();
        child.add("Elaeocarpus sphaericus");
        childItem.add(child);
        /**
         * Add Data For Ericaceae
         */
        child = new ArrayList<String>();
        child.add("Gaultheria frangrans");
        child.add("Rhododendron lepidotum");
        childItem.add(child);
        /**
         * Add Data For Euphorbiaceae
         */
        child = new ArrayList<String>();
        child.add("Croton tiglium");
        child.add("Putranjiva roxburghil");
        child.add("Ricinus communis");
        child.add("Tragia involucrata");
        childItem.add(child);
        /**
         * Add Data For Fabaceae
         */
        child = new ArrayList<String>();
        child.add("Acacia catechu");
        child.add("Acacia concinna");
        childItem.add(child);
        /**
         * Add Data For Gentianaceae
         */
        child = new ArrayList<String>();
        child.add("Gentiana kurroo");
        child.add("Swertia chairayita");
        childItem.add(child);
        /**
         * Add Data For Geraniaceae
         */
        child = new ArrayList<String>();
        child.add("Geranium nepalense");
        childItem.add(child);
        /**
         * Add Data For Gesneriaceae
         */
        child = new ArrayList<String>();
        child.add("Didymocarpus albicalyx");
        childItem.add(child);
        /**
         * Add Data For Grasses
         */
        child = new ArrayList<String>();
        child.add("Cymbopogon martinil");
        child.add("Vetiveria zizanioides");
        childItem.add(child);
        /**
         * Add Data For Hippocastanaceae
         */
        child = new ArrayList<String>();
        child.add("Aesculus hippocastanum");
        childItem.add(child);
        /**
         * Add Data For Hypericaceae
         */
        child = new ArrayList<String>();
        child.add("Hypercium perforatum");
        childItem.add(child);
        /**
         * Add Data For Hypoxidaceae
         */
        child = new ArrayList<String>();
        child.add("Curculigo orchioides");
        childItem.add(child);
        /**
         * Add Data For Iridaceae
         */
        child = new ArrayList<String>();
        child.add("Crocus sativus");
        childItem.add(child);
        /**
         * Add Data For Juglandaceae
         */
        child = new ArrayList<String>();
        child.add("Juglans regia");
        childItem.add(child);
        /**
         * Add Data For Lamiaceae
         */
        child = new ArrayList<String>();
        child.add("Coleus forskohlii");
        child.add("Mentha piperita");
        child.add("Ocimum sanctum");
        childItem.add(child);
        /**
         * Add Data For Lauraceae
         */
        child = new ArrayList<String>();
        child.add("Cinnamomum zeylanicum");
        childItem.add(child);
        /**
         * Add Data For Legumes
         */
        child = new ArrayList<String>();
        child.add("Abrus precatorius");
        child.add("Acacia nilotica");
        child.add("Albizia lebbek");
        child.add("Butea monosperma");
        child.add("Cassia fistula");
        child.add("Glycyrrhiz glabra");
        child.add("Mucuna pruriens");
        child.add("Pongamia pinnata");
        child.add("Pterocarpus marsupium");
        child.add("Pterocarpus santalinus");
        child.add("Saraca asoca");
        child.add("Tamarindus indica");
        childItem.add(child);
        /**
         * Add Data For Liliaceae
         */
        child = new ArrayList<String>();
        child.add("Fritillaria cirrhosa");
        childItem.add(child);
        /**
         * Add Data For Linaceae
         */
        child = new ArrayList<String>();
        child.add("Linum usitatissinum");
        childItem.add(child);
        /**
         * Add Data For Loganiaceae
         */
        child = new ArrayList<String>();
        child.add("Strychnos nux");
        childItem.add(child);
        /**
         * Add Data For Lycopodiaceae
         */
        child = new ArrayList<String>();
        child.add("Lycopodium japonicum");
        childItem.add(child);
        /**
         * Add Data For Lythraceae
         */
        child = new ArrayList<String>();
        child.add("Woodfordia fruticosa");
        childItem.add(child);
        /**
         * Add Data For Mallows
         */
        child = new ArrayList<String>();
        child.add("Gossypium arboreum");
        child.add("Hibiscus rosa");
        child.add("Sida cordifolia");
        childItem.add(child);
        /**
         * Add Data For Malvaceae
         */
        child = new ArrayList<String>();
        child.add("Salmalia malabarica");
        childItem.add(child);
        /**
         * Add Data For Martyniaceae
         */
        child = new ArrayList<String>();
        child.add("Martynia annua");
        childItem.add(child);
        /**
         * Add Data For Meliaceae
         */
        child = new ArrayList<String>();
        child.add("Azadirachta indica");
        childItem.add(child);
        /**
         * Add Data For Menispermaceae
         */
        child = new ArrayList<String>();
        child.add("Tinospora cordifolia");
        childItem.add(child);
        /**
         * Add Data For Moraceae
         */
        child = new ArrayList<String>();
        child.add("Ficus benghalensis");
        child.add("Ficus religiosa");
        childItem.add(child);
        /**
         * Add Data For Morchellaceae
         */
        child = new ArrayList<String>();
        child.add("Morchella esculenta");
        childItem.add(child);
        /**
         * Add Data For Myricaceae
         */
        child = new ArrayList<String>();
        child.add("Myrica esculenta");
        childItem.add(child);
        /**
         * Add Data For Myristicaceae
         */
        child = new ArrayList<String>();
        child.add("Myristica fragrans");
        childItem.add(child);
        /**
         * Add Data For Myrtaceae
         */
        child = new ArrayList<String>();
        child.add("Syzgium cumini");
        childItem.add(child);
        /**
         * Add Data For Nelumbonaceae
         */
        child = new ArrayList<String>();
        child.add("Nelumbo nucifera");
        childItem.add(child);
        /**
         * Add Data For Nightshade
         */
        child = new ArrayList<String>();
        child.add("Datura metel");
        child.add("Hyoscyamus niger");
        child.add("Solanum surattense");
        child.add("Withania somnifera");
        childItem.add(child);
        /**
         * Add Data For Nyctaginaceae
         */
        child = new ArrayList<String>();
        child.add("Boerhavia diffusa");
        childItem.add(child);
        /**
         * Add Data For Oleaceae
         */
        child = new ArrayList<String>();
        child.add("Olea cuspidata");
        childItem.add(child);
        /**
         * Add Data For Ophiocordycipitaceae
         */
        child = new ArrayList<String>();
        child.add("Ophiocordyceps sinensis");
        childItem.add(child);
        /**
         * Add Data For Orchidaceae
         */
        child = new ArrayList<String>();
        child.add("Brachycorythis obcordata");
        child.add("Ephemerantha macraei");
        child.add("Dactylorhiza hatagirea");
        childItem.add(child);
        /**
         * Add Data For Papaveraceae
         */
        child = new ArrayList<String>();
        child.add(" Argemone mexicana");
        child.add("Papaver somniferum");
        childItem.add(child);
        /**
         * Add Data For Parmeliaceae
         */
        child = new ArrayList<String>();
        child.add("Parmelia perlata");
        childItem.add(child);
        /**
         * Add Data For Phyllanthaceae
         */
        child = new ArrayList<String>();
        child.add("Embilica officinalis");
        childItem.add(child);
        /**
         * Add Data For Pinaceae
         */
        child = new ArrayList<String>();
        child.add("Cedrus deodara");
        childItem.add(child);
        /**
         * Add Data For Piperaceae
         */
        child = new ArrayList<String>();
        child.add("Piper cubeba");
        child.add("Piper longum");
        child.add("Piper mullesus");
        childItem.add(child);
        /**
         * Add Data For Plantaginaceae
         */
        child = new ArrayList<String>();
        child.add("Plantago ovata");
        childItem.add(child);
        /**
         * Add Data For Plumbaginaceae
         */
        child = new ArrayList<String>();
        child.add("Plumbago zeylanica");
        childItem.add(child);
        /**
         * Add Data For Polypodiaceae
         */
        child = new ArrayList<String>();
        child.add("Polypodium amoenum");
        childItem.add(child);
        /**
         * Add Data For Primulaceae
         */
        child = new ArrayList<String>();
        child.add("Embelia ribes");
        childItem.add(child);
        /**
         * Add Data For Pteridaceae
         */
        child = new ArrayList<String>();
        child.add("Adiantum capillus-veneris");
        childItem.add(child);
        /**
         * Add Data For Punicaceae
         */
        child = new ArrayList<String>();
        child.add("Punica granatum");
        childItem.add(child);
        /**
         * Add Data For Ranunculaceae
         */
        child = new ArrayList<String>();
        child.add("Aconitum ferox");
        child.add("Aconitum heterophyllum");
        child.add("Aconitum spicatum");
        child.add("Delphinium denudatum");
        childItem.add(child);
        /**
         * Add Data For Rhamnaceae
         */
        child = new ArrayList<String>();
        child.add("Ziziphus mauritiana");
        childItem.add(child);
        /**
         * Add Data For Rubiaceae
         */
        child = new ArrayList<String>();
        child.add("Rubia cordifolia");
        childItem.add(child);
        /**
         * Add Data For Rutaceae
         */
        child = new ArrayList<String>();
        child.add("Aegle marmelos");
        child.add("Zanthoxylon budrunga");
        child.add("Zanthoxylum oxyphyllum");
        childItem.add(child);
        /**
         * Add Data For Santalaceae
         */
        child = new ArrayList<String>();
        child.add("Santalum album");
        childItem.add(child);
        /**
         * Add Data For Sapindaceae
         */
        child = new ArrayList<String>();
        child.add("Sapindus mukorossi");
        childItem.add(child);
        /**
         * Add Data For Saxifragaceae
         */
        child = new ArrayList<String>();
        child.add("Bergina ciliata");
        childItem.add(child);
        /**
         * Add Data For Sedges
         */
        child = new ArrayList<String>();
        child.add("Cyperus scariosus");
        childItem.add(child);
        /**
         * Add Data For Smilacaceae
         */
        child = new ArrayList<String>();
        child.add("Smilax aspera");
        childItem.add(child);
        /**
         * Add Data For Taxaceae
         */
        child = new ArrayList<String>();
        child.add("Taxus baccata");
        childItem.add(child);
        /**
         * Add Data For Trilliaceae
         */
        child = new ArrayList<String>();
        child.add("Paris polyphylla");
        childItem.add(child);
        /**
         * Add Data For Umbelifers
         */
        child = new ArrayList<String>();
        child.add("Carum carvi");
        child.add("Centella asiatica");
        childItem.add(child);
        /**
         * Add Data For Verbenaceae
         */
        child = new ArrayList<String>();
        child.add("Gmelina arborea");
        childItem.add(child);
        /**
         * Add Data For Vitaceae
         */
        child = new ArrayList<String>();
        child.add("Vitis vinifera");
        childItem.add(child);
        /**
         * Add Data For Zingiberaceae
         */
        child = new ArrayList<String>();
        child.add("Amomum subulatum");
        child.add("Curcuma longa");
        child.add("Curcuma zedoaria");
        child.add("Roscoea purpurea");
        child.add("Zingiber officnale");
        childItem.add(child);
        /**
         * Add Data For Zygophyllaceae
         */
        child = new ArrayList<String>();
        child.add("Tribulus terrestris");
        childItem.add(child);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
       /* getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem item = menu.findItem(R.id.menusearch);
        SearchView searchView = (SearchView) item.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newtext) {
                return true;

            }
        });*/
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent medicinalplants_intent = new Intent(this, MainActivity.class);
            startActivity(medicinalplants_intent);
            finish();

        } else if (id == R.id.nav_medicinalplants) {
            Intent medicinalplants_intent = new Intent(this, MedicinalPlants.class);
            startActivity(medicinalplants_intent);
            finish();

        } else if (id == R.id.nav_addplants) {
            Intent family_intent = new Intent(this, AddPlants.class);
            startActivity(family_intent);
            finish();

        } else if (id == R.id.nav_family) {
            Intent family_intent = new Intent(this, Family.class);
            startActivity(family_intent);
            finish();


        } else if (id == R.id.nav_aboutus) {
            Intent aboutus_intent = new Intent(this, AboutUs.class);
            startActivity(aboutus_intent);
            finish();


        } else  if (id == R.id.nav_share) {
            String sharebody="This is great App,you should try it out";
            Intent shareintent=new Intent(Intent.ACTION_SEND);
            shareintent.setType("text/plain");
            shareintent.putExtra(android.content.Intent.EXTRA_SUBJECT,"My App");
            shareintent.putExtra(android.content.Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(shareintent,"Share via"));
            finish();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;    }

   /* @Override
    public boolean onChildClick(ExpandableListView parent, View v,
                                int groupPosition, int childPosition, long id) {
        Toast.makeText(Family.this, "Clicked On Child",
                Toast.LENGTH_SHORT).show();
        return true;
    }*/
}
