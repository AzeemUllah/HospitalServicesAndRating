package hospital.hospital;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import hospital.hospital.ChatResources.ChatAdapter;
import hospital.hospital.ChatResources.ChatData;

public class Chat extends AppCompatActivity implements View.OnClickListener {
    private List<ChatData> chatList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ChatAdapter mAdapter;

    private ImageButton mMoreOptionsImgBtn;




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

        mMoreOptionsImgBtn = (ImageButton) findViewById(R.id.moreOptionsImgBtn);
        mMoreOptionsImgBtn.setOnClickListener(this);




        prepareChatData();
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.moreOptionsImgBtn:
                showBottomSheetDialog();
                break;
//            case R.id.closeFrag:
//                Toast.makeText(this,
//                        "Button is clicked!", Toast.LENGTH_LONG).show();
//                break;
            default:
                break;
        }
    }

    public void showBottomSheetDialog() {
        // 2 diffrent fragments one for user and other for facility
        View view =  getLayoutInflater().inflate(R.layout.fragment_chat_bottom_sheet_user_side, null);
        BottomSheetDialog dialog = new BottomSheetDialog(this,R.style.NewDialog);


//        Button mCloseFrag = (Button) view.findViewById(R.id.closeFrag);
//        mCloseFrag.setOnClickListener(this);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(view);
        dialog.show();
    }

//    @OnClick(R.id.btn_bottom_sheet_dialog_fragment)
//    public void showBottomSheetDialogFragment() {
//        fragment_chat_bottom_sheet_facility_side bottomSheetFragment = new fragment_chat_bottom_sheet_facility_side();
//        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
//    }

    private void prepareChatData() {
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
