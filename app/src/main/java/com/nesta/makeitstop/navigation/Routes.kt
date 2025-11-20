package com.nesta.makeitstop.navigation

object Routes {
    const val Home = "home"
    const val Settings = "settings"

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

    object Breathing {
        const val Graph = "breathing_graph"
        const val DashBoard = "breathing_dashboard"
        const val Add = "breathing_add"
        const val Sleeping = "breathing"
    }
    object Urgency {
        const val Graph = "urgency_graph"
        const val UrgencyPlan = "urgency_breathing"
        const val Breathing = "urgency_breathing"
        const val BreathingWithParam = "urgency_breathing/{breathingJson}"
        const val FiveSenses = "urgency_five_senses"
        const val Discharge = "urgency_discharge"
        const val StopMental = "urgency_stop_mental"
        const val CorporalReset = "urgency_corporal_reset"
        const val DashBoard = "urgency_dashboard"
        const val Urgency = "urgency"
        const val Post = "urgency/post"
    }
}