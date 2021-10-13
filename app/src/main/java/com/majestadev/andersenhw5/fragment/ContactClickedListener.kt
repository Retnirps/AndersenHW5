package com.majestadev.andersenhw5.fragment

interface ContactClickedListener {
    fun contactClicked(contactId: Int, contactName: String, contactSurname: String, contactPhone: String)
}