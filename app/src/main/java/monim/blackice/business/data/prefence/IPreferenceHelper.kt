package monim.blackice.business.data.prefence

import monim.blackice.business.data.model.CurrentUserInfo
import monim.blackice.business.data.model.user.User

interface IPreferenceHelper {
    fun PrefGetCurrentUser(): User
    fun PrefLogin(user: User)
    fun PrefLogout()
    fun PrefGetLoginMode(): Boolean
}