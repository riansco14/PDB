package control;

import Utils.Utils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

/**
 * Created by Doda on 28/02/2017.
 */
public class PrincipalController {

    @FXML
    private MenuItem closeMenu;



     public void fecharTela(){

        if (Utils.pergunta("Pergunta","Deseja fechar o programa  ?") )
            Platform.exit();

    }


}
