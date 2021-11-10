package com.example.thinkanumber_14sl;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlusz, buttonMinusz, buttonTippeles;
    private TextView textViewSzam;
    private ImageView imageViewHp1, imageViewHp2, imageViewHp3, imageViewHp4;

    private int gondoltSzam, tippeltSzam, elet;
    private Random random;

    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonPlusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tippeltSzam == 10) {
                    //Toast hibaüzenet
                    /*Toast toast = new Toast(MainActivity.this);
                    toast.setText("10 felé nem mehetünk");
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();*/
                    Toast.makeText(MainActivity.this, "10 felé nem mehetünk", Toast.LENGTH_SHORT).show();
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
                    //Toast hibaüzenet (felugró ablak)
                    Toast.makeText(MainActivity.this, "1 alá nem mehetünk", Toast.LENGTH_SHORT).show();
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
                    //Toast hibaüzenet (felugró ablak)
                    Toast.makeText(MainActivity.this, "A gondolt szám nagyobb", Toast.LENGTH_SHORT).show();
                    elet--;
                    eletLevon();
                } else if (tippeltSzam > gondoltSzam) {
                    Toast.makeText(MainActivity.this, "A gondolt szám kisebb", Toast.LENGTH_SHORT).show();
                    elet--;
                    eletLevon();
                } else {
                    //Alert Dialog hibaüzenet (felugró ablak)
                    alertDialog.setTitle("Nyertél!");       //Kérdés a felhasználó felé
                    alertDialog.create();                   //Create akkor kell, ha valamit módosítunk a builderen
                    alertDialog.show();                     //Ez fogja mutatni a dialogot
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
                alertDialog.setTitle("Vesztettél!");
                alertDialog.create();
                alertDialog.show();
                break;
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
        random = new Random();
        gondoltSzam = random.nextInt(10) + 1; //1-11
        tippeltSzam = 1;
        elet = 4;
        AlertDialogCreate();
    }

    public void AlertDialogCreate() {
        alertDialog= new AlertDialog.Builder(MainActivity.this);
        alertDialog.setMessage("Szeretnél e új játékot?");
        alertDialog.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resetGame();
            }
        });
        alertDialog.create();
    }

    public void resetGame() {
        gondoltSzam = random.nextInt(10) + 1; //1-11
        tippeltSzam = 1;
        elet = 5;
        imageViewHp1.setImageResource(R.drawable.heart2);
        imageViewHp2.setImageResource(R.drawable.heart2);
        imageViewHp3.setImageResource(R.drawable.heart2);
        imageViewHp4.setImageResource(R.drawable.heart2);
        textViewSzam.setText(String.valueOf(tippeltSzam));
    }
}