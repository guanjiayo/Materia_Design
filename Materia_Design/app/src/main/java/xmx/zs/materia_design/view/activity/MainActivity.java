package xmx.zs.materia_design.view.activity;

import android.view.View;
import android.widget.Button;

import xmx.zs.materia_design.R;
import xmx.zs.materia_design.base.BaseActivity;

/*
 * @创建者     mqm
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2017/6/10
 * @本类描述	  主页面
 * @内容说明  TODO 按我们的规范代码来写这个Demo
 *           TODO 每个Demo附上使用说明文档,后期上线
 * @补充内容
 *
 * ---------------------------------
 * @更新时间
 * @新增内容
 *
 */
public class MainActivity extends BaseActivity { //TODO 这里改成HomeActivity
    Button mBtnTextinputLayout;
    Button mBtnCardview;
    Button mBtnFABActivity;
    Button mBtnFlatActivity;
    Button mBtnRaisedActivity;


    @Override
    protected int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mBtnTextinputLayout = (Button) findViewById(R.id.btn_textinput_layout);
        mBtnCardview = (Button) findViewById(R.id.btn_cardview);
        mBtnFABActivity = (Button) findViewById(R.id.btn_FABActivity);
        mBtnFlatActivity = (Button) findViewById(R.id.btn_FlatActivity);
        mBtnRaisedActivity = (Button) findViewById(R.id.btn_RaisedActivity);
    }

    @Override
    protected void initEvent() {
        mBtnTextinputLayout.setOnClickListener(this);
        mBtnCardview.setOnClickListener(this);
        mBtnFABActivity.setOnClickListener(this);
        mBtnFlatActivity.setOnClickListener(this);
        mBtnRaisedActivity.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_textinput_layout:
                startActivity(TextInputLayoutActivity.class);
                break;
            case R.id.btn_cardview:
                startActivity(CardViewActivity.class);
                break;
            case R.id.btn_FABActivity:
                startActivity(FloatingActionButtonActivity.class);
                break;
            case R.id.btn_FlatActivity:
                startActivity(FlatButtonActivity.class);
                break;
            case R.id.btn_RaisedActivity:
                startActivity(RaisedButtonActivity.class);
                break;
        }
    }
}
