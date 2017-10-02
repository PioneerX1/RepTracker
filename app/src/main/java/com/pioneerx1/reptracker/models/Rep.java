package com.pioneerx1.reptracker.models;

import org.parceler.Parcel;

@Parcel
public class Rep {

    String name;
    String title;
    String memberId;
    String state;
    String party;

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

}
