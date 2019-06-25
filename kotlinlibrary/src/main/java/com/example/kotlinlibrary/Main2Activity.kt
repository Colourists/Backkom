package com.example.kotlinlibrary

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.baselibrary.BaseActivity

import kotlinx.android.synthetic.main.activity_main2.*
@Route(path = "/kotlin/main2")
class Main2Activity : BaseActivity() {
    override fun initView() {
    }

    override fun loadData() {
    }

    override fun initListener() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            start("/kotlin/main1")
        }
    }

}
