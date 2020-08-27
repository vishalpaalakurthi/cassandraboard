package com.cassandraboard.model;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.Date;
import java.util.Map;
import java.util.Set;

@Table(keyspace = "ace2three", name = "player_games")
public class PlayerGamesModel implements  Comparable<PlayerGamesModel> {

    @PartitionKey
    @Column(name = "player_id")
    private String playerId;

    @ClusteringColumn
    @Column(name = "game_date")
    private Date gameDate;

    @Column(name = "game_id")
    private String gameId;

    @Column(name = "game_definition_id")
    private int gameDefinitionId;

    @Column(name = "is_winner")
    private boolean isWinner;

    @Column(name = "table_id")
    private String tableId;

    @Column(name = "winners")
    private Set<String> winners;

    @Column(name = "bet")
    private double bet;

    @Column(name="matched_ucids_set")
    private Set<String>  matched_ucids;

    @Column(name="player_score_map")
    private Map<String,Double> playerGameScores;

    @Column(name="players_winnning_amounts")
    private Map<String,String>  playersWinningAmount;

    @Column(name="prize")
    private double  prize;

    @Column(name="wagering")
    private double  wagering;

    @Column(name = "rake")
    private double rake;

    @Column(name="game_type")
    private String gameType;

    @Column(name = "server_type")
    private String serverType;

    @Column(name = "is_happy_hour")
    private boolean isHappyHourTable;

    @Column(name = "game_duration")
    private long gameDuration;

    @Column(name = "start_players_count")
    private int startPlayersCount;

    @Column(name ="max_players_count")
    private int maxPlayersCount;

    @Column(name = "is_helper")
    private boolean isHelper;

    @Column(name = "is_beneficiar")
    private boolean isBeneficiar;

    @Column(name = "opponent_categories")
    private Map<String, String> opponentCategories;

    @Column(name = "high_priority_collision_count")
    private Map<String, Integer> highPriorityCollisionCount;

    @Column(name = "medium_priority_collision_count")
    private Map<String, Integer> mediumPriorityCollisionCount;

    @Column(name = "low_priority_collision_count")
    private Map<String, Integer> lowPriorityCollisionCount;

    @Column(name ="game_category")
    private String gameCategory;

    @Column(name = "players_rejoin_count")
    private Map<String,Integer> playersRejoinCount;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getGameDefinitionId() {
        return gameDefinitionId;
    }

    public void setGameDefinitionId(int gameDefinitionId) {
        this.gameDefinitionId = gameDefinitionId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public boolean isIsWinner() {
        return isWinner;
    }

    public void setIsWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }

    public Set<String> getWinners() {
        return winners;
    }

    public void setWinners(Set<String> winners) {
        this.winners = winners;
    }

    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public Set<String> getMatched_ucids() {
        return matched_ucids;
    }

    public void setMatched_ucids(Set<String> matched_ucids) {
        this.matched_ucids = matched_ucids;
    }

    public Map<String, Double> getPlayerGameScores() {
        return playerGameScores;
    }

    public void setPlayerGameScores(Map<String, Double> playerGameScores) {
        this.playerGameScores = playerGameScores;
    }

    public Map<String, String> getPlayersWinningAmount() {
        return playersWinningAmount;
    }

