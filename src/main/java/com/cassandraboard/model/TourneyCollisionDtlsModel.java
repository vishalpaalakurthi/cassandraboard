package com.cassandraboard.model;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Table(keyspace = "ace2three",name = "tourney_collision_dtls")
public class TourneyCollisionDtlsModel {

    @PartitionKey
    @Column(name = "player_id")
    String playerId;

    @Column(name = "timestamp")
    Date timestamp;

    @Column(name = "tourney_id")
    String tourneyId;

    @Column(name = "table_id")
    String tableId;

    @Column(name = "game_id")
    String gameId;

    @Column(name = "referral_collision")
    Set<String> referralCollision;

    @Column(name = "suspect_collision")
    Set<String> suspectCollision;

    @Column(name = "ucid_collision")
    Set<String> ucidCollision;

    @Column(name = "winner")
    String winner;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTourneyId() {
        return tourneyId;
    }

    public void setTourneyId(String tourneyId) {
        this.tourneyId = tourneyId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Set<String> getReferralCollision() {
        return referralCollision;
    }

    public void setReferralCollision(Set<String> referralCollision) {
        this.referralCollision = referralCollision;
    }

    public Set<String> getSuspectCollision() {
        return suspectCollision;
    }

    public void setSuspectCollision(Set<String> suspectCollision) {
        this.suspectCollision = suspectCollision;
    }

    public Set<String> getUcidCollision() {
        return ucidCollision;
    }

    public void setUcidCollision(Set<String> ucidCollision) {
        this.ucidCollision = ucidCollision;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "TourneyCollisionDtlsModel{" +
                "playerId='" + playerId + '\'' +
                ", timestamp=" + timestamp +
                ", tourneyId='" + tourneyId + '\'' +
                ", tableId='" + tableId + '\'' +
                ", gameId='" + gameId + '\'' +
                ", referralCollision='" + referralCollision + '\'' +
                ", suspectCollision='" + suspectCollision + '\'' +
                ", ucidCollision='" + ucidCollision + '\'' +
                ", winner='" + winner + '\'' +
                '}';
    }
}

