package monim.blackice.business.data.prefence

import android.content.Context
import android.content.SharedPreferences
import monim.blackice.business.data.model.CurrentUserInfo
import monim.blackice.business.data.model.user.User

class PreferencesHelper(context: Context):IPreferenceHelper {
    private val PREF_KEY_IS_LOGIN = "PREF_KEY_IS_LOGIN"
    private val PREF_KEY_USER_NAME = "PREF_KEY_USER_NAME"
    private val PREF_KEY_USER_EMAIL = "PREF_KEY_USER_EMAIL"
    private val PREF_KEY_USER_PROFILE_PHOTO_URL = "PREF_KEY_USER_PROFILE_PHOTO_URL"

    private val mPrefs: SharedPreferences = context.getSharedPreferences("preference_name", Context.MODE_PRIVATE)

    override fun prefGetCurrentUser(): User {
        val user = User()
        user.name = mPrefs.getString(PREF_KEY_USER_NAME, null)
//        user.email = mPrefs.getString(PREF_KEY_USER_EMAIL, null)
//        user.profileUrl = mPrefs.getString(PREF_KEY_USER_PROFILE_PHOTO_URL, null)
        return user
    }

    override fun prefLogin(user: User) {
        mPrefs.edit().putBoolean(PREF_KEY_IS_LOGIN, true).apply()
        mPrefs.edit().putString(PREF_KEY_USER_NAME, user.name).apply()
//        mPrefs.edit().putString(PREF_KEY_USER_EMAIL, user.email).apply()
//        mPrefs.edit().putString(PREF_KEY_USER_PROFILE_PHOTO_URL, user.profileUrl).apply()
    }

    override fun prefLogout() {
        mPrefs.edit().putString(PREF_KEY_USER_NAME, null).apply()
        mPrefs.edit().putString(PREF_KEY_USER_EMAIL, null).apply()
        mPrefs.edit().putString(PREF_KEY_USER_PROFILE_PHOTO_URL, null).apply()
        mPrefs.edit().putBoolean(PREF_KEY_IS_LOGIN, false).apply()

    }

    override fun prefGetLoginMode(): Boolean {
        return mPrefs.getBoolean(PREF_KEY_IS_LOGIN, false)
    }


}