package com.example.rishika.myapplication;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

import static com.example.rishika.myapplication.R.id.toolbar;

public class MedicinalPlants extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    ListView listview;
    Context context;
    ArrayList plantlist;
    ArrayAdapter<String> adapter;



    Integer [] plantimages = {
            R.drawable.aa,R.drawable.ab, R.drawable.ac,R.drawable.ad,R.drawable.ae, R.drawable.af,R.drawable.ag,R.drawable.ah, R.drawable.ai,
            R.drawable.aj,R.drawable.ak, R.drawable.al,R.drawable.am,R.drawable.an, R.drawable.ao,R.drawable.ap,R.drawable.aq, R.drawable.ar,
            R.drawable.as,R.drawable.at, R.drawable.au,R.drawable.av,R.drawable.aw, R.drawable.ax,R.drawable.ay,R.drawable.ba, R.drawable.bb,
            R.drawable.bc,R.drawable.bd, R.drawable.be,R.drawable.bf,R.drawable.bg, R.drawable.ca,R.drawable.cb,R.drawable.cc, R.drawable.cd,
            R.drawable.ce,R.drawable.cf, R.drawable.cg,R.drawable.ch,R.drawable.ci, R.drawable.cj,R.drawable.ck,R.drawable.cl, R.drawable.cm,
            R.drawable.cn,R.drawable.co, R.drawable.cp,R.drawable.cq,R.drawable.cr, R.drawable.cs,R.drawable.da,R.drawable.db, R.drawable.dc,
            R.drawable.dd,R.drawable.de, R.drawable.ea,R.drawable.eb,R.drawable.ec, R.drawable.ed,R.drawable.ee,R.drawable.fa, R.drawable.fb,
            R.drawable.fc,R.drawable.ga, R.drawable.gb,R.drawable.gc,R.drawable.gd, R.drawable.ge,R.drawable.gf,R.drawable.gg, R.drawable.ha,
            R.drawable.hb,R.drawable.hc, R.drawable.hd,R.drawable.he,R.drawable.ia, R.drawable.ib,R.drawable.ja,R.drawable.jb, R.drawable.la,
            R.drawable.lb,R.drawable.lc, R.drawable.ma,R.drawable.mb,R.drawable.mc, R.drawable.md,R.drawable.me,R.drawable.mf, R.drawable.mg,
            R.drawable.mh,R.drawable.na, R.drawable.nb,R.drawable.oa,R.drawable.ob, R.drawable.oc,R.drawable.od,R.drawable.pa, R.drawable.pb,
            R.drawable.pc,R.drawable.pd, R.drawable.pe,R.drawable.pf,R.drawable.pg, R.drawable.ph,R.drawable.pi,R.drawable.pj, R.drawable.pk,
            R.drawable.pl,R.drawable.pm, R.drawable.pn,R.drawable.po,R.drawable.pp, R.drawable.pq,R.drawable.ra,R.drawable.rb, R.drawable.rc,
            R.drawable.rd,R.drawable.re, R.drawable.sa,R.drawable.sb,R.drawable.sc, R.drawable.sd,R.drawable.se,R.drawable.sf, R.drawable.sg,
            R.drawable.sh,R.drawable.si, R.drawable.sj,R.drawable.sk,R.drawable.sl, R.drawable.ta,R.drawable.tb,R.drawable.tc, R.drawable.td,
            R.drawable.te,R.drawable.tf,R.drawable.tg, R.drawable.th,R.drawable.ti,R.drawable.va, R.drawable.vb,R.drawable.vc, R.drawable.wa,
            R.drawable.wb,R.drawable.za,R.drawable.zb, R.drawable.zc,R.drawable.zd

    };



    String [] plants = {"Abrus precatorius", "Acacia catechu", "Acacia concinna", "Acacia nilotica","Achyranthes aspera","Aconitum ferox", "Aconitum heterophyllum",
                    "Aconitum spicatum","Acorus calamus","Adhatoda vasica","Adiantum capillus–veneris", "Aegle marmelos","Aesculus hippocastanum","Albizia lebbek",
                "Aloe barbadensis","Alstonia scholaris","Amomum subulatum","Anacyclus pyrethrum","Andrographis paniculata","Areca catechu","Argemone mexicana",
            "Aristolochia indica","Artemisia dubia", "Asparagus racemosus", "Azadirachta indica","Berberis aristata","Bergina ciliata","Betula utilis",
            "Boerhavia diffusa","Brachycorythis obcordata","Buchanania lanzan","Butea monosperma","Calotropis procera","Cannabis sativa","Carthamus tinctorious",
            "Carum carvi","Cassia fistula","Cassia tora","Cedrus deodara","Centella asiatica","Chamomilla recutita","Cinnamomum zeylanicum",
            "Coleus forskohlii","Commiphora mukul/hook","Crocus sativus","Croton tiglium","Curculigo orchioides","Curcuma longa","Curcuma zedoaria",
            "Cymbopogon martinil","Cyperus scariosus","Dactylorhiza hatagirea","Datura metel","Delphinium denudatum","Didymocarpus albicalyx","Dioscorea deltoidea",
            "Elaeocarpus sphaericus","Embelia ribes","Embilica officinalis","Ephemerantha macraei","Evolvulus alsinoides","Ficus benghalensis","Ficus religiosa",
            "Fritillaria cirrhosa", "Gaultheria frangrans","Gentiana kurroo","Geranium nepalense","Gloriosa superba","Glycyrrhiz glabra","Gmelina arborea",
            "Gossypium arboreum","Hemidesmus indicus","Hibiscus rosa","Holarrhena antidysenterica","Hyoscyamus niger","Hypercium perforatum","Ichnocarpus frutescens",
            "Inula racemosa","Juglans regia","Juniperous communis","Leptadenia reticulata","Linum usitatissinum","Lycopodium japonicum","Martynia annua",
            "Mentha piperita","Mesua ferrea","Momordica charantia","Morchella esculenta","Mucuna pruriens","Myrica esculenta","Myristica fragrans",
            "Nardostachys jatamansi","Nelumbo nucifera","Ocimum sanctum","Olea cuspidata","Operculina turpethum","Ophiocordyceps sinensis","Panax pseudo-ginseng",
            "Papaver somniferum","Paris polyphylla","Parmelia perlata","Piper cubeba","Piper longum","Piper mullesus","Pistacia integerrima",
            "Plantago ovata","Plumbago zeylanica","Podophyllum hexandrum","Polypodium amoenum","Pongamia pinnata","Pterocarpus marsupium","Pterocarpus santalinus",
            "Punica granatum","Putranjiva roxburghil","Rauwolfia serpentina","Rhododendron lepidotum","Ricinus communis","Roscoea purpurea","Rubia cordifolia",
            "Salmalia malabarica","Santalum album","Sapindus mukorossi","Saraca asoca","Saussurea lappa","Selinum tenuifolium","Sida cordifolia",
            "Smilax aspera","Solanum surattense","Strychnos nux","Swertia chairayita","Syzgium cumini","Tamarindus indica","Taxus baccata",
            "Terminalia arjuna","Terminalia belerica","Terminalia chebula","Tinospora cordifolia","Tragia involucrata","Tribulus terrestris","Trichosanthes trisuspidata",
            "Valeriana wallichi","Vetiveria zizanioides","Vitis vinifera","Withania somnifera","Woodfordia fruticosa","Zanthoxylon budrunga","Zanthoxylum oxyphyllum",
            "Zingiber officnale","Ziziphus mauritiana"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinal_plants);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, plants);
        listview = (ListView) findViewById(R.id.lv);
        listview.setAdapter(adapter);
        listview.setTextFilterEnabled(true);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               /* switch (position){
                    case 0:*/
                        Intent aa = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        aa.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(aa);
                       /* break;

                    case 1:
                        Intent ab = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ab.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ab);
                        break;

                    case 2:
                        Intent ac = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ac.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ac);
                        break;

                    case 3:
                        Intent ad = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ad.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ad);
                        break;

                    case 4:
                        Intent ae = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ae.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ae);
                        break;

                    case 5:
                        Intent af = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        af.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(af);
                        break;

                    case 6:
                        Intent ag = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ag.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ag);
                        break;

                    case 7:
                        Intent ah = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ah.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ah);
                        break;

                    case 8:
                        Intent ai = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ai.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ai);
                        break;

                    case 9:
                        Intent aj = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        aj.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(aj);
                        break;

                    case 10:
                        Intent ak = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ak.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ak);
                        break;

                    case 11:
                        Intent al = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        al.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(al);
                        break;

                    case 12:
                        Intent am = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        am.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(am);
                        break;

                    case 13:
                        Intent an = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        an.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(an);
                        break;

                    case 14:
                        Intent ao = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ao.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ao);
                        break;

                    case 15:
                        Intent ap = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ap.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ap);
                        break;

                    case 16:
                        Intent aq = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        aq.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(aq);
                        break;

                    case 17:
                        Intent ar = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ar.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ar);
                        break;

                    case 18:
                        Intent as = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        as.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(as);
                        break;

                    case 19:
                        Intent at = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        at.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(at);
                        break;

                    case 20:
                        Intent au = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        au.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(au);
                        break;

                    case 21:
                        Intent av = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        av.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(av);
                        break;

                    case 22:
                        Intent aw = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        aw.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(aw);
                        break;

                    case 23:
                        Intent ax = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ax.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ax);
                        break;

                    case 24:
                        Intent ay = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ay.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ay);
                        break;

                    case 25:
                        Intent ba = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ba.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ba);
                        break;

                    case 26:
                        Intent bb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        bb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(bb);
                        break;

                    case 27:
                        Intent bc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        bc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(bc);
                        break;

                    case 28:
                        Intent bd = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        bd.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(bd);
                        break;

                    case 29:
                        Intent be = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        be.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(be);
                        break;

                    case 30:
                        Intent bf = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        bf.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(bf);
                        break;

                    case 31:
                        Intent bg = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        bg.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(bg);
                        break;

                    case 32:
                        Intent ca = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ca.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ca);
                        break;

                    case 33:
                        Intent cb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        cb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(cb);
                        break;

                    case 34:
                        Intent cc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        cc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(cc);
                        break;

                    case 35:
                        Intent cd = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        cd.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(cd);
                        break;

                    case 36:
                        Intent ce = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ce.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ce);
                        break;

                    case 37:
                        Intent cf = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        cf.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(cf);
                        break;

                    case 38:
                        Intent cg = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        cg.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(cg);
                        break;

                    case 39:
                        Intent ch = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ch.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ch);
                        break;

                    case 40:
                        Intent ci = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ci.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ci);
                        break;

                    case 41:
                        Intent cj = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        cj.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(cj);
                        break;

                    case 42:
                        Intent ck = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ck.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ck);
                        break;

                    case 43:
                        Intent cl = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        cl.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(cl);
                        break;

                    case 44:
                        Intent cm = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        cm.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(cm);
                        break;

                    case 45:
                        Intent cn = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        cn.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(cn);
                        break;

                    case 46:
                        Intent co = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        co.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(co);
                        break;

                    case 47:
                        Intent cp = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        cp.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(cp);
                        break;

                    case 48:
                        Intent cq = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        cq.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(cq);
                        break;

                    case 49:
                        Intent cr = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        cr.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(cr);
                        break;

                    case 50:
                        Intent cs = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        cs.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(cs);
                        break;

                    case 51:
                        Intent da = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        da.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(da);
                        break;

                    case 52:
                        Intent db = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        db.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(db);
                        break;

                    case 53:
                        Intent dc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        dc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(dc);
                        break;

                    case 54:
                        Intent dd = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        dd.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(dd);
                        break;

                    case 55:
                        Intent de = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        de.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(de);
                        break;

                    case 56:
                        Intent ea = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ea.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ea);
                        break;

                    case 57:
                        Intent eb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        eb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(eb);
                        break;

                    case 58:
                        Intent ec = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ec.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ec);
                        break;

                    case 59:
                        Intent ed = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ed.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ed);
                        break;

                    case 60:
                        Intent ee = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ee.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ee);
                        break;

                    case 61:
                        Intent fa = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        fa.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(fa);
                        break;

                    case 62:
                        Intent fb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        fb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(fb);
                        break;

                    case 63:
                        Intent fc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        fc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(fc);
                        break;

                    case 64:
                        Intent ga = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ga.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ga);
                        break;

                    case 65:
                        Intent gb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        gb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(gb);
                        break;

                    case 66:
                        Intent gc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        gc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(gc);
                        break;

                    case 67:
                        Intent gd = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        gd.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(gd);
                        break;

                    case 68:
                        Intent ge = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ge.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ge);
                        break;

                    case 69:
                        Intent gf = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        gf.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(gf);
                        break;

                    case 70:
                        Intent gg = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        gg.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(gg);
                        break;

                    case 71:
                        Intent ha = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ha.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ha);
                        break;

                    case 72:
                        Intent hb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        hb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(hb);
                        break;

                    case 73:
                        Intent hc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        hc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(hc);
                        break;

                    case 74:
                        Intent hd = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        hd.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(hd);
                        break;

                    case 75:
                        Intent he = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        he.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(he);
                        break;

                    case 76:
                        Intent ia = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ia.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ia);
                        break;

                    case 77:
                        Intent ib = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ib.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ib);
                        break;

                    case 78:
                        Intent ja = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ja.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ja);
                        break;

                    case 79:
                        Intent jb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        jb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(jb);
                        break;

                    case 80:
                        Intent la = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        la.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(la);
                        break;

                    case 81:
                        Intent lb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        lb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(lb);
                        break;

                    case 82:
                        Intent lc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        lc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(lc);
                        break;

                    case 83:
                        Intent ma = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ma.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ma);
                        break;

                    case 84:
                        Intent mb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        mb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(mb);
                        break;

                    case 85:
                        Intent mc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        mc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(mc);
                        break;

                    case 86:
                        Intent md = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        md.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(md);
                        break;

                    case 87:
                        Intent me = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        me.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(me);
                        break;

                    case 88:
                        Intent mf = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        mf.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(mf);
                        break;

                    case 89:
                        Intent mg = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        mg.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(mg);
                        break;

                    case 90:
                        Intent mh = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        mh.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(mh);
                        break;

                    case 91:
                        Intent na = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        na.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(na);
                        break;

                    case 92:
                        Intent nb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        nb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(nb);
                        break;

                    case 93:
                        Intent oa = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        oa.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(oa);
                        break;

                    case 94:
                        Intent ob = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ob.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ob);
                        break;

                    case 95:
                        Intent oc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        oc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(oc);
                        break;

                    case 96:
                        Intent od = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        od.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(od);
                        break;

                    case 97:
                        Intent pa = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pa.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pa);
                        break;

                    case 98:
                        Intent pb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pb);
                        break;

                    case 99:
                        Intent pc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pc);
                        break;

                    case 100:
                        Intent pd = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pd.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pd);
                        break;

                    case 101:
                        Intent pe = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pe.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pe);
                        break;

                    case 102:
                        Intent pf = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pf.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pf);
                        break;

                    case 103:
                        Intent pg = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pg.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pg);
                        break;

                    case 104:
                        Intent ph = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ph.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ph);
                        break;

                    case 105:
                        Intent pi = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pi.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pi);
                        break;

                    case 106:
                        Intent pj = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pj.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pj);
                        break;

                    case 107:
                        Intent pk = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pk.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pk);
                        break;

                    case 108:
                        Intent pl = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pl.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pl);
                        break;

                    case 109:
                        Intent pm = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pm.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pm);
                        break;

                    case 110:
                        Intent pn = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pn.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pn);
                        break;

                    case 111:
                        Intent po = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        po.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(po);
                        break;

                    case 112:
                        Intent pp = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pp.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pp);
                        break;

                    case 113:
                        Intent pq = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        pq.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(pq);
                        break;

                    case 114:
                        Intent ra = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ra.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ra);
                        break;

                    case 115:
                        Intent rb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        rb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(rb);
                        break;

                    case 116:
                        Intent rc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        rc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(rc);
                        break;

                    case 117:
                        Intent rd = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        rd.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(rd);
                        break;

                    case 118:
                        Intent re = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        re.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(re);
                        break;

                    case 119:
                        Intent sa = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        sa.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(sa);
                        break;

                    case 120:
                        Intent sb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        sb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(sb);
                        break;

                    case 121:
                        Intent sc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        sc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(sc);
                        break;

                    case 122:
                        Intent sd = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        sd.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(sd);
                        break;

                    case 123:
                        Intent se = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        se.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(se);
                        break;

                    case 124:
                        Intent sf = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        sf.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(sf);
                        break;

                    case 125:
                        Intent sg = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        sg.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(sg);
                        break;

                    case 126:
                        Intent sh = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        sh.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(sh);
                        break;

                    case 127:
                        Intent si = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        si.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(si);
                        break;

                    case 128:
                        Intent sj = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        sj.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(sj);
                        break;

                    case 129:
                        Intent sk = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        sk.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(sk);
                        break;

                    case 130:
                        Intent sl = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        sl.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(sl);
                        break;

                    case 131:
                        Intent ta = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ta.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ta);
                        break;

                    case 132:
                        Intent tb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        tb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(tb);
                        break;

                    case 133:
                        Intent tc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        tc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(tc);
                        break;

                    case 134:
                        Intent td = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        td.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(td);
                        break;

                    case 135:
                        Intent te = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        te.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(te);
                        break;

                    case 136:
                        Intent tf = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        tf.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(tf);
                        break;

                    case 137:
                        Intent tg = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        tg.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(tg);
                        break;

                    case 138:
                        Intent th = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        th.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(th);
                        break;

                    case 139:
                        Intent ti = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        ti.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(ti);
                        break;

                    case 140:
                        Intent va = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        va.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(va);
                        break;

                    case 141:
                        Intent vb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        vb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(vb);
                        break;

                    case 142:
                        Intent vc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        vc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(vc);
                        break;

                    case 143:
                        Intent wa = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        wa.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(wa);
                        break;

                    case 144:
                        Intent wb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        wb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(wb);
                        break;

                    case 145:
                        Intent za = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        za.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(za);
                        break;

                    case 146:
                        Intent zb = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        zb.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(zb);
                        break;

                    case 147:
                        Intent zc = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        zc.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(zc);
                        break;

                    case 148:
                        Intent zd = new Intent(MedicinalPlants.this, PlantsDetail.class);
                        zd.putExtra("Plants",listview.getItemAtPosition(position).toString());
                        startActivity(zd);
                        break;


                }*/
            }
        });
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem item = menu.findItem(R.id.menusearch);
        SearchView searchView = (SearchView) item.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newtext) {
                adapter.getFilter().filter(newtext);
                return true;

            }
        });
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
        return true;
    }
}
