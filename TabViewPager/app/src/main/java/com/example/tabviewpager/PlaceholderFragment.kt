package com.example.tabviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment


class PlaceholderFragment : Fragment() {

    companion object{
        const val IMAGE_1 = "image_1"
        const val NAME_1 = "name_1"
        const val VALUE_1 = "value_1"
        const val IMAGE_2 = "image_2"
        const val NAME_2 = "name_2"
        const val VALUE_2 = "value_2"
        const val IMAGE_3 = "image_3"
        const val NAME_3 = "name_3"
        const val VALUE_3 = "value_3"
        const val IMAGE_4 = "image_4"
        const val NAME_4 = "name_4"
        const val VALUE_4 = "value_4"
        const val IMAGE_5 = "image_5"
        const val NAME_5 = "name_5"
        const val VALUE_5 = "value_5"

        @JvmStatic
        fun newInstance(image : List<Int>, name: List<String>, value: List<String>) : PlaceholderFragment{
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(IMAGE_1,image[0])
                    putInt(IMAGE_2,image[1])
                    putInt(IMAGE_3,image[2])
                    putInt(IMAGE_4,image[3])
                    putInt(IMAGE_5,image[4])
                    putString(NAME_1,name[0])
                    putString(NAME_2,name[1])
                    putString(NAME_3,name[2])
                    putString(NAME_4,name[3])
                    putString(NAME_5,name[4])
                    putString(VALUE_1,value[0])
                    putString(VALUE_2,value[1])
                    putString(VALUE_3,value[2])
                    putString(VALUE_4,value[3])
                    putString(VALUE_5,value[4])
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            view.findViewById<ImageView>(R.id.image_1).setImageDrawable(
                    ResourcesCompat.getDrawable(
                            resources, it.getInt(
                            IMAGE_1, R.drawable.ic_launcher_background
                            ),null
                    )
            )
            view.findViewById<TextView>(R.id.name_1).text = it.getString(NAME_1, "Empty")
            view.findViewById<TextView>(R.id.value_1).text = it.getString(VALUE_1,"Indisponivel")

            view.findViewById<ImageView>(R.id.image_2).setImageDrawable(
                    ResourcesCompat.getDrawable(
                            resources, it.getInt(
                            IMAGE_2, R.drawable.ic_launcher_background
                    ),null
                    )
            )
            view.findViewById<TextView>(R.id.name_2).text = it.getString(NAME_2, "Empty")
            view.findViewById<TextView>(R.id.value_2).text = it.getString(VALUE_2,"Indisponivel")

            view.findViewById<ImageView>(R.id.image_3).setImageDrawable(
                    ResourcesCompat.getDrawable(
                            resources, it.getInt(
                            IMAGE_3, R.drawable.ic_launcher_background
                    ),null
                    )
            )
            view.findViewById<TextView>(R.id.name_3).text = it.getString(NAME_3, "Empty")
            view.findViewById<TextView>(R.id.value_3).text = it.getString(VALUE_3,"Indisponivel")

            view.findViewById<ImageView>(R.id.image_4).setImageDrawable(
                    ResourcesCompat.getDrawable(
                            resources, it.getInt(
                            IMAGE_4, R.drawable.ic_launcher_background
                    ),null
                    )
            )
            view.findViewById<TextView>(R.id.name_4).text = it.getString(NAME_4, "Empty")
            view.findViewById<TextView>(R.id.value_4).text = it.getString(VALUE_4,"Indisponivel")

            view.findViewById<ImageView>(R.id.image_5).setImageDrawable(
                    ResourcesCompat.getDrawable(
                            resources, it.getInt(
                            IMAGE_5, R.drawable.ic_launcher_background
                    ),null
                    )
            )
            view.findViewById<TextView>(R.id.name_5).text = it.getString(NAME_5, "Empty")
            view.findViewById<TextView>(R.id.value_5).text = it.getString(VALUE_5,"Indisponivel")
        }

        super.onViewCreated(view, savedInstanceState)
    }
}