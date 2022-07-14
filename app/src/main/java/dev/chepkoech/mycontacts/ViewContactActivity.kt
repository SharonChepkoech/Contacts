package dev.chepkoech.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import dev.chepkoech.mycontacts.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }

    fun getExtras() {
        val extras = intent.extras
//        var name = extras?.getString("NAME", " ")
//        var phone = extras?.getString("PHONE_NUMBERS", "")
        var name =extras?.getString("NAME","name")
        var phoneNumberOne = extras?.getString("PHONENUMBERONE","phoneNumberOne")
        var emailAddressOne = extras?.getString("EMAILADDRESSONE","emailAddressOne")
        var locationOne = extras?.getString("LOCATIONONE","locationone")


        binding.tvNameOne.text = name
        binding.tvPhoneNumberOne.text = phoneNumberOne
        binding.tvEmailAddressOne.text = emailAddressOne
        binding.tvLocationOne.text = locationOne

        Picasso.get()
            .load(intent.getStringExtra("PROFILE"))
            .resize(300,300)
            .into(binding.imgProfile)



        Toast.makeText(this, name, Toast.LENGTH_LONG).show()
    }
}