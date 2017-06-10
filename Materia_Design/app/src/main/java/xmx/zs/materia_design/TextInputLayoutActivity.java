package xmx.zs.materia_design;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
/*
 * @创建者     mqm
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2017/6/10
 * @本类描述	  TextInputLyout 实际使用例子
 * @内容说明   ${TODO} 重写EditText,自定义想要的样式
 * @补充内容
 *
 * ---------------------------------
 * @更新时间
 * @新增内容
 *
 */

public class TextInputLayoutActivity extends AppCompatActivity {

    private TextInputEditText mEditText_customize;
    private TextInputLayout   mTil_customize;
    private TextInputEditText mEditText;
    private TextInputLayout   mTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);

        //自定义密码开关输入框
        mEditText_customize = (TextInputEditText) findViewById(R.id.editText_customize);
        mTil_customize = (TextInputLayout) findViewById(R.id.til_customize);
        //系统自带的密码开关输入框
        mEditText = (TextInputEditText) findViewById(R.id.editText);
        mTextInputLayout = (TextInputLayout) findViewById(R.id.til);

        customizeEditText();
        TextInputLyout_EditText();

    }

    /**
     * 系统自带的密码开关输入框的错误信息处理
     */
    private void TextInputLyout_EditText() {
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mEditText.getText().length() > mTextInputLayout.getCounterMaxLength()) {
                    mTextInputLayout.setError("超出限定字数了...");
                }

            }
        });

    }

    /**
     * 自定义密码开关输入框的错误信息处理
     */
    private void customizeEditText() {
        mEditText_customize.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mEditText_customize.getText().length() > mTil_customize.getCounterMaxLength()) {
                    mEditText_customize.setError("超出限定字数了!!");
                }
            }
        });


    }
}
