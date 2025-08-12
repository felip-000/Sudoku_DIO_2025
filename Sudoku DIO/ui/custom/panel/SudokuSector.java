package ui.custom.panel;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import ui.custom.input.NumberText;

import java.awt.Dimension;
import java.awt.Color;
import java.util.List;

public class SudokuSector extends JPanel{
    public SudokuSector(final List<NumberText> textFields){
        var dimension = new Dimension(170, 170);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setBorder(new LineBorder(Color.BLACK, 2, true));
        this.setVisible(true);
        textFields.forEach(this::add);
    }
}
