package com.wallpaper.wallpapers;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.wallpaper.wallpapers.adapters.UserAdapter;
import com.wallpaper.wallpapers.models.Wallpapers;
import com.wallpaper.wallpapers.utilities.GridSpacingItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WallpapersActivity extends AppCompatActivity {

    private String TAG = WallpapersActivity.class.getSimpleName();

    @BindView(R.id.listshow) RecyclerView mRecyclerView;
    private List<Wallpapers> mList;
    Toolbar mToolbar;
    UserAdapter mAdapter;

    private String picture = "";
    private String title = "";

    private boolean flagDecoration = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        initControllers();
    }

    public void initControllers(){
        ButterKnife.bind(this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        setTitle("Wallpapers");

        mList = Wallpapers.getWallpapers();
        mRecyclerView = (RecyclerView) findViewById(R.id.listshow);
    }

    public void nextActivity(){
        Log.d(TAG, " ----------------> nextActivity");
        Intent mIntent = new Intent(this, WallpaperDetailActivity.class);
        mIntent.putExtra("picture", picture);
        mIntent.putExtra("title", title);
        startActivity(mIntent);
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
            picture = wallpapers.getUrl_picture();
            title = wallpapers.getTitle();
            nextActivity();
        });

        mRecyclerView.setAdapter(mAdapter);
    }

}
