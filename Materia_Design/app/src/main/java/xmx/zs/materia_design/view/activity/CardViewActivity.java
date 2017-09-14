package xmx.zs.materia_design.view.activity;

import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import xmx.zs.materia_design.R;
import xmx.zs.materia_design.base.BaseActivity;
import xmx.zs.materia_design.listener.OnSeekBarChangeListener;

/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2017/6/10
 * @本类描述	  CardView
 * @内容说明
 *
 * @补充内容
 *
 * ---------------------------------
 * @更新时间
 * @新增内容
 *
 */
public class CardViewActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {

    private CardView mCardView;
    private CardView mCardView_def;
    private SeekBar  mRadiusSeekBar;
    private SeekBar  mElevationSeekBar;
    private TextView mTv_radius;
    private TextView mTv_elevation;
    private TextView mTv_maxElevation;
    private SeekBar  mMaxElevationSeekbar;
    private CheckBox mCb_cardPreventCornerOverlap;
    private CheckBox mCb_cardUseCompatPadding;


    @Override
    protected int setContentViewId() {
        return R.layout.activity_cardview;
    }

    @Override
    protected void initView() {

        mCardView = (CardView) findViewById(R.id.cardview);
        mCardView_def = (CardView) findViewById(R.id.cardview_def);
        /*SeekBar_Layout*/
        View radius_seekbar_Layout = findViewById(R.id.radius_seekbar_Layout);
        View elevation_seekbar_Layout = findViewById(R.id.elevation_seekbar_Layout);
        View maxelevation_seekbar_Layout = findViewById(R.id.maxelevation_seekbar_Layout);
        /*TextView*/
        mTv_radius = (TextView) radius_seekbar_Layout.findViewById(R.id.tv_seekbar_cardview);
        mTv_elevation = (TextView) elevation_seekbar_Layout.findViewById(R.id.tv_seekbar_cardview);
        mTv_maxElevation = (TextView) maxelevation_seekbar_Layout.findViewById(R.id.tv_seekbar_cardview);
        /*Seekbar*/
        mRadiusSeekBar = (SeekBar) radius_seekbar_Layout.findViewById(R.id.seekbar_cardview);
        mElevationSeekBar = (SeekBar) elevation_seekbar_Layout.findViewById(R.id.seekbar_cardview);
        mMaxElevationSeekbar = (SeekBar) maxelevation_seekbar_Layout.findViewById(R.id.seekbar_cardview);
        /*CheckBox*/
        mCb_cardPreventCornerOverlap = (CheckBox) findViewById(R.id.cb_cardPreventCornerOverlap);
        mCb_cardUseCompatPadding = (CheckBox) findViewById(R.id.cb_cardUseCompatPadding);

    }

    @Override
    protected void initData() {
        mTv_elevation.setText(getResources().getString(R.string.elevation_seekbar_text));
        mTv_radius.setText(getResources().getString(R.string.radius_seekbar_text));
        mTv_maxElevation.setText(getResources().getString(R.string.maxElevation_seekbar_text));

    }

    @Override
    protected void initEvent() {
        mCardView.setOnClickListener(this);
        mCardView_def.setOnClickListener(this);
        mCb_cardPreventCornerOverlap.setOnCheckedChangeListener(this);
        mCb_cardUseCompatPadding.setOnCheckedChangeListener(this);

        mRadiusSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(int progress) {
                Log.d(TAG, String.format("SeekBar Radius progress : %d", progress));
                mCardView.setRadius(progress);
            }
        });


        mElevationSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(int progress) {
                Log.d(TAG, String.format("SeekBar Elevation progress : %d", progress));
                mCardView.setCardElevation(progress);
            }
        });

        mMaxElevationSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(int progress) {
                Log.d(TAG, String.format("SeekBar MaxElevation progress : %d", progress));
                mCardView.setMaxCardElevation(progress);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cardview:
                showToast("长按有惊喜..!");
                break;
            case R.id.cardview_def:
                showToast("长按有惊喜..!");
                break;

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.cb_cardPreventCornerOverlap:
                Log.i(TAG, isChecked + "");
                mCardView.setPreventCornerOverlap(isChecked);
                break;
            case R.id.cb_cardUseCompatPadding:
                Log.i(TAG, isChecked + "");
                mCardView.setUseCompatPadding(isChecked);
                break;
        }


    }
}
