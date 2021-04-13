package com.dev.newsbox.UI.DB

import androidx.room.TypeConverter
import com.dev.newsbox.UI.Models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String) : Source {
        return Source(name, name)
    }
}
/**
 * Now we need to tell our DB to use these typeConverters
*/