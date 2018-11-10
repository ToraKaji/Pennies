package deepdive.cnm.edu.pennies.view.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import de.hdodenhof.circleimageview.CircleImageView;
import deepdive.cnm.edu.pennies.R;
import deepdive.cnm.edu.pennies.model.Scratcher;
import deepdive.cnm.edu.pennies.model.ScratcherDB;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    View view = inflater.inflate(R.layout.fragment_game0, container, false);
    for(int i = 0;i<idButtonArray.length;i++){
      createButton(view,idButtonArray[i],i,idTextArray[i]);
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


  private CircleImageView createButton(View view, int id, final int num, final int textId) {

    Random rng = new Random();

    final List<Integer> possible = new ArrayList<>();
    for (int i = 0; i <= 51; i += 10) {
      possible.add(i);
    }
    Collections.shuffle(possible);

    final int value = possible.get(rng.nextInt(possible.size()-1));
    final TextView textX = view.findViewById(textId);
    final CircleImageView buttonX = view.findViewById(id);

    buttonX.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Scratcher scratch = new Scratcher();
        scratch.setId(num);
        scratch.setDate(new Date());
        scratch.setValue(value);
        new InsertTask().execute(scratch);
        buttonX.setVisibility(View.INVISIBLE);
        textX.setText(String.valueOf(value));
        textX.setVisibility(View.VISIBLE);
        Toast.makeText(getContext(), "I'm button: " + num, Toast.LENGTH_SHORT).show();
      }
    });

    return buttonX;
  }
}
