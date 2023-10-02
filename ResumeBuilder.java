import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class ResumeBuilder extends JFrame implements ActionListener {

    // textfield to enter
    JTextField FName = null, gender = null, cityy = null,
            emaill = null, skills = null, college = null, degree = null, linkedln = null,
            github = null, experience = null;
    // panel
    JFrame p = new JFrame("ResumeBuilder");
    JComboBox cb;

    // constructor
    ResumeBuilder() {
        super("ResumeBuilder");
        p.getContentPane().setBackground(Color.LIGHT_GRAY);
        String[] optionsToChoose = { "Male", "Female" };
        cb = new JComboBox(optionsToChoose);
        cb.setBounds(200, 60, 200, 30);
        p.add(cb);

        FName = new JTextField(3);
        cityy = new JTextField(3);
        emaill = new JTextField(3);
        skills = new JTextField(3);
        college = new JTextField(3);
        degree = new JTextField(3);
        linkedln = new JTextField(3);
        github = new JTextField(3);
        experience = new JTextField(3);

        FName.setBounds(200, 10, 200, 30);

        // password.setBounds(200, 160, 200, 30);
        // cpassword.setBounds(200, 210, 200, 30);
        cityy.setBounds(200, 260, 200, 30);
        emaill.setBounds(200, 310, 200, 30);
        skills.setBounds(200, 360, 200, 30);

        college.setBounds(700, 10, 200, 30);
        degree.setBounds(700, 60, 200, 30);
        experience.setBounds(700, 110, 200, 30);

        linkedln.setBounds(200, 510, 200, 30);
        github.setBounds(200, 560, 200, 30);

        p.add(FName);
        p.add(cityy);
        p.add(emaill);
        p.add(skills);
        p.add(college);
        p.add(degree);
        p.add(linkedln);
        p.add(github);
        p.add(experience);

        // create labels
        JLabel nameJLabel = new JLabel("NAME");
        JLabel genderJLabel = new JLabel("GENDER");

        JLabel cityJLabel = new JLabel("CITY");
        JLabel emailJLabel = new JLabel("Email");
        JLabel emailJLabe = new JLabel("");
        JLabel skilJLabel = new JLabel("Skills");
        JLabel collegeJLabel = new JLabel("College");
        JLabel degreeJLabel = new JLabel("Degree");
        JLabel linkedlnJLabel = new JLabel("Linkedin link");
        JLabel githubJLabel = new JLabel("Github link");
        JLabel experienceLabel = new JLabel("Experience");
        // set location
        nameJLabel.setBounds(10, 10, 150, 30);
        genderJLabel.setBounds(10, 60, 150, 30);

        cityJLabel.setBounds(10, 260, 150, 30);
        emailJLabel.setBounds(10, 310, 150, 30);
        emailJLabe.setBounds(10, 310, 150, 30);
        skilJLabel.setBounds(10, 360, 150, 30);

        linkedlnJLabel.setBounds(10, 510, 150, 30);
        githubJLabel.setBounds(10, 560, 150, 30);

        experienceLabel.setBounds(500, 110, 150, 30);
        collegeJLabel.setBounds(500, 10, 150, 30);
        degreeJLabel.setBounds(500, 60, 150, 30);

        p.add(nameJLabel);
        p.add(genderJLabel);
        p.add(cityJLabel);
        p.add(emailJLabel);
        p.add(emailJLabe);
        p.add(skilJLabel);
        p.add(collegeJLabel);
        p.add(degreeJLabel);
        p.add(linkedlnJLabel);
        p.add(githubJLabel);
        p.add(collegeJLabel);
        p.add(experienceLabel);

        // create a panel

        // create button
        JButton b = new JButton("REGISTER");
        JButton b1 = new JButton("RESET");
        b.setBounds(500, 400, 100, 30);
        b1.setBounds(700, 400, 100, 30);
        // add ActionListener
        p.add(b);
        p.add(b1);
        b.addActionListener(this);
        b1.addActionListener(this);

        // setSize(800, 800);
        // add(p);
        p.setLayout(null);
        p.setVisible(true);
        p.setSize(1000, 1000);
    }

    public void actionPerformed(ActionEvent evt) {
        String s = evt.getActionCommand();
        String name = FName.getText();
        String city = cityy.getText();
        String email = emaill.getText();
        String gender = (String) cb.getSelectedItem();
        String uskills = skills.getText();
        String ucollege = college.getText();
        String udegree = degree.getText();
        String ulinkdln = linkedln.getText();
        String ugithub = github.getText();
        String uexperience = experience.getText();
        JFrame jf = new JFrame();
        JOptionPane.showMessageDialog(jf,
                "Name: " + name + "\nGender: " + gender + "\nCity: " + city + "\nEmail: " + email
                        + "\nSkills: " + uskills + "\nCollege: " + ucollege + "\nDegree: " + udegree
                        + "\nLinkedin: " + ulinkdln + "\nGithub: " + ugithub + "\nExperience: " + uexperience);

        if (s.equals("REGISTER")) {
            JFrame f;
            if (name.equals("") || city.equals("") || email.equals("") || udegree.equals("")
                    || ulinkdln.equals("") || ugithub.equals("") || uexperience.equals("")) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f, "Enter all details.");
            } else {
                f = new JFrame();
                JOptionPane.showMessageDialog(f, "Data Registered Successfully");
                try {
                    FileOutputStream filee = new FileOutputStream(name + "_Resume.txt", true);
                    String in = "Name: " + name + "\nGender: " + gender + "\nCity: " + city + "\nEmail: " + email
                            + "\nSkills: " + uskills + "\nCollege: " + ucollege + "\nDegree: " + udegree
                            + "\nLinkedin: " + ulinkdln + "\nGithub: " + ugithub + "\nExperience: " + uexperience;
                    char ch[] = in.toCharArray();
                    for (int i = 0; i < in.length(); i++) {
                        filee.write(ch[i]);
                    }
                    filee.close();
                } catch (Exception e) {
                }
            }
        } else if (s.equals("RESET")) {
            FName.setText("");
            emaill.setText("");
            cityy.setText("");
            skills.setText("");
            linkedln.setText("");
            experience.setText("");
            degree.setText("");
            github.setText("");
        }
    }

    // Main Method
    public static void main(String args[]) {
        new ResumeBuilder();
    }
}