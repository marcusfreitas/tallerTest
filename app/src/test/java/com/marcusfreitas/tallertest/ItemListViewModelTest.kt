package com.marcusfreitas.tallertest

import com.marcusfreitas.tallertest.data.model.Item
import com.marcusfreitas.tallertest.data.repository.ItemRepository
import com.marcusfreitas.tallertest.domain.usecase.GetItemsUseCase
import com.marcusfreitas.tallertest.ui.ItemListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class ItemListViewModelTest {

    private lateinit var repository: ItemRepository
    private lateinit var viewModel: ItemListViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = mock()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testItemListIsFetchedSuccessfully() = runTest {
        // Given
        val sampleData = listOf(Item("Title 1", "Description 1"))
        whenever(repository.getItems()).thenReturn(sampleData)

        viewModel = ItemListViewModel(GetItemsUseCase(repository), testDispatcher)

        advanceUntilIdle()

        // Then
        assertEquals(sampleData, viewModel.items.value)
    }

}