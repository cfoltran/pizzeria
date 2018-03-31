package com.example.clementfoltran.pizzeria;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class PizzeriaMainActivity extends AppCompatActivity implements FragmentPizza.OnFragmentInteractionListener {

    public final static String SAUVEGARDE_NAPOLITAINE = "compteur napolitaine";
    public final static String SAUVEGARDE_ROYALE = "compteur royale";
    public final static String SAUVEGARDE_FROMAGE = "compteur 4 fromages";
    public final static String SAUVEGARDE_MONTAGNARDE = "compteur montagnarde";
    public final static String SAUVEGARDE_RACLETTE = "compteur raclette";
    public final static String SAUVEGARDE_HAWAI = "compteur hawai";
    public final static String SAUVEGARDE_PANA_COTTA = "compteur pana cotta";
    public final static String SAUVEGARDE_TIRAMISU = "compteur tiramisu";
    final static String CLE_RES = "passage du numéro de table";
    public static int tableNum;
    public static String num;

    FragmentPreferences fragmentPreferences = new FragmentPreferences();


    /*
    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAUVEGARDE_NAPOLITAINE, napolitaine);
        outState.putInt(SAUVEGARDE_ROYALE, royale);
        outState.putInt(SAUVEGARDE_FROMAGE, fromages);
        outState.putInt(SAUVEGARDE_MONTAGNARDE, montagnarde);
        outState.putInt(SAUVEGARDE_RACLETTE, raclette);
        outState.putInt(SAUVEGARDE_HAWAI, hawai);
        outState.putInt(SAUVEGARDE_PANA_COTTA, pannacotta);
        outState.putInt(SAUVEGARDE_TIRAMISU, tiramisu);
    }
    */

    @Override
    public void onFragmentInteraction(Uri uri) {
        //
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String tableText;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main);

        Intent intent = getIntent();
        tableNum = intent.getIntExtra(PizzeriaTableActivity.CLE_DONNEES, -1);
        if (tableNum == -1) {
            Log.e("testError", "ERREUR DE CLÉ");
        }

        if (tableNum > 9)
            num = ""+tableNum;
        else
            num = "0"+tableNum;
        tableText = "Numéro de table : " + num;


        TextView table = (TextView) findViewById(R.id.textTable);
        table.setText(tableText);


        //Ajoutons le Fragment pizza
        FragmentPizza fragmentPizza = new FragmentPizza();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragmentPizza);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


        /*if (savedInstanceState != null) {
            napolitaine = savedInstanceState.getInt(SAUVEGARDE_NAPOLITAINE);
            royale = savedInstanceState.getInt(SAUVEGARDE_ROYALE);
            fromages = savedInstanceState.getInt(SAUVEGARDE_FROMAGE);
            montagnarde = savedInstanceState.getInt(SAUVEGARDE_MONTAGNARDE);
            raclette = savedInstanceState.getInt(SAUVEGARDE_RACLETTE);
            hawai = savedInstanceState.getInt(SAUVEGARDE_HAWAI);
            pannacotta = savedInstanceState.getInt(SAUVEGARDE_PANA_COTTA);
            tiramisu = savedInstanceState.getInt(SAUVEGARDE_TIRAMISU);
            button1.setText("NOPOLITAINE "+napolitaine);
            button2.setText("ROYALE "+royale);
            button3.setText("QUATRE FROMAGES "+fromages);
            button4.setText("MONTAGNARDE " + montagnarde);
            button5.setText("RACLETTE "+raclette);
            button6.setText("HAWAI "+hawai);
            button7.setText("PANNA COTTA "+pannacotta);
            button8.setText("TIRAMISU "+tiramisu);
        }*/

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1 && resultCode == RESULT_OK)
            tableNum = intent.getIntExtra(CLE_RES, 0);
    }


    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(CLE_RES, 42);
        setResult(RESULT_OK, intent);
        super.finish();
    }

    //PARTIE 7
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings) {
            getFragmentManager().beginTransaction().addToBackStack("pref").replace(R.id.fragmentContainer, fragmentPreferences).commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        applyPref();
    }

    protected void applyPref() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPref.getBoolean(String.valueOf(getResources().getText(R.string.COLOR)), true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("ACTIVITÉ : PizzariaMain \nMÉTHODE : onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("ACTIVITÉ : PizzariaMain \nMÉTHODE : onStop");
    }

}

