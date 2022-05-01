package com.android.proyecto012spinnerimagen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Spinner spr1;

    //Escribimos un vector "pais"
    String[] pais={"ecuador","peru","Rp","panama"};
    //vector bandera, haciendo referencia a la imagen preciamente guardada
    int [] bandera = {R.drawable.banera1,R.drawable.banera2,R.drawable.bandera3,R.drawable.bandera7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spr1 = findViewById(R.id.spr_id_banderas);

        //Un adaptador propio que heradara la
        PaisesAdapter adaptador1 = new PaisesAdapter();
        spr1.setAdapter(adaptador1);
    }

    public void onClickRecuperar(View view) {
        Toast.makeText(this,spr1.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
    }

    class PaisesAdapter extends BaseAdapter{

        @Override
        //Devuelve la cantidad de elementos que contenga el vector/Array
        public int getCount() {
            //Cantidad de datos en el array
            return pais.length;
        }

        //Recuperando datos del spinner devolveremos el nombre
        @Override
        public Object getItem(int i) {
            return pais[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //Donde se graficará cada uno de los items
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            //Obtenemos referencia de esta misma clase para posteriormente insertar los elementos visuales
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            //Lo llamamos para conectar el xml con el spinner
            view = inflater.inflate(R.layout.item_spinner, null);
            //Hacemos referncia del archivo de la imagen
            ImageView iv1 = view.findViewById(R.id.id_imgv_bandera);
            //Hacemos referncia del archivo del nombre
            TextView tv1 = view.findViewById(R.id.txt_nombre_pais);
            //Conectamos el archivo xml con la imagen del vector bandera
            iv1.setImageResource(bandera[i]);
            //Conectamos el archivo xml con el texto del vector pais
            tv1.setText(pais[i]);
            return view;
        }
    }

}