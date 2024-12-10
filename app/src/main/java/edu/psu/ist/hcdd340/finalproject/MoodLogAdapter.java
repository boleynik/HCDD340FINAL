package edu.psu.ist.hcdd340.finalproject;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MoodLogAdapter extends RecyclerView.Adapter<MoodLogAdapter.ViewHolder> {

    private final List<MoodLogEntry> moodLogEntries;

    public MoodLogAdapter(List<MoodLogEntry> moodLogEntries) {
        this.moodLogEntries = moodLogEntries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mood_log, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MoodLogEntry entry = moodLogEntries.get(position);
        holder.dateTimeTextView.setText(entry.getDateTime());
        holder.moodTextView.setText(entry.getMood());
        holder.reasonTextView.setText(entry.getReason());
    }

    @Override
    public int getItemCount() {
        return moodLogEntries.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dateTimeTextView, moodTextView, reasonTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTimeTextView = itemView.findViewById(R.id.dateTimeTextView);
            moodTextView = itemView.findViewById(R.id.moodTextView);
            reasonTextView = itemView.findViewById(R.id.reasonTextView);
        }
    }
}

