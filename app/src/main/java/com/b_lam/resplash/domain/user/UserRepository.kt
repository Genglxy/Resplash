package com.b_lam.resplash.domain.user

import com.b_lam.resplash.data.search.SearchService
import com.b_lam.resplash.data.user.UserService
import com.b_lam.resplash.data.user.model.User
import com.b_lam.resplash.domain.Listing
import com.b_lam.resplash.util.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class UserRepository(
    private val userService: UserService,
    private val searchService: SearchService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getUserPublicProfile(username: String) =
        safeApiCall(dispatcher) { userService.getUserPublicProfile(username) }

    fun searchUsers(query: String): Listing<User> {
        return SearchUserPagingSourceFactory(searchService, query).createListing()
    }
}
