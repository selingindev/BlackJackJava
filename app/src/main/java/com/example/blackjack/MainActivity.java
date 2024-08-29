package com.example.blackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import kotlin.math.UMathKt;

public class MainActivity extends AppCompatActivity {
    Button buttonCompra, buttonParar;
    TextView textViewPontos, textViewPontosBanca;
    ImageView imageViewCarta;

    boolean fimJogo = false;
    int pontos = 0, pontosBanca = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCompra = findViewById(R.id.buttonComprar);
        buttonParar = findViewById(R.id.buttonParar);
        textViewPontos = findViewById(R.id.textViewPontos);
        textViewPontosBanca = findViewById(R.id.textViewPontosBanca);
        imageViewCarta = findViewById(R.id.imageViewCarta);

        imageViewCarta.setImageResource(R.drawable.mesa);

        Random random = new Random();

        buttonCompra.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (fimJogo == true) {
                    pontosBanca = 0;
                    pontos = 0;
                    textViewPontos.setText("Seus pontos: " + pontos);
                    textViewPontosBanca.setText("Pontos Da Banca: " + pontosBanca);
                    fimJogo = false;
                }
                int numero = random.nextInt(13) + 1;

                switch (numero) {
                    case 1:
                        imageViewCarta.setImageResource(R.drawable.c1);
                        break;
                    case 2:
                        imageViewCarta.setImageResource(R.drawable.c2);
                        break;
                    case 3:
                        imageViewCarta.setImageResource(R.drawable.c3);
                        break;
                    case 4:
                        imageViewCarta.setImageResource(R.drawable.c4);
                        break;
                    case 5:
                        imageViewCarta.setImageResource(R.drawable.c5);
                        break;
                    case 6:
                        imageViewCarta.setImageResource(R.drawable.c6);
                        break;
                    case 7:
                        imageViewCarta.setImageResource(R.drawable.c7);
                        break;
                    case 8:
                        imageViewCarta.setImageResource(R.drawable.c8);
                        break;
                    case 9:
                        imageViewCarta.setImageResource(R.drawable.c9);
                        break;
                    case 10:
                        imageViewCarta.setImageResource(R.drawable.c10);
                        break;
                    case 11:
                        imageViewCarta.setImageResource(R.drawable.j);
                        break;
                    case 12:
                        imageViewCarta.setImageResource(R.drawable.q);
                        break;
                    case 13:
                        imageViewCarta.setImageResource(R.drawable.k);
                        break;
                }
                numero = (numero > 10) ? 10 : numero;
                pontos += numero;

                if (pontos < 22) {
                    textViewPontos.setText("Pontos: " + pontos);
                } else {
                    textViewPontos.setText("perdeu otario");
                    fimJogo = true;
                }
            }
        });

        buttonParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                while (pontosBanca < pontos && pontos <= 21) {
                    int numero = random.nextInt(13) + 1;
                    numero = (numero > 10) ? 10 : numero;
                    pontosBanca += numero;
                    textViewPontosBanca.setText("Pontos: " + pontosBanca);
                    if (pontosBanca > 21) {
                        textViewPontos.setText("Jogador ganhou o jogo, a banca estourou");
                        textViewPontosBanca.setText("Pontos Da Banca: " + pontosBanca);
                        fimJogo = true;
                        break;
                    } else if (pontosBanca >= pontos) {
                        textViewPontos.setText("A banca ganhou o jogo, seus pontos: " + pontos);
                        textViewPontosBanca.setText("Pontos Da Banca: " + pontosBanca);
                        fimJogo = true;
                        break;
                    }
                }
            }
        });
    }
}