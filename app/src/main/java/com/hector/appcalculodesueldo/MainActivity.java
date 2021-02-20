package com.hector.appcalculodesueldo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre;
    EditText txtSalario;
    EditText txtTiempoTrabajado;
    Button enviar;

    String nombre;
    String salario;
    String tiempoTrabajado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = findViewById(R.id.);
        txtSalario = findViewById(R.id.);
        txtTiempoTrabajado = findViewById(R.id.);
        enviar = findViewById(R.id.btnEnviar);
    }

    public void enviarDatos() {
        nombre = txtNombre.getText().toString();
        salario = txtSalario.getText().toString();
        tiempoTrabajado = txtTiempoTrabajado.getText().toString();

        if (validarCampoLlenado(nombre) && validarCampoLlenado(salario) && validarCampoLlenado(tiempoTrabajado)) {
            if ()
        }

    }

    public static boolean validarCampoLlenado(String valor) {

        if (valor == "" || valor == " ") {
            return false;
        } else {
            return true;
        }

    }

    public static boolean isNumeric(String string) {
        boolean result;

        try {
            Double.parseDouble(string);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }

        return result;
    }
}
