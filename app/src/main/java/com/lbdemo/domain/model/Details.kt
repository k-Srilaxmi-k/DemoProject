package com.lbdemo.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Details(
    @SerializedName("fields" ) var fields : String? = null,
    @SerializedName("flag" ) val flag: String? = null,
    @SerializedName("region" ) val region: String? = null,
    @SerializedName("subregion" ) val subregion: String? = null,
    @SerializedName("area" ) val area: String? = null,
    @SerializedName("population" ) val population: String? = null,
    @SerializedName("landlocked" ) val landlocked: String? = null,
    @SerializedName("unMember" ) val unMember: String? = null,
    @SerializedName("status" ) val status: String? = null,
    @SerializedName("independent" ) val independent: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fields)
        parcel.writeString(flag)
        parcel.writeString(region)
        parcel.writeString(subregion)
        parcel.writeString(area)
        parcel.writeString(population)
        parcel.writeString(landlocked)
        parcel.writeString(unMember)
        parcel.writeString(status)
        parcel.writeString(independent)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Details> {
        override fun createFromParcel(parcel: Parcel): Details {
            return Details(parcel)
        }

        override fun newArray(size: Int): Array<Details?> {
            return arrayOfNulls(size)
        }
    }

}