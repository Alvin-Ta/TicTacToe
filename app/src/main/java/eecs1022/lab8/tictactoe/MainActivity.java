package eecs1022.lab8.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

import eecs1022.lab8.tictactoe.model.Game;

public class MainActivity extends AppCompatActivity {
    Game val;
    /* Hint: How do you share the same game object between button clicks
     * (attached with controller methods) of the app?
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Hint: How do you display the initial status to the output textview
         * when the app is first launched?
         */
    }

    /* this mutator sets the output label */
    private void setContentsOfTextView(int id, String newContents) {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    /* this accessor retrieves input entered on the text view  */
    private String getInputOfTextField(int id) {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    /* this accessor retrieves input chosen from some spinner (drop-down menu) */
    private String getItemSelected(int id) {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }

    /* Hints on controller methods:
     *
     * Declare two controller methods, each of which declared with a parameter with type View (see Week 9 Tutorials).
     *  - One method (say cm1) should be attached to the "START/RESTART" button,
     *      whereas the other method (say cm2) should be attached to the "MOVE" button.
     *
     *  - Controller method cm1 should:
     *    + Retrieve the names of the two players from the corresponding textfields.
     *    + Retrieve the player (who will play first) from the spinner.
     *    + Then, re-create the shared game object and invoke the relevant method(s).
     *    + Finally, display the expected output of the game (i.e., board and status) to the output textview.
     *
     * - Controller method cm2 should:
     *    + Retrieve the row and column numbers (as strings) from the corresponding textfields.
     *      You may need to convert the retrieved text, e.g., "1" to an integer value using Double.parseInt.
     *    + Then, invoke the relevant method(s) on the shared game object.
     *    + Finally, display the expected output of the game (i.e., board and status) to the ouptut textview.
     */

    public void displayBoard(View view)
    {
        String firstX = getInputOfTextField(R.id.PersonXName);
        String SecondO = getInputOfTextField(R.id.PersonOName);
        String whosPlayingfirst = getItemSelected(R.id.options);
        String sent = "";
        String secondSent = "";
        char newVal = '1';
        val = new Game(firstX, SecondO);

        char Array[][] = val.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3;j++) {
                secondSent += " "+Array[i][j]+"\n";
            }
        }
        sent = "Current Game Board: \n "+ val.printBoard(Array) +"\n Current Game Status: \n "+val.getStatus()+"";
        setContentsOfTextView(R.id.invis, sent);

        if (whosPlayingfirst.equals("Player X"))
        {
            newVal = 'x';
        }
        else
        {
            newVal = 'o';
        }
        val.setWhoPlaysFirst(newVal);
    }

    public void cm2 (View view)
    {
        String rowIn = getInputOfTextField(R.id.RowVal);
        int RowInteger = Integer.parseInt(rowIn);
        String colIn = getInputOfTextField(R.id.ColVal);
        int ColInteger = Integer.parseInt(colIn);

        val.move(RowInteger, ColInteger);
        char newArray[][] = val.getBoard();
        String secondSent = "";
        String sent;
        for (int i = 0; i < 3; i ++)
        {
            for (int j = 0; j < 3; j++)
            {
                secondSent += " "+newArray[i][j]+"\n";
            }
        }
        sent = "Current Game Board: \n"+val.printBoard(newArray)+"\n Current Game Status: \n "+val.getStatus()+"";
        setContentsOfTextView(R.id.invis, sent);
    }
}