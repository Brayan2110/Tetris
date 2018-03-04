package com.example.bvarg.tetris;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //0 cuadro
    //1 largo
    //2 L derecha
    //3 L izquierda
    //4 escalera derecha
    //5 escalera izquierda
    //6 escalera centro
    int pieza;

    //0 amarillo
    //1 azul
    //2 celeste
    //3 morado
    //4 naranje
    //5 rojo
    //6 verde
    int color;

    int[][] matriz= {{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};
    ImageView[][] matriz2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout grid = (GridLayout) findViewById(R.id.layoutTablero);
        for (int i = 0; i < grid.getChildCount(); i++){
            ImageView t = (ImageView) grid.getChildAt(i);
            t.setImageResource(R.drawable.gris2);
        }
        matriz2 = new ImageView[][]{{(ImageView)findViewById(R.id.imageView00),(ImageView)findViewById(R.id.imageView01),(ImageView)findViewById(R.id.imageView02),(ImageView)findViewById(R.id.imageView03),(ImageView)findViewById(R.id.imageView04),(ImageView)findViewById(R.id.imageView05),(ImageView)findViewById(R.id.imageView06),(ImageView)findViewById(R.id.imageView07),(ImageView)findViewById(R.id.imageView08),(ImageView)findViewById(R.id.imageView09),(ImageView)findViewById(R.id.imageView0a)},
                {(ImageView)findViewById(R.id.imageView10),(ImageView)findViewById(R.id.imageView11),(ImageView)findViewById(R.id.imageView12),(ImageView)findViewById(R.id.imageView13),(ImageView)findViewById(R.id.imageView14),(ImageView)findViewById(R.id.imageView15),(ImageView)findViewById(R.id.imageView16),(ImageView)findViewById(R.id.imageView17),(ImageView)findViewById(R.id.imageView18),(ImageView)findViewById(R.id.imageView19),(ImageView)findViewById(R.id.imageView1a)},
                {(ImageView)findViewById(R.id.imageView20),(ImageView)findViewById(R.id.imageView21),(ImageView)findViewById(R.id.imageView22),(ImageView)findViewById(R.id.imageView23),(ImageView)findViewById(R.id.imageView24),(ImageView)findViewById(R.id.imageView25),(ImageView)findViewById(R.id.imageView26),(ImageView)findViewById(R.id.imageView27),(ImageView)findViewById(R.id.imageView28),(ImageView)findViewById(R.id.imageView29),(ImageView)findViewById(R.id.imageView2a)},
                {(ImageView)findViewById(R.id.imageView30),(ImageView)findViewById(R.id.imageView31),(ImageView)findViewById(R.id.imageView32),(ImageView)findViewById(R.id.imageView33),(ImageView)findViewById(R.id.imageView34),(ImageView)findViewById(R.id.imageView35),(ImageView)findViewById(R.id.imageView36),(ImageView)findViewById(R.id.imageView37),(ImageView)findViewById(R.id.imageView38),(ImageView)findViewById(R.id.imageView39),(ImageView)findViewById(R.id.imageView3a)},
                {(ImageView)findViewById(R.id.imageView40),(ImageView)findViewById(R.id.imageView41),(ImageView)findViewById(R.id.imageView42),(ImageView)findViewById(R.id.imageView43),(ImageView)findViewById(R.id.imageView44),(ImageView)findViewById(R.id.imageView45),(ImageView)findViewById(R.id.imageView46),(ImageView)findViewById(R.id.imageView47),(ImageView)findViewById(R.id.imageView48),(ImageView)findViewById(R.id.imageView49),(ImageView)findViewById(R.id.imageView4a)},
                {(ImageView)findViewById(R.id.imageView50),(ImageView)findViewById(R.id.imageView51),(ImageView)findViewById(R.id.imageView52),(ImageView)findViewById(R.id.imageView53),(ImageView)findViewById(R.id.imageView54),(ImageView)findViewById(R.id.imageView55),(ImageView)findViewById(R.id.imageView56),(ImageView)findViewById(R.id.imageView57),(ImageView)findViewById(R.id.imageView58),(ImageView)findViewById(R.id.imageView59),(ImageView)findViewById(R.id.imageView5a)},
                {(ImageView)findViewById(R.id.imageView60),(ImageView)findViewById(R.id.imageView61),(ImageView)findViewById(R.id.imageView62),(ImageView)findViewById(R.id.imageView63),(ImageView)findViewById(R.id.imageView64),(ImageView)findViewById(R.id.imageView65),(ImageView)findViewById(R.id.imageView66),(ImageView)findViewById(R.id.imageView67),(ImageView)findViewById(R.id.imageView68),(ImageView)findViewById(R.id.imageView69),(ImageView)findViewById(R.id.imageView6a)},
                {(ImageView)findViewById(R.id.imageView70),(ImageView)findViewById(R.id.imageView71),(ImageView)findViewById(R.id.imageView72),(ImageView)findViewById(R.id.imageView73),(ImageView)findViewById(R.id.imageView74),(ImageView)findViewById(R.id.imageView75),(ImageView)findViewById(R.id.imageView76),(ImageView)findViewById(R.id.imageView77),(ImageView)findViewById(R.id.imageView78),(ImageView)findViewById(R.id.imageView79),(ImageView)findViewById(R.id.imageView7a)},
                {(ImageView)findViewById(R.id.imageView80),(ImageView)findViewById(R.id.imageView81),(ImageView)findViewById(R.id.imageView82),(ImageView)findViewById(R.id.imageView83),(ImageView)findViewById(R.id.imageView84),(ImageView)findViewById(R.id.imageView85),(ImageView)findViewById(R.id.imageView86),(ImageView)findViewById(R.id.imageView87),(ImageView)findViewById(R.id.imageView88),(ImageView)findViewById(R.id.imageView89),(ImageView)findViewById(R.id.imageView8a)},
                {(ImageView)findViewById(R.id.imageView90),(ImageView)findViewById(R.id.imageView91),(ImageView)findViewById(R.id.imageView92),(ImageView)findViewById(R.id.imageView93),(ImageView)findViewById(R.id.imageView94),(ImageView)findViewById(R.id.imageView95),(ImageView)findViewById(R.id.imageView96),(ImageView)findViewById(R.id.imageView97),(ImageView)findViewById(R.id.imageView98),(ImageView)findViewById(R.id.imageView99),(ImageView)findViewById(R.id.imageView9a)},
                {(ImageView)findViewById(R.id.imageViewa0),(ImageView)findViewById(R.id.imageViewa1),(ImageView)findViewById(R.id.imageViewa2),(ImageView)findViewById(R.id.imageViewa3),(ImageView)findViewById(R.id.imageViewa4),(ImageView)findViewById(R.id.imageViewa5),(ImageView)findViewById(R.id.imageViewa6),(ImageView)findViewById(R.id.imageViewa7),(ImageView)findViewById(R.id.imageViewa8),(ImageView)findViewById(R.id.imageViewa9),(ImageView)findViewById(R.id.imageViewaa)},
                {(ImageView)findViewById(R.id.imageViewb0),(ImageView)findViewById(R.id.imageViewb1),(ImageView)findViewById(R.id.imageViewb2),(ImageView)findViewById(R.id.imageViewb3),(ImageView)findViewById(R.id.imageViewb4),(ImageView)findViewById(R.id.imageViewb5),(ImageView)findViewById(R.id.imageViewb6),(ImageView)findViewById(R.id.imageViewb7),(ImageView)findViewById(R.id.imageViewb8),(ImageView)findViewById(R.id.imageViewb9),(ImageView)findViewById(R.id.imageViewba)}};
        azar();
        MiThread y = new MiThread();
        y.run();
    }
    public void azar() {
        pieza = (int) (Math.random() * 7);
        color = (int) (Math.random() * 7);
    }

    class MiThread extends Thread {
        @Override
        public void run() {
            switch (pieza){
                case 0:
                    if(matriz[3][4] == -1 && matriz[3][5] == -1){
                        matriz[2][4]= 7;
                        matriz[2][5]= 7;
                        matriz[3][4]= 7;
                        matriz[3][5]= 7;
                        matriz2[0][4].setImageResource(R.drawable.amarillo);
                        matriz2[0][5].setImageResource(R.drawable.amarillo);
                    }
                    else{

                    }
                    break;
                case 1:
                    if(matriz[3][5] == -1){
                        matriz[0][5]= 7;
                        matriz[1][5]= 7;
                        matriz[2][5]= 7;
                        matriz[3][5]= 7;
                        matriz2[0][5].setImageResource(R.drawable.amarillo);
                    }
                    else{

                    }
                    break;
                case 2:
                    if(matriz[3][4] == -1 && matriz[3][5] == -1){
                        matriz[0][4]= 7;
                        matriz[1][4]= 7;
                        matriz[2][4]= 7;
                        matriz[3][4]= 7;
                        matriz[3][5]= 7;
                        matriz2[0][4].setImageResource(R.drawable.amarillo);
                        matriz2[0][5].setImageResource(R.drawable.amarillo);
                    }
                    else{

                    }
                    break;
                case 3:
                    if(matriz[3][5] == -1 && matriz[3][4] == -1){
                        matriz[0][5]= 7;
                        matriz[1][5]= 7;
                        matriz[2][5]= 7;
                        matriz[3][5]= 7;
                        matriz[3][4]= 7;
                        matriz2[0][4].setImageResource(R.drawable.amarillo);
                        matriz2[0][5].setImageResource(R.drawable.amarillo);
                    }
                    else{

                    }
                    break;
                case 4:
                    if(matriz[3][4] == -1 && matriz[3][5] == -1){
                        matriz[3][4]= 7;
                        matriz[3][5]= 7;
                        matriz[2][5]= 7;
                        matriz[2][6]= 7;
                        matriz2[0][4].setImageResource(R.drawable.amarillo);
                        matriz2[0][5].setImageResource(R.drawable.amarillo);
                    }
                    else{

                    }
                    break;
                case 5:
                    if(matriz[3][5] == -1 && matriz[3][6] == -1){
                        matriz[2][4]= 7;
                        matriz[2][5]= 7;
                        matriz[3][5]= 7;
                        matriz[3][6]= 7;
                        matriz2[0][5].setImageResource(R.drawable.amarillo);
                        matriz2[0][6].setImageResource(R.drawable.amarillo);
                    }
                    else{

                    }
                    break;
                case 6:
                    if(matriz[3][4] == -1 && matriz[3][5] == -1 && matriz[3][6] == -1){
                        matriz[3][4]= 7;
                        matriz[2][5]= 7;
                        matriz[3][5]= 7;
                        matriz[3][6]= 7;
                        matriz2[0][4].setImageResource(R.drawable.amarillo);
                        matriz2[0][5].setImageResource(R.drawable.amarillo);
                        matriz2[0][6].setImageResource(R.drawable.amarillo);
                    }
                    else{

                    }
                    break;
            }
        }
    }
}
