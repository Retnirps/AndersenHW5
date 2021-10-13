package com.majestadev.andersenhw5.fragment

interface SaveChangesButtonClickListener {
    fun saveChangesButtonClicked(contactId: Int, contactName: String, contactSurname: String, contactPhone: String)
}