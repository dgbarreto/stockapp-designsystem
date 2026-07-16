import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.danilobarreto.stockapp.designsystem.sample.SampleApp

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "DesignSystem Sample") {
        SampleApp()
    }
}