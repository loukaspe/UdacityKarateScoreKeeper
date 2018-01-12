package com.example.android.karatescorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.karatescorekeeper.R;

public class MainActivity extends AppCompatActivity {

    int scorePlayerA = 0;
    int scorePlayerB = 0;
    final int IPPON_THREE = 3;
    final int WAZA_ARI_TWO = 2;
    final int YUKO_ONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Team A Functions.
     */
    private void displayForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void threePointIpponPlayerA(View view)
    {
        scorePlayerA+=IPPON_THREE;
        displayForPlayerA(scorePlayerA);
    }

    public void twoPointWazaariPlayerA(View view)
    {
        scorePlayerA+=WAZA_ARI_TWO;
        displayForPlayerA(scorePlayerA);
    }

    public void onePointYukoPlayerA(View view)
    {
        scorePlayerA+=YUKO_ONE;
        displayForPlayerA(scorePlayerA);
    }

    /**
     * Team B Functions.
     */
    private void displayForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void threePointIpponPlayerB(View view)
    {
        scorePlayerB+=IPPON_THREE;
        displayForPlayerB(scorePlayerB);
    }

    public void twoPointWazaariPlayerB(View view)
    {
        scorePlayerB+=WAZA_ARI_TWO;
        displayForPlayerB(scorePlayerB);
    }

    public void onePointYukoPlayerB(View view)
    {
        scorePlayerB+=YUKO_ONE;
        displayForPlayerB(scorePlayerB);
    }

    /**
     * Reset Method
     */

    public void reset(View view)
    {
        scorePlayerA = 0;
        scorePlayerB = 0;
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
    }
}
