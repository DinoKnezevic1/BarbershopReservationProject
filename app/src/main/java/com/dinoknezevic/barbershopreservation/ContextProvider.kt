package com.dinoknezevic.barbershopreservation

import android.content.Context

class ContextProvider private constructor() {
    companion object {
        private var context: Context? = null
        fun init(context: Context) {
            this.context = context
        }

        fun getContext(): Context {
            return context!!
        }
    }
}
