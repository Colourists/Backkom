package com.example.kotlinlibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.baselibrary.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


@Route(path = "/kotlin/main1")
class Main1Activity : BaseActivity() {
    override fun initView() {

    }

    override fun loadData() {

    }

    override fun initListener() {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { View ->
            textView.text = "dsgsdgsdg"

            ARouter.getInstance()
                    .build("/kotlin/main3")
                    .navigation()
        }
//        val findViewById = findViewById<TextView>(R.id.textView)
//        findViewById.text = "fdsfsdfsd";

    }

    public fun to1(view: View) {

    }


}
