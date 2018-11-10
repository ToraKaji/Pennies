package deepdive.cnm.edu.pennies.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.Date;

@Entity
public class Scratcher {

  @PrimaryKey
  @ColumnInfo(name = "button_id")
  private long id;

  @ColumnInfo(name = "timestamp")
  private Date date;

  private long value;

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

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


}
