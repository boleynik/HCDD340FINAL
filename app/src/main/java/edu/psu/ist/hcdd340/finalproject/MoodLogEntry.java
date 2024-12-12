package edu.psu.ist.hcdd340.finalproject;

public class MoodLogEntry {
    private final String currentMood;
    private final String desiredMood;
    private final String reason;

    public MoodLogEntry(String currentMood, String desiredMood, String reason) {
        this.currentMood = currentMood;
        this.desiredMood = desiredMood;
        this.reason = reason;
    }

    public String getCurrentMood() {
        return currentMood;
    }

    public String getDesiredMood() {
        return desiredMood;
    }

    public String getReason() {
        return reason;
    }
}
