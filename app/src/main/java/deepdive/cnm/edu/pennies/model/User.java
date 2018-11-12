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
  @ColumnInfo(name = "games_played")
  private long gamesPlayed;
  private long coins;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public long getGamesPlayed() {
    return gamesPlayed;
  }

  public void setGamesPlayed(long gamesPlayed) {
    this.gamesPlayed = gamesPlayed;
  }

  public long getCoins() {
    return coins;
  }

  public void setCoins(long coins) {
    this.coins = coins;
  }
}
