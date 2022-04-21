package boxhead.model.score;

/**
 * Interface to model the score of a single game.
 */
public interface Score {

	/**
	 * @return
	 * 			The number of kills at a certain point of the game.
	 */
	int getKills();

	/**
	 * Used to add a single kill.
	 */
	void addKill();

	/**
	 * @return
	 * 			The streak of kills you are at a certain moment.
	 */
	int getStreak();
	
	/**
	 * Method to set the streak cooldown depending on the current round.
	 * @param streakTime
	 */
	void setStreakTime(int round);

	/**
	 * Used to update internally the score.
	 */
	void update();

	/**
	 * @return
	 * 			The nickname of the player.
	 */
	String getNickname();

	/**
	 * Used to set the nickname of the player.
	 * @param nickname
	 */
	void setNickname(String nickname);

	/**
	 * Used to get the playtime.
	 */
	String getTimePlayed();

	/**
	 * Used to internally set the actual time played.
	 */
	void setGameEnd();
}