package com.example.configurationchanges

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.configurationchanges.databinding.ActivityMainBinding

const val TAG="MAIN ACTIVITY"
class MainActivity : AppCompatActivity() {
    var count=0
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val textView=binding.textView
        val incrementBtn=binding.incrementBtn
        val decrementBtn=binding.decrementBtn
        incrementBtn.setOnClickListener {
            count++
            textView.text=count.toString()
        }
        decrementBtn.setOnClickListener {
            count--
            textView.text=count.toString()
        }
        if(savedInstanceState!=null){
            count=savedInstanceState.getInt("count")
            textView.text=count.toString()
        }
    }
//onSavedInstanceState is called before activity is destroyed
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(TAG,"ONSAVED")
        outState.putInt("count",count)
    }
}