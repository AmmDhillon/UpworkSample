package com.example.upworksample.dagger.component

import com.example.upworksample.dagger.module.NetworkModule
import com.example.upworksample.dagger.module.viewModule.ViewModelModule
import com.example.upworksample.ui.home.detail.DetailFragment
import com.example.upworksample.ui.home.list.ListFragment
import com.example.upworksample.ui.home.overview.OverviewFragment
import com.example.upworksample.ui.news.detail_news.DetailNewsFragment
import com.example.upworksample.ui.news.news.NewsFragment
import com.example.upworksample.ui.user.profile.ProfileFragment
import com.example.upworksample.ui.user.profile.settings.SettingsFragment


import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface AppComponent{
    fun inject(overviewFragment: OverviewFragment)
    fun inject(detailFragment: DetailFragment)
    fun inject(listFragment: ListFragment)
    fun inject(newsFragment: NewsFragment)
    fun inject(detailNewsFragment: DetailNewsFragment)
    fun inject(settingsFragment: SettingsFragment)
    fun inject(profileFragment: ProfileFragment)
}