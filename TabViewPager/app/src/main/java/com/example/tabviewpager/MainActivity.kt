package com.example.tabviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    val viewPager by lazy { findViewById<ViewPager2>(R.id.view_pager) }
    val tabs by lazy { findViewById<TabLayout>(R.id.tab) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val page_name = listOf("Salgados","Lanches","Bebidas")
        val fragments = getFragment()
        val sectionsPager = SectionsPager(fragments,this)

        viewPager.adapter = sectionsPager
        viewPager.offscreenPageLimit = 1

        TabLayoutMediator(tabs,viewPager){ tab, position ->
            tab.text = page_name[position]
        }.attach()
    }

    private fun getFragment(): List<Fragment>{
        return listOf(
                PlaceholderFragment.newInstance(
                        listOf(R.drawable.coxinha,R.drawable.enroladinho,R.drawable.paopizza,R.drawable.pastel,R.drawable.stilo),
                        listOf("Coxinha","Enroladinho","Pão pizza","Pastel","Stilo"),
                        listOf("R$11,25","R$7,50","R$5,50","R$2,00","R$15,00")
                ),
                PlaceholderFragment.newInstance(
                        listOf(R.drawable.x_tudo,R.drawable.x_salada,R.drawable.misto,R.drawable.cachorroquente,R.drawable.doubleburguer),
                        listOf("X-tudo","X-salada","Misto Quente","Cachorro Quente","Double Burguer"),
                        listOf("R$20,00","R$12,50","R$8,50","R$5,00","R$15,00")
                ),
                PlaceholderFragment.newInstance(
                        listOf(R.drawable.coca,R.drawable.guarana,R.drawable.fanta,R.drawable.limao,R.drawable.drpeppercola),
                        listOf("Coca-cola","Guaraná","Fanta Laranja","Refri de Limão","DrPepperCola"),
                        listOf("R$8,50","R$7,50","R$6,50","R$6,50","R$12,00")
                )
        )
    }
}