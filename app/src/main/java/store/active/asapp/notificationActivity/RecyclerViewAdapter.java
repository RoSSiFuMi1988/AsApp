package store.active.asapp.notificationActivity;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import store.active.asapp.R;
import store.active.asapp.models.NotificationMessage;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.NotificationMessageViewHolder>{

    List<NotificationMessage> notificationMessages;
    Context context;

    public RecyclerViewAdapter(List<NotificationMessage> _notifications, Context _context){
        this.notificationMessages = _notifications;
        this.context = _context;
    }

    public static class NotificationMessageViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView notificationTitle;
        TextView notificationBody;

        public NotificationMessageViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            notificationTitle = (TextView)itemView.findViewById(R.id.notification_title);
            notificationBody = (TextView)itemView.findViewById(R.id.notification_body);
        }
    }

    @Override
    public NotificationMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_cardview, parent, false);
        NotificationMessageViewHolder nmvh = new NotificationMessageViewHolder(v);
        return nmvh;
    }

    @Override
    public void onBindViewHolder(NotificationMessageViewHolder holder, int position) {
        holder.notificationTitle.setText(notificationMessages.get(position).getSender());
        holder.notificationBody.setText(notificationMessages.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return notificationMessages.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
