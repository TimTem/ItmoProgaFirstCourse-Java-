package sample;

import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import sample.Flat.Flat;
import sample.Launcher.ClientLauncher;

import java.util.Random;

public class VisualizationContorller {
//    @FXML
//    private Canvas canvas;
//
//    @FXML
//    private AnchorPane pane;
//
//
//
//    private static final int WIDTH = 400;
//    private static final int HEIGHT = 400;
//    private static final int AXIS_WIDTH = 2;
//    private static final Color AXIS_COLOR = Color.BLACK;
//    private static final int TICK_LENGTH = 5;
//    private static final int TICK_SPACING = 10;
//    private static final Color TICK_COLOR = Color.BLACK;
//
//
//    @FXML
//    void initialize() {
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//
//        // Отрисовка осей координат
//        gc.setLineWidth(AXIS_WIDTH);
//        gc.setStroke(AXIS_COLOR);
//        gc.strokeLine(0, HEIGHT / 2, WIDTH, HEIGHT / 2); // Ось X
//        gc.strokeLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT); // Ось Y
//        // Отрисовка меток на осях
//        gc.setLineWidth(1);
//        gc.setStroke(TICK_COLOR);
//        for (int x = -WIDTH / 2; x < WIDTH / 2; x += TICK_SPACING) {
//            gc.strokeLine(x + WIDTH / 2, HEIGHT / 2 - TICK_LENGTH / 2,
//                    x + WIDTH / 2, HEIGHT / 2 + TICK_LENGTH / 2);
//        }
//        for (int y = -HEIGHT / 2; y < HEIGHT / 2; y += TICK_SPACING) {
//            gc.strokeLine(WIDTH / 2 - TICK_LENGTH / 2, y + HEIGHT / 2,
//                    WIDTH / 2 + TICK_LENGTH / 2, y + HEIGHT / 2);
//        }
//        int houseWidth = 30; // Width of each house
//        int houseHeight = 30; // Height of each house
//
//        int roofHeight = 20; // Height of the roof
//
//        int doorWidth = 10; // Width of the door
//        int doorHeight = 15; // Height of the door
//
//        int windowWidth = 5; // Width of the window
//        int windowHeight = 5; // Height of the window
//
//        for (Flat flat : ClientLauncher.stack) {
//            int x = (int) (flat.getCoordinatesX() * TICK_SPACING + WIDTH / 2 - houseWidth / 2);
//            int y = (int) (-flat.getCoordinatesY() * TICK_SPACING + HEIGHT / 2 - houseHeight / 2);
//            Random random = new Random();
//            int red = random.nextInt(256);
//            int green = random.nextInt(256);
//            int blue = random.nextInt(256);
//            Color HOUSE_COLOR = Color.rgb(red, green, blue);
//            // Рисование домика
//            gc.setFill(HOUSE_COLOR);
//            gc.fillRect(x, y, houseWidth, houseHeight);
//
//            // Рисование крыши
//            gc.setFill(Color.RED);
//            gc.fillPolygon(new double[]{x, x + houseWidth / 2, x + houseWidth},
//                    new double[]{y, y - roofHeight, y}, 3);
//
//            // Рисование двери
//            gc.setFill(Color.BROWN);
//            gc.fillRect(x + houseWidth / 2 - doorWidth / 2,
//                    y + houseHeight - doorHeight, doorWidth, doorHeight);
//
//            // Рисование окна
//            gc.setFill(Color.WHITE);
//            gc.fillRect(x + houseWidth / 4 - windowWidth / 2,
//                    y + houseHeight / 2 - windowHeight / 2, windowWidth, windowHeight);
//        }
//    }
@FXML
private Canvas canvas;

    @FXML
    private AnchorPane pane;

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int AXIS_WIDTH = 2;
    private static final Color AXIS_COLOR = Color.BLACK;
    private static final int TICK_LENGTH = 5;
    private static final int TICK_SPACING = 10;
    private static final Color TICK_COLOR = Color.BLACK;

    @FXML
    void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Отрисовка осей координат
        gc.setLineWidth(AXIS_WIDTH);
        gc.setStroke(AXIS_COLOR);
        gc.strokeLine(0, HEIGHT / 2, WIDTH, HEIGHT / 2); // Ось X
        gc.strokeLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT); // Ось Y
        // Отрисовка меток на осях
        gc.setLineWidth(1);
        gc.setStroke(TICK_COLOR);
        for (int x = -WIDTH / 2; x < WIDTH / 2; x += TICK_SPACING) {
            gc.strokeLine(x + WIDTH / 2, HEIGHT / 2 - TICK_LENGTH / 2,
                    x + WIDTH / 2, HEIGHT / 2 + TICK_LENGTH / 2);
        }
        for (int y = -HEIGHT / 2; y < HEIGHT / 2; y += TICK_SPACING) {
            gc.strokeLine(WIDTH / 2 - TICK_LENGTH / 2, y + HEIGHT / 2,
                    WIDTH / 2 + TICK_LENGTH / 2, y + HEIGHT / 2);
        }

        int houseWidth = 30; // Width of each house
        int houseHeight = 30; // Height of each house
        int roofHeight = 20; // Height of the roof
        int doorWidth = 10; // Width of the door
        int doorHeight = 15; // Height of the door
        int windowWidth = 5; // Width of the window
        int windowHeight = 5; // Height of the window

        for (Flat flat : ClientLauncher.stack) {
            int x = (int) (flat.getCoordinatesX() * TICK_SPACING + WIDTH / 2 - houseWidth / 2);
            int y = (int) (-flat.getCoordinatesY() * TICK_SPACING + HEIGHT / 2 - houseHeight / 2);
            Random random = new Random();
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            Color houseColor = Color.rgb(red, green, blue);

            // Создание форм домика
            Rectangle houseBody = new Rectangle(x, y, houseWidth, houseHeight);
            Polygon roof = new Polygon(new double[]{
                    x, y,
                    x + houseWidth / 2, y - roofHeight,
                    x + houseWidth, y
            });
            Rectangle door = new Rectangle(
                    x + houseWidth / 2 - doorWidth / 2,
                    y + houseHeight - doorHeight,
                    doorWidth, doorHeight);
            Rectangle window = new Rectangle(
                    x + houseWidth / 4 - windowWidth / 2,
                    y + houseHeight / 2 - windowHeight / 2,
                    windowWidth, windowHeight);

            // Установка цвета домика
            houseBody.setFill(houseColor);
            roof.setFill(Color.RED);
            door.setFill(Color.BROWN);
            window.setFill(Color.WHITE);

            // Добавление домика на панель
            pane.getChildren().addAll(houseBody, roof, door, window);

            // Создание анимации для домика (поворот)
            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), pane);
            rotateTransition.setByAngle(360);
            rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
            rotateTransition.setAutoReverse(false);
            rotateTransition.play();
        }
    }
    }

