package deepdive.cnm.edu.pennies.model;

import android.arch.persistence.room.Entity;
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

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  private long id;

  private long value;

  private Date date;

}
