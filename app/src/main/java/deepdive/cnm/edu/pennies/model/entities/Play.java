package deepdive.cnm.edu.pennies.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "play",
indices = @Index(value = "play_id",unique = true))
public class Play {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "play_id")
  private long playId;

  private boolean outcome;

  private long won;

  public long getWon() {
    return won;
  }

  public void setWon(long won) {
    this.won = won;
  }

  private long scratchers;

  public boolean isOutcome() {

    return outcome;
  }

  public void setOutcome(boolean outcome) {
    this.outcome = outcome;
  }

  public long getPlayId() {
    return playId;
  }

  public void setPlayId(long playId) {
    this.playId = playId;
  }

  public long getScratchers() {
    return scratchers;
  }

  public void setScratchers(long scratchers) {
    this.scratchers = scratchers;
  }
}
