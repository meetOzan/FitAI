package com.mobven.fitai.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user_entity")
data class UserEntity(

    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val key: String,

    @ColumnInfo(name = "gender")
    val gender: String,

    @ColumnInfo(name = "height")
    val height: Int,

    @ColumnInfo(name = "first_weight")
    val firstWeight: Int,

    @ColumnInfo(name = "date_of_birth")
    val dateOfBirth: String,

    @ColumnInfo(name = "current_weight")
    val currentWeight: Int,

    @ColumnInfo(name = "target_weight")
    val targetWeight: Int,

    @ColumnInfo(name = "goals")
    val goals: String,

    @ColumnInfo(name = "preferred_activities")
    val preferredActivities: String?,

    @ColumnInfo(name = "workout_frequency")
    val workoutFrequency: String?,

    @ColumnInfo(name = "focus_areas")
    val focusAreas: String?,

    @ColumnInfo(name = "health_problem")
    val healthProblem: String?,

    @ColumnInfo(name = "basal_metabolism")
    val basalMetabolism: Int,

    @ColumnInfo(name = "daily_kcal_goal")
    val dailyKcalGoal: Int?,

    @ColumnInfo(name = "is_first_entrance")
    val isFirstEntrance: Boolean
)