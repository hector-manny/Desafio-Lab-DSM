package com.hector.appcalculodesueldo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre;
    EditText txtSalario;
    EditText txtTiempoTrabajado;

    String nombre;
    String salario;
    String tiempoTrabajado;

    Toast notificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtSalario = findViewById(R.id.txtSalario);
        txtTiempoTrabajado = findViewById(R.id.txtTiempoTrabajado);
    }

    public void calcularSalario(View v) {
        nombre = txtNombre.getText().toString();
        salario = txtSalario.getText().toString();
        tiempoTrabajado = txtTiempoTrabajado.getText().toString();

        float valorSalario;
        float valorTiempoTrabajado;

        //Validando que todos los campos se encuentren llenados
        if (validarCampoLlenado(nombre) && validarCampoLlenado(salario) && validarCampoLlenado(tiempoTrabajado)) {

            //Validando que los campos para el salario y el tiempo de antiguedad contengan un valor numerico
            if (!isNumeric(salario) || !isNumeric(tiempoTrabajado)){
                notificacion = Toast.makeText(this,"El salario y tiempo trabajdo deben ser valores numericos",Toast.LENGTH_LONG);
                notificacion.show();
            }else{

                valorSalario = Float.parseFloat(salario);
                valorTiempoTrabajado = Float.parseFloat(tiempoTrabajado);

                //Validando que el salario sea mayor o igual que 100 y el tiempo trabajado no sea negativo
                if(valorSalario >= 100 && valorTiempoTrabajado >= 0){
                    Intent i = new Intent(this,resultados.class);
                    i.putExtra("nombre", nombre);
                    i.putExtra("salario", salario);
                    i.putExtra("tiempoTrabajado",tiempoTrabajado);
                    startActivity(i);
                    limpiarCampos();
                }else{
                    notificacion = Toast.makeText(this,"El salario debe ser mayor o igual que 100 y el tiempo de antiguedad mayor o igual que 0",Toast.LENGTH_LONG);
                    notificacion.show();
                }
            }
        }else{
            notificacion = Toast.makeText(this,"Todos los campos deben ser completados",Toast.LENGTH_LONG);
            notificacion.show();
        }

    }

    //Funcion para validar que los campos no se encuentren vacíos
    public static boolean validarCampoLlenado(String valor) {

        if (valor.equals("") || valor.equals(" ")) {
            return false;
        } else {
            return true;
        }

    }

    //Función para validar si un valor es de tipo numero
    private static boolean isNumeric(String cadena){
        try {
            Float.parseFloat(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    private void limpiarCampos(){
        txtNombre.setText("");
        txtSalario.setText("");
        txtTiempoTrabajado.setText("");
    }
}
