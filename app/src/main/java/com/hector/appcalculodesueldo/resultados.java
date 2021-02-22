package com.hector.appcalculodesueldo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class resultados extends AppCompatActivity {

    TextView txtvNombre;
    TextView txtvTiempoTrabajado;
    TextView txtvSalario;
    TextView txtvAumento;
    TextView txtvSalarioNeto;

    float salario;
    double salarioNeto;
    float tiempoTrabajado;
    String aumento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        txtvNombre = (TextView) findViewById(R.id.txtvNombre);
        txtvSalario = (TextView) findViewById(R.id.txtvSalario);
        txtvTiempoTrabajado = (TextView) findViewById(R.id.txtvTiempoTrabajado);
        txtvAumento = (TextView) findViewById(R.id.txtvAumento);
        txtvSalarioNeto = (TextView) findViewById(R.id.txtvSalarioNeto);

        Bundle bundle = getIntent().getExtras();

        String pasoSalario = bundle.getString("salario");
        String pasoTiempoTrabajado = bundle.getString("tiempoTrabajado");
        salario = Float.parseFloat(pasoSalario);
        tiempoTrabajado = Float.parseFloat(bundle.getString("tiempoTrabajado").toString());

        if(salario < 500 && tiempoTrabajado >= 10){
            aumento = "20%";
            salarioNeto = (Double) (salario*1.20);
        }else if(salario < 500 && tiempoTrabajado < 10){
            aumento = "5%";
            salarioNeto = (Double) (salario*1.05);
        }else if(salario >= 500){
            aumento = "0%";
            salarioNeto = salario;
        }

        txtvNombre.setText("Nombre del Empleado: "+bundle.getString("nombre"));
        txtvSalario.setText("Salario del Empleado: "+salario);
        txtvTiempoTrabajado.setText("Años de Antiguedad: "+tiempoTrabajado);
        txtvAumento.setText("Aumento: "+aumento);
        txtvSalarioNeto.setText("Salario Neto: "+salarioNeto);

    }

    public void regresar(View v){
        finish();
    }


}