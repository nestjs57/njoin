package com.hiyupin.njoin.activity.register

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.widget.Toast
import com.chibatching.kotpref.Kotpref
import com.hiyupin.njoin.R
import com.hiyupin.njoin.UserConfig
import com.hiyupin.njoin.pojo.UserModel
import kotlinx.android.synthetic.main.activity_register.*
import android.content.Intent


class RegisterActivity : AppCompatActivity(), RegisterContract.registerView {

    var presenter: RegisterPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        getSupportActionBar()?.hide();

        Kotpref.init(this)
        presenter = RegisterPresenter(this)
        setEvent()
    }

    private fun setEvent() {
        btn_submit.setOnClickListener {

            if (edt_email.text.isEmpty()) edt_email.setError("Email is empty");
            if (edt_password.text.isEmpty()) edt_password.setError("Password is empty");
            if (edt_fullname.text.isEmpty()) edt_fullname.setError("Fullname is empty");
            if (edt_confirm_password.text.isEmpty()) edt_confirm_password.setError("Confirm password is empty");
            if (edt_confirm_password.text.toString() != edt_password.text.toString()) edt_confirm_password.setError("Passwords do not match");

            if (edt_email.text.isNotEmpty()
                && edt_password.text.isNotEmpty()
                && edt_fullname.text.isNotEmpty()
                && edt_confirm_password.text.isNotEmpty()
                && (edt_confirm_password.text.toString() == edt_password.text.toString())
            ) {
                presenter?.getRegister(
                    edt_email.text.toString(),
                    edt_password.text.toString(),
                    edt_fullname.text.toString()
                )
            }
        }
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
        view_bg.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
        view_bg.visibility = View.GONE
    }

    override fun closeActivity() {
        finish()
    }

    override fun registerFail() {
        Toast.makeText(this, "Your email has been used.", Toast.LENGTH_SHORT).show();
    }

    override fun setDataUser(list: ArrayList<UserModel>) {
        UserConfig.status_login = 1;
        UserConfig.user_id = list.get(0).user_id
        UserConfig.user_email = list.get(0).user_email
        UserConfig.user_fullname = list.get(0).user_fullname
        UserConfig.user_gender = list.get(0).user_gender
        UserConfig.user_nation = list.get(0).user_nation

        val intent = Intent()
        intent.putExtra("email", list.get(0).user_email);
        intent.putExtra("password", list.get(0).user_password);
        setResult(RESULT_OK, intent);
        finish();
//        setResult(Activity.RESULT_OK)
//        finish()
    }
}
