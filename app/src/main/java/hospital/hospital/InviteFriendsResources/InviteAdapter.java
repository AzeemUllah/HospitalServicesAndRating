package hospital.hospital.InviteFriendsResources;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import hospital.hospital.R;

/**
 * Created by syeda on 1/18/2018.
 */
public class InviteAdapter extends RecyclerView.Adapter<InviteAdapter.MyViewHolder> {

    private List<InviteData> inviteList;



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public boolean isInvited = false;
        ImageButton invited;
        public CircularImageView profilePic;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.inviteSubrowNameTxtv);
            invited = (ImageButton) itemView.findViewById(R.id.inviteBtn);
            invited.setOnClickListener(this);
            profilePic = (CircularImageView) view.findViewById(R.id.contact_profile_pic);
        }

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.inviteBtn){
                if(((Integer)invited.getTag()) == 0) {
                    invited.setImageResource(R.drawable.invitedbtn);
                    invited.setTag(R.drawable.invitedbtn);
                }
            }
        }
    }

    public InviteAdapter(List<InviteData> inviteList) {
        this.inviteList = inviteList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_invite_friends_subrow, parent, false);


            return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InviteData invites = inviteList.get(position);

        if(invites.isInvited() == true){
            holder.invited.setTag(1);
            holder.invited.setImageResource(R.drawable.invitedbtn);
        }
        else {
            holder.invited.setTag(0);
            holder.invited.setImageResource(R.drawable.invitebtn);
        }
        holder.name.setText(invites.getName());
        if(invites.getProfilePic() != null){
            Drawable yourDrawable;
            try {
                InputStream inputStream = holder.profilePic.getContext().getContentResolver().openInputStream(Uri.parse(invites.getProfilePic()));
                yourDrawable = Drawable.createFromStream(inputStream, invites.getProfilePic());
            } catch (FileNotFoundException e) {
                yourDrawable = holder.profilePic.getContext().getResources().getDrawable(R.drawable.profile_user);
            }
            holder.profilePic.setImageDrawable(yourDrawable);

        }
    }

    @Override
    public int getItemCount() {
        return inviteList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

}
