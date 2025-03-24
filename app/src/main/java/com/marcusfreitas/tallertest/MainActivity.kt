package com.marcusfreitas.tallertest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import com.marcusfreitas.tallertest.data.repository.ItemRepositoryImpl
import com.marcusfreitas.tallertest.domain.usecase.GetItemsUseCase
import com.marcusfreitas.tallertest.ui.ItemListViewModel
import com.marcusfreitas.tallertest.ui.ItemsListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Ideally we should use Hilt to inject these objects
        // but as this is only a test project I'll skip that
        val repository = ItemRepositoryImpl()
        val useCase = GetItemsUseCase(repository)
        val viewModel = ItemListViewModel(useCase)

        setContent {
            MaterialTheme {
                ItemsListScreen(viewModel = viewModel)
            }
        }
    }
}