package xmx.zs.materia_design.listener;
/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2017/9/13
 * @本类描述	  SeekBarChangeListener接口的适配器模式
 * @内容说明
 *
 */

import android.widget.SeekBar;

public abstract class OnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        onProgressChanged(progress);
    }

    public abstract void onProgressChanged(int progress);

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
