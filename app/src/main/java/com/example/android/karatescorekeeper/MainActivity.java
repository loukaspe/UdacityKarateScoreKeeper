package com.example.android.karatescorekeeper;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.karatescorekeeper.R;

public class MainActivity extends AppCompatActivity {

    int scorePlayerA = 0;
    int scorePlayerB = 0;
    int penaltiesPlayerA = 0;
    int penaltiesPlayerB = 0;
    final int IPPON_THREE = 3;
    final int WAZA_ARI_TWO = 2;
    final int YUKO_ONE = 1;
    private TextView scoreViewA;
    private TextView scoreViewB;
    private TextView penaltiesViewA;
    private TextView penaltiesViewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreViewA = (TextView) findViewById(R.id.player_a_score);
        scoreViewB = (TextView) findViewById(R.id.player_b_score);

        scoreViewA.setText(String.valueOf(scorePlayerA));
        scoreViewB.setText(String.valueOf(scorePlayerB));

        penaltiesViewA = (TextView) findViewById(R.id.player_a_penalties);
        penaltiesViewB = (TextView) findViewById(R.id.player_b_penalties);

        penaltiesViewA.setText(String.valueOf(penaltiesPlayerA));
        penaltiesViewB.setText(String.valueOf(penaltiesPlayerB));
    }

    // Code for saving InstanceState for when rotating the screen the Score and Penalties dont go missing
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putInt("scoreA", scorePlayerA);
        savedInstanceState.putInt("penaltiesA", penaltiesPlayerA);

        savedInstanceState.putInt("scoreB", scorePlayerB);
        savedInstanceState.putInt("penaltiesB", penaltiesPlayerB);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        scoreViewA.setText(String.valueOf(savedInstanceState.getInt("scoreA")));
        penaltiesViewA.setText(String.valueOf(savedInstanceState.getInt("penaltiesA")));
        scorePlayerA = savedInstanceState.getInt("scoreA");
        penaltiesPlayerA = savedInstanceState.getInt("penaltiesA");

        scoreViewB.setText(String.valueOf(savedInstanceState.getInt("scoreB")));
        penaltiesViewB.setText(String.valueOf(savedInstanceState.getInt("penaltiesB")));
        scorePlayerB = savedInstanceState.getInt("scoreB");
        penaltiesPlayerB = savedInstanceState.getInt("penaltiesB");
    }
    /**
     * Team A Functions.
     */
    private void displayForPlayerA(int score, int penalties) {
        scoreViewA.setText(String.valueOf(score));
        penaltiesViewA.setText(String.valueOf(penalties));
    }

    public void threePointIpponPlayerA(View view)
    {
        scorePlayerA+=IPPON_THREE;
        displayForPlayerA(scorePlayerA, penaltiesPlayerA);
        checkEndGame();
    }

    public void twoPointWazaariPlayerA(View view)
    {
        scorePlayerA+=WAZA_ARI_TWO;
        displayForPlayerA(scorePlayerA, penaltiesPlayerA);
        checkEndGame();
    }

    public void onePointYukoPlayerA(View view)
    {
        scorePlayerA+=YUKO_ONE;
        displayForPlayerA(scorePlayerA, penaltiesPlayerA);
        checkEndGame();
    }

    public void penaltyPlayerA(View view)
    {
        penaltiesPlayerA++;
        displayForPlayerA(scorePlayerA, penaltiesPlayerA);
        checkEndGame();
    }

    /**
     * Team B Functions.
     */
    private void displayForPlayerB(int score, int penalties) {
        scoreViewB.setText(String.valueOf(score));
        penaltiesViewB.setText(String.valueOf(penalties));
    }

    public void threePointIpponPlayerB(View view)
    {
        scorePlayerB+=IPPON_THREE;
        displayForPlayerB(scorePlayerB, penaltiesPlayerB);
        checkEndGame();
    }

    public void twoPointWazaariPlayerB(View view)
    {
        scorePlayerB+=WAZA_ARI_TWO;
        displayForPlayerB(scorePlayerB, penaltiesPlayerB);
        checkEndGame();
    }

    public void onePointYukoPlayerB(View view)
    {
        scorePlayerB+=YUKO_ONE;
        displayForPlayerB(scorePlayerB, penaltiesPlayerB);
        checkEndGame();
    }

    public void penaltyPlayerB(View view)
    {
        penaltiesPlayerB++;
        displayForPlayerB(scorePlayerB, penaltiesPlayerB);
        checkEndGame();
    }

    /* Reset Method for the Button */
    public void reset(View view)
    {
        scorePlayerA = 0;
        scorePlayerB = 0;
        penaltiesPlayerB = 0;
        penaltiesPlayerA = 0;
        displayForPlayerA(scorePlayerA, penaltiesPlayerA);
        displayForPlayerB(scorePlayerB, penaltiesPlayerB);
    }

    /* Reset Method Overload */
    public void reset()
    {
        scorePlayerA = 0;
        scorePlayerB = 0;
        penaltiesPlayerB = 0;
        penaltiesPlayerA = 0;
        displayForPlayerA(scorePlayerA, penaltiesPlayerA);
        displayForPlayerB(scorePlayerB, penaltiesPlayerB);
    }

    /* Function to check whether the game has to stop */
    private void checkEndGame()
    {
        if(scorePlayerA - scorePlayerB >= 8)
        {
            Toast.makeText(getApplicationContext(), getString(R.string.ScoreAWin), Toast.LENGTH_LONG).show();
            reset();
        }
        else if(scorePlayerB - scorePlayerA >= 8)
        {
            Toast.makeText(getApplicationContext(), getString(R.string.ScoreBWin), Toast.LENGTH_LONG).show();
            reset();
        }
        else if(penaltiesPlayerA == 4)
        {
            Toast.makeText(getApplicationContext(), getString(R.string.PenaltiesBWin), Toast.LENGTH_LONG).show();
            reset();
        }
        else if(penaltiesPlayerB == 4)
        {
            Toast.makeText(getApplicationContext(), getString(R.string.PenaltiesAWin), Toast.LENGTH_LONG).show();
            reset();
        }
    }
}
