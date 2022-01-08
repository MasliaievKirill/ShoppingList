package com.masliaiev.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masliaiev.shoppinglist.data.ShopListRepositoryImpl
import com.masliaiev.shoppinglist.domain.DeleteShopItemUseCase
import com.masliaiev.shoppinglist.domain.EditShopItemUseCase
import com.masliaiev.shoppinglist.domain.GetShopListUseCase
import com.masliaiev.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel () {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()



    fun deleteShopItem (shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnabledState (shopItem: ShopItem) {
        val editedShopItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(editedShopItem)
    }


}