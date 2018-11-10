package deepdive.cnm.edu.pennies.model;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.Date;
import java.util.List;

public interface ScratcherDAO {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long insert(Scratcher scratcher);

  @Query("SELECT * FROM Scratcher WHERE date = :date")
  List<Scratcher> find(Date date);

  @Delete
  int delete(Scratcher scratcher);

}
