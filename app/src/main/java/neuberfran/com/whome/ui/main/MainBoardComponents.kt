package neuberfran.com.whome.ui.main

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import com.google.android.things.pio.Gpio
import com.google.android.things.pio.PeripheralManager
import neuberfran.com.whome.data.lighttwo.LightTwo
import javax.inject.Inject

class MainBoardComponents @Inject constructor() : LifecycleObserver {

    companion object {
        const val GPIO_RELAY  = "BCM18"
        const val GPIO_RELAYB = "BCM27"
    }

    private lateinit var relay: Gpio
    private lateinit var relayb: Gpio

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        relay = PeripheralManager.getInstance().openGpio(GPIO_RELAY)
        relay.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW)
        relay.setActiveType(Gpio.ACTIVE_LOW)

        relayb = PeripheralManager.getInstance().openGpio(GPIO_RELAYB)
        relayb.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW)
        relayb.setActiveType(Gpio.ACTIVE_LOW)
    }

    fun setFanOn(on: Boolean) {
        relay.value = on
    }

    fun setLights(on: Boolean) {
        relayb.value = on
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        relay.close()
        relayb.close()
    }
}