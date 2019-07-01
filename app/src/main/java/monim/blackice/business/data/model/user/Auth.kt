package monim.blackice.business.data.model.user

class Auth {

    lateinit var token_type : String
    var expires_in : Double = 0.0
    lateinit var access_token : String
    lateinit var refresh_token : String
}