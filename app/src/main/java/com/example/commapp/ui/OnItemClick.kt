package com.example.commapp.ui

interface OnItemClick {
    fun favorite(id: Int, type: String)
    fun goDetail(id: Int, type: String)
}