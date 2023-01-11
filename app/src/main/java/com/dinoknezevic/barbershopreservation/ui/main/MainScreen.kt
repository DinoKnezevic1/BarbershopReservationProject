package com.dinoknezevic.barbershopreservation.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.foundation.clickable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dinoknezevic.barbershopreservation.R
import com.dinoknezevic.barbershopreservation.navigation.HISTORY_ROUTE
import com.dinoknezevic.barbershopreservation.navigation.HOME_ROUTE
import com.dinoknezevic.barbershopreservation.navigation.NavigationItem
import com.dinoknezevic.barbershopreservation.navigation.SERVICE_ID_KEY
import com.dinoknezevic.barbershopreservation.ui.history.HistoryRoute
import com.dinoknezevic.barbershopreservation.ui.home.HomeRoute
import com.dinoknezevic.barbershopreservation.ui.reservation.ReservationsRoute
import com.dinoknezevic.barbershopreservation.ui.theme.spacing

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val showBottomBar by remember {
        derivedStateOf {
            navBackStackEntry?.destination?.route == HOME_ROUTE ||
                    navBackStackEntry?.destination?.route == HISTORY_ROUTE
        }
    }

    val showBackIcon = !showBottomBar

    Scaffold(
        topBar = {
            TopBar(
                navigationIcon = {
                    if (showBackIcon) BackIcon(onBackClick = navController::popBackStack)
                }
            )
        },
        bottomBar = {
            if (showBottomBar)
                BottomNavigationBar(
                    destinations = listOf(
                        NavigationItem.HomeDestination,
                        NavigationItem.HistoryDestination,
                    ),
                    onNavigateToDestination = {
                        navController.navigate(it.route) {
                            popUpTo(HOME_ROUTE) {
                                if (it.route == HOME_ROUTE)
                                    inclusive = true
                            }
                        }
                    },
                    currentDestination = navBackStackEntry?.destination
                )
        }
    ) { padding ->
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier
                .fillMaxSize()
        ) {
            NavHost(
                navController = navController,
                startDestination = NavigationItem.HomeDestination.route,
                modifier = Modifier
                    .padding(padding)
            ) {
                composable(NavigationItem.HomeDestination.route) {
                    HomeRoute(
                        onNavigateToReservations = { navController.navigate(it) },
                    )
                }
                composable(NavigationItem.HistoryDestination.route) {
                    HistoryRoute()
                }
                composable(
                    route = NavigationItem.ReservationsDestination.route,
                    arguments = listOf(navArgument(SERVICE_ID_KEY) { type = NavType.IntType }),
                ) {
                    ReservationsRoute(onServiceItemClick = {})
                }
            }
        }
    }
}

@Composable
private fun TopBar(
    navigationIcon: @Composable (() -> Unit)? = null,
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        modifier = Modifier
            .fillMaxHeight(0.07f)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.tmdb_logo),
                contentDescription = null,
                modifier = Modifier,
                contentScale = ContentScale.Crop
            )
            if (navigationIcon != null) {
                navigationIcon()
            }
        }
    }
}

@Composable
private fun BackIcon(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.CenterStart
    ) {
        Icon(
            painter = painterResource(id = R.drawable.back_icon),
            contentDescription = null,
            modifier = Modifier
                .padding(MaterialTheme.spacing.small)
                .clickable(onClick = onBackClick)
        )
    }
}

@Composable
private fun BottomNavigationBar(
    destinations: List<NavigationItem>,
    onNavigateToDestination: (NavigationItem) -> Unit,
    currentDestination: NavDestination?,
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background
    ) {
        destinations.forEach { destination ->
            BottomNavigationItem(
                selected = currentDestination?.route == destination.route,
                icon = {
                    Icon(
                        painter = painterResource(id = if (currentDestination?.route == destination.route) destination.selectedIconId else destination.unselectedIconId),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = destination.labelId),
                        style = MaterialTheme.typography.button
                    )
                },
                onClick = { onNavigateToDestination(destination) })
        }
    }
}
