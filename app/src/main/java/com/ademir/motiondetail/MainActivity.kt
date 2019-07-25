package com.ademir.motiondetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activtiy_1.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activtiy_2)

        recyclerView.adapter = ItemAdapter().apply {
            setData(Array(LIST_SIZE) { Item() }.toList())
        }
        nestedScrollView.isNestedScrollingEnabled = false
    }

    companion object {
        const val LIST_SIZE = 20
    }

}
