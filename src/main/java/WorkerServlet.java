import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WorkerServlet extends HttpServlet {

    private final RandomGenerator generator;

    public WorkerServlet(RandomGenerator generator) {
        this.generator = generator;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write(String.valueOf(generator.get()));
        writer.flush();
        writer.close();
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
