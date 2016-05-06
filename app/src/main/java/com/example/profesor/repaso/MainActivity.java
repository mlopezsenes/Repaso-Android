package com.example.profesor.repaso;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity implements ClickItem, Handler.Callback {

    Thread tHilo;
    List<Persona> listaP = new ArrayList<Persona>();
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Persona personaUno = new Persona();
        //personaUno.setApellido("Lala");
        //personaUno.setNombre("Lele");
        //personaUno.setNumero("4234-1234");


        // listaP.add(personaUno);

        myAdapter = new MyAdapter(listaP, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(layoutManager);

        Handler h = new Handler(this);
        MiHilo mHilo = new MiHilo("http://192.168.2.126:8080/personas.csv", h);
        tHilo = new Thread(mHilo);
        tHilo.start();


        // http://www.lslutnfra.com/alumnos/practicas/personas.csv
    }

    @Override
    public void hacerClick(int position) {
        String telefono = listaP.get(position).getNumero();
        //if(this.checkSelfPermission(android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {
        Intent intent = new Intent(Intent.ACTION_CALL);

        intent.setData(Uri.parse("tel:" + telefono));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        startActivity(intent);


            Log.d("Persona", "Exception");




        Toast.makeText(this, "Se hizo click", Toast.LENGTH_LONG);
        Log.d("Hice click", "Funciona la persona");
    }

    @Override
    public void onStop(){
        super.onStop();
        tHilo.interrupt();
    }

    @Override
    public boolean handleMessage(Message msg) {

        if(msg.arg1 == 1){
            listaP.clear();
            listaP.addAll((List<Persona>)msg.obj);
            Log.d("HandlerMessaggee",listaP.size()+"");
            myAdapter.notifyDataSetChanged();

                    }
        return false;
    }
}
