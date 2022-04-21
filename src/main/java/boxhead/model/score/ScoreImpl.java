package boxhead.model.score;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import boxhead.model.entities.gun.GunUpgradeManager;

/**
 * Implementation of {@link Score}.
 */
public class ScoreImpl implements Score {

	private long time;
	private int kills;
	private long lastKill;
	private int killStreak;
	private int maxStreak;
	private long streakTime;
	private Optional<String> timePlayed;
	private Optional<String> nickname;
	private final GunUpgradeManager gunManager;
	/**
	 * @param nickname
	 * 			The nickname of the player.
	 */
	public ScoreImpl(final String nickname, final GunUpgradeManager manager) {
		this.kills = 0;
		this.killStreak = 0;
		this.maxStreak = 0;
		this.streakTime = 0;
		this.timePlayed = Optional.empty();
		this.nickname = Optional.ofNullable(nickname);
		this.gunManager = manager;
		this.setGameStart();
	}
			
	/**
	 * Used to set the starting time of the game.
	 */
	private final void setGameStart() {
		this.time = System.currentTimeMillis();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int getKills() {
		return this.kills;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void addKill() {
		this.kills++;
		this.lastKill = System.currentTimeMillis();
		this.addStreak();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int getStreak() {
		return this.killStreak;
	}
	
	@Override
	public final void setStreakTime(final int round) {
		if (round < 14) {
			this.streakTime = this.streakTime - 1000;
		}
	}

	/**
	 * Used to add a kill to the streak.
	 */
	private final void addStreak() {
		this.killStreak++;
		if (this.killStreak > this.maxStreak) {
			this.gunManager.checkUpgrades(this.killStreak);
			this.maxStreak = this.killStreak;
		}
		this.streakTime = 20000 - (this.killStreak * 500) + Math.round(Math.pow(this.killStreak, 1.7)) ;
	}

	/**
	 * Used to decrease the streak.
	 */
	private final void decreaseStreak() {
		this.killStreak--;
		this.streakTime = 20000 - (this.killStreak * 500);
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
	public final String getTimePlayed() {
		return this.timePlayed.orElse("Not set");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setGameEnd() {
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
		if (System.currentTimeMillis() - this.lastKill > streakTime && this.killStreak > 0) {
			this.lastKill = System.currentTimeMillis();
			this.decreaseStreak();
		}
	}
}
