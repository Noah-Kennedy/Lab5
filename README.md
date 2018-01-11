# Lab5
Lab 05 Game of Life

Objectives
Design and implement a program with a Graphical User Interface using the JavaFX framework.
Implement Event Handlers for mouse clicks
Assignment
The Game of Life was proposed in 1970 as a simple, 0-player game based on a grid of “cells.” The cells can only be alive or dead and cannot interact outside of their neighborhood. Cells have rules that define whether they live or die based on whether their neighbors are alive or dead. In general, if several neighbors are alive, then a cell will die due to starvation, and if there are not enough neighbors, a cell will die due to loneliness. A cell can become alive if the right number of cells are alive around it (if the right community exists). The basic idea of the game is to explore issues of population dynamics, and it has been used by computer modelers extensively since it was proposed. The image below shows the game of life in action. The black squares are “alive.”

Game of Life
You can see a web-based version of the game here.

For this assignment you will be implementing a Game of Life simulator. The Cell and LifeGrid classes have been provided for you. Your implementation must use the JavaFX framework.

The LifeGrid class contains a two-dimensional List that contains the cells and manages the relationships between the cells. The Cell.SCALE constant defines the size of each cell displayed.

Details
You should complete the lab 5 application to display the visual representation of the LifeGrid object. The following functionality is required.

The user of your application, at any time, must be able to click on any cell and it should flip from alive to dead or dead to alive.
You must provide two buttons in your UI:
One button must allow the user to randomize all the cells (whether they are alive or dead).
The other button must step through one iteration of the algorithm and visually update the grid of cells.
You must display the number of alive and dead cells on the GUI somewhere.
You should not need to modify the Cell class, and the LifeGrid class should only need minor additions (to toggle the dead/alive state). You need to implement and/or modify the following components of the application:

Lab5.java — All necessary components to make the application display and register the FXML components (if used).
lab5.fxml — if FXML is used.
Controller.java — All GUI components and event handlers (if using FXML, otherwise this may be in the Lab5.java file.)
LifeGrid.java — Functionality to track the number of alive and dead cells.
If you choose to make use of an FXML file, you’ll need to have your Controller class implement the Initializable interface and include the following method:

@Override
public void initialize(URL location, ResourceBundle resources) {
    assert gamePane != null :"fx:id=\"gamePane\" was not injected: check your FXML file 'game.fxml'.";
    lifeGrid = new LifeGrid(gamePane);
}
Note: Be sure that gamePane is the id associated with the Pane representing the game grid.

Just for Fun
Motivated students may wish to add another button that, when activated, provides an animation of the game of life going through a fixed number of iterations. The following classes may be helpful: Timeline and KeyFrame.