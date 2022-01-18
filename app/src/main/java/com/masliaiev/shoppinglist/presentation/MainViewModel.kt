package com.masliaiev.shoppinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.masliaiev.shoppinglist.data.ShopListRepositoryImpl
import com.masliaiev.shoppinglist.domain.DeleteShopItemUseCase
import com.masliaiev.shoppinglist.domain.EditShopItemUseCase
import com.masliaiev.shoppinglist.domain.GetShopListUseCase
import com.masliaiev.shoppinglist.domain.ShopItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    fun changeEnabledState(shopItem: ShopItem) {
        viewModelScope.launch {
            val editedShopItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(editedShopItem)
        }
    }
}