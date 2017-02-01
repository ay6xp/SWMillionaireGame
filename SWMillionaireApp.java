import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SWMillionaireApp extends Application {
	// lifeline idea--- play a scene of starwars that gives you a hint
	// lifeline idea-- call master Yoda( 80% chance he will be right, 25% chance
	// jar jar will answer phone and
	// give you wrong answer)
	public static class DirectionBox extends Pane {
		Rectangle bg = new Rectangle(400, 250);
		ArrayList<Label> l = new ArrayList<>();
		MenuButton yesButton;
		MenuButton noButton;
		MenuButton button;
		Label label1;

		// Pane vbox = new Pane();

		DirectionBox(int x, int y) {

			bg.setFill(Color.WHITE);
			bg.setOpacity(0.7);
			// bg.setTranslateX(0);
			// bg.setTranslateY(0);
			bg.setStroke(Color.GOLD);
			bg.setStrokeWidth(8);
			setTranslateX(x);
			setTranslateY(y);

			getChildren().addAll(bg);

		}

		public void makeButton(String name, int x, int y) {
			button = new MenuButton(name);
			button.text.setFill(Color.MIDNIGHTBLUE);
			button.setTranslateY(y);
			button.setTranslateX(x);
			getChildren().addAll(button);
		}

		public void makeYesNoButton() {
			yesButton = new MenuButton("YES");
			yesButton.text.setFill(Color.DARKGREEN);

			noButton = new MenuButton("NO");
			noButton.text.setFill(Color.DARKRED);

			yesButton.setTranslateY(55);
			yesButton.setTranslateX(-100);
			noButton.setTranslateY(55);
			noButton.setTranslateX(80);

			getChildren().addAll(yesButton, noButton);

		}

		public void removeAll() {
			for (int i = 0; i < l.size(); i++) {
				label1 = l.get(i);
				getChildren().removeAll(label1);
			}
			getChildren().removeAll(button);
		}

		public void setLabel(String label, int x, int y, int z) {

			label1 = new Label();

			label1.setText(label);

			label1.setTextAlignment(TextAlignment.JUSTIFY);
			label1.setAlignment(Pos.TOP_CENTER);

			label1.setFont(Font.font("Rebellion", FontWeight.SEMI_BOLD, z));
			label1.setTranslateY(y);
			label1.setPrefHeight(230);
			label1.setPrefWidth(380);
			label1.setTranslateX(x);
			label1.setWrapText(true);
			l.add(label1);
			getChildren().addAll(label1);

		}

		public void setTranslate(int x, int y) {
			bg.setTranslateX(x);
			bg.setTranslateX(y);
		}

	}

	public class GameMenu extends BorderPane {

		GameMenu() throws IOException {
			
			File file3 = new File("Res/images/cityRepublic.jpg");
			FileReader file = new FileReader("Res/images/starwarsqa.txt");
			Question question = new Question(file);

			int YOffset = 160;
			int XOffset = 170;
			Image image2 = new Image(file3.toURI().toString());
			ImageView imageView2 = new ImageView(image2);

			menu0.setTranslateX(530);
			menu0.setTranslateY(3);
			box.makeButton("Okay", 80, 150);
			box.setLabel("Welcome to Star Wars: Who wants to be a Millionaire! "
					+ "Answer 15 Star Wars related trivia questions in a row and you "
					+ "win $1,000,000(not really) You have have three life lines in case you"
					+ " get stuck. Good Luck.", 10, 30, 12);
			box3.setLabel("Choose the correct answer", 7, 90, 18);

			QuestionSetUp pane5 = new QuestionSetUp();
			pane5.setTranslateX(-300);

			pane5.setQuestion(question);

			imageView2.setFitHeight(600);
			imageView2.setFitWidth(800);

			MoneyMenu menu2 = new MoneyMenu();
			life1.setTranslate(540, 20);
			life2.setTranslate(627, 20);
			life3.setTranslate(712, 17);

			getChildren().addAll(imageView2, box);

			box.setOnMouseClicked(event -> {

				getChildren().addAll(box3, pane5, menu0, life1, life2, life3);

				TranslateTransition tt = new TranslateTransition(Duration.seconds(1.5), box3);
				tt.setToX(box3.getTranslateX() - XOffset);
				tt.setToY(box3.getTranslateY() - YOffset);

				FadeTransition tt2 = new FadeTransition(Duration.seconds(.5), box);
				tt2.setFromValue(1);
				tt2.setToValue(0);
				TranslateTransition tt1 = new TranslateTransition(Duration.seconds(1), pane5);
				tt1.setToX(pane5.getTranslateX() + 300);

				FadeTransition tt3 = new FadeTransition(Duration.seconds(2), menu0);
				tt3.setFromValue(0);
				tt3.setToValue(1);

				FadeTransition tt4 = new FadeTransition(Duration.seconds(2), life1);

				tt4.setFromValue(0);
				tt4.setToValue(1);

				FadeTransition tt5 = new FadeTransition(Duration.seconds(2), life2);

				tt5.setFromValue(0);
				tt5.setToValue(1);

				FadeTransition tt6 = new FadeTransition(Duration.seconds(2), life3);

				tt6.setFromValue(0);
				tt6.setToValue(1);

				tt.play();
				tt1.play();
				tt2.play();
				tt3.play();
				tt4.play();
				tt5.play();
				tt6.play();
				tt.setOnFinished(evt -> {
					getChildren().remove(box);
					playIntroSound();

					p.play();
					p.setOnEndOfMedia(new Runnable() {
						@Override
						public void run() {
							p.seek(Duration.ZERO);
						}
					});

				});

			});

		}

		public void playIntroSound() {

			ruleSound.stop();

		}

	}

	public class LifeLine extends Pane {

		DropShadow drop = new DropShadow(50, Color.BLACK);
		DropShadow drop2 = new DropShadow(30, Color.WHITE);
		Question current;
		ImageView image;
		boolean used = false;

		public LifeLine(ImageView image) {
			this.image = image;
			Circle circle = new Circle(40, 40, 40);
			DropShadow drop = new DropShadow(10, Color.BLACK);
			DropShadow drop2 = new DropShadow(30, Color.WHITE);

			circle.setFill(null);
			circle.setStroke(Color.GOLD);
			circle.setStrokeWidth(4);

			// circle.setTranslateX(x);
			// circle.setTranslateY(y);

			drop.setInput(new Glow());
			drop2.setInput(new Glow());
			image.setFitHeight(80);
			image.setFitWidth(80);
			image.setEffect(drop);
			image.setOnMouseEntered(event -> setEffect(drop2));
			image.setOnMouseExited(event -> setEffect(drop));
			// image.setTranslateX(x);
			// image.setTranslateY(y);

			getChildren().addAll(image);

		}

		public void drawX() {

			
				File file = new File("Res/Images/crossout.png");
				Image image2 = new Image(file.toURI().toString());
				ImageView view = new ImageView(image2);

				view.setTranslateX(image.getTranslateX());
				view.setTranslateY(image.getTranslateY() + 7);
				view.setFitHeight(80);
				view.setFitWidth(80);
				view.toFront();
				view.setOpacity(0.5);

				getChildren().addAll(view);
			
			

		}
		public boolean isUsed(){
			if(used){
				return false;
			}else{
				used = true;
				return true;
				
			}
			
		}

		public void playLifeSound(String name) {
			File file1 = new File(name);
			Media player = new Media(file1.toURI().toString());
			MediaPlayer player2 = new MediaPlayer(player);
			player2.play();

		}

		public void setTranslate(int x, int y) {
			setTranslateX(x);
			setTranslateY(y);

		}

	}

	public class MakePolygon extends StackPane {
		Double x;
		String str;
		ArrayList<Polygon> poly = new ArrayList<>();
		Polygon p;
		Label label;
		boolean active = true;

		public MakePolygon(Double... x) {

			p = new Polygon();

			p.getPoints().addAll(x[0], x[1], x[2], x[3], x[4], x[5], x[6], x[7], x[8], x[9], x[10], x[11]);

			p.setFill(Color.BLACK);

			p.prefWidth(200);
			p.setFill(Color.MIDNIGHTBLUE);
			p.setStroke(Color.GOLD);
			p.setStrokeWidth(3);
			p.setOpacity(0.5);
			p.setOnMouseEntered(event -> {
				if (p.getFill() != Color.BLACK) {
					p.setFill(Color.DARKBLUE);
				}

			});
			p.setOnMouseExited(event -> {
				if (p.getFill() != Color.BLACK) {
					p.setFill(Color.MIDNIGHTBLUE);
				}
			});

			getChildren().addAll(p);

		}

		public String getLabel() {
			return str;

		}

		public boolean isActive() {
			if (active) {
				return true;
			} else {
				return false;
			}
		}

		public void removeLabels() {
			getChildren().removeAll(label);

		}

		public void setActive() {
			active = true;
		}

		public void setColor(Color color) {
			p.setFill(color);

		}

		public void setInActive() {

			active = false;

		}

		public void setLabel(String text) {
			str = text;
			label = new Label(str);
			label.setTranslateX(p.getTranslateX());
			label.setTranslateY(p.getTranslateY());
			label.setFont(Font.font(12));
			label.setTextFill(Color.GOLD);
			getChildren().add(label);

		}

	}

	public static class MenuButton extends StackPane {
		Text text;

		public MenuButton(String name) {
			Rectangle bg = new Rectangle(230, 30);
			text = new Text(name);

			text.setFill(Color.WHITE);

			text.setFont(Font.font("Rebellion", FontWeight.SEMI_BOLD, 24));
			bg.setFill(Color.BLACK);
			bg.setEffect(new GaussianBlur(3.5));
			bg.setOpacity(0.0);

			setRotate(-0.5);

			getChildren().addAll(bg, text);

			DropShadow drop = new DropShadow(50, Color.WHITE);
			drop.setInput(new Glow());

			setOnMousePressed(event -> setEffect(drop));
			setOnMouseReleased(event -> setEffect(null));

		}

		public void setColor(Color color) {
			text.setFill(color);

		}

	}

	public class MoneyMenu extends Pane {
		ArrayList<Text> list = new ArrayList<>();
		int count = 15;

		public MoneyMenu() {

			VBox box = new VBox();
			Rectangle bg = new Rectangle(270, 595);
			bg.setFill(Color.MIDNIGHTBLUE);
			bg.setOpacity(0.5);
			bg.setStroke(Color.GOLD);
			bg.setStrokeWidth(5);
			Text text1 = new Text("1. $100");

			Text text2 = new Text("2. $200");

			Text text3 = new Text("3. $300");

			Text text4 = new Text("4. $500");

			Text text5 = new Text("5. $1000");

			Text text6 = new Text("6. $2000");

			Text text7 = new Text("7. $4000");

			Text text8 = new Text("8. $8000");

			Text text9 = new Text("9. $16,000");

			Text text10 = new Text("10. $32,000");

			Text text11 = new Text("11. $64,000");

			Text text12 = new Text("12. $125,000");

			Text text13 = new Text("13. $250,000");

			Text text14 = new Text("14. $500,000");

			Text text15 = new Text("15. $1 MILLION");

			list.add(text15);
			list.add(text14);
			list.add(text13);
			list.add(text12);
			list.add(text11);
			list.add(text10);
			list.add(text9);
			list.add(text8);
			list.add(text7);
			list.add(text6);
			list.add(text5);
			list.add(text4);
			list.add(text3);
			list.add(text2);
			list.add(text1);

			for (int i = 0; i < 15; i++) {

				list.get(i).setFill(Color.GOLD);
				list.get(i).setFont(Font.font("Rebellion", FontWeight.SEMI_BOLD, 24));

			}
			box.setTranslateX(30);
			box.setTranslateY(110);

			box.getChildren().addAll(list);
			getChildren().addAll(bg, box);

		}

		public String getPrice() {
			String money = " ";
			if (count > 10) {
				money = "$0";
			} else if (count > 5) {
				money = "$1000";
			} else if (count > 3) {
				money = "$32000";
			}
			return money;

		}

		public void setNext() {
			count--;
			list.get(count).setFill(Color.WHITE);

		}
	}

	public class OpenScreen extends Parent {

		public OpenScreen() {

			VBox box = new VBox(10);
			MenuButton menuButton = new MenuButton("Click To Play");
			File file2 = new File("Res/images/starwars.jpg");

			File file5 = new File("Res/sounds/clickSound.mp3");
			Image image = new Image(file2.toURI().toString());

			ImageView imageView = new ImageView(image);

			Media click = new Media(file5.toURI().toString());
			MediaPlayer clickview = new MediaPlayer(click);

			menuButton.setTranslateX(280);
			menuButton.setTranslateY(420);
			box.getChildren().addAll(menuButton);
			imageView.setFitHeight(600);
			imageView.setFitWidth(800);

			getChildren().addAll(imageView, box);

			boolean start = true;

			menuButton.setOnMouseClicked(e -> {
				view.stop();
				FadeTransition ft = new FadeTransition(Duration.seconds(4), imageView);
				ft.setFromValue(1);
				ft.setToValue(0);

				ft.play();

				imageView.setVisible(false);
				getChildren().remove(imageView);
				clickview.play();

				FadeTransition ft2 = new FadeTransition(Duration.seconds(4), menu);
				ft2.setFromValue(0);
				ft2.setToValue(1);

				ft2.play();
				menu.setVisible(true);
				ruleSound.play();

			});

		}

	}

	public class Question {
		String name;
		String q;
		ArrayList<String> line = new ArrayList<>();
		BufferedReader reader;
		String answer = "";

		// BufferedReader reader;
		public Question(FileReader file) throws IOException {
			reader = new BufferedReader(file);

			name = reader.readLine();
			q = reader.readLine();
			answer = q;

			for (int i = 0; i < 4; i++) {

				line.add(q);
				q = reader.readLine();
			}

		}

		public String getCorrectAnswer() {
			return line.get(0);

		}

		public void newQuestion() throws IOException {
			line.clear();
			name = reader.readLine();
			q = reader.readLine();
			for (int i = 0; i < 4; i++) {

				line.add(q);
				q = reader.readLine();

			}

		}

	}

	public class QuestionSetUp extends Pane {
		ArrayList<Text> label = new ArrayList<>();
		ArrayList<MakePolygon> poly = new ArrayList<>();
		Text text;
		Question current;
		MenuButton yesButton = new MenuButton("Yes");
		MenuButton noButton = new MenuButton("No");
		boolean click = true;
		boolean used = false;

		public QuestionSetUp() {
			// Pane pane = new Pane();
			AnchorPane pane = new AnchorPane();

			yesButton.setVisible(false);
			noButton.setVisible(false);

			// current = question;

			questionScreen = new MakePolygon(25d, 313d, 221d, 289d, 417d, 310d, 417d, 355d, 221d, 379d, 25d, 355d);

			questionScreen.setTranslateX(25);
			questionScreen.setTranslateY(280);

			questionBoxA = new MakePolygon(60d, 429d, 152d, 409d, 244d, 429d, 244d, 463d, 152d, 482d, 60d, 463d);
			questionBoxA.setTranslateX(25);
			questionBoxA.setTranslateY(385);

			poly.add(questionBoxA);

			questionBoxB = new MakePolygon(60d, 429d, 152d, 409d, 244d, 429d, 244d, 463d, 152d, 482d, 60d, 463d);
			questionBoxB.setTranslateX(225);
			questionBoxB.setTranslateY(385);

			poly.add(questionBoxB);
			questionBoxC = new MakePolygon(60d, 429d, 152d, 409d, 244d, 429d, 244d, 463d, 152d, 482d, 60d, 463d);
			questionBoxC.setTranslateX(25);
			questionBoxC.setTranslateY(465);

			poly.add(questionBoxC);
			questionBoxD = new MakePolygon(60d, 429d, 152d, 409d, 244d, 429d, 244d, 463d, 152d, 482d, 60d, 463d);
			questionBoxD.setTranslateX(225);
			questionBoxD.setTranslateY(465);

			poly.add(questionBoxD);

			questionBoxA.setOnMouseClicked(event -> {
				if (click && questionBoxA.isActive()) {
					isClicked();
					buttonPressed(questionBoxA);
				}
			});
			questionBoxB.setOnMouseClicked(event -> {
				if (click && questionBoxB.isActive()) {
					isClicked();
					buttonPressed(questionBoxB);
				}

			});
			questionBoxC.setOnMouseClicked(event -> {
				if (click && questionBoxC.isActive()) {
					isClicked();

					buttonPressed(questionBoxC);
				}

			});
			questionBoxD.setOnMouseClicked(event -> {
				if (click && questionBoxD.isActive()) {
					isClicked();
					buttonPressed(questionBoxD);

				}
			});
			life3.setOnMouseClicked(event -> {
				if (click && life3.isUsed()) {
					life3.drawX();
					life3.playLifeSound("Res/sounds/50_50.mp3");
					removeFifty();

				}

			});
			life2.setOnMouseClicked(event -> {
				if (click && life2.isUsed()) {
					life2.drawX();
					life2.playLifeSound("Res/sounds/jarjarS.wav");

				}
			});
			life1.setOnMouseClicked(event -> {
				if (click && life1.isUsed()) {
					life1.drawX();
					life1.playLifeSound("Res/sounds/yodasound.mp3");
					callYoda();
				}
			});

			pane.getChildren().addAll(questionScreen, questionBoxA, questionBoxB, questionBoxC, questionBoxD, yesButton,
					noButton);

			getChildren().add(pane);
		}

		public void adjustLabels() {
			questionScreen.removeLabels();
			questionScreen.setLabel(current.name);
			java.util.Collections.shuffle(poly);
			for (int i = 0; i < 4; i++) {
				poly.get(i).removeLabels();
				poly.get(i).setLabel(current.line.get(i));
				poly.get(i).setActive();
			}

		}

		public void buttonPressed(MakePolygon polygon) {

			changeBox();
			polygon.setColor(Color.BLACK);
			
			
			yesButton.setOnMouseClicked(eve -> {
				
				if (polygon.getLabel().equals(current.getCorrectAnswer())) {
					System.out.println("Correct");

					try {
						
						correctScreen(polygon);
						playSound("Res/sounds/correct1.mp3");
						menu0.setNext();
						;
						current.newQuestion();
						adjustLabels();
						unClick();
						removeBox();
						polygon.setColor(Color.MIDNIGHTBLUE);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					polygon.setColor(Color.DARKRED);
					playSound("Res/sounds/wrong.mp3");
					
					p.stop();
					System.out.println("Incorrect");
				}

			});
			noButton.setOnMouseClicked(ev -> {
				unClick();
				removeBox();
				polygon.setColor(Color.MIDNIGHTBLUE);

			});
			

		}
		public void playSound(String name){
			File file = new File(name);
			Media player = new Media(file.toURI().toString());
			MediaPlayer play = new MediaPlayer(player);
			play.play();
			
		}

		public void callYoda() {

		}

		public void changeBox() {

			box3.removeAll();

			box3.setLabel("Is this your final answer?", 7, 90, 18);

			yesButton.setVisible(true);
			noButton.setVisible(true);
			yesButton.setTranslateY(170);
			yesButton.setTranslateX(10);
			noButton.setTranslateY(170);
			noButton.setTranslateX(200);
			yesButton.setColor(Color.DARKGREEN);
			noButton.setColor(Color.DARKRED);

		}

		public void correctScreen(MakePolygon polygon) throws InterruptedException {

			/*
			 * new Thread() { public void run() {
			 * 
			 * Platform.runLater(new Runnable() { public void run() {
			 * 
			 * 
			 * } }); } }.start();
			 */

			Timeline timeline = new Timeline(

			new KeyFrame(Duration.seconds(3), e -> {
				polygon.setColor(Color.GREEN);
			}));
			timeline.setAutoReverse(true);

			//timeline.play();

		}

		public boolean isClicked() {
			click = false;

			return click;

		}

		public void removeBox() {
			box3.removeAll();
			yesButton.setVisible(false);
			noButton.setVisible(false);

			box3.setLabel("Choose the correct answer", 7, 90, 18);
			box3.setLabel("Or walk away with " + menu0.getPrice(), 7, 130, 16);

		}

		public void removeFifty() {

			int count = 0;
			if (!used) {
				for (int i = 0; i < 4; i++) {
					if (!poly.get(i).getLabel().equals(current.getCorrectAnswer())) {

						poly.get(i).removeLabels();
						poly.get(i).setInActive();

						count++;

					}

					if (count == 2) {
						used = true;
						break;

					}
				}
			}

		}

		public void setQuestion(Question question) {
			current = question;

			questionScreen.setLabel(current.name);
			java.util.Collections.shuffle(poly);
			for (int i = 0; i < 4; i++) {
				poly.get(i).setLabel(current.line.get(i));

			}

		}

		public boolean unClick() {

			click = true;
			return click;
		}

	}

	public static void main(String[] args) throws IOException {
		launch(args);

	}

	MakePolygon questionScreen;
	MakePolygon questionBoxA;

	MakePolygon questionBoxB;

	MakePolygon questionBoxC;

	MakePolygon questionBoxD;

	Pane root;

	MediaPlayer view;
	final int MAXQUESTIONS = 15;
	boolean start = false;
	OpenScreen open;
	GameMenu menu;
	File file9 = new File("Res/sounds/rules.mp3");
	Media media = new Media(file9.toURI().toString());
	MediaPlayer ruleSound = new MediaPlayer(media);
	File file = new File("Res/Images/Picture1.png");
	File file2 = new File("Res/Images/fifty2.png");
	File file3 = new File("Res/Images/qmark.png");
	Image view1 = new Image(file.toURI().toString());
	Image view2 = new Image(file2.toURI().toString());
	Image view3 = new Image(file3.toURI().toString());
	File file4 = new File("Res/sounds/stufe_1.mp3");
	Media player = new Media(file4.toURI().toString());
	MediaPlayer p = new MediaPlayer(player);
	ImageView yoda = new ImageView(view1);
	ImageView fifty = new ImageView(view2);
	ImageView qmark = new ImageView(view3);
	DirectionBox box = new DirectionBox(200, 160);

	DirectionBox box3 = new DirectionBox(200, 175);

	LifeLine life1 = new LifeLine(yoda);
	LifeLine life2 = new LifeLine(qmark);
	LifeLine life3 = new LifeLine(fifty);
	MoneyMenu menu0 = new MoneyMenu();

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage window = primaryStage;
		File file4 = new File("Res/images/openTheme.mp3");

		Media sound = new Media(file4.toURI().toString());

		view = new MediaPlayer(sound);
		view.play();

		menu = new GameMenu();
		menu.setVisible(false);

		menu.setVisible(false);

		root = new Pane();
		root.setPrefSize(800, 600);

		open = new OpenScreen();

		root.getChildren().addAll(open, menu);

		Scene scene = new Scene(root);

		window.setScene(scene);
		window.show();

	}

}
