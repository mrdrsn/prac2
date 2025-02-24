//• кнопка добавить объект розыска, 
//• кнопка список объектов розыска  
//• кнопку просмотреть информацию об объекте розыска

package com.mycompany.prac2;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GUI extends JFrame{
    Heretic heretic;
    
    public GUI() {        
        super("Еретики");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 10, 10));
        
        JButton addHeretic = new JButton("Add Heretic");
        JButton listHeretic = new JButton("Show heretic list");
        JButton infoHeretic = new JButton("Show info");
        
        
        addHeretic.addActionListener((e) -> {
            int num = 0;
            JPanel panel = new JPanel();
            JTextField numField = new JTextField(10);
            panel.add(numField);
            int option = JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "Сколько еретиков вы хотите добавить?",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (option == JOptionPane.OK_OPTION) {
                try {
                    num = Integer.parseInt(numField.getText().trim());

                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Введите корректное целое число.",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            
            Controller.createData(num);
        });
        
        listHeretic.addActionListener((e) -> {
            JPanel panel = new JPanel();
            DefaultListModel<String> p = new DefaultListModel<>();
            for (Heretic her : Controller.getHerList()) {
                p.addElement(Controller.getHerNames(her));
            }
            JList<String> peoplefinal = new JList<>(p);
            panel.add(new JScrollPane(peoplefinal));
            JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "Сколько еретиков вы хотите добавить?",
                    JOptionPane.DEFAULT_OPTION
                    //JOptionPane.QUESTION_MESSAGE
            );
        });
        
        infoHeretic.addActionListener((e) -> {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            ButtonGroup group = new ButtonGroup();

            JRadioButton[] buttons = new JRadioButton[Controller.getHerList().size()];
            for (int i = 0; i < Controller.getHerList().size(); i++) {
                buttons[i] = new JRadioButton(Controller.getHerNames(Controller.getHerList().get(i)));
                group.add(buttons[i]);
                panel.add(buttons[i]);
            }

            buttons[0].setSelected(true);

            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setPreferredSize(new Dimension(700, 200));

            int option = JOptionPane.showConfirmDialog(
                    null,
                    scrollPane,
                    "Выберите объект:",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (option == JOptionPane.OK_OPTION) {
                for (int i = 0; i < buttons.length; i++) {
                    if (buttons[i].isSelected()) {
                        showChosenHeretic(Controller.getHerList().get(i));
                    }
                }
            }

        });
        
        mainPanel.add(addHeretic);
        mainPanel.add(listHeretic);
        mainPanel.add(infoHeretic);
        
        add(mainPanel);
        pack();//автоматически устанавливает размер окна
        setLocationRelativeTo(null);
        setVisible(true);    
        
    }
    
    public void showChosenHeretic(Heretic ex) {
        JOptionPane.showMessageDialog(
                null,
                ex.toString(),
                "Введенные данные",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    
}

