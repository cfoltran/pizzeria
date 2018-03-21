package com.example.clementfoltran.pizzeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PizzeriaTableActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String SAUVEGARDE_SAISIE = "Sauvegarde du champ text";
    final static String CLE_DONNEES = "passage numTable";
    private Button validateButton;
    private EditText textField;
    private int tableNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pizzeria_table);

        validateButton = findViewById(R.id.validateButton);
        validateButton.setOnClickListener(this);

        textField = findViewById(R.id.textTable);
    }

    @Override
    public void onClick(View view) {
        tableNum = Integer.valueOf(textField.getText().toString());
        if (view.getId() == R.id.validateButton) {
            Intent intent = new Intent(this, PizzeriaMainActivity.class);
            intent.putExtra(CLE_DONNEES, tableNum);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("ACTIVITÉ : PizzariaTable \nMÉTHODE : onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("ACTIVITÉ : PizzariaTable \nMÉTHODE : onStop");
    }
}
