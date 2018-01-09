package hospital.hospital.ChatResources;

/**
 * Created by syeda on 1/9/2018.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;

import java.util.List;
import hospital.hospital.R;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {

    private List<ChatData> chatlist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView recivedName, recivedTime, recivedMessageText;
        public TextView sentMessageText, sentTime;
        //public CircularImageView recivedProfilePic;

        public MyViewHolder(View view) {
            super(view);
            recivedName = (TextView) view.findViewById(R.id.recived_message_user_name);
            recivedTime = (TextView) view.findViewById(R.id.recived_message_time);
            //recivedProfilePic = (CircularImageView) view.findViewById(R.id.recived_message_profile_pic);
            recivedMessageText = (TextView) view.findViewById(R.id.recived_message_text);

            sentMessageText = (TextView) view.findViewById(R.id.sent_message_text);
            sentTime = (TextView) view.findViewById(R.id.sent_message_time);
        }
    }


    public ChatAdapter(List<ChatData> chatlist) {

        this.chatlist = chatlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 0) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_sent_message, parent, false);
            return new MyViewHolder(itemView);
        }
        else if(viewType == 1) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_received_message, parent, false);
            return new MyViewHolder(itemView);
        }
        else{
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_welcome_box, parent, false);
            return new MyViewHolder(itemView);
        }

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ChatData chat = chatlist.get(position);
        if(holder.getItemViewType() == 1){
            holder.recivedName.setText(chat.getName());
            holder.recivedTime.setText(chat.getTime());
            //holder.recivedProfilePic.setBackgroundResource(chat.getProfilePic());
            holder.recivedMessageText.setText(chat.getMessage());
        }
        else if(holder.getItemViewType() == 0){
            holder.sentMessageText.setText(chat.getMessage());
            holder.sentTime.setText(chat.getTime());
        }
        else{

        }
    }

    @Override
    public int getItemCount() {
        return chatlist.size();
    }


    @Override
    public int getItemViewType(int position) {
        ChatData chat = chatlist.get(position);
        if (chat.getProfilePic() == "" && chat.getTime() == "") {
            return -1;
        }
        else if (chat.getProfilePic() == "") {
            return 1;
        } else if (chat.getProfilePic() != "") {
            return 0;
        }
        return -1;
    }

}
