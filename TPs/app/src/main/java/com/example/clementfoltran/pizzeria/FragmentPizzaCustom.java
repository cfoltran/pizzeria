package com.example.clementfoltran.pizzeria;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPizzaCustom extends Fragment implements View.OnClickListener{
    private Button mozzarella, gorgonzola, olives, anchois, capres, artichaud, jamcui, jamcru, envoyer;
    private String topping;

    public FragmentPizzaCustom() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_pizza_custom, container, false);

        super.onCreate(savedInstanceState);

        mozzarella = (Button) view.findViewById(R.id.mozzarella);
        mozzarella.setOnClickListener(this);

        gorgonzola = (Button) view.findViewById(R.id.gorgonzola);
        gorgonzola.setOnClickListener(this);

        olives = (Button) view.findViewById(R.id.olives);
        olives.setOnClickListener(this);

        anchois = (Button) view.findViewById(R.id.anchois);
        anchois.setOnClickListener(this);

        artichaud = (Button) view.findViewById(R.id.artichaud);
        artichaud.setOnClickListener(this);

        capres = (Button) view.findViewById(R.id.capres);
        capres.setOnClickListener(this);

        jamcru = (Button) view.findViewById(R.id.jamcru);
        jamcru.setOnClickListener(this);

        jamcui = (Button) view.findViewById(R.id.jamcui);
        jamcui.setOnClickListener(this);

        envoyer = (Button) view.findViewById(R.id.envoyer);
        envoyer.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.mozzarella) {
            mozzarella.setBackgroundColor(Color.WHITE);
            topping += (String) mozzarella.getText();
        }

        if (view.getId() == R.id.gorgonzola) {
            gorgonzola.setBackgroundColor(Color.WHITE);
            topping += (String) gorgonzola.getText();
        }

        if (view.getId() == R.id.olives) {
            olives.setBackgroundColor(Color.WHITE);
            topping += (String) olives.getText();
        }

        if (view.getId() == R.id.anchois) {
            anchois.setBackgroundColor(Color.WHITE);
            topping += (String) anchois.getText();
        }

        if (view.getId() == R.id.artichaud) {
            artichaud.setBackgroundColor(Color.WHITE);
            topping += (String) artichaud.getText();
        }

        if (view.getId() == R.id.capres) {
            capres.setBackgroundColor(Color.WHITE);
            topping += (String) capres.getText();
        }

        if (view.getId() == R.id.jamcru) {
            jamcru.setBackgroundColor(Color.WHITE);
            topping += (String) jamcru.getText();
        }

        if (view.getId() == R.id.jamcui) {
            jamcui.setBackgroundColor(Color.WHITE);
            topping += (String) jamcui.getText();
        }

        if (view.getId() == R.id.envoyer) {
            Commande customOrder = new Commande();
            Log.e("INFO", " "+PizzeriaMainActivity.tableNum+topping);
            customOrder.execute("0"+PizzeriaMainActivity.num+topping);


            FragmentPizza fragmentPizza = new FragmentPizza();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragementContainer, fragmentPizza);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

}
