public class UseCase1 {
    public static void main(String[] args) {

        MechanicalSystem system = new MechanicalSystem1();

        system.setMass(2.0);

        // Apply a constant force to simulate motion
        system.applyForce(new Vector2D(4.0, 0.0));

        System.out.println("Starting simulation...\n");

        double time = 0.0;
        double dt = 0.5;

        // Simulate motion over time
        for (int i = 0; i < 5; i++) {
            system.step(dt);
            time += dt;

            System.out.println("Time: " + time);
            System.out.println("Position: " + system.getPosition());
            System.out.println("Velocity: " + system.getVelocity());
            System.out.println("Acceleration: " + system.acceleration());
            System.out.println("----------------------");
        }
    }
}