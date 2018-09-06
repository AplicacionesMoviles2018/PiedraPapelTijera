package mx.itesm.a01373111.piedrapapeltijeras;

        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

public class Juego extends AppCompatActivity {

    private RPS rps;
    private EditText etPlayer, etCom;
    private String moveCom, result, movePlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        etCom = findViewById(R.id.etCom);
        etPlayer = findViewById(R.id.etPlayer);

        rps = new RPS();

    }

    public void playButton(View v) {
        movePlayer = v.getContentDescription().toString();
        moveCom = rps.playComputer();
        result = rps.play(movePlayer, moveCom);
        String message = "You played "+ movePlayer + " , computer played: " + moveCom + " so " + result + " wins";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        etPlayer.setText(rps.getScorePlayer() + "");
        etCom.setText(rps.getScoreCom() + "");

        String winner = rps.haveWinner();
        if(winner.equals("Player")){
            //Snackbar.make(etPlayer,"You won",Snackbar.LENGTH_LONG).show();
            showMessage("You won");
        } else
        if(winner.equals("Computer")){
            //Snackbar.make(etPlayer,"You lost",Snackbar.LENGTH_LONG).show();
            showMessage("You lost");
        }
    }

    private void showMessage(String mess){
        AlertDialog.Builder dialogue = new AlertDialog.Builder(this);
        dialogue.setTitle("Hey").setMessage(mess).setPositiveButton("Restart",null);
        rps.setScoreCom(0);
        rps.setScorePlayer(0);
        dialogue.show();
    }
}
