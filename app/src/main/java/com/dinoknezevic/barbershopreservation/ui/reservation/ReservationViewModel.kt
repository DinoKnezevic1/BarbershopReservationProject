package com.dinoknezevic.barbershopreservation.ui.reservation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinoknezevic.barbershopreservation.data.repository.BarbershopRepository
import com.dinoknezevic.barbershopreservation.ui.reservation.mapper.ReservationsScreenMapper
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ReservationViewModel(
    private val barbershopRepository: BarbershopRepository,
    private val reservationMapper: ReservationsScreenMapper,
   // private val dbFirebase: FirebaseFirestore,
) : ViewModel() {

    val reservationsScreenViewState: StateFlow<ReservationsScreenViewState> =

        barbershopRepository.services().map(reservationMapper::toReservationsScreenViewState).stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            ReservationsScreenViewState(listOf())
        )

    fun populateServices(){
        viewModelScope.launch {
            barbershopRepository.generateServices()
        }
    }

    /*
    val favoritesViewState: StateFlow<FavoritesViewState> =
        movieRepository.favoriteMovies()
            .map(favoritesMapper::toFavoritesViewState)
            .stateIn(
                viewModelScope,
                SharingStarted.Eagerly,
                FavoritesViewState(listOf())
            )

    fun toggleFavorite(movieId: Int) {
        viewModelScope.launch {
            movieRepository.toggleFavorite(movieId)
        }
    }
    */
}
