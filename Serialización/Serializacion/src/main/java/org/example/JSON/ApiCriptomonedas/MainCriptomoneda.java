package org.example.JSON.ApiCriptomonedas;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainCriptomoneda {
    public static void main(String[] args) {
        Criptomoneda precios = null;
        try {

            String apiUrl = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum&vs_currencies=usd,eur";

            URL url = new URL(apiUrl);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                json.append(line);
            }
            in.close();

            Gson gson = new Gson();
            precios = gson.fromJson(json.toString(), Criptomoneda.class);

        } catch (Exception e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }

        System.out.println("=== PRECIOS DE CRIPTOMONEDAS ===");
        System.out.println("--------------------------------");
        System.out.println("BITCOIN:");
        System.out.println("  USD: " + precios.bitcoin.usd + " $");
        System.out.println("  EUR: " + precios.bitcoin.eur + " €\n");
        System.out.println("ETHEREUM:");
        System.out.println("  USD: " + precios.ethereum.usd + " $");
        System.out.println("  EUR: " + precios.ethereum.eur + " €");
    }
}
