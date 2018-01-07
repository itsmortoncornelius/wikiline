package de.handler.mobile.wikiline.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.starcarrlane.coroutines.experimental.Android
import de.handler.mobile.wikiline.network.Page
import de.handler.mobile.wikiline.network.PagesDto
import de.handler.mobile.wikiline.network.WikiService
import kotlinx.coroutines.experimental.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WikiManager {
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://en.wikipedia.org/w/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    private val wikiService = retrofit.create(WikiService::class.java)

    fun getPages(searchTerm: String): List<Page>? {
        var pagesDto: PagesDto? = null
        launch(Android) {
            pagesDto = wikiService.getArticle(searchTerm).await()
        }
        return pagesDto?.pages
    }
}