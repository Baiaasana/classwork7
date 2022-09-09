package com.example.classwork7.domain.model

import com.squareup.moshi.Json

data class CourseModel(
    val active_courses: List<ActiveCourses>?,
    val new_courses: List<NewCourse>?,
) {
    data class NewCourse(
        val duration: String?,
        @field:Json(name = "icon_type")
        val iconType: String?,
        val id: String?,
        @field:Json(name = "main_color")
        val mainColor: String?,
        val question: String?,
        val title: String?,
    )
    data class ActiveCourses(
        @field:Json(name = "background_color_percent")
        val backgroundColorPercent: String?,
        @field:Json(name = "booking_time")
        val bookingTime: String?,
        val id: String?,
        val image: String?,
        @field:Json(name = "main_color")
        val mainColor: String?,
        @field:Json(name = "play_button_color_percent")
        val playButtonColorPercent: String?,
        val progress: String?,
        val title: String?,
    )
}
