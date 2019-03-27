package com.hiyupin.njoin.fragment.login


import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hiyupin.njoin.activity.main_page.MainPageActivity
import com.hiyupin.njoin.R
import com.hiyupin.njoin.activity.register.RegisterActivity
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment(), LoginContract.loginView {

    lateinit var presenter: LoginContract.loginPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_login, container, false)
        setEvent(view)
        presenter = LoginPresenter(this)
        return view
    }

    fun setEvent(view: View) {
        view!!.btn_signup.setOnClickListener {
            val intent = Intent(this.context, RegisterActivity::class.java)
//            startActivity(intent)
            startActivityForResult(intent, 1)
        }

        view?.linear_signin.setOnClickListener {
            presenter.getLogin()
        }
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
        v_bg.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
        v_bg.visibility = View.GONE
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            1 -> when (resultCode) {
                RESULT_OK -> {
                    //do your work here
//                    edt_username.setText(data?.getStringExtra("email"))
//                    edt_passwords.setText(data?.getStringExtra("password"))
                    val intents = Intent(activity, MainPageActivity::class.java)
                    startActivity(intents)
                    activity?.finish()

                }
            }
        }
    }

}
