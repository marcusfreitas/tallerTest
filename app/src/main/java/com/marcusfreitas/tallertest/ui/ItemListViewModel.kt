package com.marcusfreitas.tallertest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcusfreitas.tallertest.data.model.Item
import com.marcusfreitas.tallertest.domain.usecase.GetItemsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemListViewModel(private val getItemsUseCase: GetItemsUseCase) : ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> get() = _items

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            _items.value = getItemsUseCase.execute()
        }
    }

}