package ru.tinkoff.uiautomator.test

import org.junit.Test
import ru.tinkoff.uiautomator.application.YouTube

class YoutubeTest : AbstractApplicationTest<YouTube>(YouTube()){
    @Test
    fun stopVideo() {
        app.open()
        app.clickSearch()
        app.typeToSearch("JoHn muir")
        app.click("JoHn")
        app.checkAdv()
        app.addTiming(10)
    }
}