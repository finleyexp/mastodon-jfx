package com.github.wakingrufus.mastodon.feed

import com.sys1yagi.mastodon4j.MastodonClient
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import mu.KotlinLogging
import java.util.*

private val logger = KotlinLogging.logger {}
fun getFeedsForAccount(accountClient: MastodonClient): ObservableList<FeedState<*>> {
    logger.debug("getting feeds for client: " + accountClient.getInstanceName())
    val accountDefaultFeeds: ObservableList<FeedState<*>> = FXCollections.observableArrayList()
    accountDefaultFeeds.add(TootFeedState(Collections.singletonList(FeedElement(FeedQuery.HOME, accountClient))))
    accountDefaultFeeds.add(TootFeedState(Collections.singletonList(FeedElement(FeedQuery.PUBLIC, accountClient))))
    accountDefaultFeeds.add(TootFeedState(Collections.singletonList(FeedElement(FeedQuery.FEDERATED, accountClient))))
    accountDefaultFeeds.add(NotificationFeedState(
            Collections.singletonList(FeedElement(FeedQuery.NOTIFICATIONS, accountClient))))
    return accountDefaultFeeds
}