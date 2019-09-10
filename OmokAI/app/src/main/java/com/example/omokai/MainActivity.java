package com.example.omokai;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import static com.example.omokai.R.id.board;

public class MainActivity extends AppCompatActivity {

    private BoardView boardView;
    private Board b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardView = (BoardView) findViewById(board);
        b = new Board();
        boardView.setBoard(b);
        boardView.setMainActivity(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_new_game){
            newGame();
        }
        return super.onOptionsItemSelected(item);
    }

    public void gameEnded(char c){
        String msg = (c == 'T') ? "Game Ended. Tie..." : "Game Ended. " + c + " wins!";

        new AlertDialog.Builder(this).setTitle("Tic Tac Toe").
                setMessage(msg).
                setOnDismissListener(new DialogInterface.OnDismissListener(){
                    @Override
                    public void onDismiss(DialogInterface dialogInterface){
                        newGame();
                    }
                }).show();
    }

    private void newGame(){
        b.newGame();
        boardView.invalidate();
    }
}

