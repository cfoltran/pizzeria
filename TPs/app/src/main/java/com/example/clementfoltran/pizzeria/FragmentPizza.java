package com.example.clementfoltran.pizzeria;


import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentPizza.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentPizza extends Fragment implements View.OnClickListener {
    private Button button1, button2, button3, button4, button5, button6, button7, button8, custom;
    private int napolitaine, royale, fromages, montagnarde, raclette, hawai, pannacotta, tiramisu;
    private int tableNum;
    public static TextView text;

    public FragmentPizza() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_pizza, container, false);

        super.onCreate(savedInstanceState);

        button1 = (Button) view.findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button) view.findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button) view.findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = (Button) view.findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = (Button) view.findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = (Button) view.findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button7 = (Button) view.findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = (Button) view.findViewById(R.id.button8);
        button8.setOnClickListener(this);

        custom = (Button) view.findViewById(R.id.custom);
        custom.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        text = (TextView) getActivity().findViewById(R.id.textTable);

        if (v.getId() == R.id.button1) {
            napolitaine++;
            button1.setText("NAPOLITAINE " + napolitaine);
            Commande nap = new Commande();
            nap.execute(PizzeriaMainActivity.num + "Napolitaine");
        }

        if (v.getId() == R.id.button2) {
            royale++;
            button2.setText("ROYALE "+royale);
            Commande nap = new Commande();
            if (tableNum > 9)
                nap.execute(tableNum + "Royale");
            else
                nap.execute("0" + tableNum + "Royale");

        }

        if (v.getId() == R.id.button3) {
            fromages++;
            button3.setText("QUATRE FROMAGES "+fromages);
            Commande nap = new Commande();
            if (tableNum > 9)
                nap.execute(tableNum + "Quatre fromages");
            else
                nap.execute("0" + tableNum + "Quatre fromages");
        }

        if (v.getId() == R.id.button4) {
            montagnarde++;
            button4.setText("MONTAGNARDE " + montagnarde);
            Commande nap = new Commande();
            if (tableNum > 9)
                nap.execute(tableNum + "Montagnarde");
            else
                nap.execute("0" + tableNum + "Montagnarde");
        }

        if (v.getId() == R.id.button5) {
            raclette++;
            button5.setText("RACLETTE "+raclette);
            Commande nap = new Commande();
            if (tableNum > 9)
                nap.execute(tableNum + "Raclette");
            else
                nap.execute("0" + tableNum + "Raclette");
        }

        if (v.getId() == R.id.button6) {
            hawai++;
            button6.setText("HAWAI "+hawai);
            Commande nap = new Commande();
            if (tableNum > 9)
                nap.execute(tableNum + "Hawai");
            else
                nap.execute("0" + tableNum + "Hawai");
        }

        if (v.getId() == R.id.button7) {
            pannacotta++;
            button7.setText("PANNA COTTA "+pannacotta);
            Commande nap = new Commande();
            if (tableNum > 9)
                nap.execute(tableNum + "Pana cotta");
            else
                nap.execute("0" + tableNum + "Panna cotta");
        }

        if (v.getId() == R.id.button8) {
            tiramisu++;
            button8.setText("TIRAMISU " + tiramisu);
            Commande nap = new Commande();
            if (tableNum > 9)
                nap.execute(tableNum + "Tiramisu");
            else
                nap.execute("0" + tableNum + "Tiramisu");
        }

        if (v.getId() == R.id.custom) {
            FragmentPizzaCustom fragmentPizzaCustom = new FragmentPizzaCustom();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, fragmentPizzaCustom);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}


