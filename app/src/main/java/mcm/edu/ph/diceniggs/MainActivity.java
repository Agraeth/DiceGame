package mcm.edu.ph.diceniggs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    private Button rollDice;
    private Random rng=new Random();
    private ImageView imageViewDice;
    private Timer buttonTimer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollDice = findViewById(R.id.rollDice);
        imageViewDice = findViewById(R.id.image_view_dice);




        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();

            }

        });


    }

      private void rollDice() {
        int randomNumber = rng.nextInt(6)+1;

        switch (randomNumber) {
            case 1:
                imageViewDice.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageViewDice.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageViewDice.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageViewDice.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageViewDice.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageViewDice.setImageResource(R.drawable.dice6);
                break;
        }
          rollDice.setEnabled(false);


          buttonTimer.schedule(new TimerTask() {


              public void run() {
                  runOnUiThread(new Runnable() {
                      @Override

                      public void run() {
                          rollDice.setEnabled(true);
                      }
                  });
              }
          }, 2000);

      }
}