    public void setPlayersWinningAmount(Map<String, String> playersWinningAmount) {
        this.playersWinningAmount = playersWinningAmount;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public double getWagering() {
        return wagering;
    }

    public void setWagering(double wagering) {
        this.wagering = wagering;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public boolean isIsHappyHourTable() {
        return isHappyHourTable;
    }

    public void setIsHappyHourTable(boolean isHappyHourTable) {
        this.isHappyHourTable = isHappyHourTable;
    }

    public long getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(long gameDuration) {
        this.gameDuration = gameDuration;
    }

    public int getStartPlayersCount() {
        return startPlayersCount;
    }

    public void setStartPlayersCount(int startPlayersCount) {
        this.startPlayersCount = startPlayersCount;
    }

    public int getMaxPlayersCount() {
        return maxPlayersCount;
    }

    public void setMaxPlayersCount(int maxPlayersCount) {
        this.maxPlayersCount = maxPlayersCount;
    }

    public boolean isIsHelper() {
        return isHelper;
    }

    public void setIsHelper(boolean isHelper) {
        this.isHelper = isHelper;
    }

    public boolean isIsBeneficiar() {
        return isBeneficiar;
    }

    public void setIsBeneficiar(boolean isBeneficiar) {
        this.isBeneficiar = isBeneficiar;
    }

    public Map<String, Integer> getHighPriorityCollisionCount() {
        return highPriorityCollisionCount;
    }

    public void setHighPriorityCollisionCount(Map<String, Integer> highPriorityCollisionCount) {
        this.highPriorityCollisionCount = highPriorityCollisionCount;
    }

    public Map<String, Integer> getMediumPriorityCollisionCount() {
        return mediumPriorityCollisionCount;
    }

    public void setMediumPriorityCollisionCount(Map<String, Integer> mediumPriorityCollisionCount) {
        this.mediumPriorityCollisionCount = mediumPriorityCollisionCount;
    }

    public Map<String, Integer> getLowPriorityCollisionCount() {
        return lowPriorityCollisionCount;
    }

    public void setLowPriorityCollisionCount(Map<String, Integer> lowPriorityCollisionCount) {
        this.lowPriorityCollisionCount = lowPriorityCollisionCount;
    }

    public double getRake() {
        return rake;
    }

    public void setRake(double rake) {
        this.rake = rake;
    }

    public Map<String, String> getOpponentCategories() {
        return opponentCategories;
    }

    public void setOpponentCategories(Map<String, String> opponentCategories) {
        this.opponentCategories = opponentCategories;
    }

    public String getGameCategory() {
        return gameCategory;
    }

    public void setGameCategory(String gameCategory) {
        this.gameCategory = gameCategory;
    }

    public Map<String, Integer> getPlayersRejoinCount() {
        return playersRejoinCount;
    }

    public void setPlayersRejoinCount(Map<String, Integer> playersRejoinCount) {
        this.playersRejoinCount = playersRejoinCount;
    }

    @Override
    public String toString() {
        return "PlayerGamesModel{" + "playerId=" + playerId + ", gameDate=" + gameDate + ", gameId=" + gameId + ", gameDefinitionId=" + gameDefinitionId + ", isWinner=" + isWinner + ", tableId=" + tableId + ", winners=" + winners + ", bet=" + bet + ", matched_ucids=" + matched_ucids + ", playerGameScores=" + playerGameScores + ", playersWinningAmount=" + playersWinningAmount + ", prize=" + prize + ", wagering=" + wagering + ", rake=" + rake + ", gameType=" + gameType + ", serverType=" + serverType + ", isHappyHourTable=" + isHappyHourTable + ", gameDuration=" + gameDuration + ", startPlayersCount=" + startPlayersCount + ", maxPlayersCount=" + maxPlayersCount + ", isHelper=" + isHelper + ", isBeneficiar=" + isBeneficiar + ", opponentCategories=" + opponentCategories + ", highPriorityCollisionCount=" + highPriorityCollisionCount + ", mediumPriorityCollisionCount=" + mediumPriorityCollisionCount + ", lowPriorityCollisionCount=" + lowPriorityCollisionCount + ", gameCategory=" + gameCategory + ", playersRejoinCount=" + playersRejoinCount + '}';
    }

    @Override
    public int compareTo(PlayerGamesModel playerGamesModel) {
        if(this.getGameDate().after(playerGamesModel.getGameDate())) {
            return -1;
        } else if(this.getGameDate().before(playerGamesModel.getGameDate())) {
            return 1;
        } else {
            return 0;
        }
    }

}
