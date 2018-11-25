package ru.tinkoff.uiautomator.application


import ru.tinkoff.uiautomator.util.*


class YouTube : AbstractApplication("com.google.android.youtube") {
    fun clickSearch() {
        byStringRes("com.google.android.youtube:id/menu_search").waitFindObject().click()
    }

    fun typeToSearch(text: String) {
        byStringRes("com.google.android.youtube:id/search_edit_text").waitFindObject().text = text
        getDevice().pressEnter()
    }

    fun click(text: String) {
        byStringRes("com.google.android.youtube:id/title")
            .textContains(text)
            .waitFindObject()
            .click()
    }

    private fun pauseButton() {
        byStringRes("com.google.android.youtube:id/player_control_play_pause_replay_button").waitFindObject().click()
    }

    fun addTiming(TimeSeconds: Int) {
        clickPlayer()
        val stringSeconds = byStringRes("com.google.android.youtube:id/time_bar_current_time").waitFindObject().text
        val time = TimeSeconds - stringSeconds.substringAfter(":").toLong()
        Thread.sleep(time * 1000)
        pauseButton()
    }

    private fun waitAdv() {
        val stringSeconds = byStringRes("com.google.android.youtube:id/ad_timer_text").waitFindObject().text
        val time = (stringSeconds.substringAfter(":").toLong() - 2)
        Thread.sleep(time * 1000)
    }

    fun checkAdv() {
        if (byStringRes("com.google.android.youtube:id/ad_timer_text").waitHasObject()) {
            waitAdv()
        }
    }

    private fun clickPlayer() {
        byStringRes("com.google.android.youtube:id/player_fragment_container").waitFindObject().click()
    }

}