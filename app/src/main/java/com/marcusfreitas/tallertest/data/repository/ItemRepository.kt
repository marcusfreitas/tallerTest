package com.marcusfreitas.tallertest.data.repository

import com.marcusfreitas.tallertest.data.model.Item

interface ItemRepository {
    fun getItems(): List<Item>
}