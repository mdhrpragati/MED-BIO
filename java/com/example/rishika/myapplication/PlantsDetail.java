package com.example.rishika.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlantsDetail extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView imageView;
    TextView tv1,tv2,tv3,tv4,tv5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants_detail);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp); // Set the icon

        // Icon click listener
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PlantsDetail.this,MedicinalPlants.class);
                startActivity(i);
                finish();
            }
        });

        imageView = (ImageView) findViewById(R.id.imageView5);
        tv1 = (TextView) findViewById(R.id.botanical);
        tv2 = (TextView) findViewById(R.id.english);
        tv3 = (TextView) findViewById(R.id.nepali);
        tv4 = (TextView) findViewById(R.id.family);
        tv5 = (TextView) findViewById(R.id.description);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            mToolbar.setTitle(bundle.getString("Plants"));

            if(mToolbar.getTitle().toString().equalsIgnoreCase("Abrus precatorius")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.aa)) ;
                tv1.setText("Abrus precatorius");
                tv2.setText("Jequirity");
                tv3.setText("Laal Gedi");
                tv4.setText("Legumes");
                tv5.setText(R.string.aa);

            }

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Acacia catechu")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ab));
                tv1.setText("Acacia catechu");
                tv2.setText("Catechu");
                tv3.setText("Khayer");
                tv4.setText("Fabaceae");
                tv5.setText(R.string.ab);
            }

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Acacia concinna")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ac));
                tv1.setText("Acacia concinna");
                tv2.setText("Soap Pod");
                tv3.setText("Shikakai");
                tv4.setText("Fabaceae");
                tv5.setText(R.string.ac);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Acacia nilotica")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ad));
                tv1.setText("Acacia nilotica");
                tv2.setText("Gum Arabic");
                tv3.setText("Babool");
                tv4.setText("Legumes");
                tv5.setText(R.string.ad);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Achyranthes aspera")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ae));
                tv1.setText("Achyranthes aspera");
                tv2.setText("Prickly Chaff Flower");
                tv3.setText("Ultekurro");
                tv4.setText("Amaranthaceae");
                tv5.setText(R.string.ae);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Aconitum ferox")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.af));
                tv1.setText("Aconitum ferox");
                tv2.setText("Aconite");
                tv3.setText("Bikhmaa");
                tv4.setText("Ranunculaceae");
                tv5.setText(R.string.af);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Aconitum heterophyllum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ag));
                tv1.setText("Aconitum heterophyllum");
                tv2.setText("Indian Aconite");
                tv3.setText("Atees");
                tv4.setText("Ranunculaceae");
                tv5.setText(R.string.ag);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Aconitum spicatum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ah));
                tv1.setText("Aconitum spicatum");
                tv2.setText("Nepali Aconite");
                tv3.setText("Bikjara");
                tv4.setText("Ranunculaceae");
                tv5.setText(R.string.ah);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Acorus calamus")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ai));
                tv1.setText("Acorus calamus");
                tv2.setText("Sweet Flag");
                tv3.setText("Bojho");
                tv4.setText("Acoraceae");
                tv5.setText(R.string.ai);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Adhatoda vasica")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.aj));
                tv1.setText("Adhatoda vasica");
                tv2.setText("Vasaka");
                tv3.setText("Asuro");
                tv4.setText("Acanthaceae");
                tv5.setText(R.string.aj);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Adiantum capillus–veneris")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ak));
                tv1.setText("Adiantum capillus–veneris");
                tv2.setText("Maiden Hair Green");
                tv3.setText("Unyu");
                tv4.setText("Pteridaceae");
                tv5.setText(R.string.ak);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Aegle marmelos")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.al));
                tv1.setText("Aegle marmelos");
                tv2.setText("Baiel Fruit");
                tv3.setText("Bael");
                tv4.setText("Rutaceae");
                tv5.setText(R.string.al); }

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Aesculus hippocastanum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.am));
                tv1.setText("Aesculus hippocastanum");
                tv2.setText("Horse Chestnut");
                tv3.setText("Paangro");
                tv4.setText("Hippocastanaceae");
                tv5.setText(R.string.am);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Albizia lebbek")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.an));
                tv1.setText("Albizia lebbek");
                tv2.setText("Lebeck Tree");
                tv3.setText("Kaalo Sirees");
                tv4.setText("Legumes");
                tv5.setText(R.string.an);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Aloe barbadensis")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ao));
                tv1.setText("Aloe barbadensis");
                tv2.setText("Aloe");
                tv3.setText("Ghiu Kumari");
                tv4.setText("Asphodelaceae");
                tv5.setText(R.string.ao);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Alstonia scholaris")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ap));
                tv1.setText("Alstonia scholaris");
                tv2.setText("Dita – Bark Tree");
                tv3.setText("Chhatiwan");
                tv4.setText("Apocynaceae");
                tv5.setText(R.string.ap);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Amomum subulatum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.aq));
                tv1.setText("Amomum subulatum");
                tv2.setText("Greater Cardamom");
                tv3.setText("Alaichi");
                tv4.setText("Zingiberaceae");
                tv5.setText(R.string.aq);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Anacyclus pyrethrum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ar));
                tv1.setText("Anacyclus pyrethrum");
                tv2.setText("Pyrethrum");
                tv3.setText("Akarkala");
                tv4.setText("Asteraceae");
                tv5.setText(R.string.ar);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Andrographis paniculata")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.as));
                tv1.setText("Andrographis paniculata");
                tv2.setText("Andrographis");
                tv3.setText("Titkaa");
                tv4.setText("Acanthaceae");
                tv5.setText(R.string.as);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Areca catechu")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.at));
                tv1.setText("Areca catechu");
                tv2.setText("Betel Nut");
                tv3.setText("Supaari");
                tv4.setText("Arecaceae");
                tv5.setText(R.string.at);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Argemone mexicana")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.au));
                tv1.setText("Argemone mexicana");
                tv2.setText("Prickly Poppy");
                tv3.setText("Thaakal");
                tv4.setText("Papaveraceae");
                tv5.setText(R.string.au);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Aristolochia indica")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.av));
                tv1.setText("Aristolochia indica");
                tv2.setText("The indian Birthwort");
                tv3.setText("Ishworee");
                tv4.setText("Aristolochiaceae");
                tv5.setText(R.string.av);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Artemisia dubia")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.aw));
                tv1.setText("Artemisia dubia");
                tv2.setText("Mugwort");
                tv3.setText("Tite Patti");
                tv4.setText("Asteraceae");
                tv5.setText(R.string.aw);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Asparagus racemosus")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ax));
                tv1.setText("Asparagus racemosus");
                tv2.setText("Asparagus");
                tv3.setText("Kurilo");
                tv4.setText("Asparagaceae");
                tv5.setText(R.string.ax);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Azadirachta indica")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ay));
                tv1.setText("Azadirachta indica");
                tv2.setText("Neem Tree");
                tv3.setText("Neem");
                tv4.setText("Meliaceae");
                tv5.setText(R.string.ay);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Berberis aristata")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ba));
                tv1.setText("Berberis aristata");
                tv2.setText("Berberry");
                tv3.setText("Chutro");
                tv4.setText("Berberidaceae");
                tv5.setText(R.string.ba);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Bergina ciliata")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.bb));
                tv1.setText("Bergina ciliata");
                tv2.setText("Bergenia");
                tv3.setText("Paakhanved");
                tv4.setText("Saxifragaceae");
                tv5.setText(R.string.bb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Betula utilis")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.bc));
                tv1.setText("Betula utilis");
                tv2.setText("Himalayan Birch");
                tv3.setText("Bhuj Paat");
                tv4.setText("Betulaceae");
                tv5.setText(R.string.bc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Boerhavia diffusa")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.bd));
                tv1.setText("Boerhavia diffusa");
                tv2.setText("Spreading Hogweed");
                tv3.setText("Punarnavaa");
                tv4.setText("Nyctaginaceae");
                tv5.setText(R.string.bd);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Brachycorythis obcordata")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.be));
                tv1.setText("Brachycorythis obcordata");
                tv2.setText("***");
                tv3.setText("Gaamdol");
                tv4.setText("Orchidaceae");
                tv5.setText(R.string.be);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Buchanania lanzan")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.bf));
                tv1.setText("Buchanania lanzan");
                tv2.setText("Cuddapah Almods");
                tv3.setText("Chiraunjee");
                tv4.setText("Anacardiaceae");
                tv5.setText(R.string.bf);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Butea monosperma")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.bg));
                tv1.setText("Butea monosperma");
                tv2.setText("Bastard Teak");
                tv3.setText("Madaane");
                tv4.setText("Legumes");
                tv5.setText(R.string.bg);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Calotropis procera")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ca));
                tv1.setText("Calotropis procera");
                tv2.setText("Milk Weed");
                tv3.setText("Aank");
                tv4.setText("Apocynaceae");
                tv5.setText(R.string.ca);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Cannabis sativa")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cb));
                tv1.setText("Cannabis sativa");
                tv2.setText("Hemp");
                tv3.setText("Bhaang");
                tv4.setText("Cannabaceae");
                tv5.setText(R.string.cb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Carthamus tinctorious")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cc));
                tv1.setText("Carthamus tinctorious");
                tv2.setText("Stafflower");
                tv3.setText("Kusum");
                tv4.setText("Daisy ");
                tv5.setText(R.string.cc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Carum carvi")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cd));
                tv1.setText("Carum carvi");
                tv2.setText("Caraway");
                tv3.setText("jangalee Jiraa");
                tv4.setText("Umbelifers");
                tv5.setText(R.string.cd);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Cassia fistula")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ce));
                tv1.setText("Cassia fistula");
                tv2.setText("Indian Laburnum");
                tv3.setText("Amaltaash");
                tv4.setText("Legumes");
                tv5.setText(R.string.ce);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Cassia tora")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cf));
                tv1.setText("Cassia tora");
                tv2.setText("Ringworm Plant");
                tv3.setText("Chakramandee");
                tv4.setText("Caesulpinaceae");
                tv5.setText(R.string.cf);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Cedrus deodara")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cg));
                tv1.setText("Cedrus deodara");
                tv2.setText("Himalayan cedar");
                tv3.setText("Devdar");
                tv4.setText("Pinaceae");
                tv5.setText(R.string.cg);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Centella asiatica")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ch));
                tv1.setText("Centella asiatica");
                tv2.setText("Indian Pennywort");
                tv3.setText("Ghodtaapre");
                tv4.setText("Umbelifers");
                tv5.setText(R.string.ch);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Chamomilla recutita")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ci));
                tv1.setText("Chamomilla recutita");
                tv2.setText("Chamomile");
                tv3.setText("Chamomile");
                tv4.setText("Daisy ");
                tv5.setText(R.string.ci);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Cinnamomum zeylanicum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cj));
                tv1.setText("Cinnamomum zeylanicum");
                tv2.setText("Cinnmon bark");
                tv3.setText("Taj");
                tv4.setText("Lauraceae");
                tv5.setText(R.string.cj);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Coleus forskohlii")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ck));
                tv1.setText("Coleus forskohlii");
                tv2.setText("Indian Coleus");
                tv3.setText("Paasaanved");
                tv4.setText("Lamiaceae");
                tv5.setText(R.string.ck);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Commiphora mukul/hook")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cl));
                tv1.setText("Commiphora mukul/hook");
                tv2.setText("Indian Myrrh");
                tv3.setText("Gokuldhup");
                tv4.setText("Burseraceae");
                tv5.setText(R.string.cl);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Crocus sativus")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cm));
                tv1.setText("Crocus sativus");
                tv2.setText("Saffron");
                tv3.setText("Keshar");
                tv4.setText("Iridaceae");
                tv5.setText(R.string.cm);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Croton tiglium")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cn));
                tv1.setText("Croton tiglium");
                tv2.setText("Purgative Croton");
                tv3.setText("Lapche Bis");
                tv4.setText("Euphorbiaceae");
                tv5.setText(R.string.cn);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Curculigo orchioides")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.co));
                tv1.setText("Curculigo orchioides");
                tv2.setText("Curculigo");
                tv3.setText("Kaalo musalee");
                tv4.setText("Ranunculaceae");
                tv5.setText(R.string.co);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Curcuma longa")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cp));
                tv1.setText("Curcuma longa");
                tv2.setText("Turmeric");
                tv3.setText("Hardi");
                tv4.setText("Zingiberaceae");
                tv5.setText(R.string.cp);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Curcuma zedoaria")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cq));
                tv1.setText("Curcuma zedoaria");
                tv2.setText("Zedoary");
                tv3.setText("Kachur");
                tv4.setText("Zingiberaceae");
                tv5.setText(R.string.cq);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Cymbopogon martinil")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cr));
                tv1.setText("Cymbopogon martinil");
                tv2.setText("Palmarosa");
                tv3.setText("Paamaarosa");
                tv4.setText("Grasses");
                tv5.setText(R.string.cr);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Cyperus scariosus")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cs));
                tv1.setText("Cyperus scariosus");
                tv2.setText("***");
                tv3.setText("Naagarmothe");
                tv4.setText("Sedges");
                tv5.setText(R.string.cs);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Dactylorhiza hatagirea")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.da));
                tv1.setText("Dactylorhiza hatagirea");
                tv2.setText("Salep Orchid");
                tv3.setText("Paanch Aunle");
                tv4.setText("Orchidoideae");
                tv5.setText(R.string.da);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Datura metel")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.db));
                tv1.setText("Datura metel");
                tv2.setText("Thorn Apple");
                tv3.setText("Dhaturo");
                tv4.setText("Nightshade");
                tv5.setText(R.string.db);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Delphinium denudatum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dc));
                tv1.setText("Delphinium denudatum");
                tv2.setText("Larkspur");
                tv3.setText("Nirbisi");
                tv4.setText("Ranunculaceae");
                tv5.setText(R.string.dc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Didymocarpus albicalyx")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dd));
                tv1.setText("Didymocarpus albicalyx");
                tv2.setText("***");
                tv3.setText("Kumkum");
                tv4.setText("Gesneriaceae");
                tv5.setText(R.string.dd);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Dioscorea deltoidea")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.de));
                tv1.setText("Dioscorea deltoidea");
                tv2.setText("Elephants foot");
                tv3.setText("Bhyaakur");
                tv4.setText("Dioscoreaceae");
                tv5.setText(R.string.de);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Elaeocarpus sphaericus")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ea));
                tv1.setText("Elaeocarpus sphaericus");
                tv2.setText("Utrasum-bead Tree");
                tv3.setText("Rudrakshya");
                tv4.setText("Elaeocarpaceae");
                tv5.setText(R.string.ea);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Embelia ribes")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.eb));
                tv1.setText("Embelia ribes");
                tv2.setText("Embelia");
                tv3.setText("Bayubidang");
                tv4.setText("Primulaceae");
                tv5.setText(R.string.ec);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Embilica officinalis")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ec));
                tv1.setText("Embilica officinalis");
                tv2.setText("Emblic Myrobalan");
                tv3.setText("Amlaa");
                tv4.setText("Phyllanthaceae");
                tv5.setText(R.string.ec);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Ephemerantha macraei")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ed));
                tv1.setText("Ephemerantha macraei");
                tv2.setText("***");
                tv3.setText("Jiwanti");
                tv4.setText("Orchidaceae");
                tv5.setText(R.string.ed);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Evolvulus alsinoides")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ee));
                tv1.setText("Evolvulus alsinoides");
                tv2.setText("Dwarf morning-Glory");
                tv3.setText("Shankha puspi");
                tv4.setText("Convolvulaceae");
                tv5.setText(R.string.ee);
            }

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Ficus benghalensis")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.fa));
                tv1.setText("Ficus benghalensis");
                tv2.setText("Banyan Tree");
                tv3.setText("Bar");
                tv4.setText("Moraceae");
                tv5.setText(R.string.fa);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Ficus religiosa")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.fb));
                tv1.setText("Ficus religiosa");
                tv2.setText("Sacred Fig");
                tv3.setText("Pipal");
                tv4.setText("Moraceae");
                tv5.setText(R.string.fb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Fritillaria cirrhosa")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.fc));
                tv1.setText("Fritillaria cirrhosa");
                tv2.setText("Fritillary");
                tv3.setText("Kaakolee");
                tv4.setText("Liliaceae");
                tv5.setText(R.string.fc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Gaultheria frangrans")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ga));
                tv1.setText("Gaultheria frangrans");
                tv2.setText("Wintergreen");
                tv3.setText("Dhasingre");
                tv4.setText("Ericaceae");
                tv5.setText(R.string.ga);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Gentiana kurroo")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.gb));
                tv1.setText("Gentiana kurroo");
                tv2.setText("Himalayan Gentian");
                tv3.setText("Chunetroghaans");
                tv4.setText("Gentianaceae");
                tv5.setText(R.string.gb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Geranium nepalense")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.gc));
                tv1.setText("Geranium nepalense");
                tv2.setText("Nepali Geranium");
                tv3.setText("Chunetroghaans");
                tv4.setText("Geraniaceae");
                tv5.setText(R.string.gc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Gloriosa superba")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.gd));
                tv1.setText("Gloriosa superba");
                tv2.setText("Glory Lily");
                tv3.setText("Kewaree");
                tv4.setText("Colchicaceae");
                tv5.setText(R.string.gd);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Glycyrrhiz glabra")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ge));
                tv1.setText("Glycyrrhiz glabra");
                tv2.setText("Liquorice");
                tv3.setText("Jethimadhu");
                tv4.setText("Legumes");
                tv5.setText(R.string.ge);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Gmelina arborea")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.gf));
                tv1.setText("Gmelina arborea");
                tv2.setText("Candahar Tree");
                tv3.setText("Khamaaree");
                tv4.setText("Verbenaceae");
                tv5.setText(R.string.gf);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Gossypium arboreum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.gg));
                tv1.setText("Gossypium arboreum");
                tv2.setText("Cotton Plant");
                tv3.setText("Kapaas");
                tv4.setText("Mallows");
                tv5.setText(R.string.gg);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Hemidesmus indicus")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ha));
                tv1.setText("Hemidesmus indicus");
                tv2.setText("Indian Sarsaparilla");
                tv3.setText("Anantmul");
                tv4.setText("Apocynaceae");
                tv5.setText(R.string.ha);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Hibiscus rosa")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hb));
                tv1.setText("Hibiscus rosa");
                tv2.setText("Shoe-Flower");
                tv3.setText("Japaa Puspi");
                tv4.setText("Mallows");
                tv5.setText(R.string.hb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Holarrhena antidysenterica")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hc));
                tv1.setText("Holarrhena antidysenterica");
                tv2.setText("Easter Tree");
                tv3.setText("Indrajau");
                tv4.setText("Apocynaceae");
                tv5.setText(R.string.hc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Hyoscyamus niger")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hd));
                tv1.setText("Hyoscyamus niger");
                tv2.setText("Black Henbane");
                tv3.setText("Khursaanee Ajaon");
                tv4.setText("Nightshade");
                tv5.setText(R.string.hd);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Hypercium perforatum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.he));
                tv1.setText("Hypercium perforatum");
                tv2.setText("St. John’s Wort");
                tv3.setText("Urilo");
                tv4.setText("Apocynaceae");
                tv5.setText(R.string.he);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Ichnocarpus frutescens")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ia));
                tv1.setText("Ichnocarpus frutescens");
                tv2.setText("Black Creeper");
                tv3.setText("Kaaleedudhee");
                tv4.setText("Apocynaceae");
                tv5.setText(R.string.ia);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Inula racemosa")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ib));
                tv1.setText("Inula racemosa");
                tv2.setText("Elecampane");
                tv3.setText("Puskar mul");
                tv4.setText("Daisy ");
                tv5.setText(R.string.ib);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Juglans regia")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ja));
                tv1.setText("Juglans regia");
                tv2.setText("Walnut");
                tv3.setText("Okhar");
                tv4.setText("Juglandaceae");
                tv5.setText(R.string.ja);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Juniperous communis")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.jb));
                tv1.setText("Juniperous communis");
                tv2.setText("Juniper");
                tv3.setText("Dhupi");
                tv4.setText("Cypress");
                tv5.setText(R.string.jb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Leptadenia reticulata")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.la));
                tv1.setText("Leptadenia reticulata");
                tv2.setText("***");
                tv3.setText("Daadeesaak");
                tv4.setText("Asclepiadaceae");
                tv5.setText(R.string.la);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Linum usitatissinum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.lb));
                tv1.setText("Linum usitatissinum");
                tv2.setText("Linseed");
                tv3.setText("Tisi");
                tv4.setText("Linaceae");
                tv5.setText(R.string.lb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Lycopodium japonicum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.lc));
                tv1.setText("Lycopodium japonicum");
                tv2.setText("Lycopodium");
                tv3.setText("Naagbeli");
                tv4.setText("Lycopodiaceae");
                tv5.setText(R.string.lc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Martynia annua")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ma));
                tv1.setText("Martynia annua");
                tv2.setText("Devil’s Claw");
                tv3.setText("Gridharnakkee");
                tv4.setText("Martyniaceae");
                tv5.setText(R.string.ma);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Mentha piperita")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.mb));
                tv1.setText("Mentha piperita");
                tv2.setText("Pepper Mint");
                tv3.setText("Pudinaa");
                tv4.setText("Lamiaceae");
                tv5.setText(R.string.mb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Mesua ferrea")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.mc));
                tv1.setText("Mesua ferrea");
                tv2.setText("Cobra’s Saffron");
                tv3.setText("Naageswari");
                tv4.setText("Calophyllaceae");
                tv5.setText(R.string.mc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Momordica charantia")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.md));
                tv1.setText("Momordica charantia");
                tv2.setText("Bitter Gourd");
                tv3.setText("Karela");
                tv4.setText("Cucurbits");
                tv5.setText(R.string.md);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Morchella esculenta")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.me));
                tv1.setText("Morchella esculenta");
                tv2.setText("Honey-Combed Mushroom");
                tv3.setText("Guchhi Chyaau");
                tv4.setText("Morchellaceae");
                tv5.setText(R.string.me);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Mucuna pruriens")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.mf));
                tv1.setText("Mucuna pruriens");
                tv2.setText("Cowhage");
                tv3.setText("Kaauso");
                tv4.setText("Legumes");
                tv5.setText(R.string.mf);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Myrica esculenta")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.mg));
                tv1.setText("Myrica esculenta");
                tv2.setText("Box Myrtle");
                tv3.setText("Kaphal");
                tv4.setText("Myricaceae");
                tv5.setText(R.string.mg);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Myristica fragrans")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.mh));
                tv1.setText("Myristica fragrans");
                tv2.setText("Mace or Nutmeg");
                tv3.setText("Jaaipatri or Jattiphal");
                tv4.setText("Myristicaceae");
                tv5.setText(R.string.mh);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Nardostachys jatamansi")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.na));
                tv1.setText("Nardostachys jatamansi");
                tv2.setText("Nardus Root");
                tv3.setText("Jatamasi");
                tv4.setText("Caprifoliaceae");
                tv5.setText(R.string.na);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Nelumbo nucifera")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.nb));
                tv1.setText("Nelumbo nucifera");
                tv2.setText("Water Lily");
                tv3.setText("Kamal");
                tv4.setText("Nelumbonaceae");
                tv5.setText(R.string.nb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Ocimum sanctum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.oa));
                tv1.setText("Ocimum sanctum");
                tv2.setText("Sacred Basil");
                tv3.setText("Tulsi");
                tv4.setText("Lamiaceae");
                tv5.setText(R.string.oa);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Olea cuspidata")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ob));
                tv1.setText("Olea cuspidata");
                tv2.setText("Olive");
                tv3.setText("Kaandeloto");
                tv4.setText("Oleaceae");
                tv5.setText(R.string.ob);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Operculina turpethum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.oc));
                tv1.setText("Operculina turpethum");
                tv2.setText("Turpeth");
                tv3.setText("Nisodh");
                tv4.setText("Convolvulaceae");
                tv5.setText(R.string.oc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Ophiocordyceps sinensis")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.od));
                tv1.setText("Ophiocordyceps sinensis");
                tv2.setText("Cordyceps");
                tv3.setText("Yartsa Gumba");
                tv4.setText("Ophiocordycipitaceae");
                tv5.setText(R.string.od);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Panax pseudo-ginseng")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pa));
                tv1.setText("Panax pseudo-ginseng");
                tv2.setText("False Gingseng");
                tv3.setText("Saatgaanthe");
                tv4.setText("Araliaceae");
                tv5.setText(R.string.pb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Papaver somniferum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pb));
                tv1.setText("Papaver somniferum");
                tv2.setText("Opium poppy");
                tv3.setText("Aphim");
                tv4.setText("Papaveraceae");
                tv5.setText(R.string.pb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Paris polyphylla")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pc));
                tv1.setText("Paris polyphylla");
                tv2.setText("Herb Paris");
                tv3.setText("Satuwa");
                tv4.setText("Trilliaceae");
                tv5.setText(R.string.pc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Parmelia perlata")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pd));
                tv1.setText("Parmelia perlata");
                tv2.setText("Stone Flower");
                tv3.setText("Jhyaau");
                tv4.setText("Parmeliaceae");
                tv5.setText(R.string.pd);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Piper cubeba")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pe));
                tv1.setText("Piper cubeba");
                tv2.setText("Long Pepper");
                tv3.setText("Piplaa");
                tv4.setText("Piperaceae");
                tv5.setText(R.string.pe);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Piper longum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pf));
                tv1.setText("Piper longum");
                tv2.setText("Long Pepper");
                tv3.setText("Piplaa");
                tv4.setText("Piperaceae");
                tv5.setText(R.string.pf);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Piper mullesus")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pg));
                tv1.setText("Piper mullesus");
                tv2.setText("Round Pepper");
                tv3.setText("Pahaaari Peepal");
                tv4.setText("Piperaceae");
                tv5.setText(R.string.pg);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Pistacia integerrima")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ph));
                tv1.setText("Pistacia integerrima");
                tv2.setText("Pistacia Galls");
                tv3.setText("Kaakad Singhi");
                tv4.setText("Anacardiaceae");
                tv5.setText(R.string.ph);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Plantago ovata")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pi));
                tv1.setText("Plantago ovata");
                tv2.setText("Psyllium Husk");
                tv3.setText("Isabgol");
                tv4.setText("Plantaginaceae");
                tv5.setText(R.string.pi);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Plumbago zeylanica")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pj));
                tv1.setText("Plumbago zeylanica");
                tv2.setText("Lead Wort");
                tv3.setText("Chitu");
                tv4.setText("Plumbaginaceae");
                tv5.setText(R.string.pj);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Podophyllum hexandrum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pk));
                tv1.setText("Podophyllum hexandrum");
                tv2.setText("Himalayan May Apple");
                tv3.setText("Ban Bhantaa");
                tv4.setText("Berberidaceae");
                tv5.setText(R.string.pk);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Polypodium amoenum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pl));
                tv1.setText("Polypodium amoenum");
                tv2.setText("***");
                tv3.setText("Bishphej");
                tv4.setText("Polypodiaceae");
                tv5.setText(R.string.pl);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Pongamia pinnata")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pm));
                tv1.setText("Pongamia pinnata");
                tv2.setText("Pongam Oil Tree");
                tv3.setText("Kaarengee");
                tv4.setText("Legumes");
                tv5.setText(R.string.pm);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Pterocarpus marsupium")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pn));
                tv1.setText("Pterocarpus marsupium");
                tv2.setText("Indian Kino tree");
                tv3.setText("Bijayasal");
                tv4.setText("Legumes");
                tv5.setText(R.string.pn);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Pterocarpus santalinus")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.po));
                tv1.setText("Pterocarpus santalinus");
                tv2.setText("Red Sandal Wood");
                tv3.setText("Rakta Chandan");
                tv4.setText("Legumes");
                tv5.setText(R.string.po);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Punica granatum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pp));
                tv1.setText("Punica granatum");
                tv2.setText("Pomegranate");
                tv3.setText("Daarim");
                tv4.setText("Punicaceae");
                tv5.setText(R.string.pp);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Putranjiva roxburghil")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pq));
                tv1.setText("Putranjiva roxburghil");
                tv2.setText("***");
                tv3.setText("Putranjeevaa");
                tv4.setText("Euphorbiaceae");
                tv5.setText(R.string.pq);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Rauwolfia serpentina")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ra));
                tv1.setText("Rauwolfia serpentina");
                tv2.setText("Serpentina Root");
                tv3.setText("Chandmaruwa");
                tv4.setText("Apocynaceae");
                tv5.setText(R.string.ra);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Rhododendron lepidotum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.rb));
                tv1.setText("Rhododendron lepidotum");
                tv2.setText("Rhododendron");
                tv3.setText("Sunpatie");
                tv4.setText("Ericaceae");
                tv5.setText(R.string.rb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Ricinus communis")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.rc));
                tv1.setText("Ricinus communis");
                tv2.setText("Castor");
                tv3.setText("Andee");
                tv4.setText("Euphorbiaceae ");
                tv5.setText(R.string.rc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Roscoea purpurea")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.rd));
                tv1.setText("Roscoea purpurea");
                tv2.setText("Roscoe’s lily");
                tv3.setText("Bhadra");
                tv4.setText("Zingiberaceae");
                tv5.setText(R.string.rd);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Rubia cordifolia")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.re));
                tv1.setText("Rubia cordifolia");
                tv2.setText("Dyer’s Madder");
                tv3.setText("Majitho");
                tv4.setText("Rubiaceae ");
                tv5.setText(R.string.re);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Salmalia malabarica")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sa));
                tv1.setText("Salmalia malabarica");
                tv2.setText("Silk Cotton Tree");
                tv3.setText("Simal");
                tv4.setText("Malvaceae");
                tv5.setText(R.string.sb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Santalum album")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sb));
                tv1.setText("Santalum album");
                tv2.setText("White Sandalwood");
                tv3.setText("Seto Chandan");
                tv4.setText("Santalaceae");
                tv5.setText(R.string.sb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Sapindus mukorossi")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sc));
                tv1.setText("Sapindus mukorossi");
                tv2.setText("Soap Nut Tree");
                tv3.setText("Ritha");
                tv4.setText("Sapindaceae");
                tv5.setText(R.string.sc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Saraca asoca")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sd));
                tv1.setText("Saraca asoca");
                tv2.setText("Ashoka Tree");
                tv3.setText("Ashok");
                tv4.setText("Legumes");
                tv5.setText(R.string.sd);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Saussurea lappa")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.se));
                tv1.setText("Saussurea lappa");
                tv2.setText("Costus");
                tv3.setText("Kuth");
                tv4.setText("Daisy");
                tv5.setText(R.string.se);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Selinum tenuifolium")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sf));
                tv1.setText("Selinum tenuifolium");
                tv2.setText("Selinum");
                tv3.setText("Bhajadri");
                tv4.setText("Apiaceae");
                tv5.setText(R.string.sf);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Sida cordifolia")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sg));
                tv1.setText("Sida cordifolia");
                tv2.setText("Country Mallow");
                tv3.setText("Balu");
                tv4.setText("Mallows");
                tv5.setText(R.string.sg);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Smilax aspera")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sh));
                tv1.setText("Smilax aspera");
                tv2.setText("Rough Bird Weed");
                tv3.setText("Chobchini");
                tv4.setText("Smilacaceae");
                tv5.setText(R.string.sh);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Solanum surattens")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.si));
                tv1.setText("Solanum surattense");
                tv2.setText("Wild Egg Plant");
                tv3.setText("Gurmi Kaant");
                tv4.setText("Nightshade");
                tv5.setText(R.string.si);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Strychnos nux")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sj));
                tv1.setText("Strychnos nux");
                tv2.setText("Nux-vomica");
                tv3.setText("kuchila");
                tv4.setText("Loganiaceae");
                tv5.setText(R.string.sj);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Swertia chairayita")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sk));
                tv1.setText("Swertia chairayita");
                tv2.setText("Indian Gentian");
                tv3.setText("chirayito");
                tv4.setText("Gentianaceae");
                tv5.setText(R.string.sk);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Syzgium cumini")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sl));
                tv1.setText("Syzgium cumini");
                tv2.setText("Black plum");
                tv3.setText("Jamun");
                tv4.setText("Myrtaceae");
                tv5.setText(R.string.sl);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Tamarindus indica")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ta));
                tv1.setText("Tamarindus indica");
                tv2.setText("Tamarind");
                tv3.setText("Titri");
                tv4.setText("Legumes");
                tv5.setText(R.string.ta);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Taxus baccata")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.tb));
                tv1.setText("Taxus baccata");
                tv2.setText("Himalayan Yew");
                tv3.setText("Louth Salla");
                tv4.setText("Taxaceae");
                tv5.setText(R.string.tb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Terminalia arjuna")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.tc));
                tv1.setText("Terminalia arjuna");
                tv2.setText("Arjuna Myrobalan");
                tv3.setText("Arjun");
                tv4.setText("Combretaceae");
                tv5.setText(R.string.tc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Terminalia belerica")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.td));
                tv1.setText("Terminalia belerica");
                tv2.setText("Beleric Myrobalan");
                tv3.setText("Barro");
                tv4.setText("Combretaceae");
                tv5.setText(R.string.td);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Terminalia chebula")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.te));
                tv1.setText("Terminalia chebula");
                tv2.setText("Chebulic Myrobalan");
                tv3.setText("Harro");
                tv4.setText("Combretaceae");
                tv5.setText(R.string.te);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Tinospora cordifolia")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.tf));
                tv1.setText("Tinospora cordifolia");
                tv2.setText("Moon Creepers");
                tv3.setText("Gurjo");
                tv4.setText("Menispermaceae");
                tv5.setText(R.string.tf);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Tragia involucrata")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.tg));
                tv1.setText("Tragia involucrata");
                tv2.setText("Indian stinging Nettle");
                tv3.setText("Ut Kateri");
                tv4.setText("Euphorbiaceae ");
                tv5.setText(R.string.tg);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Tribulus terrestris")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.th));
                tv1.setText("Tribulus terrestris");
                tv2.setText("Lan Caltrops");
                tv3.setText("Gokhur");
                tv4.setText("Zygophyllaceae");
                tv5.setText(R.string.th);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Trichosanthes trisuspidata")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ti));
                tv1.setText("Trichosanthes trisuspidata");
                tv2.setText("Red Ball Snakegourd");
                tv3.setText("Indreni");
                tv4.setText("Cucurbitaceae ");
                tv5.setText(R.string.ti);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Valeriana wallichi")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.va));
                tv1.setText("Valeriana wallichi");
                tv2.setText("Indian Valerian");
                tv3.setText("Samaayo");
                tv4.setText("Caprifoliaceae");
                tv5.setText(R.string.va);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Vetiveria zizanioides")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.vb));
                tv1.setText("Vetiveria zizanioides");
                tv2.setText("Cuscus Grass");
                tv3.setText("Badhni");
                tv4.setText("Grasses");
                tv5.setText(R.string.vb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Vitis vinifera")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.vc));
                tv1.setText("Vitis vinifera");
                tv2.setText("Grape");
                tv3.setText("Daakh");
                tv4.setText("Vitaceae");
                tv5.setText(R.string.vc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Withania somnifera")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.wa));
                tv1.setText("Withania somnifera");
                tv2.setText("Withania");
                tv3.setText("Ashwagandha");
                tv4.setText("Nightshade");
                tv5.setText(R.string.wa);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Woodfordia fruticosa")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.wb));
                tv1.setText("Woodfordia fruticosa");
                tv2.setText("Fire Flame Bush");
                tv3.setText("Dhayaanro");
                tv4.setText("Lythraceae ");
                tv5.setText(R.string.wb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Zanthoxylon budrunga")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.za));
                tv1.setText("Zanthoxylon budrunga");
                tv2.setText("***");
                tv3.setText("***");
                tv4.setText("Rutaceae");
                tv5.setText(R.string.za);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Zanthoxylum oxyphyllum")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.zb));
                tv1.setText("Zanthoxylum oxyphyllum");
                tv2.setText("Toothache Tree");
                tv3.setText("Sil Timur");
                tv4.setText("Rutaceae");
                tv5.setText(R.string.zb);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Zingiber officnale")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.zc));
                tv1.setText("Zingiber officnale");
                tv2.setText("Dried Ginger");
                tv3.setText("Suntho");
                tv4.setText("Zingiberaceae");
                tv5.setText(R.string.zc);}

            else if(mToolbar.getTitle().toString().equalsIgnoreCase("Ziziphus mauritiana")){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.zd));
                tv1.setText("Ziziphus mauritiana");
                tv2.setText("Jujube");
                tv3.setText("Bayar");
                tv4.setText("Rhamnaceae");
                tv5.setText(R.string.zd);}


        }
    }
}
