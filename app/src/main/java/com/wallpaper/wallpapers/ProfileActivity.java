package com.wallpaper.wallpapers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.wallpaper.wallpapers.adapters.UserAdapter;
import com.wallpaper.wallpapers.models.Wallpapers;
import com.wallpaper.wallpapers.utilities.GridSpacingItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity{

    @BindView(R.id.toolbar) Toolbar mToolbar;

    @BindView(R.id.listshow) RecyclerView mRecyclerView;

    private List<Wallpapers> mList;
    UserAdapter mAdapter;

    private boolean flagDecoration = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();
        eventUI();
    }

    public void init(){
        ButterKnife.bind(this);

        mToolbar.setTitle("Mi perfil");
        setSupportActionBar(mToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mList = Wallpapers.getWallpapers();
        mRecyclerView = (RecyclerView) findViewById(R.id.listshow);
    }

    public void eventUI(){
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        service();
    }

    public void service(){
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        if(!flagDecoration) {
            mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, GridSpacingItemDecoration.dpToPx(10, this), true));
            flagDecoration = true;
        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new UserAdapter(this, mList, object -> {
            Wallpapers wallpapers = (Wallpapers) object;
            Toast.makeText(this, wallpapers.getTitle(), Toast.LENGTH_SHORT).show();
        });

        mRecyclerView.setAdapter(mAdapter);
    }
}
