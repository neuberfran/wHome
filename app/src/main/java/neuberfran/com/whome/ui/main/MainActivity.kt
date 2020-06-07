package neuberfran.com.whome.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.ContentValues
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dagger.android.AndroidInjection
import neuberfran.com.whome.data.lighttwo.LightTwo
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var boardComponents: MainBoardComponents
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        Log.d(ContentValues.TAG, "to na passo 1 ")

        lifecycle.addObserver(boardComponents)

        Log.d(ContentValues.TAG, "to na passo 2 ")

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        Log.d(ContentValues.TAG, "to na passo 3 ")

        viewModel.fanLiveData.observe(this, Observer { fanState ->

            Log.d(ContentValues.TAG, "to na passo 4 ")

            boardComponents.setFanOn(fanState?.isOn ?: false)
        })

        Log.d(ContentValues.TAG, "to na passo 5 ")

        viewModel.lightsLiveData.observe(this, Observer { lightTwo ->

            Log.d(ContentValues.TAG, "to na passo 6 ")

            boardComponents.setLights(lightTwo?.isOn ?: false)

        })
    }
}
