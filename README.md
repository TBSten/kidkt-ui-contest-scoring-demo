# [Roborazzi](https://github.com/takahirom/roborazzi?tab=readme-ov-file)によるスクリーンショットのテスト

## 出力のサンプル

```kt
// ソースのコード
@Composable
fun ScoreSection(
    user: String,
    score: Int,
) {
    Card {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text("$user さん", fontSize = 32.sp)
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("$score", fontSize = 64.sp, fontWeight = FontWeight.Bold)
                Text(" pt", fontSize = 64.sp)
            }
        }
    }
}
```

```kt
// テストコード
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
```

![出力のサンプル](docs/images/sample-screenshot.png)

## 実行方法

```bash
./gradlew recordRoborazziDebug
```
