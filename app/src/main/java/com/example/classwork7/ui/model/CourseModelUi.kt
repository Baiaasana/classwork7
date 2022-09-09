package com.example.classwork7.ui.model

import com.example.classwork7.domain.model.CourseModel
import com.squareup.moshi.Json

data class CourseModelUi(
    val active_courses: List<CourseModel.ActiveCourses>?,
    val new_courses: List<CourseModel.NewCourse>?,
) {
    data class ActiveCourse(
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
}
