package ao.marco.bin2dec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.databinding.DataBindingUtil
import ao.marco.bin2dec.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            goToSecondActivity()
        }, 3000)
    }

    private fun goToSecondActivity(){
        val newActivity = Intent(this, CalcActivity().javaClass)

        // This Flag will remove the old activity
        newActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        newActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(newActivity)
        finish()
    }
}