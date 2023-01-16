package com.dinoknezevic.barbershopreservation.ui.pick.di

import com.dinoknezevic.barbershopreservation.ui.pick.PickViewModel
import com.dinoknezevic.barbershopreservation.ui.pick.mapper.PickScreenMapper
import com.dinoknezevic.barbershopreservation.ui.pick.mapper.PickScreenMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pickModule = module {
    viewModel {
        (serviceId:Int)->
        PickViewModel(
            barbershopRepository = get(),
            serviceId = serviceId,
            pickScreenMapper = get()
        )
    }

    single<PickScreenMapper> { PickScreenMapperImpl()  }
}