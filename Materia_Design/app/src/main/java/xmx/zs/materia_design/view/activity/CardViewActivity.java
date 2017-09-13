package xmx.zs.materia_design.view.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import xmx.zs.materia_design.R;
import xmx.zs.materia_design.base.BaseActivity;

public class CardViewActivity extends BaseActivity {

    private CardView mCardView;
    private SeekBar  mRadiusSeekBar;
    private SeekBar  mElevationSeekBar;


    @Override
    protected int setContentViewId() {
        return R.layout.activity_cardview;
    }

    @Override
    protected void initView() {
        mCardView = (CardView) findViewById(R.id.cardview);
        mRadiusSeekBar = (SeekBar) findViewById(R.id.cardview_radius_seekbar);
        mElevationSeekBar = (SeekBar) findViewById(R.id.cardview_elevation_seekbar);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        mRadiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG, String.format("SeekBar Radius progress : %d", progress));
                mCardView.setRadius(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Do nothing
            }
        });


        mElevationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG, String.format("SeekBar Elevation progress : %d", progress));
                mCardView.setElevation(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Do nothing
            }
        });
    }

    @Override
    public void onClick(View v) {

    }


}
