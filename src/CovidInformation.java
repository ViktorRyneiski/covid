import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;

public class CovidInformation {

    JFrame frame;
    WorldMapPanel panel;

    JButton btnReadNews;

    JRadioButton rbtnNorthAmerica;
    JRadioButton rbtnEuropa;
    JRadioButton rbtnSouthAmerica;
    JRadioButton rbtnAsia;
    JRadioButton rbtnAfrica;
    JRadioButton rbtnAustralia;
    ButtonGroup bgCountries;

    JLabel changeCountry;

    public CovidInformation() {
        frame = new JFrame("COVID-19 INFORMATION");
        frame.setSize(625, 423);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("cherep.jpg")));

        panel = new WorldMapPanel();
        panel.setSize(613, 384);
        panel.setLayout(null);

//        panel.addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseMoved(final MouseEvent e) {
//                super.mouseMoved(e);
//                changeCountry.setText("x: " + e.getX() + " / " + "y: " + e.getY());
//            }
//        });
    }

    public void start() {
        changeCountry = new JLabel("Выберите территорию для получения информации:");
        changeCountry.setBounds(10, 10, 500, 30);
        changeCountry.setFont(new Font("", 5, 20));
        changeCountry.setForeground(Color.WHITE);

        frame.add(changeCountry);
        frame.add(panel);

        rbtnNorthAmerica = creatRbtn();
        rbtnNorthAmerica.setBounds(118, 148, 60, 60);
        rbtnNorthAmerica.setOpaque(false);
        panel.add(rbtnNorthAmerica);

        rbtnEuropa = creatRbtn();
        rbtnEuropa.setBounds(293, 126, 20, 20);
        rbtnEuropa.setOpaque(false);

        panel.add(rbtnEuropa);

        rbtnSouthAmerica = creatRbtn();
        rbtnSouthAmerica.setBounds(183, 254, 20, 20);
        rbtnSouthAmerica.setOpaque(false);
        panel.add(rbtnSouthAmerica);

        rbtnAsia = creatRbtn();
        rbtnAsia.setBounds(424, 111, 20, 20);
        rbtnAsia.setOpaque(false);
        panel.add(rbtnAsia);

        rbtnAfrica = creatRbtn();
        rbtnAfrica.setBounds(315, 207, 20, 20);
        rbtnAfrica.setOpaque(false);
        panel.add(rbtnAfrica);

        rbtnAustralia = creatRbtn();
        rbtnAustralia.setBounds(518, 271, 20, 20);
        rbtnAustralia.setOpaque(false);
        panel.add(rbtnAustralia);

        bgCountries = new ButtonGroup();
        bgCountries.add(rbtnNorthAmerica);
        bgCountries.add(rbtnEuropa);
        bgCountries.add(rbtnSouthAmerica);
        bgCountries.add(rbtnAsia);
        bgCountries.add(rbtnAfrica);
        bgCountries.add(rbtnAustralia);

        btnReadNews = new JButton("Read news");
        btnReadNews.setBounds(270, 330, 100, 20);
        btnReadNews.setOpaque(false);
        btnReadNews.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                if (rbtnNorthAmerica.isSelected()) {
                    openURL("https://index.minfin.com.ua/reference/coronavirus/geography/north_america/");
                } else if (rbtnEuropa.isSelected()) {
                    openURL("https://www.google.com/search?client=avast&sxsrf=ALeKk01yWUjmtrCpZHo8kwIpXTBV-zj5qQ%3A1587249494284&ei=VoGbXuL9EIycrgSi5Z_oDg&q=%D1%81%D1%82%D0%B0%D1%82%D0%B8%D1%81%D1%82%D0%B8%D0%BA%D0%B0+%D0%BF%D0%BE+%D0%BA%D0%BE%D1%80%D0%BE%D0%BD%D0%BE%D0%B2%D0%B8%D1%80%D1%83%D1%81%D1%83+%D0%B2+%D0%B5%D0%B2%D1%80%D0%BE%D0%BF%D0%B5&oq=%D1%81%D1%82%D0%B0%D1%82%D0%B8%D1%81%D1%82%D0%B8%D0%BA%D0%B0+%D0%BF%D0%BE+%D0%BA%D0%BE%D1%80%D0%BE%D0%BD%D0%BE%D0%B2%D0%B8%D1%80%D1%83%D1%81%D1%83+%D0%B2+%D0%B5%D0%B2%D1%80%D0%BE%D0%BF%D0%B5&gs_lcp=CgZwc3ktYWIQAzoHCCMQsAIQJzoECAAQDToECCMQJzoFCAAQgwE6AggAOgQIABBDOgoIABCDARAUEIcCOgQIABADOgcIIxCxAhAnOgQIABAKUIpRWNHMAWCNzgFoAHAAeACAAX-IAfYWkgEEMzQuMpgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwjigJuShfPoAhUMjosKHaLyB-0Q4dUDCAw&uact=5");
                } else if (rbtnSouthAmerica.isSelected()) {
                    openURL("https://by.tribuna.com/hockey/1084525487.html");
                } else if (rbtnAsia.isSelected()) {
                    openURL("https://news.un.org/ru/story/2020/03/1374532");
                } else if (rbtnAfrica.isSelected()) {
                    openURL("https://lenta.ru/news/2020/04/16/africa/");
                } else if (rbtnAustralia.isSelected()) {
                    openURL("https://ria.ru/20200324/1569048807.html");
                } else {

                    JOptionPane.showMessageDialog(frame, "Вы ничего не выбрали!", "Ошибка выбора!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(btnReadNews);

        frame.setVisible(true);
    }

    private JRadioButton creatRbtn() {
        JRadioButton radioButton = new JRadioButton();
        return radioButton;
    }

    private void openURL(String url) {
        try {
            Desktop d = Desktop.getDesktop();

            d.browse(new URI(url));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (URISyntaxException use) {
            use.printStackTrace();
        }
    }

//    private ActionListener getActionListener(String url) {
//        return new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent actionEvent) {
//                openURL(url);
//            }
//        };
//    }
}
