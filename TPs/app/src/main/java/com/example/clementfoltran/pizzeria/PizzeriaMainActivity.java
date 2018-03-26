package com.example.clementfoltran.pizzeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PizzeriaMainActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String SAUVEGARDE_NAPOLITAINE = "compteur napolitaine";
    public final static String SAUVEGARDE_ROYALE = "compteur royale";
    public final static String SAUVEGARDE_FROMAGE = "compteur 4 fromages";
    public final static String SAUVEGARDE_MONTAGNARDE = "compteur montagnarde";
    public final static String SAUVEGARDE_RACLETTE = "compteur raclette";
    public final static String SAUVEGARDE_HAWAI = "compteur hawai";
    public final static String SAUVEGARDE_PANA_COTTA = "compteur pana cotta";
    public final static String SAUVEGARDE_TIRAMISU = "compteur tiramisu";
    final static String CLE_RES = "passage du numéro de table";
    public  Button button1;
    public  Button button2;
    private Button button3, button4, button5, button6, button7, button8;
    private int napolitaine, royale, fromages, montagnarde, raclette, hawai, pannacotta, tiramisu;
    private int tableNum;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String tableText;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main);

        //Intent intent = getIntent();
        //tableNum = intent.getIntExtra(PizzeriaTableActivity.CLE_DONNEES, -1);
        if (tableNum == -1) {
            Log.e("testError", "ERREUR DE CLÉ");
        }

        tableText = "Numéro de table : " + tableNum;

        TextView tableTv = findViewById(R.id.textTable);
        tableTv.setText(tableText);


        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);

        if (savedInstanceState != null) {
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
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            napolitaine++;
            button1.setText("NAPOLITAINE " + napolitaine);
            Commande nap = new Commande();
            if (tableNum > 9)
                nap.execute(tableNum + "Napolitaine");
            nap.execute("0" + tableNum + "Napolitaine");

        }

        if (v.getId() == R.id.button2) {
            royale++;
            button2.setText("ROYALE "+royale);
        }

        if (v.getId() == R.id.button3) {
            fromages++;
            button3.setText("QUATRE FROMAGES "+fromages);
        }

        if (v.getId() == R.id.button4) {
            montagnarde++;
            button4.setText("MONTAGNARDE " + montagnarde);
        }

        if (v.getId() == R.id.button5) {
            raclette++;
            button5.setText("RACLETTE "+raclette);
        }

        if (v.getId() == R.id.button6) {
            hawai++;
            button6.setText("HAWAI "+hawai);
        }

        if (v.getId() == R.id.button7) {
            pannacotta++;
            button7.setText("PANNA COTTA "+pannacotta);
        }

        if (v.getId() == R.id.button8) {
            tiramisu++;
            button8.setText("TIRAMISU "+tiramisu);
        }

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

