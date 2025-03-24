package com.marcusfreitas.tallertest.data.repository

import com.marcusfreitas.tallertest.data.model.Item

class ItemRepositoryImpl : ItemRepository {
    override fun getItems(): List<Item> {
        return List(10) {
            Item("Title $it", "Description for item $it")
        }
    }
}