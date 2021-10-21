package com.example.thinkanumber_14sl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlusz, buttonMinusz, buttonTippeles;
    private TextView textViewSzam;
    private ImageView imageViewHp1, imageViewHp2, imageViewHp3, imageViewHp4;

    private int gondoltSzam, tippeltSzam, elet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonPlusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tippeltSzam == 10) {
                    //TODO: hibaüzenetet (felugró ablakot hozzunk létre)
                } else {
                    tippeltSzam++;
                    textViewSzam.setText(String.valueOf(tippeltSzam));
                }
            }
        });

        buttonMinusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tippeltSzam == 1) {
                    //TODO: hibaüzenetet (felugró ablakot hozzunk létre)
                } else {
                    tippeltSzam--;
                    textViewSzam.setText(String.valueOf(tippeltSzam));
                }
            }
        });

        buttonTippeles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tippeltSzam < gondoltSzam) {
                    //TODO: hibaüzenetet (felugró ablakot hozzunk létre)
                    elet--;
                    eletLevon();
                } else if (tippeltSzam > gondoltSzam) {
                    elet--;
                    eletLevon();
                } else {
                    //TODO: nyertél hibaüzenet (felugró ablakot hozzunk létre)
                }
            }
        });

    }

    private void eletLevon() {
        switch (elet) {
            case 3:
                imageViewHp1.setImageResource(R.drawable.heart1);
                break;
            case 2:
                imageViewHp2.setImageResource(R.drawable.heart1);
                break;
            case 1:
                imageViewHp3.setImageResource(R.drawable.heart1);
                break;
            case 0:
                imageViewHp4.setImageResource(R.drawable.heart1);
                break;
                //TODO: játék vége hibaüzenet (felugro ablakot hozzunk létre)
        }
    }

    public void init() {
        buttonPlusz = findViewById(R.id.buttonPlusz);
        buttonMinusz = findViewById(R.id.buttonMinusz);
        buttonTippeles = findViewById(R.id.buttonTippeles);
        textViewSzam = findViewById(R.id.textViewSzam);
        imageViewHp1 = findViewById(R.id.imageHp1);
        imageViewHp2 = findViewById(R.id.imageHp2);
        imageViewHp3 = findViewById(R.id.imageHp3);
        imageViewHp4 = findViewById(R.id.imageHp4);
        Random random = new Random();
        gondoltSzam = random.nextInt(10) + 1; //1-11
        tippeltSzam = 1;
        elet = 4;
    }
}