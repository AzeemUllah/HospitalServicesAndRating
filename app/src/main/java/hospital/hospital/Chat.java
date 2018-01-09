package hospital.hospital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hospital.hospital.ChatResources.ChatAdapter;
import hospital.hospital.ChatResources.ChatData;

public class Chat extends AppCompatActivity {
    private List<ChatData> chatList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ChatAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView = (RecyclerView) findViewById(R.id.reyclerview_message_list);

        mAdapter = new ChatAdapter(chatList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }



    private void prepareMovieData() {
        chatList.add(new ChatData("","","",""));

        ChatData bubble1 = new ChatData("message1", "1", "time1", "name1");
        chatList.add(bubble1);
        ChatData bubble2 = new ChatData("message2", "", "time2", "name2");
        chatList.add(bubble2);
        ChatData bubble3 = new ChatData("message3", "", "time3", "name3");
        chatList.add(bubble3);

        mAdapter.notifyDataSetChanged();
    }
}
