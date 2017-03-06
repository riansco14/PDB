package componentes;

import javafx.scene.control.TextField;

/**
 * Created by Francisco Bezerra da Silva on 02/12/16.
 */
public class MetroTextFieldSkin extends TextFieldWithButtonSkin{
    public MetroTextFieldSkin(TextField textField) {
        super(textField);
    }

    @Override
    protected void rightButtonPressed()
    {
        getSkinnable().setText("");
    }

}