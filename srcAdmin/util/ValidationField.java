package util;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.Calendar;
import java.util.Date;

public class ValidationField {
	public static boolean isEmptyAllFields(TextField...fields) throws ExceptionGeneric {
		for (TextField textField : fields) {
			if(textField.getText().length()==0){
				//Dialogs.showInformation("Information", "Campo Vazio", "Por favor preencha todos os campos");
                throw new ExceptionGeneric(ExceptionGeneric.CAMPO_VAZIO);
			}
		}
		return false;
	}
	
	public static EventHandler<KeyEvent> getDigitEvent(){
		EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>() {

            private boolean willConsume = false;

            @Override
            public void handle(KeyEvent event) {

                if (willConsume) {
                    event.consume();
                }
                if (!(event.getCode().isArrowKey()||event.getCode().isDigitKey()||event.getCode().isFunctionKey())) {
                    if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                        willConsume = true;
                    } else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                        willConsume = false;
                    }
                }
            }

        };
        return handler;
	}

	public static Date getData(int ano,int mes,int dia){
        Calendar cal = Calendar.getInstance();
        cal.set(ano,mes-1,dia);
        Date dateRepresentation = cal.getTime();

        return dateRepresentation;
    }
	
}
