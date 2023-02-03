package com.example.listadapter.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.listadapter.model.QuoteList
import com.example.listadapter.api.QuotesServiceAPI

class QuoteRepository(private val quotesServiceAPI: QuotesServiceAPI) {
    private val quotesLiveData = MutableLiveData<QuoteList>()
    val quotes: LiveData<QuoteList>
        get() = quotesLiveData

    suspend fun getQuote(page: Int) {
        val quote = quotesServiceAPI.getQuote(page)
        if (quote.body() != null) {
            quotesLiveData.postValue(quote.body())
        }
    }
}