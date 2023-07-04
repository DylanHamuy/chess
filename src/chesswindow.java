import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class chesswindow extends Frame {

    private static final String _CWD = System.getProperty("user.dir");
    private static final String _ASSETS = _CWD + "/assets/";
    private static final String _README = _CWD + "/src/README.txt";

    private static final ImageIcon _ICON = new ImageIcon(_ASSETS + "/icon.png");

    private static final String[] _MOVECOLNAMES = {"#", "White", "Black"};

    private static int _MOVEDATACNT = 12;
    private static Object[][] _MOVEDATA = {
            {"1", "d4 {+.26/10 4.5s}", "Nc6 {-0.12/9 4.5s}"},
            {"2", "Nf3 {+.26/9 4.5s}", "e6 {-0.18/8 4.5s}"},
            {"3", "e4 {+.31/9 5.2s}", "Nf6 {-0.29/9 5.0s}"},
            {"4", "Bd3 {+.32/9 4.5s}", "Bd4+ {-0.49/9 5.1s}"},
            {"5", "Nc3 {+.49/9 4.5s}", "O-O {-0.49/9 4.5s}"},
            {"6", "O-O {+.48/9 4.5s}", "d6 {-0.49/9 4.5s}"},
            {"7", "a3 {+.45/9 6.3s}", "Ba5 {-0.46/9 7.5s}"},
            {"8", "Bg5 {+.46/8 4.8s}", "h6 {-0.40/9 4.6s}"},
            {"9", "Be3 {+.29/9 4.4s}", "Ng4 {-0.29/8 4.4s}"},
            {"10", "Bd2 {+.34/8 4.4s}", "e5 {-0.23/9 4.4s}"},
            {"11", "d5 {+.28/9 5.7s}", "Nd4 {-0.34/9 4.3s}"},
            {"12", "h3 {+.34/8 4.4s}", ""}
    };

    private static int _DEBUGDATACNT = 18;
    private static Object[][] _DEBUGDATA = {
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()},
            {"<Dylan(1): " + Math.random() + " " + Math.random() + " " + Math.random()}
    };

    private static int _DIMX = 320;
    private static int _DIMY = 320;

    /** TEMP CODES:
     * wr1, wr2 | br1, br2
     * wk1, wk2 | bk1, bk2
     * wb1, wb2 | bb1, bb2
     *  wk, wq  |  bk, bq
     * wp_, 1-8 | bp_, 1-8
     * */
    private static HashMap<String, String> _PIECES = new HashMap<>(32);
    static {
        _PIECES.put("wr1","a1");
        _PIECES.put("wr2","a6");
        _PIECES.put("br1","h1");
        _PIECES.put("br2","h6");

        _PIECES.put("wk1","c3");
        _PIECES.put("wk2","c6");
        _PIECES.put("bk1","d4");
        _PIECES.put("bk2","d7");

        _PIECES.put("wb1","b4");
        _PIECES.put("wb2","c4");
        _PIECES.put("bb1","h3");
        _PIECES.put("bb2","e1");

        _PIECES.put("wk","a7");
        _PIECES.put("wq","a4");
        _PIECES.put("bk","h7");
        _PIECES.put("bq","h4");

        _PIECES.put("wp1", "c1");
        _PIECES.put("bp1", "g1");
        _PIECES.put("wp2", "b2");
        _PIECES.put("bp2", "g2");
        _PIECES.put("wp3", "b3");
        _PIECES.put("bp3", "g3");
        _PIECES.put("wp4", "e4");
        _PIECES.put("bp4", "f4");
        _PIECES.put("wp5", "d5");
        _PIECES.put("bp5", "e5");
        _PIECES.put("wp6", "b6");
        _PIECES.put("bp6", "g6");
        _PIECES.put("wp7", "b7");
        _PIECES.put("bp7", "g7");
        _PIECES.put("wp8", "c8");
        _PIECES.put("bp8", "f8");
    }

    private static int _DEPTH = 10;

    public chesswindow(int dimX, int dimY) {
        _DIMX = dimX;
        _DIMY = dimY;
        JFrame frame = new JFrame("ChessBot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(_DIMX, _DIMY);
        frame.setResizable(false);
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(((int) windowSize.getWidth()) / 2 - _DIMX / 2,
                ((int) windowSize.getHeight()) / 2 - _DIMY / 2);
        frame.setIconImage(_ICON.getImage());


        JMenuBar menuBar = new JMenuBar();

        JMenu gameMenu = new JMenu("Game");
        gameMenu.add(new JMenuItem("**SAMPLE**"));

        JMenu viewMenu = new JMenu("View");
        viewMenu.add(new JMenuItem("**SAMPLE**"));

        JMenu engineMenu = new JMenu("Engines");
        JMenuItem depth = new JMenuItem(new AbstractAction("Change Depth") {class depthWindow {
            public depthWindow() {
                JFrame depthFrame = new JFrame("Change Depth");
                depthFrame.setSize(_DIMX / 2, _DIMY / 2);
                depthFrame.setResizable(false);
                depthFrame.setLocation(((int) windowSize.getWidth()) / 2 - _DIMX / 4,
                        ((int) windowSize.getHeight()) / 2 - _DIMY / 4);
                depthFrame.setIconImage(_ICON.getImage());

                JPanel storage = new JPanel(new GridBagLayout());
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.fill = GridBagConstraints.HORIZONTAL;

                constraints.gridwidth = 3;
                constraints.ipady = 40;
                constraints.gridx = 0;
                constraints.gridy = 0;
                JSlider depthSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 20, 10);
                /*depthSlider.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        _DEPTH = depthSlider.getValue();
                    }
                });*/
                depthSlider.setMajorTickSpacing(5);
                depthSlider.setMinorTickSpacing(1);
                depthSlider.setPaintTicks(true);
                depthSlider.setPaintLabels(true);
                depthSlider.setPaintTrack(true);
                depthSlider.setSnapToTicks(true);
                storage.add(depthSlider, constraints);

                JButton changeDepth = new JButton("Change");
                changeDepth.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        _DEPTH = depthSlider.getValue();
                        System.out.println(_DEPTH);
                    }
                });
                constraints.gridwidth = 1;
                constraints.ipady = 0;
                constraints.gridx = 2;
                constraints.gridy = 1;
                storage.add(changeDepth, constraints);

                depthFrame.add(storage);
                depthFrame.setVisible(true);
            }
        }
            @Override
            public void actionPerformed(ActionEvent e) {
                new depthWindow();
            }
        });
        JMenuItem swapEngine = new JMenuItem(new AbstractAction("Change Engine") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        engineMenu.add(depth);
        engineMenu.add(swapEngine);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem readme = new JMenuItem(new AbstractAction("View ReadMe") {
            @Override
            public void actionPerformed(ActionEvent e) {
                File toRead = new File(_README);
                if (Desktop.isDesktopSupported() && toRead.exists()) {
                    try {
                        Desktop.getDesktop().open(toRead);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        helpMenu.add(readme);

        menuBar.add(gameMenu);
        menuBar.add(viewMenu);
        menuBar.add(engineMenu);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);

        // https://cutechess.com/cutechess.png
        JPanel main = new JPanel() {
            Color primaryColor = new Color(207, 138, 70);
            Color altColor = new Color(253, 204, 157);
            boolean alt = true;
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < _DIMX / 2; i += _DIMX / 16) {
                    alt = !alt;
                    for (int j = 0; j < _DIMY / 2; j += _DIMY / 16) {
                        if (alt) { g.setColor(altColor); } else { g.setColor(primaryColor); }
                        g.fillRect(i, j, _DIMX / 16, _DIMY / 16);
                        alt = !alt;
                    }
                }
                for (String pieceNum : _PIECES.keySet()) {
                    String location = _PIECES.get(pieceNum);
                    int row = (_DIMY / 2) - ((_DIMY / 16) * (location.charAt(0) - 96));
                    int col = ((_DIMX / 16) * (location.charAt(1) - 49));

                    String imageName = pieceNum.substring(0, 2);
                    Image img = null;
                    try {
                        if (imageName.charAt(1) == 'k' && pieceNum.length() == 3) {
                            imageName = imageName.concat("n");
                        }
                        img = ImageIO.read(new File(_ASSETS + imageName + ".png"));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    g.drawImage(img, col, row, _DIMX / 16, _DIMY / 16, null);
                }
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(_DIMX / 2, _DIMY / 2);
            }
        };
        main.setBorder(BorderFactory.createLineBorder(new Color(122, 138, 153)));

        JTable moveTable = new JTable(_MOVEDATA, _MOVECOLNAMES);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        moveTable.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        moveTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        moveTable.getColumnModel().getColumn(0).setPreferredWidth((_DIMX / 2) / 12);
        moveTable.getColumnModel().getColumn(1).setPreferredWidth((_DIMX / 2) * 5 / 12);
        moveTable.getColumnModel().getColumn(2).setPreferredWidth((_DIMX / 2) * 6 / 12);
        moveTable.setEnabled(false);

        JScrollPane moveScroll = new JScrollPane() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(_DIMX / 2 - 15, _DIMY / 2);
            }
        };
        moveScroll.setViewportView(moveTable);
        moveScroll.getHorizontalScrollBar().setEnabled(false);
        if (_MOVEDATACNT < 18) {
            moveScroll.setWheelScrollingEnabled(false);
        }

        JPanel debug = new JPanel(new BorderLayout()) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(_DIMX, _DIMY / 2 - 60);
            }
        };

        String[] garbage = {"  Engine Debug:"};
        JTable debugTable = new JTable(_DEBUGDATA, garbage);
        debugTable.setEnabled(false);

        JScrollPane debugScroll = new JScrollPane() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(_DIMX, _DIMY / 2);
            }
        };
        debugScroll.setViewportView(debugTable);
        debugScroll.getHorizontalScrollBar().setEnabled(false);
        if (_DEBUGDATACNT < 16) {
            debugScroll.setWheelScrollingEnabled(false);
        }
        debug.add(debugScroll, BorderLayout.CENTER);

        frame.getContentPane().add(main, BorderLayout.LINE_START);
        frame.getContentPane().add(moveScroll, BorderLayout.LINE_END);
        frame.getContentPane().add(debug, BorderLayout.PAGE_END);
        frame.setVisible(true);
    }
}
