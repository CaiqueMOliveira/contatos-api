package br.com.creativesoftwares.contatosapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by 16254840 on 14/11/2017.
 */

public class ContatoAdapter extends ArrayAdapter<Contato> {

    public ContatoAdapter(Context ctx, ArrayList<Contato> item){
        super(ctx, 0, item);
    }


    // METODO getView PARA CRIAR CADA ELEMENTO DA LIST VIEW
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if (v == null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item, null);
        }

        Contato item = getItem(position);

        TextView txtNome = v.findViewById(R.id.txt_nome_contato);
        TextView txtTelefone = v.findViewById(R.id.txt_telefone_contato);
        ImageView imgContato = v.findViewById(R.id.img_contato);

        txtNome.setText(item.getNome());
        txtTelefone.setText(item.getTelefone());

//        String debug = "http://10.0.2.2/ContactsAPI/"+item.getFoto();

        Picasso.with(getContext())
                .load("http://10.0.2.2/ContactsAPI/img/"+item.getFoto())
                .into(imgContato);

        return v;
    }
}
