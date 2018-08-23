package neuberfran.com.whome.ui.main

import android.arch.lifecycle.ViewModel
import neuberfran.com.whome.data.lightone.FanLiveData
import neuberfran.com.whome.data.lighttwo.LightsLiveData
import javax.inject.Inject

class MainViewModel @Inject constructor(val fanLiveData: FanLiveData, val lightsLiveData: LightsLiveData) : ViewModel()
