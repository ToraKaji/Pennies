package deepdive.cnm.edu.pennies.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import de.hdodenhof.circleimageview.CircleImageView;
import deepdive.cnm.edu.pennies.R;

public class Game0 extends Fragment {

  //Create an int array that holds id values
  private static final int idArray[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3,
      R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8};

  //Create an array of button objects
  private CircleImageView[] button = new CircleImageView[idArray.length];


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    View view = inflater.inflate(R.layout.fragment_game0, container, false);

    for (int i = 0; i < idArray.length; i++) {
      button[i] = view.findViewById(idArray[i]);

      button[i].setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
          switch (v.getId()) {
            case R.id.button0:
              button[0].setVisibility(View.INVISIBLE);

              break;
            case R.id.button1:
              button[1].setVisibility(View.INVISIBLE);
              break;
            case R.id.button2:
              button[2].setVisibility(View.INVISIBLE);
              break;
            case R.id.button3:
              button[3].setVisibility(View.INVISIBLE);
              break;
            case R.id.button4:
              button[4].setVisibility(View.INVISIBLE);
              break;
            case R.id.button5:
              button[5].setVisibility(View.INVISIBLE);
              break;
            case R.id.button6:
              button[6].setVisibility(View.INVISIBLE);
              break;
            case R.id.button7:
              button[7].setVisibility(View.INVISIBLE);
              break;
            case R.id.button8:
              button[8].setVisibility(View.INVISIBLE);
              break;


          }
        }
      });
    }
    return view;
  }
}
