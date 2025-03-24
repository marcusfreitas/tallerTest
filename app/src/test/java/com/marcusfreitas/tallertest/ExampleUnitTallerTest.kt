package com.marcusfreitas.tallertest

import com.marcusfreitas.tallertest.data.repository.ItemRepository
import com.marcusfreitas.tallertest.data.repository.ItemRepositoryImpl
import com.marcusfreitas.tallertest.domain.usecase.GetItemsUseCase
import com.marcusfreitas.tallertest.ui.ItemListViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.kotlin.mock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTallerTest {

    private lateinit var repository: ItemRepository
    private lateinit var viewModel: ItemListViewModel

    @Before
    fun setup() {
        repository = mock()
        val useCase = GetItemsUseCase()
    }

    @Test
    fun testItemListIsFetchedSuccessfully() {
        assertEquals(subject.test01(), 0)
    }

}