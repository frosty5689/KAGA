package com.waicool20.kaga.views.tabs

import com.waicool20.kaga.Kaga
import com.waicool20.kaga.util.bind
import javafx.fxml.FXML
import javafx.scene.control.CheckBox
import javafx.scene.control.ComboBox
import javafx.scene.layout.GridPane
import tornadofx.bind


class ExpeditionsTabView {
    @FXML private lateinit var enableButton: CheckBox
    @FXML private lateinit var fleet2ComboBox: ComboBox<Int>
    @FXML private lateinit var fleet3ComboBox: ComboBox<Int>
    @FXML private lateinit var fleet4ComboBox: ComboBox<Int>

    @FXML private lateinit var content: GridPane

    @FXML fun initialize() {
        setValues()
        createBindings()
    }

    private fun setValues() {
        fleet2ComboBox.items.setAll((1..41).toList())
        fleet3ComboBox.items.setAll((1..41).toList())
        fleet4ComboBox.items.setAll((1..41).toList())
    }

    private fun createBindings() {
        with(Kaga.PROFILE!!.expeditions) {
            enableButton.bind(enabledProperty)
            fleet2ComboBox.bind(fleet2Property)
            fleet3ComboBox.bind(fleet3Property)
            fleet4ComboBox.bind(fleet4Property)
        }
        content.visibleProperty().bind(enableButton.selectedProperty())
    }
}