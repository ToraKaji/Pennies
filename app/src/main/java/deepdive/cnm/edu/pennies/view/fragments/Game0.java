package deepdive.cnm.edu.pennies.view.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;
import deepdive.cnm.edu.pennies.R;
import deepdive.cnm.edu.pennies.model.Scratcher;
import deepdive.cnm.edu.pennies.model.ScratcherDB;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Game0 extends Fragment {

  //Create an int array that holds id values of text views and buttons
  private static final int idButtonArray[] = {R.id.button0, R.id.button1, R.id.button2,
      R.id.button3,
      R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8};

  private static final int idTextArray[] = {R.id.button0_val, R.id.button1_val, R.id.button2_val,
      R.id.button3_val, R.id.button4_val, R.id.button5_val, R.id.button6_val, R.id.button7_val,
      R.id.button8_val};

  //Create an array of button and text view objects
  private CircleImageView[] button = new CircleImageView[idButtonArray.length];
  private TextView[] textVal = new TextView[idTextArray.length];

  //Creates a random object
  private SecureRandom rng = new SecureRandom();


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    final List<Integer> possible = new ArrayList<>();
    for (int i = 0; i <= 51; i += 10) {
      possible.add(i);
    }
    Collections.shuffle(possible);

    final int[] possibles = {
        possible.get(rng.nextInt(possible.size() - 1)),
        possible.get(rng.nextInt(possible.size() - 1)),
        possible.get(rng.nextInt(possible.size() - 1)),
        possible.get(rng.nextInt(possible.size() - 1))};

    View view = inflater.inflate(R.layout.fragment_game0, container, false);

//Short hand for creating multiple text view and button objects
    for (int i = 0; i < idButtonArray.length; i++) {
      button[i] = view.findViewById(idButtonArray[i]);
      textVal[i] = view.findViewById(idTextArray[i]);

//Initialize onClickListeners for each button
      button[i].setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
          switch (v.getId()) {

            case R.id.button0:
              button[0].setVisibility(View.INVISIBLE);
              Scratcher scratch0 = new Scratcher();
              scratch0.setId(0);
              scratch0.setDate(new Date());
              scratch0.setValue(possibles[0]);
              new InsertTask().execute(scratch0);
              textVal[0].setText(String.valueOf(possibles[0]));
              textVal[0].setVisibility(View.VISIBLE);

              break;

            case R.id.button1:
              button[1].setVisibility(View.INVISIBLE);
              Scratcher scratch1 = new Scratcher();
              scratch1.setId(1);
              scratch1.setDate(new Date());
              scratch1.setValue(possibles[1]);
              textVal[1].setText(String.valueOf(possibles[1]));
              textVal[1].setVisibility(View.VISIBLE);
              new InsertTask().execute(scratch1);
              break;

            case R.id.button2:
              button[2].setVisibility(View.INVISIBLE);
              Scratcher scratch2 = new Scratcher();
              scratch2.setId(2);
              scratch2.setDate(new Date());
              scratch2.setValue(possibles[2]);
              textVal[2].setText(String.valueOf(possibles[2]));
              textVal[2].setVisibility(View.VISIBLE);
              new InsertTask().execute(scratch2);
              break;

            //TODO ADD OTHER BUTTON ATTRIBUTES
          }
        }
      });
    }
    return view;
  }

  private class InsertTask extends AsyncTask<Scratcher, Void, Long> {

    @Override
    protected Long doInBackground(Scratcher... scratchers) {
      return ScratcherDB.getInstance(getContext()).getScratcherDao().insert(scratchers[0]);
    }

  }

  private boolean checkWin() {

    return false;
  }

  private void init() {

  }
}
