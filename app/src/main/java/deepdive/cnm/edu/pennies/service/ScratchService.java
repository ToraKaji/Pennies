package deepdive.cnm.edu.pennies.service;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class ScratchService extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }

}
