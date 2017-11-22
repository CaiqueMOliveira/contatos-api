package br.com.creativesoftwares.contatosapi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;

public class InserirActivity extends AppCompatActivity {

    EditText txtNome, txtTelefone, txtImagem;
    Activity context;
    ProgressBar progressBar;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;

        txtNome = (EditText) findViewById(R.id.txt_nome_contato);
        txtTelefone = (EditText) findViewById(R.id.txt_telefone_contato);
        txtImagem = (EditText) findViewById(R.id.txt_imagem_contato);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inserirContato();

            }
        });


    }

    public void inserirContato(){

        final String url = "http://10.0.2.2/ContactsAPI/inserir.php";

        final HashMap<String, String> valores = new HashMap<>();

        valores.put("nome", txtNome.getText().toString());
        valores.put("telefone", txtTelefone.getText().toString());
        valores.put("imagem", txtImagem.getText().toString());

        new AsyncTask<Void, Void, Void>(){

            boolean sucesso = false;
            String mensagem = "";
            ProgressDialog progress;

            @Override
            protected void onPreExecute() {
                // progress = ProgressDialog.show(context, "Enviando dados...", "Aguarde", true /* indeterminado - tempo de xecucao*/, false /* nao pode cancelar o progress*/);

                txtNome.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtImagem.setEnabled(false);

                fab.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected Void doInBackground(Void... voids) {

                //ATRASANDO A THREAD
                SystemClock.sleep(5000);

                String resultado = Http.post(url, valores);

                try{

                    // TRANSORMAÇÂO PARA JSON
                    JSONObject jsonObject = new JSONObject(resultado);

                    sucesso = jsonObject.getBoolean("sucesso");
                    mensagem = jsonObject.getString("mensagem");

                }catch (Exception e){

                    e.printStackTrace();
                    sucesso = false;
                    mensagem = "Erro ao inserir";

                }

                return null;
            }

            // CHECA SE FOI INSERIDO OOM EXITO
            @Override
            protected void onPostExecute(Void aVoid) {

                fab.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);

                // progress.dismiss();

                Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();

                if (sucesso){
                    startActivity(new Intent(context, MainActivity.class));
                }
            }

        }.execute();
    }

}
