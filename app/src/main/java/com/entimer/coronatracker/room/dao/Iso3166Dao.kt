package com.entimer.coronatracker.room.dao

import androidx.room.*
import com.entimer.coronatracker.room.entity.Iso3166Entity

@Dao
interface Iso3166Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(iso3166Entity: Iso3166Entity)

    @Update
    fun update(iso3166Entity: Iso3166Entity)

    @Delete
    fun delete(iso3166Entity: Iso3166Entity)

    @Query("SELECT * FROM iso3166 WHERE name LIKE (:keyword) OR alpha3 LIKE (:keyword)")
    fun selectByKeyword(keyword: String): List<Iso3166Entity>
}