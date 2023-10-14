package com.example.convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import Models.Fahrenheit;
import Models.Kelvin;
import Models.celsius;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private celsius valorCelsius;
    private Kelvin valorKelvin;
    private Fahrenheit valorFahrenheit;
    private EditText editTextKelvin;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa instancias al inicio de la actividad
        editTextKelvin = findViewById(R.id.celsc);
        Spinner spinnerOpciones = findViewById(R.id.spinnerOpciones);
        textViewResultado = findViewById(R.id.farc);

        valorCelsius = new celsius(0.0);
        valorFahrenheit= new Fahrenheit(0.0);
        valorKelvin= new Kelvin(0.0);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.opciones_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOpciones.setAdapter(adapter);

        spinnerOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Acciones a realizar cuando se selecciona un elemento
                String selectedItem = parentView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Seleccionado: " + selectedItem, Toast.LENGTH_SHORT).show();

                try {
                    // Intenta obtener el valor del EditText y convertirlo a double
                    String kelvinInput = editTextKelvin.getText().toString();
                    if (!kelvinInput.isEmpty()) {
                        double kelvinValue = Double.parseDouble(kelvinInput);

                        switch (position) {
                            case 0:
                                // De Kelvin a Celsius
                                celsius resultCelsiusK = valorCelsius.parse(new Kelvin(kelvinValue));
                                textViewResultado.setText("Resultado en Celsius: " + resultCelsiusK.getValor());
                                break;
                            case 1:
                                celsius resultCelsiusF = valorCelsius.parse(new Fahrenheit(kelvinValue));
                                textViewResultado.setText("Resultado en Celsius: " + resultCelsiusF.getValor());
                                break;
                            case 2:
                                Fahrenheit resultFarC = valorFahrenheit.parse(new celsius(kelvinValue));
                                textViewResultado.setText("Resultado en Fahrenheit: " + resultFarC.getValor());
                                break;
                            case 3:
                                Fahrenheit resultFarK = valorFahrenheit.parse(new Kelvin(kelvinValue));
                                textViewResultado.setText("Resultado en Fahrenheit: " + resultFarK.getValor());
                                break;
                            case 4:
                                Kelvin resultKelvC = valorKelvin.parse(new celsius(kelvinValue));
                                textViewResultado.setText("Resultado en Kelvin: " + resultKelvC.getValor());
                                break;
                            case 5:
                                Kelvin resultKelvF = valorKelvin.parse(new Fahrenheit(kelvinValue));
                                textViewResultado.setText("Resultado en Kelvin: " + resultKelvF.getValor());
                                break;


                        }
                    } else {

                        Toast.makeText(MainActivity.this, "Ingresa la cantidad de grados", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    // Maneja la excepción si la conversión falla (por ejemplo, si el formato no es válido)
                    Toast.makeText(MainActivity.this, "Ingresa un valor válido para grados", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Acciones a realizar cuando no se ha seleccionado nada
            }
        });
    }
}
