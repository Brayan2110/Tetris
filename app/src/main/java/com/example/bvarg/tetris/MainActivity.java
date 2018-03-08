package com.example.bvarg.tetris;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //0 cuadro
    //1 largo
    //2 L derecha
    //3 L izquierda
    //4 escalera derecha
    //5 escalera izquierda
    //6 escalera centro
    int pieza;
    boolean juegoactivo = true;
    //0 amarillo
    //1 azul
    //2 celeste
    //3 morado
    //4 naranje
    //5 rojo
    //6 verde
    int color;
    int velocidad = 1000;
    int centroX;
    int centroY;
    int pos;
    boolean primero = true;
    ArrayList colores = new ArrayList();
    ArrayList afectados = new ArrayList();
    Handler handler = new Handler();
    int[][] matriz;
    ImageView[][] matriz2;
    Button derecha;
    Button izquierda;
    Button abajo;
    Button girar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        derecha = (Button)findViewById(R.id.button_derecha);
        izquierda = (Button)findViewById(R.id.button_izquierda);
        abajo = (Button)findViewById(R.id.button_abajo);
        girar = (Button)findViewById(R.id.button_girar);
        colores.add(R.drawable.amarillo);
        colores.add(R.drawable.azul);
        colores.add(R.drawable.celeste);
        colores.add(R.drawable.morado);
        colores.add(R.drawable.naranja);
        colores.add(R.drawable.rojo);
        colores.add(R.drawable.verde);
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
        jugar();


    }
    public  void reinicio(View view){
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout2);
        relativeLayout.setVisibility(View.INVISIBLE);
        jugar();

    }
    public void pausa(View view){
        if(juegoactivo){
            juegoactivo = false;
            derecha.setClickable(false);
            izquierda.setClickable(false);
            abajo.setClickable(false);
            girar.setClickable(false);
        }
        else{
            juegoactivo = true;
            derecha.setClickable(true);
            izquierda.setClickable(true);
            abajo.setClickable(true);
            girar.setClickable(true);
        }
    }
    public void jugar(){
        matriz= new int[][]{{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
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
        GridLayout grid = (GridLayout) findViewById(R.id.layoutTablero);
        for (int i = 0; i < grid.getChildCount(); i++){
            ImageView t = (ImageView) grid.getChildAt(i);
            t.setImageResource(R.drawable.gris2);
        }
        azar();
        MiThread x = new MiThread();
        handler.post(x);
    }
    public void izquierda(View view){
        int i=0;
        int y;
        int x;
        boolean jugar = true;
        while (i<8){
            y = (int)afectados.get(i);
            x = (int)afectados.get(i+1);
            i=i+2;
            if(x==0 || matriz[y][x-1] == 0 || matriz[y][x-1] == 1 || matriz[y][x-1] == 2 || matriz[y][x-1] == 3 || matriz[y][x-1] == 4 || matriz[y][x-1] == 5 || matriz[y][x-1] == 6){
                jugar = false;
            }
        }
        if(jugar){
            centroX--;
            ArrayList afectados2 = new ArrayList();
            int varX = 1;
            while (varX<11){
                int varXX = 1;
                while (varXX<8){
                    if (afectados.get(varXX).equals(varX)){
                        afectados2.add(afectados.get(varXX-1));
                        afectados2.add(afectados.get(varXX));
                    }
                    varXX= varXX +2;
                }
                varX++;
            }
            i=0;
            while (i<8){
                y = (int)afectados2.get(i);
                x = (int)afectados2.get(i+1);
                matriz[y][x] = -1;
                matriz[y][x-1] = 7;
                afectados2.set(i+1,(int)afectados2.get(i+1)-1);
                i=i+2;
                if(y>2){
                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                    matriz2[y-3][x-1].setImageResource((int)colores.get(color));
                }
            }
            varX = 14;
            afectados.clear();
            while (varX!=-1){
                int varXX = 0;
                while (varXX<8){
                    if (afectados2.get(varXX).equals(varX)){
                        afectados.add(afectados2.get(varXX));
                        afectados.add(afectados2.get(varXX+1));
                    }
                    varXX= varXX +2;
                }
                varX--;
            }
        }
    }

    public void abajo(View view){
        velocidad = 0;
    }
    public  void derecha(View view){
        int i=0;
        int y;
        int x;
        boolean jugar = true;
        while (i<8){
            y = (int)afectados.get(i);
            x = (int)afectados.get(i+1);
            i=i+2;
            if(x==10 || matriz[y][x+1] == 0 || matriz[y][x+1] == 1 || matriz[y][x+1] == 2 || matriz[y][x+1] == 3 || matriz[y][x+1] == 4 || matriz[y][x+1] == 5 || matriz[y][x+1] == 6){
                jugar = false;
            }
        }
        if(jugar){
            centroX++;
            ArrayList afectados2 = new ArrayList();
            int varX = 9;
            while (varX!=-1){
                int varXX = 1;
                while (varXX<8){
                    if (afectados.get(varXX).equals(varX)){
                        afectados2.add(afectados.get(varXX-1));
                        afectados2.add(afectados.get(varXX));
                    }
                    varXX= varXX +2;
                }
                varX--;
            }
            i=0;
            while (i<8){
                y = (int)afectados2.get(i);
                x = (int)afectados2.get(i+1);
                matriz[y][x] = -1;
                matriz[y][x+1] = 7;
                afectados2.set(i+1,(int)afectados2.get(i+1)+1);
                i=i+2;
                if(y>2){
                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                    matriz2[y-3][x+1].setImageResource((int)colores.get(color));
                }
            }
            varX = 14;
            afectados.clear();
            while (varX!=-1){
                int varXX = 0;
                while (varXX<8){
                    if (afectados2.get(varXX).equals(varX)){
                        afectados.add(afectados2.get(varXX));
                        afectados.add(afectados2.get(varXX+1));
                    }
                    varXX= varXX +2;
                }
                varX--;
            }
        }
    }

    public void rotar(View view){
        switch (pieza) {
            case 0:
                break;
            case 1:
                switch (pos){
                    case 0:
                        if(centroX == 9 && matriz[centroY][centroX-1]== -1 && matriz[centroY][centroX-2]== -1 && matriz[centroY][centroX+1]== -1){
                            int i = 0;
                            int y;
                            int x;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY-1][centroX] = -1;
                            matriz[centroY-2][centroX] = -1;
                            matriz[centroY+1][centroX] = -1;
                            matriz[centroY][centroX-1] = 7;
                            matriz[centroY][centroX+1] = 7;
                            matriz[centroY][centroX-2] = 7;
                            afectados.clear();
                            afectados.add(centroY);
                            afectados.add(centroX-1);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX+1);
                            afectados.add(centroY);
                            afectados.add(centroX-2);
                            i = 0;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource((int) colores.get(color));
                                }
                            }
                            pos++;
                            pos++;
                        }
                        else if (centroX != 0 && centroX != 10 && matriz[centroY][centroX-1] == -1 && matriz[centroY+1][centroX+1] == -1 && matriz[centroY+1][centroX+2] == -1) {
                            int i = 0;
                            int y;
                            int x;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY-1][centroX] = -1;
                            matriz[centroY-2][centroX] = -1;
                            matriz[centroY+1][centroX] = -1;
                            matriz[centroY][centroX-1] = 7;
                            matriz[centroY][centroX+1] = 7;
                            matriz[centroY][centroX+2] = 7;
                            afectados.clear();
                            afectados.add(centroY);
                            afectados.add(centroX-1);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX+1);
                            afectados.add(centroY);
                            afectados.add(centroX+2);
                            i = 0;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource((int) colores.get(color));
                                }
                            }
                            pos++;
                        }
                        break;
                    case 1:
                        if (centroY != 14 && matriz[centroY+1][centroX] == -1 && matriz[centroY-1][centroX] == -1 && matriz[centroY-2][centroX] == -1) {
                            int i = 0;
                            int y;
                            int x;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY][centroX-1] = -1;
                            matriz[centroY][centroX+1] = -1;
                            matriz[centroY][centroX+2] = -1;
                            matriz[centroY+1][centroX] = 7;
                            matriz[centroY-1][centroX] = 7;
                            matriz[centroY-2][centroX] = 7;
                            afectados.clear();
                            afectados.add(centroY-2);
                            afectados.add(centroX);
                            afectados.add(centroY-1);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY+1);
                            afectados.add(centroX);
                            i = 0;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource((int) colores.get(color));
                                }
                            }
                            pos = 0;
                        }
                        break;
                    case 2:
                        if (centroY != 14 && matriz[centroY+1][centroX] == -1 && matriz[centroY-1][centroX] == -1 && matriz[centroY-2][centroX] == -1) {
                            int i = 0;
                            int y;
                            int x;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY][centroX-1] = -1;
                            matriz[centroY][centroX+1] = -1;
                            matriz[centroY][centroX-2] = -1;
                            matriz[centroY+1][centroX] = 7;
                            matriz[centroY-1][centroX] = 7;
                            matriz[centroY-2][centroX] = 7;
                            afectados.clear();
                            afectados.add(centroY-2);
                            afectados.add(centroX);
                            afectados.add(centroY-1);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY+1);
                            afectados.add(centroX);
                            i = 0;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource((int) colores.get(color));
                                }
                            }
                            pos = 0;
                        }
                        break;
                }
                break;
            case 2:
                switch (pos){
                    case 0:
                        if (centroX != 0 && matriz[centroY][centroX-1]== -1 && matriz[centroY+1][centroX-1]== -1 && matriz[centroY][centroX+1]== -1){
                            int i=0;
                            int y;
                            int x;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY-1][centroX]=-1;
                            matriz[centroY+1][centroX]=-1;
                            matriz[centroY+1][centroX+1]=-1;
                            matriz[centroY][centroX-1]=7;
                            matriz[centroY+1][centroX-1]=7;
                            matriz[centroY][centroX+1]=7;
                            afectados.clear();
                            afectados.add(centroY+1);
                            afectados.add(centroX-1);
                            afectados.add(centroY);
                            afectados.add(centroX-1);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX+1);
                            i=0;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource((int)colores.get(color));
                                }
                            }
                            pos++;
                        }
                        break;
                    case 1:
                        if (matriz[centroY-1][centroX-1]== -1 && matriz[centroY-1][centroX]== -1 && matriz[centroY+1][centroX]== -1){
                            int i=0;
                            int y;
                            int x;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY+1][centroX-1]=-1;
                            matriz[centroY][centroX-1]=-1;
                            matriz[centroY][centroX+1]=-1;
                            matriz[centroY-1][centroX-1]=7;
                            matriz[centroY-1][centroX]=7;
                            matriz[centroY+1][centroX]=7;
                            afectados.clear();
                            afectados.add(centroY+1);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY-1);
                            afectados.add(centroX-1);
                            afectados.add(centroY-1);
                            afectados.add(centroX);
                            i=0;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource((int)colores.get(color));
                                }
                            }
                            pos++;
                        }
                        break;
                    case 2:
                        if (centroX != 10 && matriz[centroY-1][centroX+1]== -1 && matriz[centroY][centroX-1]== -1 && matriz[centroY][centroX+1]== -1){
                            int i=0;
                            int y;
                            int x;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY-1][centroX-1]=-1;
                            matriz[centroY-1][centroX]=-1;
                            matriz[centroY+1][centroX]=-1;
                            matriz[centroY-1][centroX+1]=7;
                            matriz[centroY][centroX-1]=7;
                            matriz[centroY][centroX+1]=7;
                            afectados.clear();
                            afectados.add(centroY);
                            afectados.add(centroX-1);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX+1);
                            afectados.add(centroY-1);
                            afectados.add(centroX+1);
                            i=0;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource((int)colores.get(color));
                                }
                            }
                            pos++;
                        }
                        break;
                    case 3:
                        if (centroY != 14 && matriz[centroY-1][centroX]== -1 && matriz[centroY+1][centroX]== -1 && matriz[centroY+1][centroX+1]== -1){
                            int i=0;
                            int y;
                            int x;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY-1][centroX+1]=-1;
                            matriz[centroY][centroX-1]=-1;
                            matriz[centroY][centroX+1]=-1;
                            matriz[centroY-1][centroX]=7;
                            matriz[centroY+1][centroX]=7;
                            matriz[centroY+1][centroX+1]=7;
                            afectados.clear();
                            afectados.add(centroY+1);
                            afectados.add(centroX);
                            afectados.add(centroY+1);
                            afectados.add(centroX+1);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY-1);
                            afectados.add(centroX);
                            i=0;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource((int)colores.get(color));
                                }
                            }
                            pos=0;
                        }
                        break;
                }
                break;
            case 3:
                switch (pos){
                    case 0:
                        if (centroX != 10 && matriz[centroY-1][centroX-1]== -1 && matriz[centroY][centroX-1]== -1 && matriz[centroY][centroX+1]== -1){
                            int i=0;
                            int y;
                            int x;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY-1][centroX]=-1;
                            matriz[centroY+1][centroX]=-1;
                            matriz[centroY+1][centroX-1]=-1;
                            matriz[centroY][centroX-1]=7;
                            matriz[centroY-1][centroX-1]=7;
                            matriz[centroY][centroX+1]=7;
                            afectados.clear();
                            afectados.add(centroY);
                            afectados.add(centroX-1);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX+1);
                            afectados.add(centroY-1);
                            afectados.add(centroX-1);
                            i=0;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource((int)colores.get(color));
                                }
                            }
                            pos++;
                        }
                        break;
                    case 1:
                        if (centroY != 14 && matriz[centroY-1][centroX]== -1 && matriz[centroY+1][centroX]== -1 && matriz[centroY-1][centroX+1]== -1){
                            int i=0;
                            int y;
                            int x;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY-1][centroX-1]=-1;
                            matriz[centroY][centroX-1]=-1;
                            matriz[centroY][centroX+1]=-1;
                            matriz[centroY-1][centroX+1]=7;
                            matriz[centroY-1][centroX]=7;
                            matriz[centroY+1][centroX]=7;
                            afectados.clear();
                            afectados.add(centroY+1);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY-1);
                            afectados.add(centroX);
                            afectados.add(centroY-1);
                            afectados.add(centroX+1);
                            i=0;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource((int)colores.get(color));
                                }
                            }
                            pos++;
                        }
                        break;
                    case 2:
                        if (centroX != 0 && matriz[centroY][centroX-1]== -1 && matriz[centroY][centroX+1]== -1 && matriz[centroY+1][centroX+1]== -1){
                            int i=0;
                            int y;
                            int x;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY-1][centroX+1]=-1;
                            matriz[centroY-1][centroX]=-1;
                            matriz[centroY+1][centroX]=-1;
                            matriz[centroY+1][centroX+1]=7;
                            matriz[centroY][centroX-1]=7;
                            matriz[centroY][centroX+1]=7;
                            afectados.clear();
                            afectados.add(centroY+1);
                            afectados.add(centroX+1);
                            afectados.add(centroY);
                            afectados.add(centroX-1);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX+1);
                            i=0;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource((int)colores.get(color));
                                }
                            }
                            pos++;
                        }
                        break;
                    case 3:
                        if (matriz[centroY-1][centroX]== -1 && matriz[centroY+1][centroX]== -1 && matriz[centroY+1][centroX-1]== -1){
                            int i=0;
                            int y;
                            int x;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY][centroX-1]=-1;
                            matriz[centroY][centroX+1]=-1;
                            matriz[centroY+1][centroX+1]=-1;
                            matriz[centroY-1][centroX]=7;
                            matriz[centroY+1][centroX]=7;
                            matriz[centroY+1][centroX-1]=7;
                            afectados.clear();
                            afectados.add(centroY+1);
                            afectados.add(centroX-1);
                            afectados.add(centroY+1);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY-1);
                            afectados.add(centroX);
                            i=0;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource((int)colores.get(color));
                                }
                            }
                            pos=0;
                        }
                        break;
                }
                break;
            case 4:
                switch (pos) {
                    case 0:
                        if (centroY != 14 && matriz[centroY][centroX+1] == -1 && matriz[centroY+1][centroX+1] == -1) {
                            int i = 0;
                            int y;
                            int x;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY][centroX-1] = -1;
                            matriz[centroY-1][centroX+1] = -1;
                            matriz[centroY][centroX+1] = 7;
                            matriz[centroY+1][centroX+1] = 7;
                            afectados.clear();
                            afectados.add(centroY+1);
                            afectados.add(centroX+1);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX+1);
                            afectados.add(centroY-1);
                            afectados.add(centroX);
                            i = 0;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource((int) colores.get(color));
                                }
                            }
                            pos++;
                        }
                        break;
                    case 1:
                        if (centroX != 10 && matriz[centroY][centroX-1] == -1 && matriz[centroY-1][centroX+1] == -1) {
                            int i = 0;
                            int y;
                            int x;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY][centroX+1] = -1;
                            matriz[centroY+1][centroX+1] = -1;
                            matriz[centroY][centroX-1] = 7;
                            matriz[centroY-1][centroX+1] = 7;
                            afectados.clear();
                            afectados.add(centroY);
                            afectados.add(centroX-1);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY-1);
                            afectados.add(centroX);
                            afectados.add(centroY-1);
                            afectados.add(centroX+1);
                            i = 0;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource((int) colores.get(color));
                                }
                            }
                            pos = 0;
                        }
                        break;
                }
                break;
            case 5:
                switch (pos){
                    case 0:
                        if (centroY != 14 && matriz[centroY][centroX-1] == -1 && matriz[centroY+1][centroX-1] == -1) {
                            int i = 0;
                            int y;
                            int x;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY-1][centroX-1] = -1;
                            matriz[centroY][centroX+1] = -1;
                            matriz[centroY][centroX-1] = 7;
                            matriz[centroY+1][centroX-1] = 7;
                            afectados.clear();
                            afectados.add(centroY+1);
                            afectados.add(centroX-1);
                            afectados.add(centroY);
                            afectados.add(centroX-1);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY-1);
                            afectados.add(centroX);
                            i = 0;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource((int) colores.get(color));
                                }
                            }
                            pos++;
                        }
                        break;
                    case 1:
                        if (centroX != 0 && matriz[centroY][centroX+1] == -1 && matriz[centroY-1][centroX-1] == -1) {
                            int i = 0;
                            int y;
                            int x;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY+1][centroX-1] = -1;
                            matriz[centroY][centroX-1] = -1;
                            matriz[centroY][centroX+1] = 7;
                            matriz[centroY-1][centroX-1] = 7;
                            afectados.clear();
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX+1);
                            afectados.add(centroY-1);
                            afectados.add(centroX-1);
                            afectados.add(centroY-1);
                            afectados.add(centroX);
                            i = 0;
                            while (i < 8) {
                                y = (int) afectados.get(i);
                                x = (int) afectados.get(i + 1);
                                i = i + 2;
                                if (y > 2) {
                                    matriz2[y - 3][x].setImageResource((int) colores.get(color));
                                }
                            }
                            pos = 0;
                        }
                        break;
                }
                break;
            case 6:
                switch (pos){
                    case 0:
                        if (centroY != 14 && matriz[centroY+1][centroX] == -1){
                            int i=0;
                            int y;
                            int x;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY][centroX-1]=-1;
                            matriz[centroY+1][centroX]=7;
                            afectados.clear();
                            afectados.add(centroY+1);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX+1);
                            afectados.add(centroY-1);
                            afectados.add(centroX);
                            i=0;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource((int)colores.get(color));
                                }
                            }
                            pos++;
                        }
                        break;
                    case 1:
                        if (centroX != 0 && matriz[centroY][centroX-1]== -1){
                            int i=0;
                            int y;
                            int x;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY-1][centroX]=-1;
                            matriz[centroY][centroX-1]=7;
                            afectados.clear();
                            afectados.add(centroY+1);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX-1);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX+1);
                            i=0;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource((int)colores.get(color));
                                }
                            }
                            pos++;
                        }
                        break;
                    case 2:
                        if (matriz[centroY-1][centroX]== -1){
                            int i=0;
                            int y;
                            int x;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY][centroX+1]=-1;
                            matriz[centroY-1][centroX]=7;
                            afectados.clear();
                            afectados.add(centroY+1);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX-1);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY-1);
                            afectados.add(centroX);
                            i=0;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource((int)colores.get(color));
                                }
                            }
                            pos++;
                        }
                        break;
                    case 3:
                        if (centroX != 10 && matriz[centroY][centroX+1]== -1){
                            int i=0;
                            int y;
                            int x;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource(R.drawable.gris2);
                                }
                            }
                            matriz[centroY+1][centroX]=-1;
                            matriz[centroY][centroX+1]=7;
                            afectados.clear();
                            afectados.add(centroY);
                            afectados.add(centroX-1);
                            afectados.add(centroY);
                            afectados.add(centroX);
                            afectados.add(centroY);
                            afectados.add(centroX+1);
                            afectados.add(centroY-1);
                            afectados.add(centroX);
                            i=0;
                            while (i<8){
                                y = (int)afectados.get(i);
                                x = (int)afectados.get(i+1);
                                i=i+2;
                                if(y>2){
                                    matriz2[y-3][x].setImageResource((int)colores.get(color));
                                }
                            }
                            pos=0;
                        }
                        break;
                }
                break;
        }
    }

    public void azar() {
        pieza = (int) (Math.random() * 7);
        color = (int) (Math.random() * 7);
    }

    class MiThread implements Runnable {
        @Override
        public void run() {
            if(!juegoactivo){
                handler.postDelayed(this,velocidad);
            }
            else{
                if(primero){
                    pos = 0;
                    boolean seguir = true;
                    int n = 0;
                    while(n<10){
                        if(matriz[2][n] != -1){
                            seguir = false;
                        }
                        n++;
                    }
                    if(seguir){
                        switch (pieza){
                            case 0:
                                if(matriz[3][4] == -1 && matriz[3][5] == -1 ){
                                    matriz[2][4]= 7;
                                    matriz[2][5]= 7;
                                    matriz[3][4]= 7;
                                    matriz[3][5]= 7;
                                    matriz2[0][4].setImageResource((int)colores.get(color));
                                    matriz2[0][5].setImageResource((int)colores.get(color));
                                    afectados.clear();
                                    afectados.add(3);
                                    afectados.add(4);
                                    afectados.add(3);
                                    afectados.add(5);
                                    afectados.add(2);
                                    afectados.add(4);
                                    afectados.add(2);
                                    afectados.add(5);
                                }
                                else{
                                    seguir = false;
                                }
                                break;
                            case 1:
                                if(matriz[3][5] == -1){
                                    matriz[0][5]= 7;
                                    matriz[1][5]= 7;
                                    matriz[2][5]= 7;
                                    matriz[3][5]= 7;
                                    matriz2[0][5].setImageResource((int)colores.get(color));
                                    afectados.clear();
                                    afectados.add(3);
                                    afectados.add(5);
                                    afectados.add(2);
                                    afectados.add(5);
                                    afectados.add(1);
                                    afectados.add(5);
                                    afectados.add(0);
                                    afectados.add(5);
                                    centroY = 1;
                                    centroX = 5;
                                }
                                else{
                                    seguir = false;
                                }
                                break;
                            case 2:
                                if(matriz[3][4] == -1 && matriz[3][5] == -1){
                                    matriz[1][4]= 7;
                                    matriz[2][4]= 7;
                                    matriz[3][4]= 7;
                                    matriz[3][5]= 7;
                                    matriz2[0][4].setImageResource((int)colores.get(color));
                                    matriz2[0][5].setImageResource((int)colores.get(color));
                                    afectados.clear();
                                    afectados.add(3);
                                    afectados.add(4);
                                    afectados.add(3);
                                    afectados.add(5);
                                    afectados.add(2);
                                    afectados.add(4);
                                    afectados.add(1);
                                    afectados.add(4);
                                    centroY = 2;
                                    centroX = 4;
                                }
                                else{
                                    seguir = false;
                                }
                                break;
                            case 3:
                                if(matriz[3][5] == -1 && matriz[3][4] == -1){
                                    matriz[1][5]= 7;
                                    matriz[2][5]= 7;
                                    matriz[3][5]= 7;
                                    matriz[3][4]= 7;
                                    matriz2[0][4].setImageResource((int)colores.get(color));
                                    matriz2[0][5].setImageResource((int)colores.get(color));
                                    afectados.clear();
                                    afectados.add(3);
                                    afectados.add(5);
                                    afectados.add(3);
                                    afectados.add(4);
                                    afectados.add(2);
                                    afectados.add(5);
                                    afectados.add(1);
                                    afectados.add(5);
                                    centroY = 2;
                                    centroX = 5;
                                }
                                else{
                                    seguir = false;
                                }
                                break;
                            case 4:
                                if(matriz[3][4] == -1 && matriz[3][5] == -1){
                                    matriz[3][4]= 7;
                                    matriz[3][5]= 7;
                                    matriz[2][5]= 7;
                                    matriz[2][6]= 7;
                                    matriz2[0][4].setImageResource((int)colores.get(color));
                                    matriz2[0][5].setImageResource((int)colores.get(color));
                                    afectados.clear();
                                    afectados.add(3);
                                    afectados.add(4);
                                    afectados.add(3);
                                    afectados.add(5);
                                    afectados.add(2);
                                    afectados.add(5);
                                    afectados.add(2);
                                    afectados.add(6);
                                    centroY = 3;
                                    centroX = 5;
                                }
                                else{
                                    seguir = false;
                                }
                                break;
                            case 5:
                                if(matriz[3][5] == -1 && matriz[3][6] == -1){
                                    matriz[2][4]= 7;
                                    matriz[2][5]= 7;
                                    matriz[3][5]= 7;
                                    matriz[3][6]= 7;
                                    matriz2[0][5].setImageResource((int)colores.get(color));
                                    matriz2[0][6].setImageResource((int)colores.get(color));
                                    afectados.clear();
                                    afectados.add(3);
                                    afectados.add(5);
                                    afectados.add(3);
                                    afectados.add(6);
                                    afectados.add(2);
                                    afectados.add(4);
                                    afectados.add(2);
                                    afectados.add(5);
                                    centroY = 3;
                                    centroX = 5;
                                }
                                else{
                                    seguir = false;
                                }
                                break;
                            case 6:
                                if(matriz[3][4] == -1 && matriz[3][5] == -1 && matriz[3][6] == -1){
                                    matriz[3][4]= 7;
                                    matriz[2][5]= 7;
                                    matriz[3][5]= 7;
                                    matriz[3][6]= 7;
                                    matriz2[0][4].setImageResource((int)colores.get(color));
                                    matriz2[0][5].setImageResource((int)colores.get(color));
                                    matriz2[0][6].setImageResource((int)colores.get(color));
                                    afectados.clear();
                                    afectados.add(3);
                                    afectados.add(4);
                                    afectados.add(3);
                                    afectados.add(5);
                                    afectados.add(3);
                                    afectados.add(6);
                                    afectados.add(2);
                                    afectados.add(5);
                                    centroY = 3;
                                    centroX = 5;

                                }
                                else{
                                    seguir = false;
                                }
                                break;
                        }
                    }
                    if(seguir){
                        primero = false;
                        handler.postDelayed(this,velocidad);
                    }
                    else{
                        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout2);
                        relativeLayout.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    int i=0;
                    int y;
                    int x;
                    centroY++;
                    boolean jugar = true;
                    while (i<8){
                        y = (int)afectados.get(i);
                        x = (int)afectados.get(i+1);
                        i=i+2;
                        if(y==14 || matriz[y+1][x] == 0 || matriz[y+1][x] == 1 || matriz[y+1][x] == 2 || matriz[y+1][x] == 3 || matriz[y+1][x] == 4 || matriz[y+1][x] == 5 || matriz[y+1][x] == 6){
                            jugar = false;
                        }
                    }
                    if(jugar){
                        i=0;
                        while (i<8){
                            y = (int)afectados.get(i);
                            x = (int)afectados.get(i+1);
                            matriz[y][x] = -1;
                            matriz[y+1][x] = 7;
                            afectados.set(i,(int)afectados.get(i)+1);
                            i=i+2;
                            if(y>2){
                                matriz2[y-3][x].setImageResource(R.drawable.gris2);
                                matriz2[y-2][x].setImageResource((int)colores.get(color));
                            }
                            if(y==2){
                                matriz2[y-2][x].setImageResource((int)colores.get(color));
                            }
                        }
                        handler.postDelayed(this,velocidad);
                    }
                    else{
                        i=0;
                        while (i<8){
                            y = (int)afectados.get(i);
                            x = (int)afectados.get(i+1);
                            i=i+2;
                            matriz[y][x] = color;
                        }
                        primero = true;
                        azar();
                        MiThread m = new MiThread();
                        handler.post(m);
                        velocidad = 1000;
                        verificarlinea();
                    }
                }
            }
        }
    }
    public void verificarlinea(){
        int y = 14;
        while (y!=2){
            int x = 0;
            boolean completa = true;
            while (x != 11){
                if(matriz[y][x] == -1){
                    completa = false;
                }
                x++;
            }
            if(completa){
                int yy = y-1;
                while(yy!=2){
                    int xx = 0;
                    while (xx != 11){
                        matriz[yy+1][xx] = matriz[yy][xx];
                        int col = matriz[yy][xx];
                        if (col == -1){
                            matriz2[yy - 2][xx].setImageResource(R.drawable.gris2);
                        }
                        else {
                            matriz2[yy - 2][xx].setImageResource((int) colores.get(col));
                        }
                        xx++;
                    }
                    yy--;
                }
                verificarlinea();
            }
            y--;
        }
    }
}
