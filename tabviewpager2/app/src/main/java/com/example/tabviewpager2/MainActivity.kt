package com.example.tabviewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    val tabs by lazy { findViewById<TabLayout>(R.id.tabs) }
    val view_pager by lazy { findViewById<ViewPager2>(R.id.view_pager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragments = getFragment()
        val sectionsPager = SectionsPager(fragments,this)

        view_pager.adapter = sectionsPager
        view_pager.offscreenPageLimit = 1

        TabLayoutMediator(tabs,view_pager){tab , position->
            tab.text = fragments[position].arguments?.getString(
                PlaceholderFragment.FRAGMENT_NAME,
                "Sem Valor"
            )
        }.attach()
    }

    private fun getFragment() : List<Fragment> {
        return listOf(
            PlaceholderFragment.newInstance(
                "Fragment_1",
                R.color.design_default_color_secondary
            ),
            PlaceholderFragment.newInstance(
                "Fragment_2",
                R.color.material_on_background_disabled
            ),
            PlaceholderFragment.newInstance(
                "Fragment_3",
                R.color.purple_700
            )
        )
    }
}