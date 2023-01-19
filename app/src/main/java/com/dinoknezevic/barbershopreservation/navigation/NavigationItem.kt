package com.dinoknezevic.barbershopreservation.navigation

import com.dinoknezevic.barbershopreservation.R

const val HOME_ROUTE = "Home"
const val HISTORY_ROUTE = "History"

const val RESERVATIONS_ROUTE = "Reservations"
const val SERVICE_ID_KEY = "movieId"
const val SERVICE_RESERVATION_ROUTE_WITH_PARAMS = "$RESERVATIONS_ROUTE/{$SERVICE_ID_KEY}"

const val DATE_TIME_PICK_ROUTE = "DateTimePick"
const val PICK_SERVICE_ID_KEY = "serviceId"
const val DATE_TIME_PICK_ROUTE_WITH_PARAMS = "$DATE_TIME_PICK_ROUTE/{$PICK_SERVICE_ID_KEY}"

const val FINISH_ROUTE = "Finish"
const val FINISH_PICK_SERVICE_ID_KEY = "finishServiceId"
const val FINISH_PICK_PICKED_DATE_KEY = "finishPickedDate"
const val FINISH_ROUTE_WITH_PARAMS =
    "$FINISH_ROUTE/{$FINISH_PICK_SERVICE_ID_KEY}/{$FINISH_PICK_PICKED_DATE_KEY}"

const val LOGIN_ROUTE = "Login"

sealed class NavigationItem(
    override val route: String,
    val selectedIconId: Int,
    val unselectedIconId: Int,
    val labelId: Int,
) : BarbershopReservationDestination(route) {
    object HomeDestination : NavigationItem(
        route = HOME_ROUTE,
        selectedIconId = R.drawable.ic_home_filled,
        unselectedIconId = R.drawable.ic_home_outlined,
        labelId = R.string.home,
    )

    object HistoryDestination : NavigationItem(
        route = HISTORY_ROUTE,
        selectedIconId = R.drawable.ic_history_filled,
        unselectedIconId = R.drawable.ic_history_outlined,
        labelId = R.string.history,
    )

    object LoginDestination:BarbershopReservationDestination(LOGIN_ROUTE){
        fun createNavigationRoute():String= LOGIN_ROUTE
    }

    object ReservationsDestination :
        BarbershopReservationDestination(SERVICE_RESERVATION_ROUTE_WITH_PARAMS) {
        fun createNavigationRoute(serviceId: Int): String = "$RESERVATIONS_ROUTE/$serviceId"
    }

    object DateTimePickDestination :
        BarbershopReservationDestination(DATE_TIME_PICK_ROUTE_WITH_PARAMS) {
        fun createNavigationRoute(serviceId: Int): String = "$DATE_TIME_PICK_ROUTE/$serviceId"
    }

    object FinishDestination :
        BarbershopReservationDestination(FINISH_ROUTE_WITH_PARAMS) {
        fun createNavigationRoute(serviceId: Int, pickedDate: Long): String =
            "$FINISH_ROUTE/$serviceId/$pickedDate"
    }

}
