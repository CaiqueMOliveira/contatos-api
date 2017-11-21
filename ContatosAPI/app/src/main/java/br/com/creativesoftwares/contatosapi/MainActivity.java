package br.com.creativesoftwares.contatosapi;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ContatoAdapter adapter;
    final Activity CONTEXT = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // USAR PARA TELA DE INSERIR
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CONTEXT.finish();
                Snackbar.make(view, "/quit", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // *******************************************

        // CRICAO DO ADAPTER
        listView = (ListView) findViewById(R.id.list_view);
        adapter = new ContatoAdapter(this,new ArrayList<Contato>());
        listView.setAdapter(adapter);


        // FAZER A CONEXAO COM A API

        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                String retornoJson = Http.get("http://10.0.2.2/ContactsAPI/ContactsAPI.php");
                Log.d("TAG", retornoJson);

                try{
                    JSONArray jsonArray = new JSONArray(retornoJson);

                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject item = jsonArray.getJSONObject(i);

                        adapter.add(Contato.create(
                                item.getInt("id"),
                                item.getString("nome"),
                                item.getString("telefone"),
                                item.getString("imagem")));
                    }
                }catch(Exception e){
                    Log.e("ERROR", e.getMessage());
                }

                return null;
            }
        }.execute();
    }
}
