package jp.ne.mkb.ringring.ui;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import jp.ne.mkb.ringring.utils.BottomNavigationViewHelper;
import jp.ne.mkb.ringring.R;

public class MainActivity extends AppCompatActivity {

    //mute判断フラグ
    private int flag = 1;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction homeFragmentTransaction = getFragmentManager().beginTransaction();
                    homeFragmentTransaction.replace(R.id.frame,homeFragment,"ホーム");
                    homeFragmentTransaction.commit();
                    return true;
                case R.id.navigation_follow:
                    FollowFragment followFragment = new FollowFragment();
                    FragmentTransaction followFragmentTransaction = getFragmentManager().beginTransaction();
                    followFragmentTransaction.replace(R.id.frame,followFragment,"フォロー");
                    followFragmentTransaction.commit();
                    return true;
                case R.id.navigation_message:
                    MessageFragment messageFragment = new MessageFragment();
                    FragmentTransaction messageFragmentTransaction = getFragmentManager().beginTransaction();
                    messageFragmentTransaction.replace(R.id.frame,messageFragment,"メッセージ");
                    messageFragmentTransaction.commit();
                    return true;
                case R.id.navigation_mypage:
                    HomeFragment fragment = new HomeFragment();
                    FragmentTransaction mypageFragmentTransaction = getFragmentManager().beginTransaction();
                    mypageFragmentTransaction.replace(R.id.frame,fragment,"マイページ");
                    mypageFragmentTransaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_subject_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


}
