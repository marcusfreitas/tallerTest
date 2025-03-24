package com.marcusfreitas.tallertest.domain.usecase

import com.marcusfreitas.tallertest.data.repository.ItemRepository

class GetItemsUseCase(private val repository: ItemRepository) {
    fun execute() = repository.getItems()
}