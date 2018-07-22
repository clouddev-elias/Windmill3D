package vindmolle;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class Tastaturtrykk extends Behavior
{
	Alpha alpha;
	WakeupCriterion[] keyEvents;
	WakeupOr keyCriterion;

	public Tastaturtrykk(Alpha alpha)
	{
		this.alpha=alpha;
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 200.0);
		this.setSchedulingBounds(bounds);
	}

	public void initialize()
	{
		keyEvents = new WakeupCriterion[1];
		keyEvents[0]=new WakeupOnAWTEvent(KeyEvent.KEY_PRESSED);
		keyCriterion = new WakeupOr(keyEvents);
		wakeupOn (keyCriterion);
	}

	public void processStimulus (Enumeration criteria)
	{
		WakeupCriterion wakeup;
		AWTEvent[] event;
		int id;
		char k;

		while (criteria.hasMoreElements()) {
			wakeup = (WakeupCriterion) criteria.nextElement();
			if (wakeup instanceof WakeupOnAWTEvent) {
				event = ((WakeupOnAWTEvent)wakeup).getAWTEvent();
				for (int i=0; i<event.length; i++) {
					id = event[i].getID();
					if (id == KeyEvent.KEY_PRESSED) {
						k = ((KeyEvent)event[i]).getKeyChar();
						long oldvalue= alpha.getIncreasingAlphaDuration();
						if (k=='+')
						{
							alpha.setIncreasingAlphaDuration(oldvalue/2);
							System.out.println("+");
						}
						else if (k=='-')
						{ 
							alpha.setIncreasingAlphaDuration(oldvalue*2);
							System.out.println("-");
						}
					} // End if
				} // End for
			} // End if
		} // End while
		wakeupOn (keyCriterion);
	} // End processStimulus
} // End class Tastaturtrykk
