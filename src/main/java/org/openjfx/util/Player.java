package org.openjfx.util;

public class Player {
    private String team;
    private String playerName;

    @Override
    public String toString() {
        return "Player [team=" + team + ", playerName=" + playerName + "]";
    }

    /**
     * @return the team
     */
    public String getTeam() {
        return team;
    }

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * @param team
     * @param playerName
     */
    public Player(String team, String playerName) {
        this.team = team;
        this.playerName = playerName;
    }
    
}
