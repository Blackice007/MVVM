package monim.blackice.business.data

import monim.blackice.business.data.local_db.IRoomHelper
import monim.blackice.business.data.network.IApiHelper
import monim.blackice.business.data.network.IApiService
import monim.blackice.business.data.prefence.IPreferenceHelper

interface IDataManager : IPreferenceHelper,IRoomHelper,IApiHelper {
}