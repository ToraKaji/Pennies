package deepdive.cnm.edu.pennies.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import deepdive.cnm.edu.pennies.model.ScratcherDB.Converters;
import deepdive.cnm.edu.pennies.model.entities.Play;
import deepdive.cnm.edu.pennies.model.entities.Scratcher;
import java.util.Date;

@Database(
    entities = {Scratcher.class, Play.class},
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters.class)
public abstract class ScratcherDB extends RoomDatabase {

  private static final String DB_NAME = "text_db";
  private static ScratcherDB instance = null;

  public synchronized static void forgetInstance() {
    instance = null;
  }

  public synchronized static ScratcherDB getInstance(Context context) {
    if (instance == null) {
      instance = Room.databaseBuilder(context.getApplicationContext(), ScratcherDB.class, DB_NAME)
          .build();
    }
    return instance;
  }

  public abstract PlayDao getPlayDao();

  public abstract ScratcherDao getScratcherDao();

  public static class Converters {

    @TypeConverter
    public static Date dateFromLong(Long time) {
      return (time != null) ? new Date(time) : null;
    }

    @TypeConverter
    public static Long longFromDate(Date date) {
      return (date != null) ? date.getTime() : null;
    }
  }
}

