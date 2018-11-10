package deepdive.cnm.edu.pennies.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import java.util.Date;

@Entity
public class Scratcher {

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getValue() {
    return value;
  }

  public void setValue(long value) {
    this.value = value;
  }

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "button_id")
  private long id;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
  @NonNull
  @ColumnInfo(name = "timestamp")
  private Date date;

  private long value;


}
