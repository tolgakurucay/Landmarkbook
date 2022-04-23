package com.tolgakurucay.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tolgakurucay.storingdata.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences:SharedPreferences
    var ageFromPreferences:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //SharedPreferences Initialize
        sharedPreferences=this.getSharedPreferences("com.tolgakurucay.storingdata",Context.MODE_PRIVATE)

        ageFromPreferences = sharedPreferences.getInt("age",-1)
        if(ageFromPreferences==-1)
        {
            textView.text="Your Age : "
        }
        else
        {
            textView.text="Your Age : $ageFromPreferences"
        }


    }

    fun save(view :View)
    {
        //SharedPreferences
        //Ufak verileri kaydetmek için kullanılır




        val myAge=ageText.text.toString().toIntOrNull()
        if(myAge!=null)
        {
            textView.text=myAge.toString()
            sharedPreferences.edit().putInt("age",myAge).apply()
        }
        else
        {
            textView.text="Hata!\nLütfen Tam Sayı Bir Değer Giriniz!"

        }
    }
    fun delete(view: View)
    {
        ageFromPreferences = sharedPreferences.getInt("age",-1)
        if(ageFromPreferences!=-1)
        {
            sharedPreferences.edit().remove("age").apply()
            textView.text="Your Age"


        }



    }
    fun update(view:View){

    }
}