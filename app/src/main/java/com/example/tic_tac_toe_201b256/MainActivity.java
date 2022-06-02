package com.example.tic_tac_toe_201b256;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner = false;
    int imageClick = -1;
    int player= 1;//player 1 is cross
    int [][]winningStates={{0,1,2},{0,3,6},{0,4,8},{3,4,5},{6,7,8},{2,5,8}};
    int []gameState={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view) {
            ImageView v = (ImageView) view;
            int tag = Integer.parseInt(v.getTag().toString());
            imageClick=gameState[tag];
            if (isWinner == false && imageClick == -1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                gameState[tag] = player;
                Toast.makeText(this, tag + "" + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                gameState[tag] = player;
                Toast.makeText(this, tag + " " + "Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < winningStates.length; i++) {
                if (gameState[winningStates[i][0]] == gameState[winningStates[i][1]] && gameState[winningStates[i][1]] == gameState[winningStates[i][2]] && gameState[winningStates[i][0]] > -1) {
                    Toast.makeText(this, "Winner Is Player" + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}