package hospital.hospital;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import hospital.hospital.InviteFriendsResources.InviteAdapter;
import hospital.hospital.InviteFriendsResources.InviteData;

public class InviteFriends extends AppCompatActivity {
    private List<InviteData> inviteList = new ArrayList<>();
    private RecyclerView recyclerView;
    private InviteAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);

        recyclerView = (RecyclerView) findViewById(R.id.reyclerview_contactsInvite);

        mAdapter = new InviteAdapter(inviteList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareInviteData();
        getContactList();
    }



    private void prepareInviteData() {

        InviteData bubble1 = new InviteData("profile pic", "name", true);
        inviteList.add(bubble1);

        InviteData bubble2 = new InviteData("profile pic2", "name2", false);
        inviteList.add(bubble2);

        mAdapter.notifyDataSetChanged();
    }

    private void getContactList() {
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if ((cur != null ? cur.getCount() : 0) > 0) {
            while (cur != null && cur.moveToNext()) {
                String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));

                if (cur.getInt(cur.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));

                        String pic = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.PHOTO_URI));

                        InviteData bubble1 = new InviteData(pic, name, true);
                        inviteList.add(bubble1);

                        Log.i("i", "Name: " + name);
                        Log.i("i", "Phone Number: " + phoneNo);
                        Log.i("i", "Photo: " + pic);
                    }
                    pCur.close();
                }
            }
        }
        if(cur!=null){
            cur.close();
        }
    }

}
