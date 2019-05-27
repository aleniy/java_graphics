package test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.shape.*;


public class task1 extends Application{
	
	public static void main (String args[]) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) 
	
	{
		Group root = new Group();
		Scene scene = new Scene(root, 500, 400);
		scene.setFill(Color.rgb(255, 128, 64));
		
		
		Polygon sun = new Polygon();
		sun.getPoints().addAll(new Double[]{
			150.0, 200.0,
			180.0, 140.0,
			250.0, 120.0,
			350.0, 180.0,
			330.0, 250.0,
			260.0, 280.0,
			190.0, 260.0
			});
		root.getChildren().add(sun);
		sun.setFill(Color.rgb(255, 255, 0));
		
		Rectangle eye1 = new Rectangle(210,170,8,8);
		root.getChildren().add(eye1);
		eye1.setFill(Color.rgb(0,128,128));
		
		Rectangle eye2 = new Rectangle(270,170,8,8);
		root.getChildren().add(eye2);
		eye2.setFill(Color.rgb(0,128,128));
		
		Polygon smile = new Polygon();
		smile.getPoints().addAll(new Double[]{
		 215.0, 210.0,
		 280.0, 210.0,
		 247.0, 230.0 });
		root.getChildren().add(smile);
		smile.setFill(Color.RED);
		
		
		Line line1 = new Line(200.0, 140.0, 150.0, 80.0);
		line1.setStrokeWidth(9);
		line1.setStrokeLineCap(StrokeLineCap.ROUND);
		root.getChildren().add(line1);
		line1.setStroke(Color.rgb(255, 255, 0));
		
		Line line2 = new Line(240.0, 130.0, 215.0, 60.0);
		line2.setStrokeWidth(9);
		line2.setStrokeLineCap(StrokeLineCap.ROUND);
		root.getChildren().add(line2);
		line2.setStroke(Color.rgb(255, 255, 0));
		
		Line line3 = new Line(255.0, 140.0, 290.0, 70.0);
		line3.setStrokeWidth(9);
		line3.setStrokeLineCap(StrokeLineCap.ROUND);
		root.getChildren().add(line3);
		line3.setStroke(Color.rgb(255, 255, 0));
		
		
		Line line5 = new Line(290.0, 150.0, 340.0, 100.0);
		line5.setStrokeWidth(9);
		line5.setStrokeLineCap(StrokeLineCap.ROUND);
		root.getChildren().add(line5);
		line5.setStroke(Color.rgb(255, 255, 0));
		
		Line line6 = new Line(310.0, 180.0, 400.0, 155.0);
		line6.setStrokeWidth(9);
		line6.setStrokeLineCap(StrokeLineCap.ROUND);
		root.getChildren().add(line6);
		line6.setStroke(Color.rgb(255, 255, 0));
		
		Line line7 = new Line(310.0, 200.0, 400.0, 220.0);
		line7.setStrokeWidth(9);
		line7.setStrokeLineCap(StrokeLineCap.ROUND);
		root.getChildren().add(line7);
		line7.setStroke(Color.rgb(255, 255, 0));
		
		Line line8 = new Line(320.0, 240.0, 380.0, 280.0);
		line8.setStrokeWidth(9);
		line8.setStrokeLineCap(StrokeLineCap.ROUND);
		root.getChildren().add(line8);
		line8.setStroke(Color.rgb(255, 255, 0));
		
		Line line9 = new Line(290.0, 260.0, 320.0, 320.0);
		line9.setStrokeWidth(9);
		line9.setStrokeLineCap(StrokeLineCap.ROUND);
		root.getChildren().add(line9);
		line9.setStroke(Color.rgb(255, 255, 0));
		
		Line line10 = new Line(225.0, 270.0, 220.0, 330.0);
		line10.setStrokeWidth(9);
		line10.setStrokeLineCap(StrokeLineCap.ROUND);
		root.getChildren().add(line10);
		line10.setStroke(Color.rgb(255, 255, 0));
		
		Line line11 = new Line(190.0, 230.0, 130.0, 280.0);
		line11.setStrokeWidth(9);
		line11.setStrokeLineCap(StrokeLineCap.ROUND);
		root.getChildren().add(line11);
		line11.setStroke(Color.rgb(255, 255, 0));
		
		Line line12 = new Line(150.0, 200.0, 90.0, 210.0);
		line12.setStrokeWidth(9);
		line12.setStrokeLineCap(StrokeLineCap.ROUND);
		root.getChildren().add(line12);
		line12.setStroke(Color.rgb(255, 255, 0));
		
		Line line13 = new Line(170.0, 165.0, 110.0, 130.0);
		line13.setStrokeWidth(9);
		line13.setStrokeLineCap(StrokeLineCap.ROUND);
		root.getChildren().add(line13);
		line13.setStroke(Color.rgb(255, 255, 0));
		
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}