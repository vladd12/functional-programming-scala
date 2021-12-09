package com.app {
    // import the default encoders for primitive types (Int, String, Lists etc)
    import spray.json.DefaultJsonProtocol._
    import com.app.UserRegistry.ActionPerformed

    object JsonFormats {
        implicit val userJsonFormat = jsonFormat3(User)
        implicit val usersJsonFormat = jsonFormat1(Users)
        implicit val actionPerformedJsonFormat = jsonFormat1(ActionPerformed)
    }
}

