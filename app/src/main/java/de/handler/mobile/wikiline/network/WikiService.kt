package de.handler.mobile.wikiline.network

import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface WikiService {
    @GET("api.php?action=query&prop=revisions&rvprop=content&format=json&formatversion=2")
    fun getArticle(@Query("titles") searchTerm: String): Deferred<PagesDto>
}