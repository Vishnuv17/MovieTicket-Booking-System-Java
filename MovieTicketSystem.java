import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovieTicketSystem extends JFrame implements ActionListener {
    public CardLayout cardLayout;
    public JPanel cards;
    public JButton movie1Button, movie2Button, movie3Button, nextButton1,nextButton2,nextButton3, confirmButton;
    public JLabel movieLabel, seatLabel, ml1,ml2,ml3, il;
    public ImageIcon monnu, ghilli, vaaranam1000,greenIcon;
    public String selectedSeatsText = "";

    public MovieTicketSystem() {
        setTitle("Movie Ticket Booking System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        JPanel movieSelectionPanel = createMovieSelectionPanel();
        JPanel MonnuseatSelection = monnuSeatSelectionPanel();
        JPanel GhilliseatSelection = ghilliSeatSelectionPanel();
        JPanel VAseatSelection = VASeatSelectionPanel();
        JPanel paymentPanel = createPaymentPanel();

        cards.add(movieSelectionPanel, "MovieSelection");
        cards.add(MonnuseatSelection, "MonnuSeat");
        cards.add(GhilliseatSelection, "GhilliSeat");
        cards.add(VAseatSelection, "VASeat");
        cards.add(paymentPanel, "Payment");

        greenIcon = new ImageIcon("C:\\Users\\admin\\Downloads\\ghilli.jpg");
        Image resizedImage = greenIcon.getImage();
        resizedImage = resizedImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Adjust the width and height as needed
        greenIcon = new ImageIcon(resizedImage);

        add(cards);
        setVisible(true);
    }

    public JPanel createMovieSelectionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null); // Set layout to null for absolute positioning

        // Movie 1 - Monnu
        monnu = new ImageIcon("C:\\Users\\admin\\Downloads\\monnu.jpg");
        Image img1 = monnu.getImage();
        img1 = img1.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        monnu = new ImageIcon(img1);
        movie1Button = new JButton(monnu);
        movie1Button.addActionListener(this);
        movie1Button.setBounds(50, 20, 180, 180); // Set bounds for the button

        JLabel movie1Label = new JLabel("Monnu");
        movie1Label.setBounds(120, 200, 180, 20); // Set bounds for the label

        panel.add(movie1Button);
        panel.add(movie1Label);

        // Movie 2 - Ghilli
        ghilli = new ImageIcon("C:\\Users\\admin\\Downloads\\ghilli.jpg");
        Image img2 = ghilli.getImage();
        img2 = img2.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ghilli = new ImageIcon(img2);
        movie2Button = new JButton(ghilli);
        movie2Button.addActionListener(this);
        movie2Button.setBounds(250, 20, 180, 180); // Set bounds for the button

        JLabel movie2Label = new JLabel("Ghilli");
        movie2Label.setBounds(320, 200, 180, 20); // Set bounds for the label

        panel.add(movie2Button);
        panel.add(movie2Label);

        // Movie 3 - Vaaranam 1000
        vaaranam1000 = new ImageIcon("C:\\Users\\admin\\Downloads\\vaaranam1000.jpg");
        Image img3 = vaaranam1000.getImage();
        img3 = img3.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        vaaranam1000 = new ImageIcon(img3);
        movie3Button = new JButton(vaaranam1000);
        movie3Button.addActionListener(this);
        movie3Button.setBounds(450, 20, 180, 180); // Set bounds for the button

        JLabel movie3Label = new JLabel("Vaaranam 1000");
        movie3Label.setBounds(500, 200, 180, 20); // Set bounds for the label

        panel.add(movie3Button);
        panel.add(movie3Label);

        return panel;
    }

    public JPanel VASeatSelectionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        ml3 = new JLabel();
        panel.add(ml3, BorderLayout.NORTH);

        JPanel seatp = new JPanel(new GridLayout(10, 10));
        for (int i = 1; i <= 100; i++) {
            JCheckBox seat = new JCheckBox("Seat " + i);
            seat.setActionCommand("Seat " + i);
            seat.addActionListener(this);
            seatp.add(seat);
        }
        panel.add(seatp, BorderLayout.CENTER);

        nextButton1 = new JButton("Next");
        nextButton1.addActionListener(this);
        panel.add(nextButton1, BorderLayout.SOUTH);

        return panel;
    }

    public JPanel ghilliSeatSelectionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        ml2 = new JLabel();
        panel.add(ml2, BorderLayout.NORTH);

        JPanel seatp = new JPanel(new GridLayout(10, 10));
        for (int i = 1; i <= 100; i++) {
            JCheckBox seat = new JCheckBox("Seat " + i);
            seat.setActionCommand("Seat " + i);
            seat.addActionListener(this);
            seatp.add(seat);
        }
        panel.add(seatp, BorderLayout.CENTER);

        nextButton2 = new JButton("Next");
        nextButton2.addActionListener(this);
        panel.add(nextButton2, BorderLayout.SOUTH);

        return panel;
    }
    public JPanel monnuSeatSelectionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        ml1 = new JLabel();
        panel.add(ml1, BorderLayout.NORTH);

        JPanel seatp = new JPanel(new GridLayout(10, 10));
        for (int i = 1; i <= 100; i++) {
            JCheckBox seat = new JCheckBox("Seat " + i);
            seat.setActionCommand("Seat " + i);
            seat.addActionListener(this);
            seatp.add(seat);
        }
        panel.add(seatp, BorderLayout.CENTER);

        nextButton3 = new JButton("Next");
        nextButton3.addActionListener(this);
        panel.add(nextButton3, BorderLayout.SOUTH);

        return panel;
    }

    public JPanel createPaymentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null); // Set layout to null to use setBounds method

        movieLabel = new JLabel();
        seatLabel = new JLabel();
        il = new JLabel();
        confirmButton = new JButton("Confirm Payment");
        confirmButton.addActionListener(this);

        // Set bounds for each component
        movieLabel.setBounds(10, 10, 200, 30);
        il.setBounds(10, 40, 180, 180);
        seatLabel.setBounds(10, 250, 1000, 30);
        confirmButton.setBounds(10, 400, 150, 30);

        // Add components to the panel
        panel.add(movieLabel);
        panel.add(seatLabel);
        panel.add(il);
        panel.add(confirmButton);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == movie1Button) {
            cardLayout.show(cards, "MonnuSeat");
            ml1.setText("Selected Movie: Monnu");
            movieLabel.setText("Selected Movie: Monnu");
            il.setIcon(monnu);
        } else if (e.getSource() == movie2Button) {
            cardLayout.show(cards, "GhilliSeat");
            ml2.setText("Selected Movie: Ghilli");
            movieLabel.setText("Selected Movie: Ghilli");
            il.setIcon(ghilli);
        } else if (e.getSource() == movie3Button) {
            cardLayout.show(cards, "VASeat");
            ml3.setText("Selected Movie: Vaaranam 1000");
            movieLabel.setText("Selected Movie: Vaaranam 1000");
            il.setIcon(vaaranam1000);
        } else if (e.getActionCommand().startsWith("Seat")) {
            JCheckBox checkBox = (JCheckBox) e.getSource();
            String seat = checkBox.getText();
            selectedSeatsText += seat + ", "; //selectedSeatsText=selectedSeatsText+seat + ", ";
        } else if (e.getSource() == nextButton1 || e.getSource() == nextButton2 || e.getSource() == nextButton3) {
            cardLayout.show(cards, "Payment");
            seatLabel.setText("Selected Seats: " + selectedSeatsText);
        } else if (e.getSource() == confirmButton) {
            selectedSeatsText="";
            JOptionPane.showMessageDialog(null, "Ticket has been Successfully Booked", "Ticket Booked", JOptionPane.INFORMATION_MESSAGE, greenIcon);
            cardLayout.show(cards, "MovieSelection");
        }
    }

    public static void main(String[] args) {
        MovieTicketSystem m = new MovieTicketSystem();
    }
}