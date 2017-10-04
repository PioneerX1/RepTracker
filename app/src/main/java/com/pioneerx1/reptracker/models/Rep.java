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

    public Rep(String name, String title, String memberId, String state, String party) {
        this.name = name;
        this.title = title;
        this.memberId = memberId;
        this.state = state;
        this.party = party;
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
