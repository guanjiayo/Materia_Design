package xmx.zs.materia_design.view.activity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.FloatingActionButton.OnVisibilityChangedListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import xmx.zs.materia_design.R;
import xmx.zs.materia_design.base.BaseActivity;
import xmx.zs.materia_design.listener.OnSeekBarChangeListener;
import xmx.zs.materia_design.utils.Logger;

/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2017/9/14
 * @本类描述	  FloatingActionButton
 * @内容说明
 *
 */

public class FloatingActionButtonActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {


    private FloatingActionButton mFab_code;
    private View                 mElevation_layout;
    private TextView             mTv_elevation;
    private SeekBar              mSeekbar_elevation;
    private CheckBox             mCb_useCompatPadding;
    private Switch               mSwitch_fab;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_fab_btn;
    }

    @Override
    protected void initView() {
        mSwitch_fab = (Switch) findViewById(R.id.sw_fab);
        mFab_code = (FloatingActionButton) findViewById(R.id.fab_code);
        /*elevation*/
        mElevation_layout = findViewById(R.id.seekbar_elevation);
        mTv_elevation = (TextView) mElevation_layout.findViewById(R.id.tv_seekbar_fab);
        mSeekbar_elevation = (SeekBar) mElevation_layout.findViewById(R.id.seekbar_fab);
        mCb_useCompatPadding = (CheckBox) findViewById(R.id.cb_UseCompatPadding);

    }

    @Override
    protected void initData() {
        mTv_elevation.setText("Elevation");

        /*BackgroundTintList*/
        mFab_code.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

        /*BackgroundTintMode*/
        mFab_code.setBackgroundTintMode(PorterDuff.Mode.SRC_ATOP);

        /*RippleColor*/
        mFab_code.setRippleColor(Color.BLUE);

        /*fabSize*/
        mFab_code.setSize(FloatingActionButton.SIZE_AUTO);

    }


    @Override
    protected void initEvent() {
        mSwitch_fab.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mFab_code.hide(mOnVisibilityChangedListener);
                } else {
                    mFab_code.show(mOnVisibilityChangedListener);

                }
            }
        });



        /*checkbox_useCompatPadding*/
        mCb_useCompatPadding.setOnCheckedChangeListener(this);

        /*elevation*/
        mSeekbar_elevation.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(int progress) {
                //兼容性,使用 setCompatElevation(float)
                mFab_code.setCompatElevation(progress);
            }
        });


    }

    /**
     * FAB 隐藏或显示监听事件
     */
    OnVisibilityChangedListener mOnVisibilityChangedListener = new OnVisibilityChangedListener() {
        public void onShown(FloatingActionButton fab) {
            Logger.i(TAG, "Fab show...");
        }

        @Override
        public void onHidden(FloatingActionButton fab) {
            Logger.i(TAG, "Fab hide...");
        }
    };


    /**
     * 设置不同状态时颜色。
     */
    private ColorStateList createColorStateList(int normal, int pressed, int focused, int unable) {
        int[] colors = new int[]{pressed, focused, normal, focused, unable, normal};
        int[][] states = new int[6][];
        states[0] = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        states[1] = new int[]{android.R.attr.state_enabled, android.R.attr.state_focused};
        states[2] = new int[]{android.R.attr.state_enabled};
        states[3] = new int[]{android.R.attr.state_focused};
        states[4] = new int[]{android.R.attr.state_window_focused};
        states[5] = new int[]{};
        return new ColorStateList(states, colors);
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        Logger.i(TAG, isChecked + "");
        mFab_code.setUseCompatPadding(isChecked);
    }


}
