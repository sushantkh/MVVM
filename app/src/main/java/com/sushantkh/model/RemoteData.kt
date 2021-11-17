package com.sushantkh.model

import com.google.gson.annotations.SerializedName
import com.sushantkh.model.Data
import com.sushantkh.model.Meta


data class RemoteData (

   @SerializedName("meta") var meta : Meta,
   @SerializedName("data") var data : List<Data>

)