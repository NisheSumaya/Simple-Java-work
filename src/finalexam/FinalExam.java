
package finalexam;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FinalExam extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label l= new Label("Name of Customer");
        Label l2= new Label("Bill Amount");
        Label l3= new Label("Mode of Payment");
        Label l4= new Label("Net Amount");
        Button b = new Button("Calculate");
        Button b2 = new Button("Clear");
        TextField t = new TextField();
        TextField t2 = new TextField();
        ComboBox cb = new ComboBox ();
        cb.getItems().addAll("Cash","Cheque","Credit card");
        TextField t3 = new TextField();
       EventHandler<ActionEvent> eh;
        eh = new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try{
                    if(event.getSource()==b&&cb.getValue().equals("Cash")){
                     
                            int a= Integer.parseInt(t2.getText());
                            int c = (int) (a-(a*.08));
                            t3.setText(""+c);
                            
                        }
                        if(event.getSource()==b&&cb.getValue().equals("Cheque")){
                            int a= Integer.parseInt(t2.getText());
                            int c = (int) (a-(a*.07));
                            t3.setText(""+c);
                            
                        }
                        if(event.getSource()==b&&cb.getValue().equals("Credit card")){
                            t3.setText(t2.getText());
         
                        }
                    
                    if(event.getSource()==b2){
                        t.setText(" ");
                        t2.setText(" ");
                        t3.setText(" ");
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }}
        };
       cb.setOnAction(eh);
        b.setOnAction(eh);
        b2.setOnAction(eh);
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(5);
        gp.setVgap(5);
        gp.addColumn(0,l,l2,l3,b,l4);
        gp.addColumn(1,t,t2,cb,b2,t3);
        
        Scene scene = new Scene(gp, 300, 250);
        
        primaryStage.setTitle("Garments Bill Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
