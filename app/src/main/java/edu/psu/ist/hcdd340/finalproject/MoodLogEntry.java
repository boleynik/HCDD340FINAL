package edu.psu.ist.hcdd340.finalproject;
public class MoodLogEntry {
    private final String mood;
    private final String reason;
    private final String dateTime;

    public MoodLogEntry(String mood, String reason, String dateTime) {
        this.mood = mood;
        this.reason = reason;
        this.dateTime = dateTime;
    }

    public String getMood() {
        return mood;
    }

    public String getReason() {
        return reason;
    }

    public String getDateTime() {
        return dateTime;
    }
}

