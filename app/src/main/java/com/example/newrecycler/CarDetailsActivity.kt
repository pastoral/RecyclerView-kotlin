package com.example.newrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.newrecycler.databinding.ActivityCarDetailsBinding
import kotlinx.android.synthetic.main.activity_car_details.*

class CarDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityCarDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_car_details)

        car_name.text = getIntent().getStringExtra("CARNAME")
        car_description.text = getIntent().getStringExtra("CARDESC")
        image_car.setImageResource(getIntent().getStringExtra("CARLOGO").toInt())

    }
}
