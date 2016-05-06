package com.example.profesor.repaso;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by profesor on 05/05/2016.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView nombre;
    TextView apellido;
    TextView telefono;
    ImageView foto;
    ClickItem clickItem;

    public MyViewHolder(View v, ClickItem click)
    {
        super(v);
        nombre = (TextView) v.findViewById(R.id.tvNombre);
        apellido = (TextView) v.findViewById(R.id.tvApellido);
        telefono = (TextView) v.findViewById(R.id.tvNumero);
        foto = (ImageView) v.findViewById(R.id.imgView);
        clickItem = click;
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        clickItem.hacerClick(getAdapterPosition());
    }
}
