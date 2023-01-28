import codedraw.*;

public class ParticleGravity {
	public static void main(String[] args) {
		CodeDraw cd = new CodeDraw();
		EventScanner es = cd.getEventScanner();

		final int particleCount = 100000;
		final double exponent = -0.25 * Math.sqrt(2) - 0.5;
		final double speed = 100;

		// game state
		int mouseX = cd.getWidth() / 2;
		int mouseY = cd.getHeight() / 2;
		double[] particlesX = new double[particleCount];
		double[] particlesY = new double[particleCount];

		for (int i = 0; i < particleCount; i++) {
			particlesX[i] = Math.random() * cd.getWidth();
			particlesY[i] = Math.random() * cd.getHeight();
		}

		// game loop
		while (!cd.isClosed()) {
			// event handling
			while (es.hasEventNow()) {
				if (es.hasMouseMoveEvent()) {
					MouseMoveEvent a = es.nextMouseMoveEvent();
					mouseX = a.getX();
					mouseY = a.getY();
				}
				else {
					es.nextEvent();
				}
			}

			// game logic
			for (int i = 0; i < particleCount; i++) {
				double distanceX = mouseX - particlesX[i];
				double distanceY = mouseY - particlesY[i];

				double movementFactor = speed * Math.pow(distanceX * distanceX + distanceY * distanceY, exponent);

				particlesX[i] += distanceX * movementFactor;
				particlesY[i] += distanceY * movementFactor;
			}

			// rendering
			cd.clear(Palette.BLACK);
			for (int i = 0; i < particleCount; i++) {
				cd.setPixel((int)particlesX[i], (int)particlesY[i], Palette.RED);
			}
			cd.show(16);
		}
	}
}

