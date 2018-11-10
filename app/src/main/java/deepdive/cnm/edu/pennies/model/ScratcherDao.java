package deepdive.cnm.edu.pennies.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface ScratcherDao {

  @Query("SELECT * FROM Scratcher")
  List<Scratcher> getAll();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insert(Scratcher scratcher);

}