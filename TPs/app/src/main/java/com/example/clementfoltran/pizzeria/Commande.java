package com.example.clementfoltran.pizzeria;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static com.example.clementfoltran.pizzeria.FragmentPizza.text;

/**
 * Created by clementfoltran on 21/03/2018.
 */

public class Commande extends AsyncTask<String, String, Void> {
    private int port = 9874;
    private String returnMessage2 = "";
    private String returnMessage = "";


    @Override
    protected Void doInBackground(String... values) {
        Socket socket = null;
        try {
            socket = new Socket("chadok.info", port);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Log.e("INFO", "CONNECTION ESTABLISHED ON PORT "+port);

            Log.e("Info", "Ici" + values[0]);
            writer.println(values[0]);
            returnMessage = reader.readLine();
            if (returnMessage != null)
                System.out.println(returnMessage);
            publishProgress(returnMessage);

            //force à attendre une réponse du serveur pour indiquer que le plat est prêt
            while(returnMessage2.equals("")) {
                returnMessage2 = reader.readLine();
            }
            publishProgress(returnMessage2);
            //Signaler à l'application que la pizza est prête

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        text.setText(returnMessage);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        text.setText(returnMessage2);
    }
}
