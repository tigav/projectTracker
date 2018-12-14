package net.designanddata.etools.projecttracker.model
// https://developer.android.com/training/data-storage/room/#kotlin

import android.arch.persistence.room.*
import android.content.Context

@Database(entities = [Client::class, Business::class, WorkHour::class,Payment::class,Delivery::class,Invoice::class,Project::class],
	version = 1)
@TypeConverters(ProjectTrackerConverters::class)
abstract class ProjectTrackerDatabase : RoomDatabase() {
	abstract fun projectTrackerDao(): ProjectTrackerDao

	// Singleton design pattern, BUT must be initialized with context
	/*
		Could be Object instead of Class (Kotlin) but RoomDatabase is a class
		Must return nullable as INSTANCE must be initialized or abstract (abstract vars?)
		therefore INSTANCE *MUST* be Nullable

		As long as the program is active, the database should be too.
	 */
	companion object {
		@Volatile // still not sure on when I should use this...
		private var INSTANCE: ProjectTrackerDatabase? = null

		// public static
		fun getInstance(context: Context): ProjectTrackerDatabase? {
			synchronized(ProjectTrackerDatabase::class) {
				INSTANCE = Room.databaseBuilder(
					context.applicationContext,
					ProjectTrackerDatabase::class.java,
					"db")
					.build()
			}
			return INSTANCE
		}
		// close database connection and free persistent instance.
		// Not used:: fun destroyInstance() {INSTANCE = null
	}
}
