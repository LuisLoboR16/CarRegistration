package com.example.luisanibal.carregister;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class RegistrarCarro extends AppCompatActivity {
    private EditText cajaPlaca, cajaPrecio;
    private Spinner cmbMarca,cmbModelo,cmbColor;
    private ArrayAdapter<String> adapter,adapter2,adapter3;
    private String opc[],opc2[],opc3[];
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_carro);

        cajaPlaca = findViewById(R.id.txtPlaca);
        cajaPrecio = findViewById(R.id.txtPrecio);
        cmbMarca = findViewById(R.id.cmbMarca);
        cmbModelo = findViewById(R.id.cmbModelo);
        cmbColor = findViewById(R.id.cmbColor);

        opc = this.getResources().getStringArray(R.array.marcas);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        cmbMarca.setAdapter(adapter);

        opc2 = this.getResources().getStringArray(R.array.modelos);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc2);
        cmbModelo.setAdapter(adapter2);

        opc3 = this.getResources().getStringArray(R.array.colores);
        adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc3);
        cmbColor.setAdapter(adapter3);

        fotos = new ArrayList<Integer>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
    }

    public void guardar(View v){
        String placa;
        int marca,modelo,color,precio,foto;
        if(validar()){
        foto = Metodos.fotoAleatoria(fotos);
        placa = cajaPlaca.getText().toString();
        marca = cmbMarca.getSelectedItemPosition();
        modelo = cmbModelo.getSelectedItemPosition();
        color = cmbColor.getSelectedItemPosition();
        precio = Integer.parseInt(cajaPrecio.getText().toString());

            Carro c = new Carro(foto,placa,marca,modelo,color,precio);
            c.guardar();
            Snackbar.make(v,getResources().getString(R.string.mensaje_guardado),Snackbar.LENGTH_SHORT)
                    .setAction("Action",null).show();
            limpiar();

        }
    }

    public void limpiar(){
        cajaPlaca.setText("");
        cajaPrecio.setText("");
        cmbMarca.setSelection(0);
        cmbModelo.setSelection(0);
        cmbColor.setSelection(0);
        cajaPlaca.requestFocus();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(RegistrarCarro.this,Principal.class);
        startActivity(i);
    }

    public boolean validar(){
        if (cajaPlaca.getText().toString().isEmpty() ){
            //Toast.makeText(getApplicationContext(), "Digite por favor el nombre" , Toast.LENGTH_SHORT).show();
            cajaPlaca.setError(getResources().getString(R.string.error_1));
            return false;
        }else{
            if(cajaPrecio.getText().toString().isEmpty() ){
                //Toast.makeText(getApplicationContext(), "Digite por favor el nombre" , Toast.LENGTH_SHORT).show();
                cajaPrecio.setError(getResources().getString(R.string.error_2));
                return false;
            }
        }
        return true;
    }
}
