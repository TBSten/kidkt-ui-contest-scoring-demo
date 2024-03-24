package me.tbsten.kidktuicontestscoringdemo

import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.github.takahirom.roborazzi.ExperimentalRoborazziApi
import com.github.takahirom.roborazzi.RoborazziOptions
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.GraphicsMode

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @OptIn(ExperimentalRoborazziApi::class)
    @Test
    fun roborazziTest() {
        val inputUserName = "tbsten"
        val inputScore = 12345

        composeTestRule.setContent {
            Box(
                modifier = Modifier
                    .testTag("root"),
            ) {
                ScoreSection(
                    user = inputUserName,
                    score = inputScore,
                )
            }
        }

        composeTestRule
            .onNodeWithTag("root")
            .assertExists("rootSurfaceタグの付与されたSurfaceが見つかりません。指定されたComposable以外を編集しないでください。")
            .captureRoboImage("screenshots/$inputUserName.png", RoborazziOptions())

    }
}