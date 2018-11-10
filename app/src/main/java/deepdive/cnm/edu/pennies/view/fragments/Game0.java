package deepdive.cnm.edu.pennies.view.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import de.hdodenhof.circleimageview.CircleImageView;
import deepdive.cnm.edu.pennies.R;
import deepdive.cnm.edu.pennies.model.Button;
import deepdive.cnm.edu.pennies.model.Scratcher;
import deepdive.cnm.edu.pennies.model.ScratcherDB;
import java.security.SecureRandom;
import java.util.ArrayList;
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

  //Creates an array of all known values
  int[] values = {-1,-2,-3,-4,-5,-6,-7,-8,-9};

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_game0, container, false);
    for (int i = 0; i < idButtonArray.length; i++) {
      button[i] = createButton(view, i, idButtonArray[i], idTextArray[i]);
    }

    return view;
  }


  private class InsertTask extends AsyncTask<Scratcher, Void, Long> {

    @Override
    protected Long doInBackground(Scratcher... scratchers) {
      Log.d("TEST", "Added entity entry");
      return ScratcherDB.getInstance(getContext()).getScratcherDao().insert(scratchers[0]);

    }
  }


  private CircleImageView createButton(View view, final int num, int id,  final int textId) {

    //Creates a RNG for the values of 0-50 in increments of 10.
    Random rng = new Random();
    final List<Integer> possible = new ArrayList<>();
    for (int i = 0; i <= 51; i += 10) {
      possible.add(i);
    }

    //Creates fields to set listeners and textview objects
    final int value = possible.get(rng.nextInt(possible.size() - 1));
    final TextView textX = view.findViewById(textId);
    final CircleImageView buttonX = view.findViewById(id);

    //Sets onClickListeners for each button created.
    buttonX.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        //Sets up the entity class for DB.
        Scratcher scratch = new Scratcher();
        scratch.setId(num);
        scratch.setDate(new Date());
        scratch.setValue(value);
        new InsertTask().execute(scratch);
        //Physical effects on the object.
        buttonX.setVisibility(View.INVISIBLE);
        textX.setText(String.valueOf(value));
        textX.setVisibility(View.VISIBLE);
        values[num] = value;
        checkWin();
        Toast.makeText(getContext(), "I'm button: " + num, Toast.LENGTH_SHORT).show();
      }
    });
    return buttonX;
  }

private void checkWin() {
    boolean win = false;
    for(int x = 0;x<7;x+=3) {
      //Checks for horizontal wins ( x==x+1&&x==x+2 == true linear horizontal win.)
      if (values[x] == values[x + 1] && values[x] == values[x + 2]) {
        win = true;
      } else {
        win = false;
      }
    }
    //TODO handle other wins
    if(win==true){
      Toast.makeText(getActivity(), "You won!", Toast.LENGTH_SHORT).show();
    }

  }
}
