import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text("Water Counter", style = MaterialTheme.typography.titleLarge)
        StatefulCounter()
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }

    Column(modifier = modifier.padding(8.dp)) {
        StatelessCounter(count, onIncrement = { count++ })

        Spacer(modifier = Modifier.height(8.dp))

        AnotherStatelessMethod(count, onDouble = { count *= 2 })
    }
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit) {
    Column {
        if (count > 0) {
            Text("You've had $count glasses.")
        }

        Button(
            onClick = onIncrement,
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add one")
        }
    }
}

@Composable
fun AnotherStatelessMethod(count: Int, onDouble: () -> Unit) {
    Column {
        Text("Double your count: $count → ${count * 2}")

        Button(
            onClick = onDouble,
            enabled = count > 0,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Double it")
        }
    }
}