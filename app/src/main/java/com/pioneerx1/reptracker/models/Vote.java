package com.pioneerx1.reptracker.models;


import org.parceler.Parcel;

@Parcel
public class Vote {

    String question;
    String description;
    String voteDate;
    String position;
    String billId;

    public Vote() { }

    public Vote(String question, String description, String voteDate, String position, String billId) {
        this.question = question;
        this.description = description;
        this.voteDate = voteDate;
        this.position = position;
        this.billId = billId;
    }

    public String getQuestion() {
        return question;
    }

    public String getDescription() {
        return description;
    }

    public String getVoteDate() {
        return voteDate;
    }

    public String getPosition() {
        return position;
    }

    public String getBillId() {
        return billId;
    }

}
