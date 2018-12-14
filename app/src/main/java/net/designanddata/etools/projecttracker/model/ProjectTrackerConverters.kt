package net.designanddata.etools.projecttracker.model

import android.arch.persistence.room.TypeConverter

class ProjectTrackerConverters {
	@TypeConverter
	fun stringToList(string: String?): List<Int>? {
		if (string==null) return null
		val strings: List<String> = string.split(',')
		return strings.map { it.toInt() }
	}

	@TypeConverter
	fun ListToString(list: List<Int>?): String? {
		if (list==null) return null
		return list.joinToString("," )
	}
}
