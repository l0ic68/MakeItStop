package com.nesta.makeitstop.navigation

object Routes {
    const val Home = "home"

    object Addiction {
        const val Graph = "craving_graph"
        const val DashBoard = "craving_dashboard"
        const val Craving = "craving"
        const val Post = "craving/post"
    }

    object SleepingJournaling {
        const val Graph = "sleeping_journaling_graph"
        const val DashBoard = "sleeping_journaling_dashboard"
        const val Sleeping = "sleeping_journaling"
        const val Post = "sleeping_journaling/post"
    }

    object Urgency {
        const val Graph = "urgency_graph"
        const val Breathing = "urgency_breathing"
        const val DashBoard = "urgency_dashboard"
        const val Urgency = "urgency"
        const val Post = "urgency/post"
    }
}