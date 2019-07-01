package monim.blackice.business.data.model

class BaseModel<z>()  {

    lateinit var status: String
    lateinit var code: String
    lateinit var message: List<String>
    var data: z? = null
}