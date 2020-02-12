package lab02;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Asg2 extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Asg2() {
		setTitle("RGB Color");
		getContentPane().add(new TColor());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
	}

	public static void main(String arg[]) {
		new Asg2();
	}
}

class TColor extends JPanel {
	
	private static final long serialVersionUID = 1L;
	DrawingCanvas canvas = new DrawingCanvas();
	JSlider sR, sG, sB;
	JTextField t1=new JTextField("0",4);
	JTextField t2=new JTextField("0",4);
	JTextField t3=new JTextField("0",4);
	JPanel q1 =new JPanel();
	JPanel q2=new JPanel();
	JPanel q3=new JPanel();;
	JPanel p = new JPanel();
	DrawingCanvas A = new DrawingCanvas();
	
	public TColor() {
		add(canvas,BorderLayout.NORTH);
		
		sR = getSlider();
		sG = getSlider();
		sB = getSlider();
		p.setLayout(new GridLayout(3, 3));
		add(p,BorderLayout.SOUTH);
		p.setBounds(0,500,500,300);
		
		//extracted();
		q1.add(new JLabel("  RED "));
		q1.add(sR);
		sR.setBounds(80, 0, 50, 30);
		
		q1.add(t1);
		p.add(q1);
		q1.setBounds(0, 0, 400, 100);
		
		q2.add(new JLabel("GREEN"));
		q2.add(sG);
		sG.setBounds(80, 100, 50, 30);
		q2.add(t2);
		p.add(q2);
		q2.setBounds(0, 100, 400, 100);
		
		q3.add(new JLabel(" BLUE "));
		q3.add(sB);
		sB.setBounds(80, 300, 50, 30);
		q3.add(t3);
		p.add(q3);
		q3.setBounds(0, 300, 400, 100);
		
		add(canvas,BorderLayout.NORTH);
		
	}
	
	public JSlider getSlider() {
		JSlider js1 = new JSlider(JSlider.HORIZONTAL, 0, 255, 1);  
		js1.setMajorTickSpacing(255);
		js1.setPaintLabels(true);
		js1.addChangeListener(new SliderListener());
		return js1;
	}

	class DrawingCanvas extends Canvas {
		private static final long serialVersionUID = 1L;
		Color color;
		public int rV, gV,bV;
		
		public DrawingCanvas() {
			setSize(400, 200);
			color = new Color(0, 0, 0);
			setBackgroundColor();
		}

		public void setBackgroundColor() {
			color = new Color(rV, gV, bV);
			setBackground(color);
		}
	}
	
	class SliderListener implements ChangeListener {
		
		public void stateChanged(ChangeEvent e) {
			JSlider s = (JSlider) e.getSource();
			if (s== sR) {
				canvas.rV= s.getValue();
				t1.setText("  "+canvas.rV);
				canvas.setBackgroundColor();
				} else if (s == sG) {
				canvas.gV= s.getValue();
				t2.setText("  "+canvas.gV);
				canvas.setBackgroundColor();
			} else if (s == sB) {
				canvas.bV= s.getValue();
				t3.setText("  "+canvas.bV);
				canvas.setBackgroundColor();
			} canvas.repaint();
		}

    }
 }
