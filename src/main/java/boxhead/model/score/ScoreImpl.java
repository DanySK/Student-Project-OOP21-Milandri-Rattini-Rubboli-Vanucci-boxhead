package boxhead.model.score;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * TODO SCORE WILL BE IN THE ZOMBIEMODEL CLASS, SO THAT WHENEVER A ZOMBIE DIES THE SCORE WILL BE INCREMENTED.
 * @author emira
 *
 */
public class ScoreImpl implements Score {

	private long time;
	private int kills;
	private long lastKill;
	private int killStreak;
	private long streakTime;
	private Optional<String> timePlayed;
	private Optional<String> nickname;
	
	public ScoreImpl(final String nickname) {
		this.kills = 0;
		this.killStreak = 0;
		this.streakTime = 4000;
		this.timePlayed = Optional.empty();
		this.nickname = Optional.ofNullable(nickname);
		this.setGameStart();
	}
	
	/**
	 * Used to set the starting time of the game.
	 */
	private void setGameStart() {
		this.time = System.currentTimeMillis();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getKills() {
		return this.kills;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addKill() {
		this.kills++;
		this.lastKill = System.currentTimeMillis();
		this.addStreak();
	}

	/**
	 * Used to get the time the last kill was added.
	 * @return
	 * 			The time when the last kill was added.
	 */
	private long getLastKill() {
		return this.lastKill;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getStreak() {
		return this.killStreak;
	}

	/**
	 * Used to add a kill to the streak.
	 */
	private void addStreak() {
		this.killStreak++;
	}

	/**
	 * Used to decrease the streak.
	 */
	private final void decreaseStreak() {
		this.killStreak--;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getNickname() {
		return this.nickname.orElse("No nickname yet");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setNickname(String nickname) {
		this.nickname = Optional.ofNullable(nickname);
	}

	/**
	 * {@inheritDoc}
	 * @return 
	 */
	@Override
	public String getTimePlayed() {
		return this.timePlayed.orElse("Not set");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGameEnd() {
		this.time = System.currentTimeMillis() - this.time;
        final long hour = TimeUnit.MILLISECONDS.toHours(this.time);
        final long min = TimeUnit.MILLISECONDS.toMinutes(this.time) - TimeUnit.HOURS.toMinutes(hour);
        final long sec = TimeUnit.MILLISECONDS.toSeconds(this.time) - TimeUnit.MINUTES.toSeconds(min);
        this.timePlayed = Optional.of(String.format("%02d:%02d:%02d", hour, min, sec));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update() {
		if (System.currentTimeMillis() - this.lastKill > this.streakTime) {
			this.decreaseStreak();
		}
	}

}
