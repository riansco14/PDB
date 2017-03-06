package Utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.jetbrains.annotations.Contract;

import java.util.Optional;

/**
 * Created by Doda on 28/02/2017.
 */
public class Utils {

    public static void mensagem(String titulo,String mensagem){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
        alert = null;
    }

    public static void mensagemError(String titulo, String mensagem){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
        alert = null;

    }

    @Contract(value = "_, _ -> true", pure = true)
    public static boolean pergunta(String titulo, String pergunta){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,pergunta,ButtonType.YES,ButtonType.NO);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(pergunta);

        alert.showAndWait();

            if (alert.getResult() == ButtonType.YES)
                return true;
            else
                return false;

    }

}
