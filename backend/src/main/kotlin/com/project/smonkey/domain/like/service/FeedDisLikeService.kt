package com.project.smonkey.domain.like.service

import com.project.smonkey.domain.feed.facade.FeedFacade
import com.project.smonkey.domain.like.entity.FeedLike
import com.project.smonkey.domain.like.facade.LikeFacade
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

@Service
class FeedDisLikeService(
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade,
    private val likeFacade: LikeFacade,
) {

    fun disLike(
        feedId: Long
    ): BaseResponse<Unit> {
        val user = userFacade.getCurrentUser()
        val feed = feedFacade.getFeedById(feedId)

        likeFacade.disLike(
            feedLike = FeedLike(
                user = user,
                feed = feed,
            )
        )

        return BaseResponse(
            status = 201,
            message = FEED_DISLIKE_SUCCESS,
            content = null,
        )
    }

    companion object {
        const val FEED_DISLIKE_SUCCESS = "success to dislike feed"
    }
}
