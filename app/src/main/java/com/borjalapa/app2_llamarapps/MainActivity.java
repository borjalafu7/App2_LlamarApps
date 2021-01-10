package com.borjalapa.app2_llamarapps;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
final int RESPUESTA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar(View view) {
        //creamos el intent
        Intent sendIntent = new Intent();
        //sendIntent.setPackage("com.bolapa.App1_LlamarApps");
        //le decimos la accion que va a hacer
        sendIntent.setAction(Intent.ACTION_SEND);

        //le añadimos como extra un texto plano llamado start
        sendIntent.putExtra(Intent.EXTRA_TEXT,"start");

        //le decimos el tipo de lo que le vamos a pasar
        sendIntent.setType("text/plain");

        //chooser para elegir la app que queremos abrir
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivityForResult(shareIntent, RESPUESTA);
    }

    //coges el extra del intent y lo metes en una variable texto que luego muestras en el TextView
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String texto = data.getExtras().getString("RESULTADO");
        ((TextView)findViewById(R.id.tvTexto)).setText(texto);
    }
}