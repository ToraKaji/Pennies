package deepdive.cnm.edu.pennies.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import deepdive.cnm.edu.pennies.model.entities.Play;

@Dao
public interface PlayDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insert(Play play);

}
