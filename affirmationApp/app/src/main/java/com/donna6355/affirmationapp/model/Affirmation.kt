package com.donna6355.affirmationapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringResourcedId: Int,
    @DrawableRes val imageResourcedId: Int,
)
