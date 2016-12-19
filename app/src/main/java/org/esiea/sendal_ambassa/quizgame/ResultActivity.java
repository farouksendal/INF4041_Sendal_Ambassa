package org.esiea.sendal_ambassa.quizgame;

/**
 * Created by farouksendal on 20/11/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends Activity {
    Button butReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //Note
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        TextView t=(TextView)findViewById(R.id.textResult);
        //Score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        //Affichage du score
        bar.setRating(score);
        switch (score)
        {
            case 0: t.setText("Vous êtes nul!");
            case 1: t.setText("N'importe quoi!!");
            case 2: t.setText("Oops! fallait pas sécher les cours :(");
                break;
            case 3:t.setText("Vous avez les bases, faites un effort! ");
            case 4:t.setText("Encore un peu et vous serez un Sayan!");
                break;
            case 5:t.setText("Wow! Bravo vous êtes un dieu!");
                break;
        }
        Toast.makeText(this,"appuyez sur retour pour rejouer",Toast.LENGTH_SHORT).show();
    }
    
    public void restartActivity(View v)
    {
        Intent intent= new Intent(this, ActivityQuizz.class);
        startActivity(intent);
        finish();
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }

}
