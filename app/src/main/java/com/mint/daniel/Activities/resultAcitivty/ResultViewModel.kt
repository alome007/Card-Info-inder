package com.mint.daniel.Activities.resultAcitivty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mint.daniel.Model.Card
import com.mint.daniel.utils.Network
import com.mint.daniel.utils.NetworkState
import org.jetbrains.annotations.TestOnly

class ResultViewModel(val cardNumber: Int) : ViewModel() {
    private val _loading = MutableLiveData(NetworkState.LOADING)
    val loading: LiveData<NetworkState>
        get() = _loading

    private val _cardLiveData = MutableLiveData<Card>()
    val cardLiveData: LiveData<Card>
        get() = _cardLiveData


    fun loadCardDetails(network: Network) {
        network.getCard(cardNumber, _loading, _cardLiveData)
    }

    @TestOnly
    fun loadMockData(state: NetworkState, card: Card?){
        _loading.postValue(state)
        if (card != null)
            _cardLiveData.postValue(card)
    }
}