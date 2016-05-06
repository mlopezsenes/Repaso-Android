package com.example.profesor.repaso;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by profesor on 05/05/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<Persona> personas;
    ClickItem cl;
    public MyAdapter(List<Persona> _personas, ClickItem click){
        this.personas = _personas;
        cl=click;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.persona_item,parent,false);
        MyViewHolder vH=new MyViewHolder(v,cl);
        return vH;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Persona p = personas.get(position);
        holder.nombre.setText(p.getNombre());
        holder.apellido.setText(p.getApellido());
        holder.telefono.setText(p.getNumero());


    }

    @Override
    public int getItemCount() {
        return personas.size();
    }
}
