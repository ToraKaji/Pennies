package deepdive.cnm.edu.pennies.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import deepdive.cnm.edu.pennies.R;

public class LossFragment extends Fragment {

  private Button newGame;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_loss, container, false);
    newGame = view.findViewById(R.id.new_game);
    newGame.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Game0())
            .commit();
        getFragmentManager().popBackStack();
      }
    });
    return view;
  }
}
