package ru.tinkoff.uiautomator.test

import org.junit.Test
import ru.tinkoff.uiautomator.application.YouTube

class YoutubeTest : AbstractApplicationTest<YouTube>(YouTube()){
    @Test
    fun stopVideo() {
        app.open()
        app.clickSearch()
        app.typeToSearch("ВРЕМЕННЫЕ ТРУДНОСТИ")
        app.click("BadComedian")
        app.checkAdv()
        app.addTiming(10)
    }
}