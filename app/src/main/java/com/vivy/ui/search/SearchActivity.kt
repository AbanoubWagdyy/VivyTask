package com.vivy.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vivy.R
import com.vivy.di.base.BaseActivity

class SearchActivity : BaseActivity() {

    override fun layoutRes(): Int = R.layout.activity_search

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, SearchFragment.newInstance())
            .commitAllowingStateLoss()
    }
}
