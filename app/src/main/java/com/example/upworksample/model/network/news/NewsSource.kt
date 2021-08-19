package com.example.upworksample.model.network.news

import com.example.upworksample.model.network.data.SmallMovieList
import com.example.upworksample.model.network.news.data.Result
import com.example.upworksample.model.network.news.data.TvNew
import com.example.upworksample.utils.ALL_NEWS
import com.example.upworksample.utils.DAILY_NEWS
import com.example.upworksample.utils.WEEKLY_NEWS
import com.example.upworksample.utils.ioReturnTask
import javax.inject.Inject

class NewsSource @Inject constructor(private val api: NewsApi) {

    suspend fun getDailyNews(type: String = ALL_NEWS): List<SmallMovieList> {
        val newsResponse = api.getNews(type, DAILY_NEWS)

        return if (newsResponse.smallMovieList.isNullOrEmpty()) {
            emptyList()
        } else {
            newsResponse.smallMovieList
        }
    }

    suspend fun getWeeklyNews(type: String = ALL_NEWS): List<SmallMovieList> {
        val newsResponse = api.getNews(type, WEEKLY_NEWS)

        return if (newsResponse.smallMovieList.isNullOrEmpty()) {
            emptyList()
        } else {
            newsResponse.smallMovieList.subList(0, 10)
        }
    }

    suspend fun getTvNews(type: String = WEEKLY_NEWS): List<TvNew> {
        val response = api.getTvNews(type)

        return if (response.newsList.isNullOrEmpty()) {
            emptyList()
        } else {
            response.newsList.subList(0, 5).sortedBy { it.vote_average }.reversed()
        }
    }
}