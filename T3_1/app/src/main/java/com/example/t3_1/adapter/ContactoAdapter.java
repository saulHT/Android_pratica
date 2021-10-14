package com.example.t3_1.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t3_1.R;

import java.util.List;


public class ContactoAdapter extends  RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{

    private List<String> nombre;
    private List<String> numero;

    public ContactoAdapter(List<String>nombre,List<String>numero){
        this.nombre=nombre;
        this.numero=numero;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contato_item,parent,false);

        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder holder, int position) {

        TextView tx=holder.itemView.findViewById(R.id.nombre);
        TextView tN=holder.itemView.findViewById(R.id.numero);
        String value=nombre.get(position);
        String value1=numero.get(position);

        tx.setText(value);
        tN.setText(value1);
        String celular=numero.get(position);

        Button btButllamar=holder.itemView.findViewById(R.id.but_llamar);
        btButllamar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                  //String celular="+960998211";
                  //String celular="+"+numero.get(position);
                  Intent intent=new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",celular,null));
                holder.itemView.getContext().startActivity(intent);
            }
        });

        Button btSMS=holder.itemView.findViewById(R.id.but_SMS);
        btSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String sms="";
                Intent smsInt=new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms",celular,null));
               smsInt.putExtra("sms_body",sms);
              // view.getContext().startActivity(smsInt);
               holder.itemView.getContext().startActivity(smsInt);
            }
     });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ContactoViewHolder extends RecyclerView.ViewHolder{

         public ContactoViewHolder( View itemView){
             super(itemView);
         }
    }
}
