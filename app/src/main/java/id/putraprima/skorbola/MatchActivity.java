package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MatchActivity extends AppCompatActivity {

    private String hometeam, awayteam;
    private String winner;
    private int homescore, awayscore;
    private TextView scoreHome, scoreAway;
    private TextView homeText, awayText;
    private CircleImageView homeLogo, awayLogo;
    private Button addHome, addHome2, addHome3;
    private Button addAway, addAway2, addAway3;
    private Button cekResult, resetScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        homeText = findViewById(R.id.txt_home);
        awayText = findViewById(R.id.txt_away);
        scoreHome = findViewById(R.id.score_home);
        scoreAway = findViewById(R.id.score_away);
        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);
        addHome = findViewById(R.id.btn_add_home);
        addHome2= findViewById(R.id.btn_add_home2);
        addHome3 = findViewById(R.id.btn_add_home3);
        addAway = findViewById(R.id.btn_add_away);
        addAway2 = findViewById(R.id.btn_add_away2);
        addAway3 = findViewById(R.id.btn_add_away3);
        cekResult = findViewById(R.id.btn_result);
        resetScore = findViewById(R.id.btn_reset);

        homescore = 0;
        awayscore = 0;
        scoreHome.setText(String.valueOf(homescore));
        scoreAway.setText(String.valueOf(awayscore));

        Bundle bundle = getIntent().getExtras();
        hometeam = bundle.getString("namahome");
        homeText.setText(hometeam);
        awayteam = bundle.getString("namaaway");
        awayText.setText(awayteam);
        homeLogo.setImageURI(Uri.parse(bundle.getString("homeImg")));
        awayLogo.setImageURI(Uri.parse(bundle.getString("awayImg")));

        addHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore += 1;
                scoreHome.setText(String.valueOf(homescore));
            }
        });
        addHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore += 2;
                scoreHome.setText(String.valueOf(homescore));
            }
        });
        addHome3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore += 3;
                scoreHome.setText(String.valueOf(homescore));
            }
        });

        addAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 1;
                scoreAway.setText(String.valueOf(awayscore));
            }
        });
        addAway2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 2;
                scoreAway.setText(String.valueOf(awayscore));
            }
        });
        addAway3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 3;
                scoreAway.setText(String.valueOf(awayscore));
            }
        });

        cekResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                winner = "empty";
                if(homescore > awayscore){
                    winner = hometeam + " Win!";
                }
                else if (homescore == awayscore){
                    winner = "Draw";
                }
                else {
                    winner = awayteam + " Win!";
                }

                Intent intent = new Intent(MatchActivity.this, ResultActivity.class);
                intent.putExtra("winner", winner);
                startActivity(intent);
            }
        });

        resetScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore = 0;
                awayscore = 0;
                scoreHome.setText(String.valueOf(homescore));
                scoreAway.setText(String.valueOf(awayscore));
            }
        });
    }
}
