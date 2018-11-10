package deepdive.cnm.edu.pennies.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.Date;
import java.util.UUID;

@Entity
public class User {

  @PrimaryKey
  @ColumnInfo(name = "player_id")
  private UUID id;

  @ColumnInfo(name = "start_date")
  private Date startDate;

}
