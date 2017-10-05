package com.pioneerx1.reptracker.models;

import org.parceler.Parcel;

@Parcel
public class Rep {

    String name;
    String title;
    String memberId;
    String state;
    String party;

    // additional properties added
    String phone;
    String website;
    String missedVotes;
    String votesWithParty;
    String twitterHandle;
    String facebookAccount;
    String nextElection;  // JSON data is String


    public Rep() { }

    public Rep(String name, String title, String memberId, String state, String party, String phone, String website,
               String missedVotes, String votesWithParty, String twitterHandle, String facebookAccount, String nextElection) {
        this.name = name;
        this.title = title;
        this.memberId = memberId;
        this.state = state;
        this.party = setParty(party);
        this.phone = phone;
        this.website = website;
        this.missedVotes = missedVotes;
        this.votesWithParty = votesWithParty;
        this.twitterHandle = twitterHandle;
        this.facebookAccount = facebookAccount;
        this.nextElection = nextElection;
    }

    public String setParty(String letter) {
        if (letter.equals("D")) {
            return "Democrat";
        } else if (letter.equals("R")) {
            return "Republican";
        } else if (letter.equals("G")) {
            return "Green";
        } else if (letter.equals("L")) {
            return "Libertarian";
        } else if (letter.equals("I")) {
            return "Independent";
        } else {
            return "Unknown";
        }
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getState() {
        return state;
    }

    public String getParty() {
        return party;
    }

    public String getPhone() { return phone; }

    public String getWebsite() { return website; }

    public String getMissedVotes() { return missedVotes; }

    public String getVotesWithParty() { return votesWithParty; }

    public String getTwitterHandle() { return twitterHandle; }

    public String getFacebookAccount() { return facebookAccount; }

    public String getNextElection() { return nextElection; }

}
