package ar.com.dartech.trabajopractico2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btnConvertir, btnReiniciar;
    private RadioButton rdbDolar, rdbEuro, rdbReal;
    private EditText edtMontoDinero;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConvertir = findViewById(R.id.btnConvertir);
        btnReiniciar = findViewById(R.id.btnReiniciar);
        edtMontoDinero = findViewById(R.id.edtMontoDinero);
        txtResultado = findViewById(R.id.txtResultado);
        rdbDolar = findViewById(R.id.rdbDolar);
        rdbEuro = findViewById(R.id.rdbEuro);
        rdbReal = findViewById(R.id.rdbReal);

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarControlres();
            }
        });

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(datosValidos()){
                    convertirMoneda();
                }else{
                    Toast.makeText(MainActivity.this, "INgrese un monto", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void limpiarControlres(){
        edtMontoDinero.setText("---");
        txtResultado.setText("---");
        rdbDolar.setChecked(true);
    }

    private boolean datosValidos(){
        boolean resultado = true;

        resultado = edtMontoDinero.getText().toString().isEmpty() ? true : false;

        return resultado;

    }

    private void convertirMoneda(){
        int monto = Integer.parseInt(edtMontoDinero.getText().toString());
        int cotizacion =0;

        if(rdbDolar.isChecked()) {
            cotizacion = 75;
        }

        if(rdbEuro.isChecked()){
            cotizacion = 82;
        }

        if(rdbReal.isChecked()){
            cotizacion = 35;
        }

        txtResultado.setText( String.valueOf(monto * cotizacion));

    }


}
