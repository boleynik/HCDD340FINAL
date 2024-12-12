package edu.psu.ist.hcdd340.finalproject;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MoodLogAdapter extends RecyclerView.Adapter<MoodLogAdapter.MoodLogViewHolder> {

    private final List<MoodLogEntry> moodLogList;
    private final Context context;

    public MoodLogAdapter(Context context, List<MoodLogEntry> moodLogList) {
        this.context = context;
        this.moodLogList = moodLogList;
    }

    @NonNull
    @Override
    public MoodLogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_mood_log, parent, false);
        return new MoodLogViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MoodLogViewHolder holder, int position) {
        MoodLogEntry currentEntry = moodLogList.get(position);

        holder.currentMoodTextView.setText("Current Mood: " + currentEntry.getCurrentMood());
        holder.desiredMoodTextView.setText("Desired Mood: " + currentEntry.getDesiredMood());
        holder.reasonTextView.setText("Reason: " + currentEntry.getReason());
    }

    @Override
    public int getItemCount() {
        return moodLogList.size();
    }

    public class MoodLogViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView currentMoodTextView;
        public final TextView desiredMoodTextView;
        public final TextView reasonTextView;
        final MoodLogAdapter adapter;

        public MoodLogViewHolder(@NonNull View itemView, MoodLogAdapter adapter) {
            super(itemView);

            this.adapter = adapter;

            currentMoodTextView = itemView.findViewById(R.id.currentMoodTextView);
            desiredMoodTextView = itemView.findViewById(R.id.desiredMoodTextView);
            reasonTextView = itemView.findViewById(R.id.reasonTextView);

            // Set click listeners
            currentMoodTextView.setOnClickListener(this);
            desiredMoodTextView.setOnClickListener(this);
            reasonTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Navigate to LogActivityActivity when an item is clicked
            Intent intent = new Intent(context, LogActivityActivity.class);
            int position = getLayoutPosition();

            // Pass data if needed
            MoodLogEntry clickedEntry = moodLogList.get(position);
            intent.putExtra("currentMood", clickedEntry.getCurrentMood());
            intent.putExtra("desiredMood", clickedEntry.getDesiredMood());
            intent.putExtra("reason", clickedEntry.getReason());

            context.startActivity(intent);
        }
    }
}


