package com.example.bvarg.tetris;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int y = 0;
        GridLayout grid = (GridLayout) findViewById(R.id.layoutTablero);
        for (int i = 0; i < grid.getChildCount(); i++){
            ImageView t = (ImageView) grid.getChildAt(i);
            t.setImageResource(R.drawable.gris2);
        }
    }
}
