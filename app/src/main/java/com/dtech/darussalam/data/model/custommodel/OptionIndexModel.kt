package com.dtech.darussalam.data.model.custommodel

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class OptionIndexModel(var optionId: Int, var questionId: String = ""): Parcelable
