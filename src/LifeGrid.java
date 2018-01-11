/*
 * SE1021
 * Winter 2018
 * Lab Game Of Life
 * Name: Derek Riley (edits by Chris Taylor & Brad Dennis)
 * Created 11/25/2016
 * Revised 1/11/2018
 */


import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the grid of cells used to model Conway's Game of Life.
 *
 * @author Derek Riley
 * @version 2018AY
 */
public class LifeGrid {

    private static final double ALIVE_CHANCE = 0.5;

    /**
     * This instance variable stores the grid of Cells
     */
    private List<List<Cell>> cells;


    /**
     * This constructor builds a LifeGrid using the size of the Pane passed and the scale of the cells
     *
     * @param gamePane viewing pane
     */
    public LifeGrid(Pane gamePane) {
        final int numberOfCellsWide = (int) gamePane.getPrefWidth() / Cell.SCALE;
        final int numberOfCellsHigh = (int) gamePane.getPrefHeight() / Cell.SCALE;
        cells = new ArrayList<>();

        //initialize the two dimensional ArrayList
        for (int i = 0; i < numberOfCellsHigh; i++) {
            cells.add(new ArrayList<>());
        }

        //create cells
        for (int i = 0; i < numberOfCellsHigh; i++) {     // yPosition
            for (int j = 0; j < numberOfCellsWide; j++) { // xPosition
                cells.get(i).add(new Cell(j, i));
            }
        }

        //set neighbors for all cells
        for (int i = 0; i < numberOfCellsHigh; i++) {     // yPosition
            for (int j = 0; j < numberOfCellsWide; j++) { // xPosition
                if (i > 0) {
                    if (j > 0) {
                        cells.get(i).get(j).setNeighborAboveLeft(cells.get(i - 1).get(j - 1));
                    }
                    cells.get(i).get(j).setNeighborAboveCenter(cells.get(i - 1).get(j));
                    if (j < numberOfCellsWide - 1) {
                        cells.get(i).get(j).setNeighborAboveRight(cells.get(i - 1).get(j + 1));
                    }
                }
                if (j > 0) {
                    cells.get(i).get(j).setNeighborMiddleLeft(cells.get(i).get(j - 1));
                }
                if (j < numberOfCellsWide - 1) {
                    cells.get(i).get(j).setNeighborMiddleRight(cells.get(i).get(j + 1));
                }
                if (i < numberOfCellsHigh - 1) { // bottom boarder elements
                    if (j > 0) {
                        cells.get(i).get(j).setNeighborBelowLeft(cells.get(i + 1).get(j - 1));
                    }
                    cells.get(i).get(j).setNeighborBelowCenter(cells.get(i + 1).get(j));
                    if (j < numberOfCellsWide - 1) {
                        cells.get(i).get(j).setNeighborBelowRight(cells.get(i + 1).get(j + 1));
                    }
                }
            }
        }
        initialize(gamePane);
    }

    /**
     * This method randomizes the life and death attributes of all cells in the cells.
     * Cells have a 50% chance of being alive or dead.
     */
    public void randomize() {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                cell.setAlive(Math.random() < ALIVE_CHANCE);
                cell.updateColors();
            }
        }
    }

    /**
     * This method triggers one iteration (tick) of the game of life rules for the entire grid.
     */
    public void iterate() {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                cell.determineNextTick();
            }
        }
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                cell.updateTick();
            }
        }
    }

    /**
     * This method adds all the cell rectangles to the Pane
     */
    private void initialize(Pane gamePane) {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                gamePane.getChildren().add(cell);
            }
        }
    }
}
