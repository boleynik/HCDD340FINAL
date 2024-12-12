package edu.psu.ist.hcdd340.finalproject;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

    public class MoodLogAdapter extends RecyclerView.Adapter<MoodLogAdapter.MoodLogViewHolder> {

        private final List<MoodLogEntry> moodLogEntries;

        public MoodLogAdapter(List<MoodLogEntry> moodLogEntries) {
            this.moodLogEntries = moodLogEntries;
        }

        @NonNull
        @Override
        public MoodLogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mood_log, parent, false);
            return new MoodLogViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MoodLogViewHolder holder, int position) {
            MoodLogEntry entry = moodLogEntries.get(position);
            holder.currentMoodTextView.setText("Current Mood: " + entry.getCurrentMood());
            holder.desiredMoodTextView.setText("Desired Mood: " + entry.getDesiredMood());
            holder.reasonTextView.setText("Reason: " + entry.getReason());
        }

        @Override
        public int getItemCount() {
            return moodLogEntries.size();
        }

        public static class MoodLogViewHolder extends RecyclerView.ViewHolder {

            TextView currentMoodTextView;
            TextView desiredMoodTextView;
            TextView reasonTextView;

            public MoodLogViewHolder(@NonNull View itemView) {
                super(itemView);
                currentMoodTextView = itemView.findViewById(R.id.currentMoodTextView);
                desiredMoodTextView = itemView.findViewById(R.id.desiredMoodTextView);
                reasonTextView = itemView.findViewById(R.id.reasonTextView);
            }
        }
    }


