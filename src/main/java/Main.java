import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {


    public static void main(String[] args) throws Exception {
        FaultModeManager fmm = new FaultModeManager();

        RandomGenerator generator = new GeneratorFaultDecorator(fmm, new RandomGeneratorImpl());

        Server server = new Server(9090);
        final ServletContextHandler context = new ServletContextHandler();
        context.addServlet(new ServletHolder(new WorkerServlet(generator)),"/doWork");
        context.addServlet(new ServletHolder(new FaultManagerServlet(fmm)),"/fault");
        context.addServlet(new ServletHolder(new Crasher()),"/crash");

        server.setHandler(context);
        server.start();


    }
}
