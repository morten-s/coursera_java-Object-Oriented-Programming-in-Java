package module6;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

/** Implements a visual marker for land earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 *
 */
public class LandQuakeMarker extends EarthquakeMarker {
	
	
	public LandQuakeMarker(PointFeature quake, PImage img) {
		
		// calling EarthquakeMarker constructor
		super(quake, img);
		
		// setting field in earthquake marker
		isOnLand = true;
	}


	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		// IMPLEMENT: drawing circle for LandQuake
		// DO NOT set the fill color.  That will be set in the EarthquakeMarker
		// class to indicate the depth of the earthquake.
		// Simply draw a centered square.
		// HINT: Notice the radius variable in the EarthquakeMarker class
		// and how it is set in the EarthquakeMarker constructor
		//pg.ellipse(x, y, 2*radius, 2*radius);
		pg.ellipse(x-10, y+10, 5, 5);
		String depth = String.valueOf(getMagnitude());
		pg.pushStyle();
		
		pg.rectMode(PConstants.CORNER);
		
		pg.stroke(110);
		pg.fill(200,200,200);
		pg.rect(x-7, y + 12, pg.textWidth(depth) +2, 10, 5);
		pg.textSize(9);
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.fill(0);
		pg.text(depth, x-6 , y +11);
		
		pg.popStyle();
		
		// pg.rect(x-10, y+10, 2*radius, 2);
		
	}
	

	// Get the country the earthquake is in
	public String getCountry() {
		return (String) getProperty("country");
	}

		
}