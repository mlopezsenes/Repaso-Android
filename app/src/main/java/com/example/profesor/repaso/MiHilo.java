package com.example.profesor.repaso;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by profesor on 05/05/2016.
 */
public class MiHilo implements Runnable{

    String uri;
    Handler handler;

    public MiHilo(String uri, Handler handler){
        this.uri = uri;
        this.handler = handler;

    }

    @Override
    public void run() {
        HttpManager httpM = new HttpManager(uri);
        try {

            String strPersona = httpM.getStrDataByGET();
            Log.d("Persona: ", strPersona);
            String[] strSplit = strPersona.split(System.lineSeparator());

            List<Persona> listPersona = new ArrayList<Persona>();

            for (String s : strSplit){
                String[] sDatos = s.split(";");

                Persona per = new Persona(sDatos[0],sDatos[1],sDatos[2],sDatos[3]);

                listPersona.add(per);

            }

            Message mes = new Message();
            mes.obj = listPersona;
            mes.arg1 = 1;
            handler.sendMessage(mes);

            Log.d("Persona: ", strPersona);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Persona: Log ", e.getMessage());
        }
    }
}
