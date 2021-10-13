package com.majestadev.andersenhw5.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.majestadev.andersenhw5.R
import com.majestadev.andersenhw5.model.Contact

private const val CONTACT_ID = "contactId"
private const val CONTACT_NAME = "contactName"
private const val CONTACT_SURNAME = "contactSurname"
private const val CONTACT_PHONE = "contactPhone"

private var contacts = arrayOf(
    Contact(1, "Gorilla", "Turbo", "11111111111"),
    Contact(2, "Crocodile", "Supercharger", "22222222222"),
    Contact(3, "Elephant", "Hydraulic", "33333333333"),
    Contact(4, "Leopard", "Wagon", "44444444444")
)

class ContactsListFragment : Fragment(R.layout.fragment_contacts_list) {
    private val contactId: Int by lazy { requireArguments().getInt(CONTACT_ID, 0) }
    private val contactName: String by lazy { requireArguments().getString(CONTACT_NAME, "") }
    private val contactSurname: String by lazy { requireArguments().getString(CONTACT_SURNAME, "") }
    private val contactPhone: String by lazy { requireArguments().getString(CONTACT_PHONE, "") }
    private lateinit var contactClickedListener: ContactClickedListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contact1TextView: TextView = view.findViewById(R.id.contact1TextView)
        val contact2TextView: TextView = view.findViewById(R.id.contact2TextView)
        val contact3TextView: TextView = view.findViewById(R.id.contact3TextView)
        val contact4TextView: TextView = view.findViewById(R.id.contact4TextView)

        contact1TextView.text = contacts[0].name
        contact2TextView.text = contacts[1].name
        contact3TextView.text = contacts[2].name
        contact4TextView.text = contacts[3].name

        if (arguments?.isEmpty == false) {
            when (contactId) {
                1 -> {
                    val contact = contacts[0]
                    contact.name = contactName
                    contact.surname = contactSurname
                    contact.phone = contactPhone
                    contact1TextView.text = contactName
                }
                2 -> {
                    val contact = contacts[1]
                    contact.name = contactName
                    contact.surname = contactSurname
                    contact.phone = contactPhone
                    contact2TextView.text = contactName
                }
                3 -> {
                    val contact = contacts[2]
                    contact.name = contactName
                    contact.surname = contactSurname
                    contact.phone = contactPhone
                    contact3TextView.text = contactName
                }
                4 -> {
                    val contact = contacts[3]
                    contact.name = contactName
                    contact.surname = contactSurname
                    contact.phone = contactPhone
                    contact4TextView.text = contactName
                }
            }
        }

        contact1TextView.setOnClickListener {
            val contact = contacts[0]
            contactClickedListener.contactClicked(contact.id, contact.name, contact.surname, contact.phone)
        }

        contact2TextView.setOnClickListener {
            val contact = contacts[1]
            contactClickedListener.contactClicked(contact.id, contact.name, contact.surname, contact.phone)
        }

        contact3TextView.setOnClickListener {
            val contact = contacts[2]
            contactClickedListener.contactClicked(contact.id, contact.name, contact.surname, contact.phone)
        }

        contact4TextView.setOnClickListener {
            val contact = contacts[3]
            contactClickedListener.contactClicked(contact.id, contact.name, contact.surname, contact.phone)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ContactClickedListener) {
            contactClickedListener = context
        } else {
            throw ClassCastException("$context must implement ContactClickedListener")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(contactId: Int?, contactName: String?, contactSurname: String?, contactPhone: String?) =
            ContactsListFragment().apply {
                if (contactId != null && contactName != null) {
                    arguments = Bundle().apply {
                        putInt(CONTACT_ID, contactId)
                        putString(CONTACT_NAME, contactName)
                        putString(CONTACT_SURNAME, contactSurname)
                        putString(CONTACT_PHONE, contactPhone)
                    }
                } else {
                    ContactsListFragment()
                }
            }
    }
}