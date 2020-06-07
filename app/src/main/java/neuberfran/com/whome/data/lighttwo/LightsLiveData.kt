package neuberfran.com.whome.data.lighttwo

import android.arch.lifecycle.LiveData
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import neuberfran.com.whome.data.lighttwo.LightTwo
import javax.inject.Inject


class LightsLiveData @Inject constructor(val firebase: DatabaseReference) : LiveData<LightTwo>() {

    companion object {
        private val TAG = LightsLiveData::class.java.simpleName!!
        private const val FIREBASE_TWO_ON = "lighttwo/on"
    }

    private val valueEventListener = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val newValue = snapshot.getValue(Boolean::class.java) ?: false
            Log.d(TAG, "onDataChange (value=$newValue)")
            value = LightTwo(newValue)
        }

        override fun onCancelled(error: DatabaseError) {
            Log.w(TAG, "onCancelled", error.toException())
        }
    }

    override fun onActive() {
        firebase.child(FIREBASE_TWO_ON).addValueEventListener(valueEventListener)
    }

    override fun onInactive() {
        firebase.child(FIREBASE_TWO_ON).removeEventListener(valueEventListener)
    }
}