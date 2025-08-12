package ui.custom.input;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Space;
import service.EventEnum;
import java.util.EventListener;

public class NumberText extends JTextField implements EventListener {
    private final Space space;
    
    public NumberText(final Space space){
        this.space = space;
        var dimension = new Dimension(50,50);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setFont(new Font("Arial", Font.PLAIN, 20));
        this.setFont(new Font("Arial", Font.PLAIN, 20));
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new NumberTextLimit());
        this.setEnabled(!space.isFixed());
        if(space.isFixed()){
            this.setText(space.getActual().toString());
        }
        this.getDocument().addDocumentListener(new DocumentListener() {

            
            @Override
            public void insertUpdate(final DocumentEvent e) {
                changeSpace();
                
            }
            @Override
            public void removeUpdate(final DocumentEvent e) {
                changeSpace();
                
            }
            @Override
            public void changedUpdate(final DocumentEvent e) {
                changeSpace();
                
            }
            
            private void changeSpace(){
                if (getText().isEmpty()){
                    space.clearSpace();
                    return;
                }
                space.setActual(Integer.parseInt(getText()));
            }
        });
    }

    public void update(final EventEnum eventType) {
        if(eventType.equals(EventEnum.CLEAR_SPACE) && (this.isEnabled())){
            this.setText("");
        }
    }
}
