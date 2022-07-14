package dev.chepkoech.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import dev.chepkoech.mycontacts.databinding.ContactListItemBinding

class ContactsRVAdapter(var contactList:List<Contact>):
    RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var binding = ContactListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactsViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var currentContact = contactList.get(position)
        with(holder.binding){
        val contactsBinding = holder.binding
        val context = holder.itemView.context
        contactsBinding.tvName.text = currentContact.name
        contactsBinding.tvEmail.text = currentContact.email
        contactsBinding.tvPhoneNUmber.text = currentContact.phoneNumber
        contactsBinding.tvAddress.text = currentContact.address
        Picasso.get()
            .load(currentContact.image)
            .error(R.drawable.ic_baseline_error_outline_24)
            .resize(300,300)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_person_24)
            .into(imgContact)


            cvContact.setOnClickListener{
                val intent = Intent(context,ViewContactActivity::class.java)
//                intent.putExtra("NAME", currentContact.name)
                intent.putExtra("PROFILE", currentContact.image)
                intent.putExtra("NAME",currentContact.name)
                intent.putExtra("PHONENUMBERONE",currentContact.phoneNumber)
                intent.putExtra("EMAILADDRESSONE",currentContact.email)
                intent.putExtra("LOCATIONONE",currentContact.address)
                context.startActivity(intent)


            }
            imgContact.setOnClickListener{
                Toast.makeText(context,"You have clicked on my face!",Toast.LENGTH_LONG)
                    .show()
            }

            }
    }
    override fun getItemCount(): Int {
        return contactList.size
    }
}

class ContactsViewHolder(var binding:  ContactListItemBinding):RecyclerView.ViewHolder(binding.root){


}
