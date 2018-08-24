package com.example.opet.myapplication;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void carregarImoveis(View view){

        Resources res = getResources();

        InputStream is = res.openRawResource(R.raw.imobiliaria);

        Scanner scanner = new Scanner(is);

        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }

        parseJson(builder.toString());

    }

    private void parseJson(String s) {

        TextView txtDisplay = (TextView) findViewById(R.id.text_display);

        StringBuilder builder = new StringBuilder();

        try {
            JSONObject root = new JSONObject(s);

            JSONObject imobiliaria = root.getJSONObject("imoveis-imobiliaria");

            JSONArray imoveis = imobiliaria.getJSONArray("imoveis");

            for (int i = 0; i < imoveis.length(); i++){
                JSONObject imovel = imoveis.getJSONObject(i);
                builder.append(imovel.getString("id"))
                        .append(": ")
                        .append("\n")
                        .append(imovel.getString("categoria"))
                        .append(": ")
                        .append("\n")
                        .append(imovel.getString("cidade"))
                        .append("\n")
                        .append(imovel.getString("uf"))
                        .append("\n")
                        .append(imovel.getString("bairro"))
                        .append("\n")
                        .append(imovel.getString("status"))
                        .append("\n")
                        .append(imovel.getString("area_total"))
                        .append("\n")
                        .append(imovel.getString("iptu"))
                        .append("\n")
                        .append(imovel.getString("condominio"))
                        .append("\n")
                        .append(imovel.getString("planta"))
                        .append("\n")
                        .append(imovel.getString("dependencia"))
                        .append("\n")
                        .append(imovel.getString("sacada"))
                        .append("\n")
                        .append(imovel.getString("portaria"))
                        .append("\n")
                        .append(imovel.getString("elevador"))
                        .append("\n")
                        .append(imovel.getString("churrasqueira"))
                        .append("\n")
                        .append(imovel.getString("dormitorios"))
                        .append("\n")
                        .append(imovel.getString("suites"))
                        .append("\n")
                        .append(imovel.getString("vagas"))
                        .append("\n")
                        .append(imovel.getString("banheiros"))
                        .append("\n")
                        .append(imovel.getString("cep"))
                        .append("\n")
                        .append(imovel.getString("endereco"))
                        .append("\n")
                        .append(imovel.getString("numero"))
                        .append("\n")
                        .append(imovel.getString("complemento"))
                        .append("\n")
                        .append(imovel.getString("descricao"))
                        .append("\n")
                        .append(imovel.getString("latitude"))
                        .append("\n")
                        .append(imovel.getString("longitude"))
                        .append("\n")
                        .append(imovel.getString("valor_venda"))
                        .append("\n")
                        .append(imovel.getString("mostrar_mapa"))
                        .append("\n")
                        .append(imovel.getString("imagem_principal"))
                        .append("\n\n\n\n");
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


        txtDisplay.setText(builder.toString());
    }

}
