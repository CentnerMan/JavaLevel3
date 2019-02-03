package NetworkChatWithDB.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            public void handle(WindowEvent we) {
//                System.out.println("Stage is closing");
//                Controller.disconnect();
//            }
//        });
        primaryStage.setOnCloseRequest(event -> Controller.disconnect());
    }

    @Override
    public void stop(){

        //Здесь Вы можете прописать все действия при закрытии Вашего приложения.

    }


    public static void main(String[] args) {
        launch(args);
    }
}
