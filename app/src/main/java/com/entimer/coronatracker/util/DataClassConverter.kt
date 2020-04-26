package com.entimer.coronatracker.util

import com.entimer.coronatracker.data.dataclass.ApiRecentData
import com.entimer.coronatracker.data.dataclass.CovidData
import com.entimer.coronatracker.data.room.entity.RecentEntity

fun apiRecentData2RecentEntry(data: ApiRecentData): RecentEntity {
    val time = data.lastUpdate
    val confirmed = data.confirmed.value
    val recovered = data.recovered.value
    val deaths = data.deaths.value
    val actives = confirmed - recovered - deaths
    return RecentEntity(
        0,
        time,
        "recent",
        confirmed,
        actives,
        recovered,
        deaths
    )
}

fun recentEntry2CovidData(data: RecentEntity): CovidData {
    return CovidData(data.time, data.country, data.confirmed, data.actives, data.recovered, data.deaths)
}