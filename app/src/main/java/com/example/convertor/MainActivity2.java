package com.example.convertor;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity2 extends AppCompatActivity {
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Inicia el temporizador cuando se crea la actividad
        startCountDownTimer();
    }

    private void startCountDownTimer() {
        countDownTimer = new CountDownTimer(3000, 1000) {
            // 3000 milisegundos en total, se decrementa en intervalos de 1000 milisegundos (1 segundo)

            @Override
            public void onTick(long millisUntilFinished) {
                // Este método se llama cada segundo mientras el temporizador está en marcha
                // Puedes realizar acciones en cada tick si es necesario
            }

            @Override
            public void onFinish() {
                // Este método se llama cuando el temporizador llega a cero
                // Aquí puedes realizar la acción que deseas después de 3 segundos sin presionar un botón
                Log.d("CountDownTimer", "¡Tiempo agotado!");

                // Redirige a MainActivity
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);

                // Cierra la actividad actual
                finish();
            }
        };

        // Inicia el temporizador
        countDownTimer.start();
    }



}